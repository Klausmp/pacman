package de.klausmp.pacman.utils;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.gameObjects.staticGameObjects.textured.wall.Wall;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * type {@link GridTile gridTiles} an,
 *
 * @author Klausmp
 * @version 0.9.8
 * @since 0.1.3
 */
public enum GridTileType {

    /**
     * {@link GridTile gridTile} welches eine
     * {@link Wall wall}
     * enthällt
     *
     * @since 0.1.3
     */
    WALL(1),

    /**
     * {@link GridTile gridTile} welches kein
     * {@link de.klausmp.pacman.gameObjects.GameObject gameObject} enthällt.
     *
     * @since 0.1.3
     */
    EMTY(0),

    /**
     * {@link GridTile gridTile} welches von {@link PacMan pacMan}
     * und den {@link Ghost geistern} zum laufen benutzt wird.
     *
     * @since 0.1.3
     */
    ROAD(2),

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    INTERSECTION(3),

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.8
     */
    DOOR(4),

    /**
     * TODO JAVA DOC
     * @since 0.9.1
     */
    INFWALL(6),

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.8
     */
    BED(7);

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.1
     */
    private final int type;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.1
     */
    GridTileType(int type) {
        this.type = type;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.1
     */
    public int getType() {
        return type;
    }
}
