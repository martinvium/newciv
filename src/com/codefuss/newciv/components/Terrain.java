package com.codefuss.newciv.components;

import com.codefuss.newciv.entitysystem.BaseComponent;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class Terrain extends BaseComponent {

    private int food;
    private int production;
    private int commerce;

    public Terrain(int food, int production, int commerce) {
        this.food = food;
        this.production = production;
        this.commerce = commerce;
    }

    public int getFood() {
        return food;
    }

    public int getProduction() {
        return production;
    }

    public int getCommerce() {
        return commerce;
    }
}
