package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class LayerRendererQueQueElement {

    private static final float DEFAULTPROIRITY = 10.0f;
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
        this.priority = DEFAULTPROIRITY;
    }

    public LayerRendererQueQueElement(Sprite sprite, Layers layerToRenderOn) {
        this.sprite = sprite;
        this.layerToRenderOn = layerToRenderOn;
        this.priority = DEFAULTPROIRITY;
    }

    public LayerRendererQueQueElement(Texture texture, Vector2 position, Layers layerToRenderOn, float priority) {
        sprite = new Sprite(texture);
        sprite.setX(position.x);
        sprite.setY(position.y);
        this.layerToRenderOn = layerToRenderOn;
        this.priority = priority;
    }

    public LayerRendererQueQueElement(Texture texture, Vector2 position, float priority) {
        sprite = new Sprite(texture);
        sprite.setX(position.x);
        sprite.setY(position.y);
        this.layerToRenderOn = Layers.DEFAULT;
        this.priority = priority;
    }

    public LayerRendererQueQueElement(Texture texture, Vector2 position) {
        sprite = new Sprite(texture);
        sprite.setX(position.x);
        sprite.setY(position.y);
        this.layerToRenderOn = Layers.DEFAULT;
        this.priority = DEFAULTPROIRITY;
    }

    public LayerRendererQueQueElement(Texture texture, Vector2 position, Layers layerToRenderOn) {
        sprite = new Sprite(texture);
        sprite.setX(position.x);
        sprite.setY(position.y);
        this.layerToRenderOn = layerToRenderOn;
        this.priority = DEFAULTPROIRITY;
    }
}
