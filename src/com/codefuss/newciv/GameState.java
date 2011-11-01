package com.codefuss.newciv;

import com.codefuss.newciv.actions.Action;
import com.codefuss.newciv.components.Sprite;
import com.codefuss.newciv.entitysystem.Entity;
import com.codefuss.newciv.factories.GameFactory;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.BasicGameState;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class GameState extends BasicGameState {

    static public final int ID = 1;
    static final int PLAYER_WIDTH = 128;
    GameFactory gameFactory;
    Entity player;

    @Override
    public int getID() {
        return ID;
    }

    public Entity getPlayer() {
        return player;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        gameFactory = new GameFactory(Game.getProperties(), container.getInput());

        gameFactory.getCamera().lookAt(player.getComponent(Sprite.class));

        container.setMaximumLogicUpdateInterval(100);
        container.setDefaultFont(gameFactory.getLabelFont());
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        for (Action action : gameFactory.getInputManager().getActions(delta)) {
            action.invoke();
        }

        for (Sprite component : gameFactory.getEntitySystem().getComponents(Sprite.class)) {
            component.render();
        }

        gameFactory.getCamera().update(container);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Camera camera = gameFactory.getCamera();

        gameFactory.getMap().render(-camera.getX(), -camera.getY());

        for (Sprite component : gameFactory.getEntitySystem().getComponents(Sprite.class)) {
            component.render();
        }
    }
}