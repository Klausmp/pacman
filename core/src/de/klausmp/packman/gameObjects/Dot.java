package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;

/**
 * @author Klausmp
 */
public class Dot extends GameObject {

    public Dot(TextureRegion region, Vector2 position, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region, position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
    }

    @Override
    public void update() {

    }
}
