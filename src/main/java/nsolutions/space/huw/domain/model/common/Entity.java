package nsolutions.space.huw.domain.model.common;

import java.util.UUID;

public class Entity {

	private UUID id;
	private int concurrencyVersion;

	public Entity() {
		this.generateId();
		this.setConcurrencyVersion(0);
	}

	public UUID id() {
		return this.id;
	}
	
	private void generateId() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}
	}
	
    public int concurrencyVersion() {
        return this.concurrencyVersion;
    }

    private void setConcurrencyVersion(int concurrencyVersion) {
        this.concurrencyVersion = concurrencyVersion;
    }
    
    // each entity should have tenant assigned to it
   // abstract void initializeWithTenant(UUID tenantID);
}
