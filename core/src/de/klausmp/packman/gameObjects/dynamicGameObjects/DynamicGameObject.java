package de.klausmp.packman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.animations.Animation;
import de.klausmp.packman.visuals.renderer.Layer;

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
 * @version 0.3.0
 * @see GameObject
 * @since 0.1.0
 */
public abstract class DynamicGameObject extends GameObject {

    /**
     * movement animation
     *
     * @since 0.3.0
     */
    protected Animation movement;

    /**
     * TODO JAVADOC
     *
     * @since o.3.0
     */
    protected GridTile nextGridTile;

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public DynamicGameObject(TextureRegion region, Vector2 position, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region, position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
    }


    @Override
    public void update() {
        super.update();
        movement();
    }

    /**
     * hier geschieht das movement des {@link GameObject gameObjekts} in jedem tick.
     *
     * @since 0.1.0
     */
    protected abstract void movement();

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveUp() {

    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveRight() {

    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveDown() {

    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveLeft() {

    }

    /**
     * TODO JAVADC
     *
     * @param rotation
     * @since 0.3.0
     */
    protected void moveToGridTile(Rotation rotation) {

    }

}
