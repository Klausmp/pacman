package de.klausmp.packman.utils;

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
     * {@link de.klausmp.packman.gameObjects.Wall wall}
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
     * {@link de.klausmp.packman.level.GridTile gridTile} welches von {@link de.klausmp.packman.gameObjects.PacMan pacMan}
     * und den {@link de.klausmp.packman.gameObjects.Ghost geistern} zum laufen benutzt wird.
     *
     * @since 0.1.3
     */
    ROAD;

}
