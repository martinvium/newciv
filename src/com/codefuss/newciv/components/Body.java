package com.codefuss.newciv.components;

import com.codefuss.newciv.entitysystem.BaseComponent;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Body extends BaseComponent {

    private float x;
    private float y;
    private int width;
    private int height;

    public Body(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
