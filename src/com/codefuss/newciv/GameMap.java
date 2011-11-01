package com.codefuss.newciv;

import com.codefuss.newciv.entitysystem.Entity;
import com.codefuss.newciv.factories.EntityFactory;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

/**
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
    
    public void initGround() {
        int layerIndex = tiledMap.getLayerIndex("terrain");
        for (int x = 0; x < tiledMap.getWidth(); x++) {
            for (int y = 0; y < tiledMap.getHeight(); y++) {
                int tileId = tiledMap.getTileId(x, y, layerIndex);
                if (tileId > 0) {
                    entityFactory.getTerrain(
                            x * tiledMap.getTileWidth(), y * tiledMap.getTileHeight(),
                            tiledMap.getTileWidth(), tiledMap.getTileHeight(),
                            Integer.parseInt(tiledMap.getTileProperty(tileId, "food", "0")),
                            Integer.parseInt(tiledMap.getTileProperty(tileId, "production", "0")),
                            Integer.parseInt(tiledMap.getTileProperty(tileId, "commerce", "0"))
                    );
                }
            }
        }
    }

    public void initResources() {
        int layerIndex = tiledMap.getLayerIndex("resources");
        for (int x = 0; x < tiledMap.getWidth(); x++) {
            for (int y = 0; y < tiledMap.getHeight(); y++) {
                int tileId = tiledMap.getTileId(x, y, layerIndex);
                if (tileId > 0) {
                    entityFactory.getResource(
                            x * tiledMap.getTileWidth(), y * tiledMap.getTileHeight(),
                            tiledMap.getTileWidth(), tiledMap.getTileHeight(),
                            Integer.parseInt(tiledMap.getTileProperty(tileId, "food", "0")),
                            Integer.parseInt(tiledMap.getTileProperty(tileId, "production", "0")),
                            Integer.parseInt(tiledMap.getTileProperty(tileId, "commerce", "0"))
                    );
                }
            }
        }
    }

    public void initUnits() {
        int layerIndex = tiledMap.getLayerIndex("units");
        for (int x = 0; x < tiledMap.getWidth(); x++) {
            for (int y = 0; y < tiledMap.getHeight(); y++) {
                int tileId = tiledMap.getTileId(x, y, layerIndex);
                if (tileId > 0) {
                    entityFactory.getUnit(
                            x * tiledMap.getTileWidth(), y * tiledMap.getTileHeight(),
                            tiledMap.getTileWidth(), tiledMap.getTileHeight(),
                            tiledMap.getTileImage(x, y, layerIndex),
                            tiledMap.getTileProperty(tileId, "type", "")
                    );
                }
            }
        }
    }

    public void render(float x, float y) {
        tiledMap.render((int) x, (int) y, tiledMap.getLayerIndex("terrain"));
        tiledMap.render((int) x, (int) y, tiledMap.getLayerIndex("resources"));
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
