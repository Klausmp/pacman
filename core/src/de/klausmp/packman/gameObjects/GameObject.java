package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * @author Klausmp
 */
//TODO JAVA DOC MACHEN
public abstract class GameObject extends Sprite {

    protected ObjectType objectType;
    protected LayerRendererQueQueElement renderElement;
    protected Layers layerToRenderOn;
    protected float renderPriority;
    protected boolean alive = true;

    public GameObject(TextureRegion region, Vector2 position, ObjectType objectType, Layers layerToRenderOn, float renderPriority) {
        super(region);
        creat(position, objectType, layerToRenderOn, renderPriority);
    }

    private void creat(Vector2 position, ObjectType objectType, Layers layerToRenderOn, float renderPriority) {
        this.setX(position.x);
        this.setY(position.y);
        this.objectType = objectType;
        this.layerToRenderOn = layerToRenderOn;
        this.renderPriority = renderPriority;
        renderElement = new LayerRendererQueQueElement(this, layerToRenderOn, renderPriority);
    }

    public void update() {

    }

    public void render(LayerRenderer renderer) {
        renderer.addToQueque(renderElement);
    }

    public Layers getLayerToRenderOn() {
        return layerToRenderOn;
    }

    public float getRenderPriority() {
        return renderPriority;
    }

    public void setRenderElement(LayerRendererQueQueElement renderElement) {
        this.renderElement = renderElement;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}