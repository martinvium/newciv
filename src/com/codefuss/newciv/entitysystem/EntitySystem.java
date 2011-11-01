package com.codefuss.newciv.entitysystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.newdawn.slick.util.Log;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class EntitySystem
{
	Map<String, Entity> entityCache = new HashMap<String, Entity>();
	Map<Class, HashMap<String, Component>> componentStores = new HashMap<Class, HashMap<String, Component>>();
    Collection<String> pendingRemoval = new ArrayList<String>();

    public void addComponent(String id, Component component)
	{
        component.setEntitySystem(this);
        component.setOwnerId(id);

		if(! componentStores.containsKey(component.getClass())) {
			componentStores.put(component.getClass(), new HashMap<String, Component>());
		}

        componentStores.get(component.getClass()).put(id, component);
	}

    public <T> T getComponent(String e, Class<T> className)
	{
        if(! hasComponent(e, className)) {
            throw new IllegalArgumentException("entity " + e + " does not possess Component of class: " + className );
        }

        T result = (T)componentStores.get(className).get(e);
        return result;
	}

    public boolean hasComponent(String e, Class className)
	{
		if(! componentStores.containsKey(className)) {
            return false;
        }

        return componentStores.get(className).containsKey(e);
	}

	public <T> Collection<T> getComponents(Class<T> component)
	{
        if(! componentStores.containsKey(component)) {
            return new ArrayList<T>();
        }

        return (Collection<T>)componentStores.get(component).values();
	}

    public Collection<Entity> getEntitiesWith(Class component)
	{
        if(! componentStores.containsKey(component)) {
            return new ArrayList<Entity>();
        }

        ArrayList<Entity> foundEntities = new ArrayList();
        for(String entityId : componentStores.get(component).keySet()) {
            Entity e = getEntity(entityId);
            if(! foundEntities.contains(e)) {
                foundEntities.add(e);
            }
        }

        return foundEntities;
	}

	public String newEntityId()
	{
		return UUID.randomUUID().toString();
	}

	public Entity getEntity(String id)
	{
        if(! entityCache.containsKey(id)) {
            entityCache.put(id, new Entity(this, id));
        }

		return entityCache.get(id);
	}

    public void cleanPendingRemoval() {
        for(String id : pendingRemoval) {
            entityCache.remove(id);
            removeComponentsByEntityId(id);
        }
        
        pendingRemoval.clear();
    }

	public void removeEntity(String id)
	{
		pendingRemoval.add(id);
        Log.debug("removed entity: " + id);
	}
    
    private void removeComponentsByEntityId(String id)
    {
        for(Class eachClass : componentStores.keySet()) {
            componentStores.get(eachClass).remove(id);
        }
    }

    @Deprecated
    public List<Entity> getEntitiesWith(Class... requiredComponents)
	{
		ArrayList<Entity> foundEntities = new ArrayList();

		for(Class eachClass : requiredComponents) {
			for(String entityId : componentStores.get(eachClass).keySet()) {
                Entity e = getEntity(entityId);
				if(! foundEntities.contains(e)) {
					foundEntities.add(e);
				}
			}
		}

		return foundEntities;
	}

    @Deprecated
	public <T> List<T> getComponentsByBase(Class<T> component)
	{
		ArrayList<T> foundComponents = new ArrayList<T>();

		for(Class eachClass : componentStores.keySet()) {
			if(component.isAssignableFrom(eachClass)) {
				HashMap<String, Component> entityComponents = componentStores.get(eachClass);

				for(String entityId : entityComponents.keySet()) {
					foundComponents.add((T)entityComponents.get(entityId));
				}
			}
		}

		return foundComponents;
	}
}
