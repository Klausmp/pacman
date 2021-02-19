package de.klausmp.pacman.world.grid;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;

/**
 * einzelteil eines {@link Grid grids}. <br>
 * alle {@link GameObject gameObjete} werden in einem gridTile gespeichert
 *
 * @author Klausmp
 * @version 0.10.3
 * @since 0.0.1
 */
public class GridTile {

    /**
     * position innerhalb des {@link Grid grids}. <br>
     * NUR GANZEZAHLEN
     *
     * @since 0.0.1
     */
    private final Vector2 position;

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
    private final Grid grid;

    /**
     * liste indem alle {@link GameObject gameObjete} dieses {@link GridTile gridTiles} gespeichert sind.
     *
     * @since 0.0.1
     */
    private final Array<GameObject> gameObjects = new Array<GameObject>();

    private GridTile[] surroundingGridTiles = new GridTile[4];

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
     * @version 0.5.0
     * @since 0.0.1
     */
    public void update(float deltaTime) {
        for (int i = 0; i < gameObjects.size; i++) {
            //gameObjects.get(i).update(deltaTime);
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
    public void removeDeadGameObjects() {
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
    public GameObject getGameObjectByType(GameObjectType gameObjectType) throws NullPointerException {
        for (GameObject object : gameObjects) {
            if (object.getGameObjectType().equals(gameObjectType)) {
                return object;
            }
        }
        return null;
    }

    /**
     * dreht ein array von {@link GridTileType gridTileTypen} im uhrzeigersinn um 90°.
     *
     * @param suroundings array der umliegenden {@link GridTileType gridTileTypen} eines {@link GridTile gridTiles}.
     * @return {@link GridTile#getSurroundingGridTileTypes() surrundings} werden um 90° im uhrzeigersinn gedreht.
     * @since 0.1.4
     */
    public static GridTileType[] rotateSuroundings(GridTileType[] suroundings) {
        GridTileType[] result = new GridTileType[4];
        result[Rotation.UP.getInt()] = suroundings[Rotation.LEFT.getInt()];
        result[Rotation.RIGHT.getInt()] = suroundings[Rotation.UP.getInt()];
        result[Rotation.DOWN.getInt()] = suroundings[Rotation.RIGHT.getInt()];
        result[Rotation.LEFT.getInt()] = suroundings[Rotation.DOWN.getInt()];
        return result;
    }

    /**
     * gibt die {@link GridTileType gridTileTypen} aller umliegenden {@link GridTile gridTiles} zurrück.
     *
     * @return {@link GridTileType gridTileTypen} der umliegenden {@link GridTile gridTiles}
     * @since 0.1.4
     */
    public GridTileType[] getSurroundingGridTileTypes() {
        GridTileType[] result = new GridTileType[4];
        result[Rotation.UP.getInt()] = getUpperTile().getGridTileType();
        result[Rotation.RIGHT.getInt()] = getRightGridTile().getGridTileType();
        result[Rotation.DOWN.getInt()] = getLowerTile().getGridTileType();
        result[Rotation.LEFT.getInt()] = getLeftGridTile().getGridTileType();
        return result;
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since 0.9.3
     */
    public GridTile[] getSurroundingGridTiles() {
        if (surroundingGridTiles[Rotation.UP.getInt()] != null && surroundingGridTiles[Rotation.LEFT.getInt()] != null && surroundingGridTiles[Rotation.DOWN.getInt()] != null && surroundingGridTiles[Rotation.RIGHT.getInt()] != null) {
            return surroundingGridTiles;
        }
        GridTile[] result = new GridTile[4];
        result[Rotation.UP.getInt()] = getUpperTile();
        result[Rotation.RIGHT.getInt()] = getRightGridTile();
        result[Rotation.DOWN.getInt()] = getLowerTile();
        result[Rotation.LEFT.getInt()] = getLeftGridTile();
        surroundingGridTiles = result;
        return result;
    }

    /**
     * gibt das {@link GridTile gridTile} über diesem zurrück.
     *
     * @return {@link GridTile gridTile} über diesem.
     * @since 0.1.3
     */
    public GridTile getUpperTile() {
        if (surroundingGridTiles[Rotation.UP.getInt()] != null) {
            return surroundingGridTiles[Rotation.UP.getInt()];
        }
        return grid.getGridTile((int) position.x, (int) position.y + 1);
    }

    /**
     * gibt das {@link GridTile gridTile} unter diesem zurrück.
     *
     * @return {@link GridTile gridTile} unter diesem.
     * @since 0.1.3
     */
    public GridTile getLowerTile() {
        if (surroundingGridTiles[Rotation.DOWN.getInt()] != null) {
            return surroundingGridTiles[Rotation.DOWN.getInt()];
        }
        return grid.getGridTile((int) position.x, (int) position.y - 1);
    }

    /**
     * gibt das {@link GridTile gridTile} links neben diesem zurrück.
     *
     * @return {@link GridTile gridTile} links neben diesem.
     * @since 0.1.3
     */
    public GridTile getLeftGridTile() {
        if (surroundingGridTiles[Rotation.LEFT.getInt()] != null) {
            return surroundingGridTiles[Rotation.LEFT.getInt()];
        }
        return grid.getGridTile((int) position.x - 1, (int) position.y);
    }

    /**
     * gibt das {@link GridTile gridTile} rechts neben diesem zurrück.
     *
     * @return {@link GridTile gridTile} links neben diesem.
     * @since 0.1.3
     */
    public GridTile getRightGridTile() {
        if (surroundingGridTiles[Rotation.RIGHT.getInt()] != null) {
            return surroundingGridTiles[Rotation.RIGHT.getInt()];
        }
        return grid.getGridTile((int) position.x + 1, (int) position.y);
    }

    /**
     * TODO JAVADOC
     *
     * @return
     * @since 0.4.0
     */
    @Deprecated
    public void removeGameObject(GameObject object) {
        gameObjects.removeValue(object, false);
    }

    /**
     * TODO JAVADOC
     *
     * @since 0.4.0
     */
    public boolean checkForGameObject(GameObject object) {
        for (GameObject gameObject : gameObjects) {
            if (object.equals(gameObject)) {
                return true;
            }
        }
        return false;
    }

    /**
     * TODO JAVA DOC
     *
     * @param object
     * @return
     * @since 0.9.8
     */
    public boolean canWalkOn(GameObjectType gameObjectType) {
        switch (getGridTileType()) {
            case DOOR:
            case BED:
                if (gameObjectType == GameObjectType.GHOST) {
                    return true;
                } else {
                    return false;
                }
            case INFWALL:
            case WALL:
            case EMTY:
                return false;
            case INTERSECTION:
            case ROAD:
                return true;
            default:
                return false;
        }
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

    public Array<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Grid getGrid() {
        return grid;
    }

    public void print() {
        System.out.print(gridTileType.getType());
    }
}