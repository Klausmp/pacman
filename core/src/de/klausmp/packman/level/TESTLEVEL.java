package de.klausmp.packman.level;


import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.packman.gameObjects.kinematicGameObjects.DeadPacMan;
import de.klausmp.packman.gameObjects.staticGameObjects.Dot;
import de.klausmp.packman.gameObjects.staticGameObjects.Wall;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 */
public class TESTLEVEL extends Level {

    public TESTLEVEL() {
        super();

        grid.addToGridTile(new Wall(new Vector2(0 * 16, 0), grid.getGridTile(0, 0)), 0, 0);
        grid.addToGridTile(new Wall(new Vector2(1 * 16, 0), grid.getGridTile(1, 0)), 1, 0);
        grid.addToGridTile(new Wall(new Vector2(2 * 16, 0), grid.getGridTile(2, 0)), 2, 0);

        grid.addToGridTile(new Wall(new Vector2(0 * 16, 1 * 16), grid.getGridTile(0, 1)), 0, 1);
        grid.addToGridTile(new Dot(new Vector2(1 * 16, 1 * 16), grid.getGridTile(1, 1)), 1, 1);
        grid.addToGridTile(new Wall(new Vector2(2 * 16, 1 * 16), grid.getGridTile(2, 1)), 2, 1);

        grid.addToGridTile(new Wall(new Vector2(0 * 16, 2 * 16), grid.getGridTile(0, 2)), 0, 2);
        grid.addToGridTile(new Wall(new Vector2(1 * 16, 2 * 16), grid.getGridTile(1, 2)), 1, 2);
        grid.addToGridTile(new Wall(new Vector2(2 * 16, 2 * 16), grid.getGridTile(2, 2)), 2, 2);

        grid.addToGridTile(new PacMan(new Vector2(15 * 16, 15 * 16), grid.getGridTile(15, 15)), 15, 15);


        grid.addToGridTile(new DeadPacMan(new Vector2(10 * 16, 10 * 16), Rotation.UP, grid.getGridTile(10, 10)), 10, 10);

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
