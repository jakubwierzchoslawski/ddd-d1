package nsolutions.space.huw.application.order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import nsolutions.space.huw.application.order.commands.CreateOrderCommand;
import nsolutions.space.huw.application.order.commands.SetupTeamCommand;
import nsolutions.space.huw.domain.model.order.WorkOrder;
import nsolutions.space.huw.domain.model.order.WorkOrderRepository;
import nsolutions.space.huw.domain.model.order.orderitems.OrderItemsRepository;
import nsolutions.space.huw.domain.model.order.orderitems.Spool;
import nsolutions.space.huw.domain.model.team.Manager;
import nsolutions.space.huw.domain.model.team.Welder;
import nsolutions.space.huw.domain.services.order.WorkOrderDomainService;
import nsolutions.space.huw.domain.services.team.TeamRepository;
import nsolutions.space.huw.infrastructure.externalone.PortForSomeExternalIntegration;

/**
 * Serwisy aplikacyjne należy traktować jak API w warstwie obsługi klienta HTTP.
 * W przypadku architektury opartej o zdarzenia każda metoda publiczna winna
 * przyjmować jako argument obiekt Command
 * 
 * Command odpalany jest tylko w serwisach aplikacyjnych
 * 
 * Serwisy aplikacyjne operują na modelu domenowym w szczególności na agregatach
 * oraz serwisach domenowych.
 * 
 * @author jakub
 *
 */
public class WorkOrderApplicationService {

	private WorkOrderRepository orderRepo;
	private OrderItemsRepository orderItemsRepo;
	private TeamRepository teamRepo;

	private WorkOrderDomainService orderDomainService;

	private PortForSomeExternalIntegration portOne;

	public WorkOrderApplicationService(WorkOrderRepository repo, OrderItemsRepository itemsRepo) {
		this.orderRepo = repo;
		this.orderItemsRepo = itemsRepo;
	}

	// API operation
	public WorkOrder createOrder(CreateOrderCommand createOrderCommand) {
		UUID tenantID = createOrderCommand.getTenantID();

		// delegacja akcji do serwisu domenowego celem walidacji istotnych reguł
		// biznesowych. Reguły operują na modelu domenowych - agregaty w obrębie domeny

		// dopuszczalne jest wywoływanie usług zewnętrznych (mikrousługi w ekosystemie /
		// serwisy 3rd party) w serwisach domenowych. zwykle to praktyczna droga na
		// skróty i często uzasadniona jeśli praktykowana w granicach zdrowego rozsądku
		orderDomainService.validateSomeImportantBusinessRuleshere();

		WorkOrder workOrder = new WorkOrder(tenantID, createOrderCommand.getOrderNumber(),
				createOrderCommand.getName());

		return orderRepo.createOrUpdate(workOrder);
	}

	// API operation
	// TODO jeden z przypadków użycia serwisu domenowego walidującego reguły
	// biznesowe klienta związane z profilem prowadzonej działalności i procesami
	public WorkOrder setupTeam(SetupTeamCommand command) {

		Manager manager = teamRepo.findManagerById(command.getTenantID(), command.getManagerID());
		WorkOrder workOrder = orderRepo.findById(command.getTenantID(), command.getOrderID());

		// przypisywanie managera do zespołu jest
		orderDomainService.assignManagerToOrder(workOrder, manager);

		// Lista weldersów z command powinna być docelowo brana
		List<Welder> welders = new ArrayList<Welder>();
		orderDomainService.assignWelders(workOrder, welders);

		// nie mam konkretnego przypadku użycia serwisów zewnętrznych dla tej metody ale
		// załóżmy że są, wtedy wywołujemy serwisy infrastruktury (IN/OUT).
		portOne.invokeExternal();

		// wywolanie portOne zwykle zmienia stan modelu

		// persist changes
		orderRepo.createOrUpdate(workOrder);

		return workOrder;
	}

	/**
	 * 
	 * @param tenantID
	 * @param orderID
	 * @param loadItems load order spools
	 * @return
	 */
	public WorkOrder findOrder(UUID tenantID, UUID orderID, boolean loadItems) {
		WorkOrder order = orderRepo.findById(tenantID, orderID);

		// just another use case of domain service usage
		// like eg validate user privilages (byc moze findOrder to nie najlepszy
		// przykład ale generalnie chodzi o przypadek użycia)
		orderDomainService.validateSomeImportantBusinessRuleshere();

		// interpret outcome of domain rules validation and do some action
		// eg. setup filters
		// easter egg: dlacze
		doAction();

		if (loadItems) {
			loadOrderSpools(order);
		}

		return order;
	}

	// sample doAction method, can be infrastructure service invocation
	private void doAction() {
		// do some action here - could use infrastructure and other application or
		// domain services
	}

	//
	private List<Spool> loadOrderSpools(WorkOrder order) {

		// może zwaliduj uprawnienia użytkownika dla zamówienia zanim zwrócisz liste?
		portOne.invokeExternal();

		if (order.id() != null && order.tenantID() != null) {
			return orderItemsRepo.spools(order.tenantID(), order.id());
		} else {
			// do sth
			return null;
		}
	}
}
