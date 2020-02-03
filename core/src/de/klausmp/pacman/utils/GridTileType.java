package de.klausmp.pacman.utils;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.pacman.gameObjects.staticGameObjects.Wall;

/**
 * type {@link de.klausmp.pacman.level.GridTile gridTiles} an,
 *
 * @author Klausmp
 * @version 0.1.3
 * @since 0.1.3
 */
public enum GridTileType {

    /**
     * {@link de.klausmp.pacman.level.GridTile gridTile} welches eine
     * {@link Wall wall}
     * enthällt
     *
     * @since 0.1.3
     */
    WALL,

    /**
     * {@link de.klausmp.pacman.level.GridTile gridTile} welches kein
     * {@link de.klausmp.pacman.gameObjects.GameObject gameObject} enthällt.
     *
     * @since 0.1.3
     */
    EMTY,

    /**
     * {@link de.klausmp.pacman.level.GridTile gridTile} welches von {@link PacMan pacMan}
     * und den {@link Ghost geistern} zum laufen benutzt wird.
     *
     * @since 0.1.3
     */
    ROAD
}
