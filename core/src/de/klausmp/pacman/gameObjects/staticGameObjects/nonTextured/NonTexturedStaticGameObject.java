package de.klausmp.pacman.gameObjects.staticGameObjects.nonTextured;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.staticGameObjects.textured.StaticGameObjekt;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;
import de.klausmp.pacman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 * 
 * @since 0.10.4
 * @version 0.9.8
 */
public abstract class NonTexturedStaticGameObject extends StaticGameObjekt {
    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param position        position an dem das {@link GameObject gameObjekt}
     *                        gespawned wird.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject
     *                        gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das
     *                        {@link GameObject gameObjekt} gerendert wird. weitere
     *                        informationen
     *                        {@link LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses
     *                        {@link GameObject gameObjekt} befindet
     * @since 0.10.3
     */
    public NonTexturedStaticGameObject(Vector2 position, Rotation rotation, GameObjectType gameObjectType,
            Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("black"), position, rotation, gameObjectType, layerToRenderOn,
                renderPriority, gridTile);
    }

    @Override
    public void render(LayerRenderer renderer) {

    }

    @Override
    protected void animation() {

    }
}
