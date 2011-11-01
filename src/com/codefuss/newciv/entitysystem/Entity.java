package com.codefuss.newciv.entitysystem;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Entity
{
	String id;
	EntitySystem entitySystem;

	public Entity(EntitySystem es, String id)
	{
        entitySystem = es;
		this.id = id;
	}

	public <T> T getComponent(Class<T> className)
	{
		return entitySystem.getComponent(id, className);
	}

	public boolean hasComponent(Class className)
	{
		return entitySystem.hasComponent(id, className);
	}

	public String getId()
	{
		return id;
	}

    public void addComponent(Component component)
    {
        entitySystem.addComponent(id, component);
    }
}
