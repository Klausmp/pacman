package de.klausmp.packman.level;


import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.Wall;

/**
 * @author Klausmp
 */
public class TESTLEVEL extends Level {

    public TESTLEVEL() {
        super();
//        for (int x = 0; x < grid.getSize().x - 1; x++) {
//            for (int y = 0; y < grid.getSize().y - 1; y++) {
//                grid.addToGridTile(new Wall(new Vector2(x * 16, y * 16)), x, y);
//            }
//        }
        grid.addToGridTile(new Wall(new Vector2(10 * 16, 10 * 16)), new Vector2(10 , 10));
    }
}
