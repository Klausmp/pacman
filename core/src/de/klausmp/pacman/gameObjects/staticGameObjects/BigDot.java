package de.klausmp.pacman.gameObjects.staticGameObjects;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.level.GridTile;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.screens.GameScreen;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.7.0
 * @see de.klausmp.pacman.gameObjects.staticGameObjects.Dot
 * @since 0.5.0
 */
public class BigDot extends Dot {
    public BigDot(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("bigFood"), position, 50, Rotation.DEFAULTROTATION, GameObjectType.BIGDOT, Layers.DEFAULT, 10f, gridTile);
    }

    @Override
    public void kill() {
        super.kill();
        GameScreen.chaseMode = true;
    }
}