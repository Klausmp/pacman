package de.klausmp.pacman.gameObjects.staticGameObjects.nonTextured;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.UpdatebleGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 * @since 0.9.8
 * @version 0.10.3
 */
public class Bed extends NonTexturedStaticGameObject implements UpdatebleGameObject {
    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public Bed(Vector2 position, GridTile gridTile) {
        super(position, Rotation.DEFAULTROTATION, GameObjectType.BED, Layers.BACKGROUND, 50f, gridTile);
    }

    @Override
    public void update(float deltaTime) {
        for (GameObject object : currendGridTile.getGameObjects()) {
            if (object instanceof Ghost) {
                Ghost ghost = (Ghost) object;
                ghost.setRotation(Rotation.UP);
                ghost.setNextRotation(Rotation.UP);
                ghost.setEaten(false);
            }
        }
    }
}