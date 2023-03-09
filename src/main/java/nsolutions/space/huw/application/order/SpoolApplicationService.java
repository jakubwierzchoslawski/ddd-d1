package nsolutions.space.huw.application.order;

import nsolutions.space.huw.application.order.commands.AddWeldCommand;
import nsolutions.space.huw.application.order.commands.CreateSpoolCommand;
import nsolutions.space.huw.domain.model.order.orderitems.OrderItemsRepository;
import nsolutions.space.huw.domain.model.order.orderitems.Spool;
import nsolutions.space.huw.domain.model.order.orderitems.Weld;

/**
 * Serwisy aplikacyjne należy traktować jak API w warstwie obsługi klienta HTTP.
 * W przypadku architektury opartej o zdarzenia każda metoda publiczna winna
 * przyjmować jako argument obiekt Command
 * 
 * Command odpalany jest tylko w serwisach aplikacyjnych
 * 
 * @author jakub
 *
 */
public class SpoolApplicationService {

	private OrderItemsRepository orderItemsRepo;

	/**
	 * API
	 * @param csc
	 * @return
	 */
	public Spool initializeOrderItems(CreateSpoolCommand csc) {

		Spool spool = new Spool(csc.getTenantID(), csc.getOrderID());

		for (int i = 0; i < csc.getNrOfWeldsPerSpool(); i++) {
			Weld weld = new Weld(csc.getTenantID(), csc.getOrderID());
			weld.setName("testname " + System.currentTimeMillis());

			spool.addWeld(weld);
		}

		return orderItemsRepo.createOrUpdateSpool(spool);
	}

	/**
	 * API
	 * @param awc
	 * @return
	 */
	public Spool addWeldToSpool(AddWeldCommand awc) {
		Spool spool = orderItemsRepo.findSpoolById(awc.getTenantID(), awc.getSpoolID());

		if (spool == null) {
			return null;
		}

		Weld weld = new Weld(awc.getTenantID(), spool.id());
		spool.addWeld(weld);

		return orderItemsRepo.createOrUpdateSpool(spool);
	}
}
