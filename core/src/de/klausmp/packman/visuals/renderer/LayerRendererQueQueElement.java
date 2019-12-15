package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Klausmp
 */
//TODO JAVA DOC
public class LayerRendererQueQueElement {

    private static final float DEFAULTPROIRITY = 10.0f;
    private Sprite sprite;
    private Layers layerToRenderOn;
    private float priority;
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

    public LayerRendererQueQueElement(TextureRegion region, Vector2 position, Layers layerToRenderOn, float priority) {
        sprite = new Sprite(region);
        sprite.setX(position.x);
        sprite.setY(position.y);
        this.layerToRenderOn = layerToRenderOn;
        this.priority = priority;
    }

    public LayerRendererQueQueElement(TextureRegion region, Vector2 position, float priority) {
        sprite = new Sprite(region);
        sprite.setX(position.x);
        sprite.setY(position.y);
        this.layerToRenderOn = Layers.DEFAULT;
        this.priority = priority;
    }

    public LayerRendererQueQueElement(TextureRegion region, Vector2 position, Layers layerToRenderOn) {
        sprite = new Sprite(region);
        sprite.setX(position.x);
        sprite.setY(position.y);
        this.layerToRenderOn = layerToRenderOn;
        this.priority = DEFAULTPROIRITY;
    }

    public LayerRendererQueQueElement(TextureRegion region, Vector2 position) {
        sprite = new Sprite(region);
        sprite.setX(position.x);
        sprite.setY(position.y);
        this.layerToRenderOn = Layers.DEFAULT;
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
