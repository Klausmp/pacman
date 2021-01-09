package de.klausmp.pacman.gameObjects.staticGameObjects.textured.wall;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 *
 * @since 0.9.8
 * @version 0.9.8
 */
public class Door  extends Wall{
    /**
     * konstrucktor mit einstellungsmöglichkeiten bei der startposition.
     *
     * @param position startposition der {@link Wall wall}.
     * @param gridTile {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public Door(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("door"),position, GameObjectType.DOOR, gridTile);
    }

    @Override
    public void setTexture(TextureAtlas atlas) {

    }
}
