package de.klausmp.packman.visuals.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.level.Level;
import de.klausmp.packman.level.TESTLEVEL;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * @author Klausmp
 */

public class GameScreen extends ScreenAdapter {
    private static LayerRenderer layerRenderer;
    private static TextureAtlas atlas;
    private static Level level;

    public GameScreen() {
        layerRenderer = new LayerRenderer(Layers.DEFAULTLAYERORDER());
        atlas = new TextureAtlas("spriteSheed.atlas");
        level = new TESTLEVEL();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        //level.update();
        level.render(layerRenderer);
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
