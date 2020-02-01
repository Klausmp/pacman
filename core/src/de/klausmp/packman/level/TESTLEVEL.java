package de.klausmp.packman.level;


import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.packman.gameObjects.kinematicGameObjects.DeadPacMan;
import de.klausmp.packman.gameObjects.staticGameObjects.BigDot;
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

        grid.addToGridTile(new DeadPacMan(new Vector2(10 * 16, 10 * 16), Rotation.LEFT, grid.getGridTile(10, 10)), 10, 10);

        grid.addToGridTile(new PacMan(new Vector2(15 * 16, 15 * 16), grid.getGridTile(15, 15)), 15, 15);

        grid.addToGridTile(new Dot(new Vector2(8 * 16, 8 * 16), grid.getGridTile(8, 8)), 8, 8);
        grid.addToGridTile(new BigDot(new Vector2(9 * 16, 8 * 16), grid.getGridTile(9, 8)), 9, 8);

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
