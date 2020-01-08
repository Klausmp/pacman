package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.GridTileType;
import de.klausmp.packman.visuals.renderer.LayerRenderer;

/**
 * einzelteil eines {@link Grid grids}. <br>
 * alle {@link GameObject gameObjete} werden in einem gridTile gespeichert
 *
 * @author Klausmp
 * @version 0.1.3
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
     * gitb den {@link GridTileType type} des {@link GridTile gridTiles} an.
     *
     * @since 0.1.3
     */
    private GridTileType gridTileType;

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
     * konstructor mit einstellung der {@link #position position} und setzung des {@link #grid grids} von dem
     * dieses {@link GridTile gridTile} ein teil ist.
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
     * konstructor mit allen verfügbaren einstellungen
     *
     * @param position position des {@link GridTile gridTiles} innerhalb des {@link Grid grids}.
     * @param grid     {@link Grid grid} von dem dieses {@link GridTile gridtile} ein bestandteil ist.
     * @since 0.1.3
     */
    public GridTile(GridTileType gridTileType, Vector2 position, Grid grid) {
        this.gridTileType = gridTileType;
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

    /**
     * gibt die {@link GridTileType gridTileTypen} aller umliegenden {@link GridTile gridTiles} zurrück.
     *
     * @return {@link GridTileType gridTileTypen} der umliegenden {@link GridTile gridTiles}
     * @since 0.1.3
     */
    public GridTileType[] getSorroundings() {
        GridTileType[] result = new GridTileType[8];
        result[0] = grid.getGridTile((int) position.x - 1, (int) position.y + 1).getGridTileType();
        result[1] = getUpperTile().getGridTileType();
        result[2] = grid.getGridTile((int) position.x + 1, (int) position.y + 1).getGridTileType();
        result[3] = getLeftGridTile().getGridTileType();
        result[4] = getRightGridTile().getGridTileType();
        result[5] = grid.getGridTile((int) position.x - 1, (int) position.y - 1).getGridTileType();
        result[6] = getLowerTile().getGridTileType();
        result[7] = grid.getGridTile((int) position.x + 1, (int) position.y - 1).getGridTileType();
        return result;
    }

    /**
     * gibt das {@link GridTile gridTile} über diesem zurrück.
     *
     * @return {@link GridTile gridTile} über diesem.
     * @since 0.1.3
     */
    public GridTile getUpperTile() {
        return grid.getGridTile((int) position.x, (int) position.y + 1);
    }

    /**
     * gibt das {@link GridTile gridTile} unter diesem zurrück.
     *
     * @return {@link GridTile gridTile} unter diesem.
     * @since 0.1.3
     */
    public GridTile getLowerTile() {

        return grid.getGridTile((int) position.x, (int) position.y - 1);
    }

    /**
     * gibt das {@link GridTile gridTile} links neben diesem zurrück.
     *
     * @return {@link GridTile gridTile} links neben diesem.
     * @since 0.1.3
     */
    public GridTile getLeftGridTile() {

        return grid.getGridTile((int) position.x - 1, (int) position.y);
    }

    /**
     * gibt das {@link GridTile gridTile} rechts neben diesem zurrück.
     *
     * @return {@link GridTile gridTile} links neben diesem.
     * @since 0.1.3
     */
    public GridTile getRightGridTile() {

        return grid.getGridTile((int) position.x + 1, (int) position.y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public GridTileType getGridTileType() {
        return gridTileType;
    }

    public void setGridTileType(GridTileType gridTileType) {
        this.gridTileType = gridTileType;
    }
}