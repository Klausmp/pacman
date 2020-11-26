package de.klausmp.pacman.gameObjects.staticGameObjects.wall;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

public class Door  extends Wall{

    public Door(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("wallGhost"), position, Rotation.DEFAULTROTATION, GameObjectType.DOOR, Layers.BACKGROUND, 0.5F, gridTile);
    }
}
