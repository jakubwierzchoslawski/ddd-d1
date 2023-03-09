package nsolutions.space.huw.domain.services.order;

import java.util.List;

import nsolutions.space.huw.domain.model.order.WorkOrder;
import nsolutions.space.huw.domain.model.order.WorkOrderRepository;
import nsolutions.space.huw.domain.model.team.Manager;
import nsolutions.space.huw.domain.model.team.Welder;

// - odpowiedzialne za obsługę logiki domenowej - czyli takiej, która implementuje decyzje biznesowe (niezmienniczość w obrębie domeny niekoniecznie w obrębie agregatu)
// - mogą być używane w Encjach i agregatach jeśli nie komunikują się ze światame zewnętrznym 
public class WorkOrderDomainService {

	private WorkOrderRepository workOrderRepo;

	// q: dlaczego by nie umieścić tej logiki w Application Service?
	// a: może być wiele use case'ów użycia tej operacji z perspektywy
	// biznesu i wtedy można reużyć tą część kodu - gdyby była bardziej rozbudowana
	// np.
	public void assignManagerToOrder(WorkOrder order, Manager manager) {

		// walidacja reguł biznesowych angażujących więcej jak jeden agregat (ale w
		// obrębie domeny)

		// np:
		// - sprawdzić czy order jest ACTIVE ,
		// - sprawedizć czy manager już czasem nie jest przypisany do wiecej orderów niż zakłada biznes
		validateSomeImportantBusinessRuleshere();
		
		
		order.setManagerID(manager.id());
		this.workOrderRepo.createOrUpdate(order);
	}
	
	public void validateSomeImportantBusinessRuleshere() {
		// sprawdzić niezmienniki biznesowe dla agregatów w domenie
	}

	public void assignWelders(WorkOrder workOrder, List<Welder> welders) {
		// TODO Auto-generated method stub
		
	}

}
