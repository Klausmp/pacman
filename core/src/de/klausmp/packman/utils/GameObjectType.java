package de.klausmp.packman.utils;

import de.klausmp.packman.gameObjects.*;
import de.klausmp.packman.gameObjects.kinematicGameObjects.Ghost;
import de.klausmp.packman.gameObjects.staticGameObjects.Dot;
import de.klausmp.packman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.packman.gameObjects.staticGameObjects.Wall;

/**
 * liste aller {@link GameObject GameObject} typen.
 *
 * @author Klausmp
 * @version  0.0.1
 * @since 0.0.1
 */
public enum GameObjectType {
    /**
     * @see Wall
     * @since 0.0.1
     */
    WALL,
    /**
     * @see PacMan
     * @since 0.0.1
     */
    PACMAN,
    /**
     * @see Ghost
     * @since 0.0.1
     */
    GHOST,
    /**
     * @see Dot
     * @since 0.0.1
     */
    DOT
}