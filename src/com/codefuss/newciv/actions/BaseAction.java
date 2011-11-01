package com.codefuss.newciv.actions;

import com.codefuss.newciv.entitysystem.Entity;
import org.newdawn.slick.Input;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
abstract public class BaseAction implements Action {

    protected Entity creature;

    public BaseAction(Entity creature) {
        this.creature = creature;
    }

    @Override
    public boolean test(Input input, int keyCode, int delta) {
        return input.isKeyDown(keyCode);
    }
}
