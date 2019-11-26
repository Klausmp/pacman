package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * @author Klausmp
 */
public class Grid {
    private final int GRINDSIZE = 32;
    private final int DEFAULTGRIDSIZE = 32;
    private Array<GridTile> gridTiles = new Array<GridTile>();
    private Vector2 position;
    private Vector2 size;

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
                gridTiles.add(new GridTile(new Vector2((x * GRINDSIZE) + position.x, (y * GRINDSIZE) + position.y), this));
            }
        }
    }

    public void update() {
        for (GridTile gridTile : gridTiles) {
            gridTile.update();
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public void addTile(GridTile gridTile) {
        gridTiles.add(gridTile);
    }
}