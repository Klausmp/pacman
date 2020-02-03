package de.klausmp.pacman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.Sprite;
import de.klausmp.pacman.utils.Layers;

/**
 * objekt welches alle informationen enthällt die der {@link LayerRenderer layerRenderer} zum
 * rendern benötigt wird <br>
 *
 * @author Klausmp
 * @version 0.0.1
 * @since 0.0.1
 */
public class LayerRendererQueQueElement {
    /**
     * ein standart werd der {@link #priority priorität}
     *
     * @since 0.0.1
     */
    private static final float DEFAULTPROIRITY = 10.0f;

    /**
     * in {@link Sprite sprite} werden alle informationen über die textur
     * sowie ihre position gespeichert.
     *
     * @since 0.0.1
     */
    private Sprite sprite;

    /**
     * angabe auf welchem {@link Layer} gerdernt werden soll <br>
     * diese ist type aus dem {@link Layers layers} enum.
     *
     * @since 0.0.1
     */
    private Layers layerToRenderOn;

    /**
     * zeigt an in welcher reihenfolge im layer gerendert wird. <br>
     * bzw welche textur von welcher im layer überzeichnet wird
     *
     * @since 0.0.1
     */
    private float priority;

    /**
     * zeigt an ob das object gelöscht werden kann
     *
     * @since 0.0.1
     */
    private boolean canBeRemoved = false;

    /**
     * alle parameter die nicht angegeben sind werden mit default werten belegt <br>
     *
     * @param sprite          {@link #sprite siehe hier}
     * @param layerToRenderOn {@link #layerToRenderOn siehe hier}
     * @param priority        {@link #priority siehe hier}
     * @since 0.0.1
     */
    public LayerRendererQueQueElement(Sprite sprite, Layers layerToRenderOn, float priority) {
        this.sprite = sprite;
        this.layerToRenderOn = layerToRenderOn;
        this.priority = priority;
    }

    /**
     * alle parameter die nicht angegeben sind werden mit default werten belegt <br>
     *
     * @param sprite   {@link #sprite siehe hier}
     * @param priority {@link #priority siehe hier}
     * @since 0.0.1
     */
    public LayerRendererQueQueElement(Sprite sprite, float priority) {
        this.sprite = sprite;
        this.layerToRenderOn = Layers.DEFAULT;
        this.priority = priority;
    }

    /**
     * alle parameter die nicht angegeben sind werden mit default werten belegt <br>
     *
     * @param sprite {@link #sprite siehe hier}
     * @since 0.0.1
     */
    public LayerRendererQueQueElement(Sprite sprite) {
        this.sprite = sprite;
        this.layerToRenderOn = Layers.DEFAULT;
        this.priority = DEFAULTPROIRITY;
    }

    /**
     * alle parameter die nicht angegeben sind werden mit default werten belegt <br>
     *
     * @param sprite          {@link #sprite siehe hier}
     * @param layerToRenderOn {@link #layerToRenderOn siehe hier}
     * @since 0.0.1
     */
    public LayerRendererQueQueElement(Sprite sprite, Layers layerToRenderOn) {
        this.sprite = sprite;
        this.layerToRenderOn = layerToRenderOn;
        this.priority = DEFAULTPROIRITY;
    }

    public static float getDEFAULTPROIRITY() {
        return DEFAULTPROIRITY;
    }

    public Layers getLayerToRenderOn() {
        return layerToRenderOn;
    }

    public float getPriority() {
        return priority;
    }

    public Sprite getSprite() {
        return sprite;
    }
}