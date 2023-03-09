package nsolutions.space.huw.domain.model.order;

import java.util.Date;
import java.util.UUID;

import nsolutions.space.huw.domain.model.common.Entity;

public class WorkOrder extends Entity {

	private String orderNumber;
	private String name;
	private Date createdAt;
	private UUID managerID;
	private UUID tenantID;

	// TODO przypisywanie spawaczy do zamowienia
	// List<Welder> welders;

	/*
	 * spool'e jako id ;; spool jest dla przykladu odrebnym agregatem
	 * 
	 * List<SpoolID> listOfSpoolIDs;
	 */

	private WorkOrder(UUID tenantID) {
		this.tenantID = tenantID;
	}

	public WorkOrder(UUID tenantID, String orderNumber, String name) {
		this(tenantID);

		this.orderNumber = orderNumber;
		this.name = name;

		// emit EVENT WorkOrderCreated
		// obsluga eventow w "DDD cz2." jak się wyrobie
	}

	public UUID managerID() {
		return this.managerID;
	}

	public UUID tenantID() {
		return this.tenantID;
	}

	public void setManagerID(UUID managerID) {
		this.managerID = managerID;
	}

}
