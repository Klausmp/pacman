package de.klausmp.packman.gameObjects.staticGameObjects;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 */
public class Dot extends GameObject {

    public Dot(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("food"), position, Rotation.DEFAULTROTATION, GameObjectType.DOT, Layers.BACKGROUND, 10f, gridTile);
    }

    @Override
    public void update() {

    }
}
