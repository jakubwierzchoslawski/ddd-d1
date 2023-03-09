package nsolutions.space.huw.domain.model.team;

import java.util.UUID;

import nsolutions.space.huw.domain.model.common.Entity;

public class Worker extends Entity {
	private UUID tenantID;
	private String name;

	public Worker(UUID tenantID) {
		super();
		this.tenantID = tenantID;
	}


}
