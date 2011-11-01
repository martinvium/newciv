package com.codefuss.newciv.actions;

import com.codefuss.newciv.entitysystem.Entity;
import java.util.Collection;
import org.newdawn.slick.Input;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public interface Action {
    public Collection<Entity> invoke();

    public boolean test(Input input, int keyCode, int delta);
}
