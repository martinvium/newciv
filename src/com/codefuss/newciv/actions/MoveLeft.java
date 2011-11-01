package com.codefuss.newciv.actions;

import com.codefuss.newciv.entitysystem.Entity;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class MoveLeft extends BaseAction {

    public MoveLeft(Entity creature) {
        super(creature);
    }

    @Override
    public Collection<Entity> invoke() {
        //creature.setState(Sprite.State.WALKING);
        //creature.setVelocityX(-creature.getSpeedX());
        return new ArrayList<Entity>();
    }
}
