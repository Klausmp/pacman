package de.klausmp.pacman.world.grid;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.UpdatebleGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Blinky;
import de.klausmp.pacman.gameObjects.staticGameObjects.nonTextured.Bed;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;

import java.util.HashMap;

/**
 * raster auf dem die {@link GameObject gameObjekte} sich verteilen, bewegen und gespeichert werden.
 *
 * @author Klausmp
 * @version 0.10.3
 * @since 0.0.1
 */
public class Grid {
    /**
     * default größe des grids in x und y richtung
     *
     * @since 0.0.1
     */
    private static final int DEFAULTGRIDSIZE = 27;

    /**
     * TODO JAVA DOC
     *
     * @since 0.10.3
     */
    private final Array<GridTile> gridTilesWereSomethingDied = new Array<GridTile>();

    /**
     * TODO JAVA DOC
     *
     * @since 0.10.3
     */
    private final Array<UpdatebleGameObject> updatebleGameObjects = new Array<UpdatebleGameObject>();

    /**
     * hasmap aller {@link GridTile gridTiles} im {@link Grid grid}.
     *
     * @since 0.10.2
     */
    private final HashMap<String, GridTile> gridTiles = new HashMap<String, GridTile>();

    /**
     * verschiebung des {@link Grid grids} (in pixel) in x und y richtung.
     *
     * @since 0.0.1
     */
    private Vector2 position;

    /**
     * größe des grids in x und y richtung
     *
     * @since 0.0.1
     */
    private Vector2 size;

    /**
     * TODO JAVADOC
     *
     * @since 0.4.0
     */
    private static final Vector2 gridTileSize = new Vector2(16, 16);

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.1
     */
    private PacMan pacMan;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    private Blinky blinky;

    private Bed bed;


    /**
     * default konstruktor mit standart einstellungen.
     *
     * @since 0.0.1
     */
    public Grid() {
        create(new Vector2(0, 0), new Vector2(DEFAULTGRIDSIZE, DEFAULTGRIDSIZE));
    }

    /**
     * konstruktor mit einstellungesmöglichkeiten der {@link #position position} und der {@link #size size}.
     *
     * @param position {@link #position siehe hier}
     * @param size     {@link #size siehe hier}
     * @since 0.0.1
     */
    public Grid(Vector2 position, Vector2 size) {
        create(position, size);
    }

    /**
     * konstruktor mit einstellungesmöglichkeiten der {@link #size size}.
     *
     * @param size {@link #size siehe hier}
     * @since 0.0.1
     */
    public Grid(Vector2 size) {
        create(new Vector2(0, 0), size);
    }

    /**
     * konstruktor mit einstellungesmöglichkeiten der {@link #position position}.
     *
     * @param posX x - wert der {@link #position poistion}
     * @param posY y - wert der {@link #position position}
     * @since 0.0.1
     */
    public Grid(float posX, float posY) {
        create(new Vector2(posX, posY), new Vector2(DEFAULTGRIDSIZE, DEFAULTGRIDSIZE));
    }

    /**
     * setzt die werte bei der erstellung eines {@link Grid grids}. <br>
     * wird nur im konstruktor verwendet.
     *
     * @param position
     * @param size
     * @since 0.0.1
     */
    private void create(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
        /*for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                addTile(new GridTile(GridTileType.WALL, new Vector2((x * DEFAULTGRIDSIZE) + position.x, (y * DEFAULTGRIDSIZE) + position.y), this));
            }
        }*/
    }

    /**
     * updated alle {@link GridTile gridTiles} in der liste {@link #gridTiles gridTiles}.
     *
     * @version 0.5.0
     * @since 0.0.1
     */
    public void update(float deltaTime) {
        updatebleGameObjects.forEach(updatebleGameObject -> updatebleGameObject.update(deltaTime));
        if (!gridTilesWereSomethingDied.isEmpty()) {
            removeDeadGameObjects();
            gridTilesWereSomethingDied.clear();
        }
    }

    /**
     * rendert alle gridTiles mit der instance des {@link LayerRenderer layerRenderes}.
     *
     * @param renderer instabce des {@link LayerRenderer layerRenderers} in aktiven {@link com.badlogic.gdx.Screen screens}
     * @since 0.0.1
     */
    public void render(LayerRenderer renderer) {
        gridTiles.forEach((string, gridTile) -> gridTile.render(renderer));
    }

    /**
     * durchsucht die liste der {@link #gridTiles gridtiles} nach einem mit den passenden koordinaten.
     * wennn keines gefunden wird wird NULL zurrückgegeben.
     * nur ganze zahlen
     *
     * @param posX x position des gesuchten {@link GridTile gridTiles}.
     * @param posY y position des gesuchten {@link GridTile gridTiles}.
     * @return das gridTile mit den x und y werten
     * @since 0.4.0
     */
    public GridTile getGridTile(float posX, float posY) {
        GridTile gridTile = gridTiles.get(posX + "-" + posY);
        if (gridTile == null) {
            addEmtyGridTile(new Vector2(posX, posY), this);
            return getGridTile(posX, posY);
        } else {
            return gridTile;
        }
    }

    /**
     * durchsucht die liste der {@link #gridTiles gridtiles} nach einem mit den passenden koordinaten.
     * wennn keines gefunden wird wird NULL zurrückgegeben.
     * nur ganze zahlen
     *
     * @param position position des geuchten {@link GridTile gridTiles}
     * @return das gridTile an der gegebenen position
     * @since 0.0.1
     */
    public GridTile getGridTile(Vector2 position) {
        return getGridTile((int) position.x, (int) position.y);
    }

    /**
     * fügt die inctanze des {@link GameObject gameObjekts} zum {@link GridTile gridTile} mit der
     * angegebenen position. <br>
     * wenn an der geuchten stelle kein {@link GridTile gridTile} vorhanden ist wird ein neues erstellt.
     *
     * @param gameObject {@link GameObject gameObjekt} welches hinzugefügt werden soll
     * @param position   position des {@link GridTile gridTiles} zu dem das {@link GameObject gameObjekt} hinzugefügt werden soll
     * @since 0.1.3
     */
    public void addToGridTile(GameObject gameObject, Vector2 position) {
        GridTile gridTile = getGridTile((int) position.x, (int) position.y);
        if (gridTile != null) {
            if (gameObject instanceof UpdatebleGameObject) {
                updatebleGameObjects.add((UpdatebleGameObject) gameObject);
            }
            switch (gameObject.getGameObjectType()) {
                case DOT:
                case BIGDOT:
                case GHOST:
                case PACMAN:
                    gridTile.setGridTileType(GridTileType.ROAD);
                    break;
                case WALL:
                    gridTile.setGridTileType(GridTileType.WALL);
                    break;
                case NULL:
                    gridTile.setGridTileType(GridTileType.EMTY);
                    break;
                case DOOR:
                    gridTile.setGridTileType(GridTileType.DOOR);
                    break;
                case BED:
                    gridTile.setGridTileType(GridTileType.BED);
                    break;
                case INVWALL:
                    gridTile.setGridTileType(GridTileType.INFWALL);
                    break;
                default:
                    System.out.println("ERROR IN GRID.ADDTOGRIDTILE. Kein GameObjectType gefunden: " + gameObject.getGameObjectType());
                    break;
            }
            gridTile.addGameObject(gameObject);
        } else {
            addEmtyGridTile(position, this);
            addToGridTile(gameObject, position);
        }
    }

    /**
     * fügt ein neues {@link GridTile gridTile} zu diesem {@link Grid grid} hinzu.
     *
     * @param gridTileType type des neuen {@link GridTile gridTiles}
     * @param position     position des neuen {@link GridTile gridTiles}
     * @param grid         {@link Grid grid} indem sich das neue {@link GridTile gridTile} befindet
     * @since 0.1.3
     */
    public GridTile addEmtyGridTile(GridTileType gridTileType, Vector2 position, Grid grid) {
        GridTile gridTile = new GridTile(gridTileType, position, grid);
        addTile(gridTile);
        return gridTile;
    }

    /**
     * fügt ein neues {@link GridTile gridTile} zu diesem {@link Grid grid} hinzu.
     *
     * @param position position des neuen {@link GridTile gridTiles}
     * @param grid     {@link Grid grid} indem sich das neue {@link GridTile gridTile} befindet
     * @since 0.1.3
     */
    public GridTile addEmtyGridTile(Vector2 position, Grid grid) {
        GridTile gridTile = new GridTile(GridTileType.ROAD, position, grid);
        addTile(gridTile);
        return gridTile;
    }

    /**
     * fügt die inctanze des {@link GameObject gameObjekts} zum {@link GridTile gridTile} mit
     * den passenden x und y koordinaten
     *
     * @param gameObject {@link GameObject gameObjekt} welches hinzugefügt werden soll
     * @param posX       x position des {@link GridTile gridTiles} zu dem das {@link GameObject gameObjekt} hinzugefügt werden soll
     * @param posY       y position des {@link GridTile gridTiles} zu dem das {@link GameObject gameObjekt} hinzugefügt werden soll
     * @since 0.0.1
     */
    public void addToGridTile(GameObject gameObject, int posX, int posY) {
        addToGridTile(gameObject, new Vector2(posX, posY));
    }

    /**
     * TODO JAVA DOC
     *
     * @param gridTilePosition
     * @return
     * @since 0.4.0
     */
    public static Vector2 convertToPixelPosition(Vector2 gridTilePosition) {
        return new Vector2(gridTilePosition.x * gridTileSize.x, gridTilePosition.y * gridTileSize.x);
    }

    /**
     * TODO JAVADOC
     *
     * @param pixelPosition
     * @return
     * @since 0.4.0
     */
    public static Vector2 convertToGridPosition(Vector2 pixelPosition) {
        return new Vector2(pixelPosition.x / gridTileSize.x, pixelPosition.y / gridTileSize.y);
    }

    /**
     * TODO JAVADOC
     *
     * @param newGridTile
     * @since 0.4.0
     */
    public void transverToOtherGridTile(GameObject object, GridTile newGridTile) {
        GridTile oldGridTile = object.getCurrendGridTile();
        newGridTile.addGameObject(object);
        oldGridTile.removeGameObject(object);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void addTile(GridTile gridTile) {
        //System.out.println(gridTile.getPosition().x +"-" +gridTile.getPosition().y);
        gridTiles.put(gridTile.getPosition().x + "-" + gridTile.getPosition().y, gridTile);
    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public static int getDEFAULTGRIDSIZE() {
        return DEFAULTGRIDSIZE;
    }

    public HashMap<String, GridTile> getGridTiles() {
        return gridTiles;
    }

    @Deprecated
    public Array<GridTile> getGridTilesAsList() {
        Array<GridTile> array = new Array<GridTile>();
        gridTiles.forEach((string, gridTile) -> array.add(gridTile));
        return array;
    }

    public static Vector2 getGridTileSize() {
        return gridTileSize;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.10.3
     */
    private void removeDeadGameObjects() {
        for (GridTile gridTile: gridTilesWereSomethingDied) {
            gridTile.removeDeadGameObjects();
        }
        Array<UpdatebleGameObject> deadGameObjects = new Array<UpdatebleGameObject>();
        for (UpdatebleGameObject updatable : updatebleGameObjects) {
            GameObject gameObject = (GameObject) updatable;
            if (!gameObject.isAlive()) {
                deadGameObjects.add((UpdatebleGameObject) gameObject);
            }
        }
        updatebleGameObjects.removeAll(deadGameObjects, true);

    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since 0.9.1
     */
    public PacMan getPacMan() throws NullPointerException {
        if (pacMan != null) {
            return this.pacMan;
        }
        for (GridTile gridTile : getGridTilesAsList()) {
            for (GameObject gameObject : gridTile.getGameObjects()) {
                if (gameObject instanceof PacMan) {
                    this.pacMan = (PacMan) gameObject;
                    return (PacMan) gameObject;
                }
            }
        }
        return null;
    }

    public void addGridTilesToRemoveDeadObjectsFrom(GridTile gridTile) {
        gridTilesWereSomethingDied.add(gridTile);
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since 0.9.5
     */
    public Blinky getBlinky() throws NullPointerException {
        if (blinky != null) {
            return this.blinky;
        }
        for (GridTile gridTile : getGridTilesAsList()) {
            for (GameObject gameObject : gridTile.getGameObjects()) {
                if (gameObject instanceof Blinky) {
                    this.blinky = (Blinky) gameObject;
                    return (Blinky) gameObject;
                }
            }
        }
        return null;
    }

    public Bed getBed() throws NullPointerException {
        if (bed != null) {
            return this.bed;
        }
        for (GridTile gridTile : getGridTilesAsList()) {
            for (GameObject gameObject : gridTile.getGameObjects()) {
                if (gameObject instanceof Bed) {
                    this.bed = (Bed) gameObject;
                    return (Bed) gameObject;
                }
            }
        }
        return null;
    }

    public void print() {
        for (int x = 0; x < gridTileSize.x; x++) {
            for (int y = 0; y < gridTileSize.y; y++) {
                getGridTile(x, y).print();
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}