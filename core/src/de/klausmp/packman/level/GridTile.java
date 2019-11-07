package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;

/**
 * @author Klausmp
 */
public class GridTile {

    private Vector2 position;
    private Vector2 size;

    public GridTile(Vector2 position) {
        this.position = position;
        size = new Vector2(32, 32);

    }
}
