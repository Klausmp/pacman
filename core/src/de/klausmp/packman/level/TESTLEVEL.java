package de.klausmp.packman.level;


import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.Wall;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 */
public class TESTLEVEL extends Level {

    public TESTLEVEL() {
        super();
        for (int y = 0; y < 5; y++) {
            grid.addToGridTile(new Wall(new Vector2(0 * 16, y * 16), grid.getGridTile(0, y)), 0, y);
        }
        for (int x = 1; x < 5; x++) {
            grid.addToGridTile(new Wall(new Vector2(x * 16, 0 * 16), grid.getGridTile(x, 0)), x, 0);
        }


        for (int x = 0; x < grid.getSize().x - 1; x++) {
            for (int y = 0; y < grid.getSize().y - 1; y++) {
                if (grid.getGridTile(x, y).getGameObjectByType(GameObjectType.WALL) != null && grid.getGridTile(x, y).getGameObjects().get(0) instanceof Wall) {
                    Wall wall = (Wall) grid.getGridTile(x, y).getGameObjects().get(0);
                    wall.setTexture(GameScreen.getAtlas());
                }
            }
        }
    }
}
