package de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.world.Path;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.utils.Timer;
import de.klausmp.pacman.visuals.renderer.LayerRendererQueQueElement;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.7.4
 * @since 0.6.0
 * @see de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject
 * @see java.lang.Runnable
 */
public class Ghost extends DynamicGameObject implements Runnable {

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    private Path currentPath;

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    private Path nextPath;

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    private Timer newPathTimer;

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    private boolean changePath = false;

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
    public Ghost(TextureRegion region, Vector2 position, float movementSpeed, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region, position, movementSpeed, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
    }

    /**
     * @version 0.6.0
     * @since 0.6.0
     */
    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if (newPathTimer.isExpired()){
            Thread thread = new Thread(this);
            thread.start();
        }
        if (changePath){
            changePath = false;
            currentPath.setPath(nextPath.getPath());
        }

    }

    @Override
    protected void movement(float deltaTime) {
        findNextGridTile(Rotation.DOWN);
        super.movement(deltaTime);
    }

    @Override
    protected void findNextGridTile(Rotation nextRotation) {
        super.findNextGridTile(nextRotation);
    }

    /**
     * @version 0.6.0
     * @since 0.6.0
     */
    @Override
    public void run() {

        //IMMER ALS LETZTES
        changePath = true;
    }
}