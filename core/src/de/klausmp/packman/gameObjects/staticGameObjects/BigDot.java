package de.klausmp.packman.gameObjects.staticGameObjects;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.5.0
 * @see de.klausmp.packman.gameObjects.staticGameObjects.Dot
 * @since 0.5.0
 */
public class BigDot extends Dot {
    public BigDot(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("bigFood"), position, 50, Rotation.DEFAULTROTATION, GameObjectType.DOT, Layers.DEFAULT, 10f, gridTile);
    }

    @Override
    public void kill() {
        super.kill();
        GameScreen.chaseMode = true;
    }
}