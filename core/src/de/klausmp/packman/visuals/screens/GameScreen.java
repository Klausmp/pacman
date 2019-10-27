package de.klausmp.packman.visuals.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.Layers;

public class GameScreen extends ScreenAdapter {
    LayerRenderer layerRenderer;

    public GameScreen() {
        Layers[] layerOrder = {Layers.BACKGROUND, Layers.BACK, Layers.DEFAULT, Layers.FRONT, Layers.INFRONT, Layers.TEXT, Layers.GUI};
        layerRenderer = new LayerRenderer(layerOrder);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        layerRenderer.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
