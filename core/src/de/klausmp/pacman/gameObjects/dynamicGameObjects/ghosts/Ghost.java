package de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;
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
 * @version 0.9.2
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
    protected Path path;

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    protected Timer newPathTimer;

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    protected boolean changePath = false;

    protected boolean firstFrame = true;

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
        //nextGridTile = currendGridTile;
        path = new Path(getGrid());
        newPathTimer = new Timer(3000);
    }

    /**
     * @version 0.6.0
     * @since 0.6.0
     */
    @Override
    public void update(float deltaTime) {
        if (newPathTimer.isExpired()) {
            newPathTimer.start();
            setTarged();
            path.newPath(currendGridTile, targed);
        }
        super.update(deltaTime);
    }

    @Override
    public void render(LayerRenderer renderer) {
        super.render(renderer);
    }

    @Override
    protected void movement(float deltaTime) {
        if (path.isPathLoaded()) {
            if (currendGridTile == null) {
                System.out.println("current");
                currendGridTile = getGrid().getGridTile((int) getX(), (int) getY());
            }
            if (nextGridTile == null) {
                System.out.println("next");
            }
            if (currendGridTile.equals(nextGridTile)) {
                currendGridTile = path.getNext();
            }
        }
        findNextGridTile(getObjectRotation());
        super.movement(deltaTime);
    }

    @Override
    protected void findNextGridTile(Rotation nextRotation) {
        if (currendGridTile.getPosition().x >= nextGridTile.getPosition().x) {
            nextRotation = Rotation.LEFT;
        }
        if (currendGridTile.getPosition().x <= nextGridTile.getPosition().x) {
            nextRotation = Rotation.RIGHT;
        }

        if (currendGridTile.getPosition().y >= nextGridTile.getPosition().y) {
            nextRotation = Rotation.DOWN;
        }

        if (currendGridTile.getPosition().y <= nextGridTile.getPosition().y) {
            nextRotation = Rotation.UP;
        }
        super.findNextGridTile(nextRotation);
    }

    public abstract void setTarged();
}