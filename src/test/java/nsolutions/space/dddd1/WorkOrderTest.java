package nsolutions.space.dddd1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import nsolutions.space.huw.application.order.WorkOrderApplicationService;
import nsolutions.space.huw.application.order.commands.CreateOrderCommand;
import nsolutions.space.huw.domain.model.order.WorkOrder;
import nsolutions.space.huw.domain.model.order.WorkOrderRepository;
import nsolutions.space.huw.domain.model.order.orderitems.OrderItemsRepository;
import nsolutions.space.huw.domain.model.team.Manager;

@SpringBootTest
class WorkOrderTest {

	private WorkOrderRepository orderRepo;
	private OrderItemsRepository orderItemsRepo;
	
	private WorkOrderApplicationService woService;
	private UUID tenantID = UUID.randomUUID();
	
	@Test
	void contextLoads() {
	}
	
	void shouldCreateWO_IfNotExists() {
		this.woService = new WorkOrderApplicationService(orderRepo, orderItemsRepo);	
		assertNotNull(this.woService);
		
		
		// test order creation
		
		CreateOrderCommand command = prepareWorkOrder();
		WorkOrder wo = woService.createOrder(command);
		
		assertNotNull(wo.id());
		
	}
	
	
	private CreateOrderCommand prepareWorkOrder() {
		CreateOrderCommand command = new CreateOrderCommand();
		command.setName("OrderName: " + System.currentTimeMillis());
		command.setTenantID(this.tenantID);
		command.setOrderNumber("OrderNumber: "+ System.currentTimeMillis() );
		
		
		return command;
	}
	
	private Manager prepareManager() {
		Manager manager = new Manager(this.tenantID);
		
		return manager;
	}
	

}