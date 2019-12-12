package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.Layers;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 */
public class Wall extends GameObject {

    public Wall(Vector2 position, Layers layerToRenderOn, float renderPriority) {
        super(GameScreen.getAtlas().findRegion(""), position, ObjectType.WALL, layerToRenderOn, renderPriority);
    }

    public Wall( Vector2 position, Layers layerToRenderOn, float renderPriority) {
        super(texture, position, ObjectType.WALL, layerToRenderOn, renderPriority);
    }

    @Override
    public void update() {

    }
}
