package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * @author Klausmp
 */
public class Ghost extends GameObject {
    public Ghost(TextureRegion region, Vector2 position) {
        super(region, position, Layers.DEFAULT, 5.0f);
    }

    public Ghost(Texture texture, Vector2 position) {
        super(texture, position, Layers.DEFAULT, 5.0f);
    }

    @Override
    public void update() {

    }
}
