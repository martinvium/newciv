package com.codefuss.newciv.components;

import com.codefuss.newciv.Camera;
import com.codefuss.newciv.entitysystem.BaseComponent;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Sprite extends BaseComponent {

    private Image image;

    public Sprite(String ref) {
        try {
            image = new Image(ref);
        } catch(SlickException ex) {
            Log.error("failed to load image: " + ref);
        }
    }

    public Sprite(Image image) {
        this.image = image;
    }

    public void render(Camera camera) {
        Body body = getComponent(Body.class);
        image.draw(body.getX() - camera.getX(), body.getY() - camera.getY());
    }
}
