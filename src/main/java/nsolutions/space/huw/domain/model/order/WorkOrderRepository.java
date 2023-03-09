package nsolutions.space.huw.domain.model.order;

import java.util.Collection;
import java.util.UUID;

public interface WorkOrderRepository {
    public Collection<WorkOrder> all(UUID tenantID);
    public WorkOrder findById(UUID tenantID, UUID orderID);
    public void markAsDeleted(UUID tenantID, UUID orderID);
    public WorkOrder createOrUpdate(WorkOrder order);
}
