package de.klausmp.pacman.utils;

import com.badlogic.gdx.utils.Array;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.gameObjects.staticGameObjects.textured.dots.BigDot;
import de.klausmp.pacman.gameObjects.staticGameObjects.textured.dots.Dot;
import de.klausmp.pacman.gameObjects.staticGameObjects.textured.wall.Wall;

/**
 * liste aller {@link GameObject GameObject} typen.
 *
 * @author Klausmp
 * @version 0.9.8
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
     * TODO JAVA DOC
     *
     * @since 0.9.7
     */
    DOOR(255, 255, 255),

    /**
     * @version 0.7.0
     * @see PacMan
     * @since 0.0.1
     */
    PACMAN(255, 0, 0),

    /**
     * @version 0.9.2
     * @see Ghost
     * @since 0.0.1
     */
    GHOST(50, 50, 50),

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
    BIGDOT(100, 255, 0),

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.8
     */
    BED(252, 181, 255),

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.8
     */
    INVWALL(0, 74, 127),

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.7
     */
    NULL(0, 0, 0);

    /**
     * zeigt die r g b werte der einzelnen {@link GameObjectType gameObjectTypen} an.
     *
     * @since 0.7.0
     */
    private int r, g, b;

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

    /**
     * TODO JAVA DOC
     *
     * @param r red
     * @param g green
     * @param b blue
     * @return
     * @throws NullPointerException
     * @version 0.9.8
     * @since 0.7.3
     */
    public static GameObjectType getGameObjecTypeFromColor(int r, int g, int b) throws NullPointerException {
        if ((GameObjectType.WALL.getR() == r && (GameObjectType.WALL.getG() == g) && (GameObjectType.WALL.getB() == b))) {
            return GameObjectType.WALL;
        }

        if ((GameObjectType.DOT.getR() == r && (GameObjectType.DOT.getG() == g) && (GameObjectType.DOT.getB() == b))) {
            return GameObjectType.DOT;
        }

        if ((GameObjectType.BIGDOT.getR() == r && (GameObjectType.BIGDOT.getG() == g) && (GameObjectType.BIGDOT.getB() == b))) {
            return GameObjectType.BIGDOT;
        }

        if ((GameObjectType.GHOST.getR() == r && (GameObjectType.GHOST.getG() == g) && (GameObjectType.GHOST.getB() == b))) {
            return GameObjectType.GHOST;
        }

        if ((GameObjectType.PACMAN.getR() == r && (GameObjectType.PACMAN.getG() == g) && (GameObjectType.PACMAN.getB() == b))) {
            return GameObjectType.PACMAN;
        }

        if ((GameObjectType.DOOR.getR() == r && (GameObjectType.DOOR.getG() == g) && (GameObjectType.DOOR.getB() == b))) {
            return GameObjectType.DOOR;
        }

        if ((GameObjectType.BED.getR() == r && (GameObjectType.BED.getG() == g) && (GameObjectType.BED.getB() == b))) {
            return GameObjectType.BED;
        }

        if ((GameObjectType.INVWALL.getR() == r && (GameObjectType.INVWALL.getG() == g) && (GameObjectType.INVWALL.getB() == b))) {
            return GameObjectType.INVWALL;
        }

        return NULL;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}