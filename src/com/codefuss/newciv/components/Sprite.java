package com.codefuss.newciv.components;

import com.codefuss.newciv.entitysystem.BaseComponent;
import org.newdawn.slick.Image;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Sprite extends BaseComponent {

    private Image image;

    public Sprite(Image image) {
        this.image = image;
    }

    public void render() {
        Body body = getComponent(Body.class);
        image.draw(body.getX(), body.getY());
    }
}
