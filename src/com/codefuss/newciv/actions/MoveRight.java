package com.codefuss.newciv.actions;

import com.codefuss.newciv.components.Body;
import com.codefuss.newciv.entitysystem.Entity;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class MoveRight extends BaseAction {

    public MoveRight(Entity creature) {
        super(creature);
    }

    @Override
    public Collection<Entity> invoke() {
        Body body = creature.getComponent(Body.class);
        body.setX(body.getX() + 32);
        return new ArrayList<Entity>();
    }
}
