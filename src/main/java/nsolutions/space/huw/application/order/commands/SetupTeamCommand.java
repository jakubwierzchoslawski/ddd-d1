package nsolutions.space.huw.application.order.commands;

import java.util.UUID;

public class SetupTeamCommand {
	
	public UUID tenantID;
	public UUID managerID;
	public UUID orderID;
	
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
	public UUID getOrderID() {
		return orderID;
	}
	public void setOrderID(UUID orderID) {
		this.orderID = orderID;
	}
}
