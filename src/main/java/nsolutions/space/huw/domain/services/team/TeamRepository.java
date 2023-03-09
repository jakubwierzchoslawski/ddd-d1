package nsolutions.space.huw.domain.services.team;

import java.util.UUID;

import nsolutions.space.huw.domain.model.team.Manager;

public interface TeamRepository {
	
	Manager findManagerById(UUID tenantID, UUID managerID);
	Manager createOrUpdateManager(Manager manager);

}
