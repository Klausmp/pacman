package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class LayerRendererQueQueElement {

    public Sprite sprite;
    public Layers layerToRenderOn;
    public float priority;

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
        this.priority = 10.0f;
    }
}
