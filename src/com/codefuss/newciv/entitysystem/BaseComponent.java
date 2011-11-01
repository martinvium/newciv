package com.codefuss.newciv.entitysystem;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class BaseComponent implements Component {

    String ownerId;
    EntitySystem entitySystem;

    @Override
    public void setEntitySystem(EntitySystem system) {
        entitySystem = system;
    }

    protected EntitySystem getEntitySystem() {
        return entitySystem;
    }

    @Override
    public void setOwnerId(String id) {
        ownerId = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    @Override
    public Entity getEntity() {
        return entitySystem.getEntity(ownerId);
    }

    protected <T> T getComponent(Class<T> className) {
        return entitySystem.getComponent(ownerId, className);
    }

    @Override
    public void setOwnerEntity(Entity owner) {
    }
}
