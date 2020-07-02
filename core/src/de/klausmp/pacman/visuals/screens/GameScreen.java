package de.klausmp.pacman.visuals.screens;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import de.klausmp.pacman.Main;
import de.klausmp.pacman.world.level.Level;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;
import de.klausmp.pacman.utils.Layers;

/**
 * screen in dem das spiel statfindt.
 * hier werden alle objekte für das gameplay {@link #render(float) gerendert}
 * und {@link #update() geupdated}.
 *
 * @author Klausmp
 * @version 0.8.1
 * @see com.badlogic.gdx.ScreenAdapter
 * @since 0.0.1
 */
public class GameScreen extends ScreenAdapter implements Disposable {
    /**
     * TODO JAVA DOC
     *
     * @since 0.0.1
     */
    private static LayerRenderer layerRenderer;

    /**
     * im {@link TextureAtlas textureAtlas} sind alle texturen aufgeführt die im spiel verwendet werden.
     *
     * @sine 0.0.1
     * @see TextureAtlas* @since 0.0.1
     */
    private static TextureAtlas atlas;

    /**
     * level welches gerade gespielt wird.
     *
     * @since 0.0.1
     */
    private static Level level;

    /**
     * TODO JAVA DOC
     *
     * @since 0.5.0
     */
    public static int score = 0;

    /**
     * TODO JAVA DOC
     *
     * @since
     */
    public static boolean chaseMode = false;

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
        level = new Level("maps/map1.png");
    }

    /**
     * {@link Level#update() updated} das {@link Level level}.
     *
     * @since 0.0.1
     */
    public void update(float deltaTime) {
        level.update(deltaTime);
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
        update(delta);
        level.render(layerRenderer);
        if (level.isMapLoaded()) {
            layerRenderer.render();
        }
    }

    public void dispose() {
        //super.dispose();
        //layerRenderer.dispose();
        //atlas.dispose();
        //level.dispose();
    }
}