package de.klausmp.packman.visuals.screens;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import de.klausmp.packman.Main;
import de.klausmp.packman.level.Level;
import de.klausmp.packman.level.TESTLEVEL;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.utils.Layers;

/**
 * screen in dem das spiel statfindt.
 * hier werden alle objekte für das gameplay {@link #render(float) gerendert}
 * und {@link #update() geupdated}.
 *
 * @author Klausmp
 * @version 0.0.1
 * @see com.badlogic.gdx.ScreenAdapter
 * @since 0.0.1
 */
public class GameScreen extends ScreenAdapter {
    /**
     * @see LayerRenderer
     * @since 0.0.1
     */
    private static LayerRenderer layerRenderer;

    /**
     * im {@link TextureAtlas textureAtlas} sind alle texturen aufgeführt die im spiel verwendet werden.
     *
     * @see TextureAtlas
     * @since 0.0.1
     */
    private static TextureAtlas atlas;

    /**
     * level welches gerade gespielt wird.
     *
     * @since 0.0.1
     */
    private static Level level;

    /**
     * Constructor ohne eigenschaften.
     * start des spieles.
     */
    public GameScreen() {
        create();
    }

    public static LayerRenderer getLayerRenderer() {
        return layerRenderer;
    }

    public static TextureAtlas getAtlas() {
        return atlas;
    }

    /**
     * initalisierung des {@link LayerRenderer LayerRenderes} mit der zu verwendenen
     * layerorder einem array aus {@link Layers layers}. <br>
     * <p>
     * initalisierung des {@link TextureAtlas TextureAtlases} mit dem pfad
     * des spriteSheets in "core.assets". <br>
     * <p>
     * initalisierung des {@link Level level}. hierbei kann das jedes von {@link Level level}
     * erbende objekt verwendet werden
     *
     * @since 0.0.1
     */
    public void create() {
        layerRenderer = new LayerRenderer(Layers.DEFAULTLAYERORDER());
        atlas = new TextureAtlas("spriteSheed.atlas");
        level = new TESTLEVEL();
    }

    /**
     * {@link Level#update() updated} das {@link Level level}.
     *
     * @since 0.0.1
     */
    public void update() {
        level.update();
    }

    /**
     * rendert und updated alle objecte auf dem screen.
     *
     * @param delta {@link Graphics#getDeltaTime() deltatime} des spieles dient zur berechnung von geschwindigkeiten und timern
     * @Override
     * @see Main#render()
     * @since 0.0.1
     */
    public void render(float delta) {
        super.render(delta);
        update();
        level.render(layerRenderer);
        layerRenderer.render();
    }

    public void dispose() {
        super.dispose();
    }
}
