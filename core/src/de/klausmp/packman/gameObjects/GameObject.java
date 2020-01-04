package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.packman.visuals.renderer.Layers;

/**
 * diese klasse ist der ursprung aller objekte die im spiel vorhanden sind. <br>
 * die gameObjekte werden automatisch mit einem {@link LayerRenderer layerRenderer} gerdenrt. <br>
 * es sind viele verschiedene methoden und atribute vorhanden mit denen die eigenschaften jedes
 * im spiel befindelichen objektes modieliert werden können. <br>
 * diese klasse erbt von der klasse {@link Sprite sprite}.
 *
 * @author Klausmp
 * @version 0.0.1
 * @see Sprite
 */

public abstract class GameObject extends Sprite {

    /**
     * typ des gameObjekts.
     *
     * @since 0.0.1
     */
    protected GameObjectType gameObjectType;

    /**
     * element indem alle daten gespeichert sind die zum rendern benötigt wird.
     *
     * @since 0.0.1
     */
    protected LayerRendererQueQueElement renderElement;

    /**
     * layer auf dem das {@link GameObject gameObject} gerendert wird.
     *
     * @since 0.0.1
     */
    protected Layers layerToRenderOn;

    /**
     * priorität nach der das {@link GameObject gameObjekt} gerendert wird. <br>
     * genauere informationen {@link LayerRendererQueQueElement#priority hier}.
     *
     * @since 0.0.1
     */
    protected float renderPriority;

    /**
     * zeigt an ob das {@link GameObject gameObjekt} am leben ist. <br>
     * wenn false wird das {@link GameObject gameObjekt} am ende des ticks gelöscht.
     *
     * @since 0.0.1
     */
    protected boolean alive = true;

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link de.klausmp.packman.visuals.renderer.Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     * @since 0.0.1
     */
    public GameObject(TextureRegion region, Vector2 position, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority) {
        super(region);
        creat(position, gameObjectType, layerToRenderOn, renderPriority);
    }

    /**
     * wird nur im konstruktor verwendet. speichert alle variablen aus dem konsruktor in die parameter der klasse.
     *
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn @link de.klausmp.packman.visuals.renderer.Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     */
    private void creat(Vector2 position, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority) {
        this.setX(position.x);
        this.setY(position.y);
        this.gameObjectType = gameObjectType;
        this.layerToRenderOn = layerToRenderOn;
        this.renderPriority = renderPriority;
        renderElement = new LayerRendererQueQueElement(this, layerToRenderOn, renderPriority);
    }

    /**
     * updated das {@link GameObject gameObjekt} jeden tick.
     *
     * @since 0.0.1
     */
    public void update() {
    }

    /**
     * rendert die {@link Sprite sprite} der oberKlasse auf den screen. <br>
     * hierzu wird in bei jedem tick das {@link LayerRendererQueQueElement renderElement} zur verwendeten inctanze des {@link LayerRenderer leyerrenderers} übergeben.
     *
     * @param renderer inctanze des verwenteten {@link LayerRenderer layerRenderers}.
     * @since 0.0.1
     */
    public void render(LayerRenderer renderer) {
        renderer.addToQueque(renderElement);
    }

    public void setRenderElement(LayerRendererQueQueElement renderElement) {
        this.renderElement = renderElement;
    }

    public Layers getLayerToRenderOn() {
        return layerToRenderOn;
    }

    public float getRenderPriority() {
        return renderPriority;
    }

    public GameObjectType getGameObjectType() {
        return gameObjectType;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}