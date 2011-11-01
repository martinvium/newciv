package com.codefuss.newciv;

import com.codefuss.newciv.entitysystem.Entity;
import com.codefuss.newciv.factories.EntityFactory;
import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
 *
 * @author Martin Vium <martin.vium@gmail.com>
 */
public final class GameMap implements TileBasedMap {

    TiledMap tiledMap;
    EntityFactory entityFactory;

    public GameMap(EntityFactory entityFactory, String ref) throws SlickException {
        tiledMap = new TiledMap(ref);
        this.entityFactory = entityFactory;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public void render(float x, float y) {
        tiledMap.render((int) x, (int) y);
    }

    @Override
    public int getWidthInTiles() {
        return tiledMap.getWidth();
    }

    @Override
    public int getHeightInTiles() {
        return tiledMap.getHeight();
    }

    public int getWidth() {
        return getWidthInTiles() * tiledMap.getTileWidth();
    }

    public int getHeight() {
        return getHeightInTiles() * tiledMap.getTileHeight();
    }

    @Override
    public void pathFinderVisited(int x, int y) {
    }

    @Override
    public boolean blocked(PathFindingContext context, int tx, int ty) {
        return true;
    }

    @Override
    public float getCost(PathFindingContext context, int tx, int ty) {
        return 1;
    }
}
