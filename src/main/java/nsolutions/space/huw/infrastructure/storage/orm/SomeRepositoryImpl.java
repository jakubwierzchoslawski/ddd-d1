package nsolutions.space.huw.infrastructure.storage.orm;

import java.util.Collection;
import java.util.UUID;

import nsolutions.space.huw.domain.model.order.WorkOrder;
import nsolutions.space.huw.domain.model.order.WorkOrderRepository;

public class SomeRepositoryImpl implements WorkOrderRepository{

	@Override
	public Collection<WorkOrder> all(UUID tenantID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorkOrder findById(UUID tenantID, UUID orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markAsDeleted(UUID tenantID, UUID orderID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WorkOrder createOrUpdate(WorkOrder order) {
		// TODO Auto-generated method stub
		return null;
	}

}
