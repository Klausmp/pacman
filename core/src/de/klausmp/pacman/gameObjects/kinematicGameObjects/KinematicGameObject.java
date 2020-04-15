package de.klausmp.pacman.gameObjects.kinematicGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.renderer.Layer;

/**
 * kinetisches {@link GameObject gameObjekt}. <br>
 * <p>
 * wird nicht jeden tick bewegt. <br>
 * <p>
 * die movement methode muss extern oder nur
 * unter einer bestimmten bedingung aufgerufen werden
 *
 * @author Klausmp
 * @version 0.8.0
 * @see GameObject
 * @since 0.1.0
 */
public abstract class KinematicGameObject extends GameObject {
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
    public KinematicGameObject(TextureRegion region, Vector2 position, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region, position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
    }

    /**
     * hier geschieht das movement des {@link GameObject gameObjekts}.
     *
     * @since 0.1.0
     */
    public void movement() {

    }

    /**
     * TODO JAVA DOC
     * @snce 0.8.0
     */
    @Override
    public void dispose() {
        super.dispose();
    }
}