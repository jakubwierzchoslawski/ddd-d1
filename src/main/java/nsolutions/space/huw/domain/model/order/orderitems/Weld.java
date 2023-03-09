package nsolutions.space.huw.domain.model.order.orderitems;

import java.util.Date;
import java.util.UUID;

import nsolutions.space.huw.domain.model.common.Entity;

public class Weld extends Entity{

	private UUID tenantID;
	private String name;
	private Date createdAt;
	private UUID spoolID;
	
	//private List<Measurement> measurements;
	
	public Weld(UUID tenantID, UUID spoolID) {
		super();
		
		this.tenantID = tenantID;
		this.spoolID = spoolID;
		this.createdAt = new Date();
		//this.initializeMeasurementList();
	}
	
	public void setName(String name) {
		if (validateName(name)) {
			this.name = name;
		}
	}
	
	private boolean validateName(String name) {
		return true;
	}
	

	
	/*
	 * private void initializeMeasurementList() { if (this.measurements == null) {
	 * this.measurements = new ArrayList<Measurement>(); } }
	 */
}
