package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.visuals.renderer.LayerRenderer;

/**
 * @author Klausmp
 */
//TODO JAVA DOC MACHEN
public class Grid {
    private final int DEFAULTGRIDSIZE = 32;
    private Array<GridTile> gridTiles = new Array<GridTile>();
    private Vector2 position;
    private Vector2 size;
    private Map map;

    public Grid() {
        create(new Vector2(0, 0), new Vector2(DEFAULTGRIDSIZE, DEFAULTGRIDSIZE));
    }

    public Grid(Vector2 position, Vector2 size) {
        create(position, size);
    }

    public Grid(Vector2 size) {
        create(new Vector2(0, 0), size);
    }

    public Grid(float posX, float posY) {
        create(new Vector2(posX, posY), new Vector2(DEFAULTGRIDSIZE, DEFAULTGRIDSIZE));
    }

    public void create(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                gridTiles.add(new GridTile(new Vector2((x * DEFAULTGRIDSIZE) + position.x, (y * DEFAULTGRIDSIZE) + position.y), this));
            }
        }
    }

    public void update() {
        for (GridTile gridTile : gridTiles) {
            gridTile.update();
        }
    }

    public void render(LayerRenderer renderer) {
        for (GridTile gridTile : gridTiles) {
            gridTile.render(renderer);
        }
    }

    public GridTile getGridTile(int posX, int posY) {
        for (GridTile gridTile : gridTiles) {
            if (gridTile.getPosition().x == posX && gridTile.getPosition().y == posY) {
                return gridTile;
            }
        }
        //System.out.println("No GridTile at Position: " + posX + " and " + posY);
        return null;
    }

    public GridTile getGridTile(Vector2 position) {
        return getGridTile((int) position.x, (int) position.y);
    }

    public void addToGridTile(GameObject gameObject, Vector2 position) {
        if (getGridTile((int) position.x, (int) position.y) != null) {
            getGridTile((int) position.x, (int) position.y).addGameObject(gameObject);
        } else {
            gridTiles.add(new GridTile(position, this));
            addToGridTile(gameObject, position);
        }
    }

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