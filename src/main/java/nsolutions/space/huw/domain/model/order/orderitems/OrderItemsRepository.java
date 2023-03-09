package nsolutions.space.huw.domain.model.order.orderitems;

import java.util.List;
import java.util.UUID;

public interface OrderItemsRepository {
	List<Spool> spools(UUID tenantID, UUID orderID);
	Spool findSpoolById(UUID tenantID, UUID spoolID);
	Weld findWeldById(UUID tenantID, UUID weldID);
	Spool createOrUpdateSpool(Spool spool);
}
