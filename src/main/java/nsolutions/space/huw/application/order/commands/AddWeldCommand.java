package nsolutions.space.huw.application.order.commands;

import java.util.UUID;

public class AddWeldCommand {
	
	private UUID tenantID;
	private UUID spoolID;
	
	private String weldName;

	public UUID getTenantID() {
		return tenantID;
	}

	public void setTenantID(UUID tenantID) {
		this.tenantID = tenantID;
	}

	public UUID getSpoolID() {
		return spoolID;
	}

	public void setSpoolID(UUID spoolID) {
		this.spoolID = spoolID;
	}

	public String getWeldName() {
		return weldName;
	}

	public void setWeldName(String weldName) {
		this.weldName = weldName;
	}
	
	

}
