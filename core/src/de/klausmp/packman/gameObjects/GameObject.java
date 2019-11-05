package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * @author Klausmp
 */
public abstract class GameObject extends Sprite {

    private LayerRendererQueQueElement renderElement;
    private Layers layerToRenderOn;
    private float renderPriority;

    public GameObject(TextureRegion region, Vector2 position, Layers layerToRenderOn, float renderPriority) {
        super(region);
        creat(position, layerToRenderOn, renderPriority);
    }

    public GameObject(Texture texture, Vector2 position, Layers layerToRenderOn, float renderPriority) {
        super(texture);
        creat(position, layerToRenderOn, renderPriority);
    }

    private void creat(Vector2 position, Layers layerToRenderOn, float renderPriority){
        this.setX(position.x);
        this.setY(position.y);
        this.layerToRenderOn = layerToRenderOn;
        this.renderPriority = renderPriority;
        renderElement = new LayerRendererQueQueElement(this, layerToRenderOn, renderPriority);

    }

    public abstract void update();

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
}