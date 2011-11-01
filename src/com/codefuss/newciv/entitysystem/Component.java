package com.codefuss.newciv.entitysystem;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface Component
{
	public void setEntitySystem(EntitySystem system);

	public void setOwnerEntity(Entity owner);

    public void setOwnerId(String id);

    public Entity getEntity();
}
