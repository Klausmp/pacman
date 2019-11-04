package de.klausmp.packman.visuals.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * @author Klausmp
 */

public class GameScreen extends ScreenAdapter {
    private static LayerRenderer layerRenderer;

    public static Sprite sprite;

    public GameScreen() {
        layerRenderer = new LayerRenderer(Layers.DEFAULTLAYERORDER());
        sprite = new Sprite(new Texture("pacMan/food.png"));
        sprite.setX(0);
        sprite.setY(0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        getLayerRenderer().addToQueque(new LayerRendererQueQueElement(sprite, 1));
        getLayerRenderer().addToQueque(new LayerRendererQueQueElement(sprite, 9));
        getLayerRenderer().addToQueque(new LayerRendererQueQueElement(sprite, 2));
        getLayerRenderer().addToQueque(new LayerRendererQueQueElement(sprite, 5));
        getLayerRenderer().addToQueque(new LayerRendererQueQueElement(sprite, 2.1f));
        layerRenderer.render();
    }

    public static LayerRenderer getLayerRenderer() {
        return layerRenderer;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
