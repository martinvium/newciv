package com.codefuss.newciv.actions;

import com.codefuss.newciv.components.Body;
import com.codefuss.newciv.entitysystem.Entity;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class MoveUp extends BaseAction {

    public MoveUp(Entity creature) {
        super(creature);
    }

    @Override
    public Collection<Entity> invoke() {
        Body body = creature.getComponent(Body.class);
        body.setY(body.getY() - 32);
        return new ArrayList<Entity>();
    }
}
