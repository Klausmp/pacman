package de.klausmp.pacman.gameObjects.staticGameObjects.textured.dots;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.utils.GameMode;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.world.level.Level;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.7.0
 * @see Dot
 * @since 0.5.0
 */
public class BigDot extends Dot {
    public BigDot(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("bigFood"), position, 50, Rotation.DEFAULTROTATION, GameObjectType.BIGDOT, Layers.DEFAULT, 10f, gridTile);
    }

    @Override
    public void kill() {
        super.kill();
        Level.changeGameMode(GameMode.FRIGHTEND);
    }

    @Override
    protected void animation() {

    }
}