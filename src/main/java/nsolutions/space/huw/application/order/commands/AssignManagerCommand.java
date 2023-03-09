package nsolutions.space.huw.application.order.commands;

import java.util.UUID;

public class AssignManagerCommand {
	private UUID orderID;
	private UUID tenantID;
	private UUID managerID;
	
	
	public UUID getOrderID() {
		return orderID;
	}
	public void setOrderID(UUID orderID) {
		this.orderID = orderID;
	}
	public UUID getTenantID() {
		return tenantID;
	}
	public void setTenantID(UUID tenantID) {
		this.tenantID = tenantID;
	}
	public UUID getManagerID() {
		return managerID;
	}
	public void setManagerID(UUID managerID) {
		this.managerID = managerID;
	}
	
	
}
