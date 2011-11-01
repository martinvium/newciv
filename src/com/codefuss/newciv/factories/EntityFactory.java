package com.codefuss.newciv.factories;

import com.codefuss.newciv.components.Sprite;
import com.codefuss.newciv.entitysystem.Entity;
import com.codefuss.newciv.entitysystem.EntitySystem;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class EntityFactory {

    EntitySystem entitySystem;

    public EntityFactory(EntitySystem entitySystem) {
        this.entitySystem = entitySystem;
    }

    public Entity getPlayer() {
        String id = entitySystem.newEntityId();
        entitySystem.addComponent(id, new Sprite());
        return entitySystem.getEntity(id);
    }
}
