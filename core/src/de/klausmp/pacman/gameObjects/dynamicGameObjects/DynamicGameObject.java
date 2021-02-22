package de.klausmp.pacman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.UpdatebleGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement.IDynamicMovementControler;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement.IDynamicNextRotationChooser;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.renderer.Layer;
import de.klausmp.pacman.world.grid.GridTile;
import org.jetbrains.annotations.NotNull;

/**
 * dynamisches {@link GameObject gameObjekt}. <br>
 * <p>
 * es kann bewegt werden und ferfügt daher upber eine {@link #movement() movement} methode. <br>
 * <p>
 * dieses movement geschieht nach den updates die in der {@link GameObject#update() update}
 * methode des {@link GameObject gameObjekts} getätigt werden. <br>
 * <p>
 * dannach wird das erbende objekt geupdated.
 *
 * @author Klausmp
 * @version 0.10.7
 * @see GameObject
 * @since 0.1.0
 */
public abstract class DynamicGameObject extends GameObject implements UpdatebleGameObject {

    /**
     * TODO JAVA DOC
     *
     * @since 0.7.4
     */
    private float movementSpeed;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    protected Rotation nextRotation;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    private IDynamicNextRotationChooser nextRotationChooser;

    private IDynamicMovementControler movementControler;

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param movementSpeed   geschwindigkeit mit dem sich das {@link GameObject gameObjekt} bewegt.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link de.klausmp.pacman.visuals.renderer.LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public DynamicGameObject(TextureRegion region, Vector2 position, float movementSpeed, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile, IDynamicNextRotationChooser nextRotationChooser, IDynamicMovementControler movementControler) {
        super(region, position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
        this.movementSpeed = movementSpeed;
        this.nextRotationChooser = nextRotationChooser;
        this.movementControler = movementControler;
        nextRotation = rotation;
    }

    @Override
    public void update(float deltaTime) {
        movementControler.move(this, deltaTime);
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since0.9.4
     */
    public Rotation getNextRotation() {
        return nextRotation;
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since0.9.4
     */
    public void setNextRotation(@NotNull Rotation nextRotation) {
        this.nextRotation = nextRotation;
    }

    public IDynamicNextRotationChooser getNextRotationChooser() {
        return nextRotationChooser;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }
}
