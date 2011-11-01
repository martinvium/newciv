package com.codefuss.newciv;

import com.codefuss.newciv.actions.Action;
import com.codefuss.newciv.actions.MoveDown;
import com.codefuss.newciv.actions.MoveLeft;
import com.codefuss.newciv.actions.MoveRight;
import com.codefuss.newciv.actions.MoveUp;
import com.codefuss.newciv.actions.SettleCity;
import com.codefuss.newciv.components.Body;
import com.codefuss.newciv.components.Sprite;
import com.codefuss.newciv.entitysystem.Entity;
import com.codefuss.newciv.factories.GameFactory;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.BasicGameState;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class GameState extends BasicGameState {

    static public final int ID = 1;
    static final int PLAYER_WIDTH = 128;
    GameFactory gameFactory;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        gameFactory = new GameFactory(Game.getProperties(), container.getInput());

        gameFactory.getMap().initUnits();

        for(Sprite spriteComponent : gameFactory.getEntitySystem().getComponents(Sprite.class)) {
            Entity e = spriteComponent.getEntity();
            gameFactory.getCamera().lookAt(e.getComponent(Body.class));
            gameFactory.getInputManager().mapToKey(new MoveLeft(e), Input.KEY_LEFT);
            gameFactory.getInputManager().mapToKey(new MoveRight(e), Input.KEY_RIGHT);
            gameFactory.getInputManager().mapToKey(new MoveDown(e), Input.KEY_DOWN);
            gameFactory.getInputManager().mapToKey(new MoveUp(e), Input.KEY_UP);
            gameFactory.getInputManager().mapToKey(new SettleCity(e, gameFactory.getEntityFactory()), Input.KEY_B);
        }

        container.setMaximumLogicUpdateInterval(100);
        container.setDefaultFont(gameFactory.getLabelFont());
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        for (Action action : gameFactory.getInputManager().getActions(delta)) {
            action.invoke();
        }

        /*for (Sprite component : gameFactory.getEntitySystem().getComponents(Sprite.class)) {
            component.render();
        }*/

        gameFactory.getCamera().update(container);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Camera camera = gameFactory.getCamera();

        gameFactory.getMap().render(-camera.getX(), -camera.getY());

        for (Sprite component : gameFactory.getEntitySystem().getComponents(Sprite.class)) {
            component.render(gameFactory.getCamera());
        }
    }
}