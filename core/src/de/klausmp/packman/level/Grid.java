package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.visuals.renderer.LayerRenderer;

/**
 * @author Klausmp
 * @version 0.0.1
 * @since 0.0.1
 */
//TODO wert für höhe und breite eines gridTiles
public class Grid {
    /**
     * default größe des grids in x und y richtung
     *
     * @since 0.0.1
     */
    private final int DEFAULTGRIDSIZE = 32;

    /**
     * liste aller {@link GridTile gridTiles} im {@link Grid grid}.
     *
     * @since 0.0.1
     */
    private Array<GridTile> gridTiles = new Array<GridTile>();

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
    public void create(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                gridTiles.add(new GridTile(new Vector2((x * DEFAULTGRIDSIZE) + position.x, (y * DEFAULTGRIDSIZE) + position.y), this));
            }
        }
    }

    /**
     * updated alle {@link GridTile gridTiles} in der liste {@link #gridTiles gridTiles}.
     *
     * @since 0.0.1
     */
    public void update() {
        for (GridTile gridTile : gridTiles) {
            gridTile.update();
        }
    }

    /**
     * rendert alle gridTiles mit der instance des {@link LayerRenderer layerRenderes}.
     *
     * @param renderer instabce des {@link LayerRenderer layerRenderers} in aktiven {@link com.badlogic.gdx.Screen screens}
     * @since 0.0.1
     */
    public void render(LayerRenderer renderer) {
        for (GridTile gridTile : gridTiles) {
            gridTile.render(renderer);
        }
    }

    /**
     * @param posX x position des gesuchten {@link GridTile gridTiles}.
     * @param posY y position des gesuchten {@link GridTile gridTiles}.
     * @return das gridTile mit den x und y werten
     * @throws NullPointerException gibt NULL zurrück wenn kein passendes {@link GridTile gridTile} gefunden wird
     * @since 0.0.1
     */
    public GridTile getGridTile(int posX, int posY) {
        for (GridTile gridTile : gridTiles) {
            if (gridTile.getPosition().x == posX && gridTile.getPosition().y == posY) {
                return gridTile;
            }
        }
        //System.out.println("No GridTile at Position: " + posX + " and " + posY);
        return null;
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
     * @since 0.0.1
     */
    public void addToGridTile(GameObject gameObject, Vector2 position) {
        if (getGridTile((int) position.x, (int) position.y) != null) {
            getGridTile((int) position.x, (int) position.y).addGameObject(gameObject);
        } else {
            gridTiles.add(new GridTile(position, this));
            addToGridTile(gameObject, position);
        }
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

    public Vector2 getPosition() {
        return position;
    }

    public void addTile(GridTile gridTile) {
        gridTiles.add(gridTile);
    }

    public Vector2 getSize() {
        return size;
    }

    public int getDEFAULTGRIDSIZE() {
        return DEFAULTGRIDSIZE;
    }
}