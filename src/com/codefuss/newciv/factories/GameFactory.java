package com.codefuss.newciv.factories;

import com.codefuss.newciv.Camera;
import com.codefuss.newciv.GameMap;
import com.codefuss.newciv.InputManager;
import com.codefuss.newciv.actions.NullAction;
import com.codefuss.newciv.entitysystem.EntitySystem;
import java.awt.Color;
import java.util.Properties;
import org.newdawn.slick.Font;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class GameFactory {

    ComponentFactory componentFactory;
    Camera camera;
    InputManager inputManager;
    GameMap gameMap;
    EntityFactory entityFactory;
    Properties properties;
    Input input;
    UnicodeFont labelFont;
    EntitySystem entitySystem;

    public GameFactory(Properties properties, Input input) {
        this.properties = properties;
        this.input = input;
    }

    public InputManager getInputManager() {
        if (inputManager == null) {
            inputManager = new InputManager(input);
            inputManager.setDefaultAction(new NullAction());
        }
        return inputManager;
    }

    public EntityFactory getEntityFactory() {
        if (entityFactory == null) {
            entityFactory = new EntityFactory(getEntitySystem());
        }
        return entityFactory;
    }

    public GameMap getMap() {
        if (gameMap == null) {
            String ref = properties.getProperty("MAP_FILE");
            try {
                gameMap = new GameMap(getEntityFactory(), ref);
            } catch (SlickException ex) {
                throw new RuntimeException("failed to load map: " + ref + ", msg: " + ex.getMessage());
            }
        }
        return gameMap;
    }

    public Camera getCamera() {
        if (camera == null) {
            camera = new Camera(getMap());
        }

        return camera;
    }

    public ComponentFactory getComponentFactory() {
        if (componentFactory == null) {
            componentFactory = new ComponentFactory();
        }

        return componentFactory;
    }

    public Font getLabelFont() {
        if (labelFont == null) {
            try {
                labelFont = new UnicodeFont(properties.getProperty("LABEL_FONT_FILE"), 10, false, false);
                labelFont.addAsciiGlyphs();
                labelFont.getEffects().add(new ColorEffect(Color.white));
                labelFont.loadGlyphs();
            } catch (SlickException ex) {
                throw new RuntimeException(ex);
            }
        }

        return labelFont;
    }

    public EntitySystem getEntitySystem() {
        if (entitySystem == null) {
            entitySystem = new EntitySystem();
        }

        return entitySystem;
    }
}
