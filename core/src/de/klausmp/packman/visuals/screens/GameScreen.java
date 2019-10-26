package de.klausmp.packman.visuals.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.packman.visuals.renderer.Layers;

public class GameScreen extends ScreenAdapter {
    ShapeRenderer shapeRenderer;
    LayerRenderer layerRenderer;
    Sprite sprite;

    public GameScreen() {

        sprite = new Sprite(new Texture("spritesheet.png"));
        sprite.setX(0);
        sprite.setY(0);

        shapeRenderer = new ShapeRenderer();
        Layers[] layerOrder = {Layers.BACKGROUND, Layers.BACK, Layers.DEFAULT, Layers.FRONT, Layers.INFRONT, Layers.TEXT, Layers.GUI};
        layerRenderer = new LayerRenderer(layerOrder);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        layerRenderer.addToQueque(new LayerRendererQueQueElement(sprite, Layers.DEFAULT, 1f));
        layerRenderer.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
