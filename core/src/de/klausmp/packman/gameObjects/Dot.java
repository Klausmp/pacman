package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * @author Klausmp
 */
public class Dot extends GameObject {

    public Dot(TextureRegion region, Vector2 position, Layers layerToRenderOn, float renderPriority) {
        super(region, position, layerToRenderOn, renderPriority);
    }

    public Dot(Texture texture, Vector2 position, Layers layerToRenderOn, float renderPriority) {
        super(texture, position, layerToRenderOn, renderPriority);
    }

    @Override
    public void update() {

    }
}
