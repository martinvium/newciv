package com.codefuss.newciv.actions;

import com.codefuss.newciv.entitysystem.Entity;
import java.util.ArrayList;
import java.util.Collection;
import org.newdawn.slick.Input;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class NullAction implements Action {

    @Override
    public boolean test(Input input, int keyCode, int delta) {
        throw new UnsupportedOperationException("Null action is untestable");
    }

    @Override
    public Collection<Entity> invoke() {
        return new ArrayList<Entity>();
    }
}
