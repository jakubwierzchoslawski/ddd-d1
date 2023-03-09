package nsolutions.space.huw.application.order.commands;

import java.util.UUID;

public class CreateOrderCommand {
	
	private UUID tenantID;
	private String orderNumber;
	private String name;
	
	public UUID getTenantID() {
		return tenantID;
	}
	public void setTenantID(UUID tenantID) {
		this.tenantID = tenantID;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
