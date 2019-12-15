package de.klausmp.packman.visuals.screens;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import de.klausmp.packman.Main;
import de.klausmp.packman.level.Level;
import de.klausmp.packman.level.TESTLEVEL;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * screen in dem das spiel statfindt.
 * hier werden alle objekte für das gameplay {@link #render(float) gerendert}
 * und {@link #update() geupdated}.
 * @author Klausmp
 * @version 0.0.1
 * @see com.badlogic.gdx.ScreenAdapter
 */
public class GameScreen extends ScreenAdapter {
    private static LayerRenderer layerRenderer;
    private static TextureAtlas atlas;
    private static Level level;

    /**
     * Constructor ohne eigenschaften.
     * start des spieles.
     */
    public GameScreen() {
        create();
    }

    /**
     * initalisierung des {@link LayerRenderer LayerRenderes} mit der zu verwendenen
     * layerorder einem array aus {@link Layers layers}. <br>
     *
     * initalisierung des {@link TextureAtlas TextureAtlases} mit dem pfad
     * des spriteSheets in "core.assets". <br>
     *
     * initalisierung des {@link Level level}. hierbei kann das jedes von {@link Level level}
     * erbende objekt verwendet werden
     * @since 0.0.1
     */
    public void create() {
        layerRenderer = new LayerRenderer(Layers.DEFAULTLAYERORDER());
        atlas = new TextureAtlas("spriteSheed.atlas");
        level = new TESTLEVEL();
    }

    /**
     * {@link Level#update() updated} das {@link Level level}.
     * @since 0.0.1
     */
    public void update() {
        level.update();
    }

    /**
     * rendert und updated alle objecte auf dem screen.
     * @see Main#render()
     * @param delta {@link Graphics#getDeltaTime() deltatime} des spieles dient zur berechnung von geschwindigkeiten und timern
     * @since
     * @Override
     */
    public void render(float delta) {
        super.render(delta);
        update();
        level.render(layerRenderer);
        layerRenderer.render();
    }

    public static LayerRenderer getLayerRenderer() {
        return layerRenderer;
    }

    public static TextureAtlas getAtlas() {
        return atlas;
    }

    /**
     * @since 0.0.1
     * @Override
     */
    public void dispose() {
        super.dispose();
    }
}
