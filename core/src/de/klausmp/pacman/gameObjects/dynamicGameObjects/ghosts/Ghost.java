package de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.GhostMovementControler;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.utils.Timer;
import de.klausmp.pacman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.9.3
 * @see de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject
 * @see java.lang.Runnable
 * @since 0.6.0
 */
public abstract class Ghost extends DynamicGameObject {

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.1
     */
    protected GridTile targed;

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    protected Timer pathTimer;

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param movementSpeed   geschwindigkeit mit dem sich das {@link GameObject gameObjekt} bewegt.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public Ghost(TextureRegion region, Vector2 position, Rotation rotation, GridTile gridTile) {
        super(region, position, 90f, Rotation.DEFAULTROTATION, GameObjectType.GHOST, Layers.DEFAULT, 5f, gridTile, new GhostMovementControler());
    }

    /**
     * @version 0.6.0
     * @since 0.6.0
     */
    @Override
    public void update(float deltaTime) {
        killPacMan();
        super.update(deltaTime);
    }


    /**
     * TODO JAVA DOC
     *
     * @param targed
     * @sijnce 0.9.4
     */
    public void setTarged() {

    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since 0.9.4
     */
    public GridTile getTarged() {
        return targed;
    }

    private void killPacMan() {
        for (GameObject gameObject : currendGridTile.getGameObjects()) {
            if (gameObject instanceof PacMan) {
                gameObject.kill();
            }
        }
    }
}