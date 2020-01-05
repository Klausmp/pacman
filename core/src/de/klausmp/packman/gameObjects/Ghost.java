package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;

/**
 * @author Klausmp
 */
public class Ghost extends GameObject {
    public Ghost(TextureRegion region, Vector2 position) {
        super(region, position, Rotation.DEFAULTROTATION,GameObjectType.GHOST, Layers.DEFAULT, 5.0f);
    }

    @Override
    public void update() {

    }
}