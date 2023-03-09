package nsolutions.space.huw.application.order.commands;

import java.util.UUID;

public class CreateSpoolCommand {

	private UUID tenantID;
	private UUID orderID;
	private int nrOfWeldsPerSpool;
	
	
	public UUID getTenantID() {
		return tenantID;
	}
	public void setTenantID(UUID tenantID) {
		this.tenantID = tenantID;
	}
	public UUID getOrderID() {
		return orderID;
	}
	public void setOrderID(UUID orderID) {
		this.orderID = orderID;
	}
	public int getNrOfWeldsPerSpool() {
		return nrOfWeldsPerSpool;
	}
	public void setNrOfWeldsPerSpool(int nrOfWeldsPerSpool) {
		this.nrOfWeldsPerSpool = nrOfWeldsPerSpool;
	}
	
	
}
