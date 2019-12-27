package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * @author Klausmp
 */
//TODO JAVA DOC MACHEN
public class PacMan extends GameObject {
    public PacMan(TextureRegion region, Vector2 position, Layers layerToRenderOn, float renderPriority) {
        super(region, position, GameObjectType.PACMAN, layerToRenderOn, renderPriority);
    }

    @Override
    public void update() {

    }
}
