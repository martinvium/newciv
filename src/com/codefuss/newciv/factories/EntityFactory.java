package com.codefuss.newciv.factories;

import com.codefuss.newciv.components.Body;
import com.codefuss.newciv.components.Sprite;
import com.codefuss.newciv.components.Terrain;
import com.codefuss.newciv.entitysystem.Entity;
import com.codefuss.newciv.entitysystem.EntitySystem;
import org.newdawn.slick.Image;

/**
 * @author Martin Vium <martin.vium@gmail.com>
 */
public class EntityFactory {

    private EntitySystem entitySystem;

    public EntityFactory(EntitySystem entitySystem) {
        this.entitySystem = entitySystem;
    }

    public Entity getTerrain(float x, float y, int width, int height, int food, int production, int commerce) {
        String id = entitySystem.newEntityId();
        entitySystem.addComponent(id, new Body(x, y, width, height));
        entitySystem.addComponent(id, new Terrain(food, production, commerce));
        return entitySystem.getEntity(id);
    }

    public Entity getResource(float x, float y, int width, int height, int food, int production, int commerce) {
        return getTerrain(x, y, width, height, food, production, commerce);
    }

    public Entity getUnit(float x, float y, int width, int height, Image sprite, String type) {
        String id = entitySystem.newEntityId();
        entitySystem.addComponent(id, new Body(x, y, width, height));
        entitySystem.addComponent(id, new Sprite(sprite));
        return entitySystem.getEntity(id);
    }

    public Entity getCity(Body body) {
        String id = entitySystem.newEntityId();
        entitySystem.addComponent(id, new Body(body));
        entitySystem.addComponent(id, new Sprite("assets/sprites/city.png"));
        return entitySystem.getEntity(id);
    }
}
