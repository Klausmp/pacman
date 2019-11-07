package de.klausmp.packman.level;

import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.gameObjects.Dot;
import de.klausmp.packman.gameObjects.PacMan;
import de.klausmp.packman.gameObjects.Wall;

/**
 * @author Klausmp
 */
public abstract class Level {

    private Array<Wall> walls = new Array<Wall>();
    private Array<Dot> dots = new Array<Dot>();
    private PacMan pacMan;

    public Level() {


    }
}
