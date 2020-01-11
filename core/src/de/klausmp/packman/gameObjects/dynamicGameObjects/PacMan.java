package de.klausmp.packman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;

/**
 * @author Klausmp
 */
public class PacMan extends GameObject {
    public PacMan(TextureRegion region, Vector2 position, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region, position, Rotation.DEFAULTROTATION,GameObjectType.PACMAN, layerToRenderOn, renderPriority, gridTile);
    }

    @Override
    public void update() {

    }
}
