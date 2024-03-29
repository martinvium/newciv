package com.codefuss.newciv;

import com.codefuss.newciv.actions.Action;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.newdawn.slick.Input;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class InputManager {

    Input input;
    HashMap<Integer, Action> keyActions = new HashMap<Integer, Action>();
    Action defaultAction;
    
    public InputManager(Input input) {
        this.input = input;
    }

    public void setDefaultAction(Action action) {
        defaultAction = action;
    }

    public void mapToKey(Action action, int keyCode) {
        keyActions.put(keyCode, action);
    }

    public Collection<Action> getActions(int delta)
	{
        ArrayList<Action> foundActions = new ArrayList<Action>();
        for(int keyCode : keyActions.keySet()) {
            if(keyActions.get(keyCode).test(input, keyCode, delta)) {
                foundActions.add(keyActions.get(keyCode));
            }
        }

        if(foundActions.isEmpty()) {
            foundActions.add(defaultAction);
        }

        return foundActions;
	}
}
