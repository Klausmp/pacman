package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * objekt welches alle informationen enthällt die der {@link LayerRenderer layerRenderer} zum
 * rendern benötigt <br>
 *
 * @author Klausmp
 * @version 0.0.1
 */
//TODO JAVA DOC (in arbeit)
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

    public LayerRendererQueQueElement(Sprite sprite, Layers layerToRenderOn, float priority) {
        this.sprite = sprite;
        this.layerToRenderOn = layerToRenderOn;
        this.priority = priority;
    }

    public LayerRendererQueQueElement(Sprite sprite, float priority) {
        this.sprite = sprite;
        this.layerToRenderOn = Layers.DEFAULT;
        this.priority = priority;
    }

    public LayerRendererQueQueElement(Sprite sprite) {
        this.sprite = sprite;
        this.layerToRenderOn = Layers.DEFAULT;
        this.priority = DEFAULTPROIRITY;
    }

    public LayerRendererQueQueElement(Sprite sprite, Layers layerToRenderOn) {
        this.sprite = sprite;
        this.layerToRenderOn = layerToRenderOn;
        this.priority = DEFAULTPROIRITY;
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

    public static float getDEFAULTPROIRITY() {
        return DEFAULTPROIRITY;
    }
}
