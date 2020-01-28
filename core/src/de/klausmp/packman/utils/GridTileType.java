package de.klausmp.packman.utils;

import de.klausmp.packman.gameObjects.kinematicGameObjects.Ghost;
import de.klausmp.packman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.packman.gameObjects.staticGameObjects.Wall;

/**
 * type {@link de.klausmp.packman.level.GridTile gridTiles} an,
 *
 * @author Klausmp
 * @version 0.1.3
 * @since 0.1.3
 */
public enum GridTileType {

    /**
     * {@link de.klausmp.packman.level.GridTile gridTile} welches eine
     * {@link Wall wall}
     * enthällt
     *
     * @since 0.1.3
     */
    WALL,

    /**
     * {@link de.klausmp.packman.level.GridTile gridTile} welches kein
     * {@link de.klausmp.packman.gameObjects.GameObject gameObject} enthällt.
     *
     * @since 0.1.3
     */
    EMTY,

    /**
     * {@link de.klausmp.packman.level.GridTile gridTile} welches von {@link PacMan pacMan}
     * und den {@link Ghost geistern} zum laufen benutzt wird.
     *
     * @since 0.1.3
     */
    ROAD
}
