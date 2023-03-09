package nsolutions.space.huw.domain.model.order.orderitems;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import nsolutions.space.huw.domain.model.common.Entity;

// agregat, poziom granularności zależy przypadków użycia.
//
// agregat i jego składniki muszą być spójne w ramach transakcji. 
// w szczególności należy dopilnować, żeby tzw biznesowe niezmienniki zostały zachowane 
// niezależnie od przypadków użycia. nie można dopuścić do przecieków 
// w postaci dostępu do prywatnych atrybutów Encji i ValueObjectów użytych w agregacie

public class Spool extends Entity {
	private UUID tenantID;
	private String name;
	private Date createdAt;
	private UUID orderID;

	private List<Weld> welds;

	public Spool(UUID tenantID, UUID orderID) {
		super();

		this.tenantID = tenantID;
		this.orderID = orderID;
		this.createdAt = new Date();
		this.initializeWeldList();
	}

	private void initializeWeldList() {
		if (this.welds == null) {
			this.welds = new ArrayList<Weld>();
		}
	}

	public void addWeld(Weld weld) {

		// TODO weryfikacja niezmienników biznesowych i inne rzeczy

		this.welds.add(weld);
	}
}
