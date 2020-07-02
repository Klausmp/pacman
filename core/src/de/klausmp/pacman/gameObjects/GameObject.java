package de.klausmp.pacman.gameObjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import de.klausmp.pacman.world.grid.Grid;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;
import de.klausmp.pacman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.pacman.utils.Layers;

/**
 * diese klasse ist der ursprung aller objekte die im spiel vorhanden sind. <br>
 * die gameObjekte werden automatisch mit einem {@link LayerRenderer layerRenderer} gerdenrt. <br>
 * es sind viele verschiedene methoden und atribute vorhanden mit denen die eigenschaften jedes
 * im spiel befindelichen objektes modieliert werden können. <br>
 * diese klasse erbt von der klasse {@link Sprite sprite}.
 *
 * @author Klausmp
 * @version 0.9.2
 * @see Sprite
 * @since 0.0.1
 */

public abstract class GameObject extends Sprite implements Disposable {

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
    protected GridTile currendGridTile;

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
    private boolean alive = true;

    /**
     * zeigt die rotation des {@link GameObject gameObjekts} an.
     *
     * @since 0.1.0
     */
    private Rotation rotation;

    /**
     * idle animation;
     *
     * @since 0.3.0
     */
    protected Animation idle;

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link de.klausmp.pacman.visuals.renderer.Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     * @param currendGridTile {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public GameObject(TextureRegion region, Vector2 position, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile currendGridTile) {
        super(region);
        creat(position, rotation, gameObjectType, layerToRenderOn, renderPriority, currendGridTile);
    }

    /**
     * wird nur im konstruktor verwendet. speichert alle variablen aus dem konsruktor in die parameter der klasse.
     *
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link de.klausmp.pacman.visuals.renderer.Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
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
        this.currendGridTile = gridTile;
        renderElement = new LayerRendererQueQueElement(this, layerToRenderOn, renderPriority);
    }

    /**
     * updated das {@link GameObject gameObjekt} jeden tick.
     *
     * @since 0.0.1
     */
    public void update(float deltaTime) {
        animation();
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

    /**
     * hier wird alles mit animationen abgewickelt
     *
     * @version 0.6.0
     * @since 0.2.0
     */
    protected void animation() {
        setRegion(idle.getCurrentFrame());
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.1
     */
    public void kill() {
        alive = false;
        currendGridTile.removeGameObject(this);
    }

    public void setRenderElement(LayerRendererQueQueElement renderElement) {

        this.renderElement = renderElement;
    }

    public Rotation getObjectRotation() {
        return rotation;
    }

    public void setObjectRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    public GridTile getCurrendGridTile() {
        return currendGridTile;
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

    public Grid getGrid() {
        return currendGridTile.getGrid();
    }

    /**
     * @since 0.8.0
     */
    @Override
    public void dispose() {

    }
}