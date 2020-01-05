package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.visuals.renderer.LayerRenderer;

/**
 * einzelteil eines {@link Grid grids}. <br>
 * alle {@link GameObject gameObjete} werden in einem gridTile gespeichert
 *
 * @author Klausmp
 * @version 0.0.1
 * @since 0.0.1
 */
public class GridTile {

    /**
     * position innerhalb des {@link Grid grids}. <br>
     * NUR GANZEZAHLEN
     *
     * @since 0.0.1
     */
    private Vector2 position;

    /**
     * instance des {@link Grid grids} von dem dieses {@link GridTile gridTile} ein teil ist.
     *
     * @since 0.0.1
     */
    private Grid grid;

    /**
     * liste indem alle {@link GameObject gameObjete} dieses {@link GridTile gridTiles} gespeichert sind.
     *
     * @since 0.0.1
     */
    private Array<GameObject> gameObjects = new Array<GameObject>();

    /**
     * standart konstructor
     *
     * @param position position des {@link GridTile gridTiles} innerhalb des {@link Grid grids}.
     * @param grid     {@link Grid grid} von dem dieses {@link GridTile gridtile} ein bestandteil ist.
     * @since 0.0.1
     */
    public GridTile(Vector2 position, Grid grid) {
        this.position = position;
        this.grid = grid;
    }

    /**
     * updated alle {@link GameObject gameObjekte} in der {@link #gameObjects gameObjekt} liste
     * und entfernt alle die zu entfernen sind.
     *
     * @since 0.0.1
     */
    public void update() {
        for (GameObject object : gameObjects) {
            object.update();
        }
        removeDeadGameObjects();
    }

    /**
     * rendert alle {@link GameObject gameObjekte} mithilfe eines {@link LayerRenderer layerRenderers}.
     *
     * @param renderer instace des layerRenderes der in diesem {@link com.badlogic.gdx.Screen screen} verwendet wird.
     * @since 0.0.1
     */
    public void render(LayerRenderer renderer) {
        for (GameObject object : gameObjects) {
            object.render(renderer);
        }
    }

    /**
     * entfern alle toten {@link GameObject gameObjekte} aus {@link #gameObjects gameObjects}
     *
     * @since 0.0.1
     */
    private void removeDeadGameObjects() {
        Array<GameObject> gameObjectsToRemove = new Array<GameObject>();
        for (GameObject object : gameObjects) {
            if (!object.isAlive()) {
                gameObjectsToRemove.add(object);
            }
        }
        gameObjects.removeAll(gameObjectsToRemove, true);
    }

    /**
     * entfernt alle {@link GameObject gameObjekte} aus {@link #gameObjects gameObjects}.
     *
     * @since 0.0.1
     */
    public void removeAllGameObject() {
        gameObjects.clear();
    }

    /**
     * fügt ein neues {@link GameObject gameObjekt} zu diesem {@link GridTile gridTile} hinzu.
     *
     * @param gameObject {@link GameObject gameObjekt} welches zu diesem {@link GridTile grildTile} hinzugefügt werden soll.
     * @since 0.0.1
     */
    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    /**
     * durchsucht {@link #gameObjects gameObjekts} nach einem {@link GameObject gameObjekt} mit gleichem Type und gibt dies zurrück.
     *
     * @param gameObjectType {@link GameObjectType gameObjektType} nachdem in {@link #gameObjects gameObjekts} gesucht wird.
     * @return wenn ein passendes {@link GameObject gameObjekt} gefunden wird, wird dies zurrückgegeben. wenn keines gefunden wird, wird null zurrückgegeben
     * @throws NullPointerException wenn kein passendes gameObjekt gefunden wird.
     * @since 0.0.1
     */
    public GameObject getGameObjectByType(GameObjectType gameObjectType) {
        for (GameObject object : gameObjects) {
            if (object.getGameObjectType().equals(gameObjectType)) {
                return object;
            }
        }
        return null;
    }

    public Vector2 getPosition() {
        return position;
    }
}