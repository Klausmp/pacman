package de.klausmp.packman.visuals.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * @author Klausmp
 */

public class GameScreen extends ScreenAdapter {
    private static LayerRenderer layerRenderer;
    private static TextureAtlas atlas;

    public GameScreen() {
        layerRenderer = new LayerRenderer(Layers.DEFAULTLAYERORDER());
        atlas = new TextureAtlas("spriteSheed.atlas");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        layerRenderer.addToQueque(new LayerRendererQueQueElement(atlas.findRegion("pacMan0"), new Vector2(50, 50)));
        layerRenderer.render();
    }

    public static LayerRenderer getLayerRenderer() {
        return layerRenderer;
    }

    public static TextureAtlas getAtlas() {
        return atlas;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
