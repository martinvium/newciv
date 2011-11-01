package com.codefuss.newciv.actions;

import com.codefuss.newciv.components.Body;
import com.codefuss.newciv.entitysystem.Entity;
import com.codefuss.newciv.factories.EntityFactory;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class SettleCity extends BaseAction {

    private EntityFactory entityFactory;

    public SettleCity(Entity creature, EntityFactory entityFactory) {
        super(creature);
        this.entityFactory = entityFactory;
    }

    @Override
    public Collection<Entity> invoke() {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        entities.add(entityFactory.getCity(creature.getComponent(Body.class)));
        return entities;
    }
}
