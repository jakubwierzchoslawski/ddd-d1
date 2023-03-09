package nsolutions.space.huw.domain.model.team;

import java.util.Set;
import java.util.UUID;

import nsolutions.space.huw.domain.model.common.Entity;

public class Team extends Entity {

	private UUID tenantID;
	private Manager manager;
	private Set<Welder> welders;
	
	public Team(UUID tenantID) {
		super();
		
		this.tenantID = tenantID;
	}


	
}
