package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.renderer.LayerRenderer;
import de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.packman.utils.Layers;

/**
 * diese klasse ist der ursprung aller objekte die im spiel vorhanden sind. <br>
 * die gameObjekte werden automatisch mit einem {@link LayerRenderer layerRenderer} gerdenrt. <br>
 * es sind viele verschiedene methoden und atribute vorhanden mit denen die eigenschaften jedes
 * im spiel befindelichen objektes modieliert werden können. <br>
 * diese klasse erbt von der klasse {@link Sprite sprite}.
 *
 * @author Klausmp
 * @version 0.1.4
 * @see Sprite
 * @since 0.0.1
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
     * {@link GridTile gridTile} indem sich dieses {@link GameObject gameOnjekt} befindet
     *
     * @since 0.1.4
     */
    protected GridTile gridTile;

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
     * zeigt die rotation des {@link GameObject gameObjekts} an.
     *
     * @since 0.1.0
     */
    protected Rotation rotation;

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link de.klausmp.packman.visuals.renderer.Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public GameObject(TextureRegion region, Vector2 position, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region);
        creat(position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
    }

    /**
     * wird nur im konstruktor verwendet. speichert alle variablen aus dem konsruktor in die parameter der klasse.
     *
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link de.klausmp.packman.visuals.renderer.Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    private void creat(Vector2 position, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        this.setX(position.x);
        this.setY(position.y);
        this.rotation = rotation;
        this.gameObjectType = gameObjectType;
        this.layerToRenderOn = layerToRenderOn;
        this.renderPriority = renderPriority;
        this.gridTile = gridTile;
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