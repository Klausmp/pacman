package de.klausmp.packman.utils;

import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.packman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.packman.gameObjects.staticGameObjects.BigDot;
import de.klausmp.packman.gameObjects.staticGameObjects.Dot;
import de.klausmp.packman.gameObjects.staticGameObjects.Wall;

/**
 * liste aller {@link GameObject GameObject} typen.
 *
 * @author Klausmp
 * @version 0.7.1
 * @since 0.0.1
 */
public enum GameObjectType {
    /**
     * @version 0.7.0
     * @see Wall
     * @since 0.0.1
     */
    WALL(0, 0, 255),
    /**
     * @version 0.7.0
     * @see PacMan
     * @since 0.0.1
     */
    PACMAN(0, 0, 0),
    /**
     * @version 0.7.0
     * @see Ghost
     * @since 0.0.1
     */
    GHOST(0, 0, 0),
    /**
     * @version 0.7.0
     * @see Dot
     * @since 0.0.1
     */
    DOT(200, 255, 0),

    /**
     * @verson 0.7.1
     * @see BigDot
     * @since 0.7.0
     */
    BIGDOT(100, 255, 0);

    /**
     * zeigt die r g b werte der einzelnen {@link GameObjectType gameObjectTypen} an.
     *
     * @since 0.7.0
     */
    public int r, g, b;

    /**
     * @param r
     * @param g
     * @param b
     * @version 0.7.0
     * @since 0.7.0
     */
    GameObjectType(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        //TODO LISTE MIt ALLEN eSSbAren GAMe OBJECTTYPEN + IMPLEMENTIErUNG IN DER PACMAN METHODE ZUM ESSEN.
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @version 0.7.0
     * @since 0.7.0
     */
    public static Array<GameObjectType> edibles() {
        Array<GameObjectType> edibles = new Array<GameObjectType>();
        edibles.add(GameObjectType.DOT);
        edibles.add(GameObjectType.BIGDOT);
        return edibles;
    }
}