package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.PacMan;

/**
 * @author Klausmp
 */
public abstract class Level {
    protected PacMan pacMan;
    protected Grid grid;
    protected Vector2 gridSize;
    protected Vector2 gridPosition;

    public Level() {
        create(new Vector2(grid.getDEFAULTGRIDSIZE(), grid.getDEFAULTGRIDSIZE()), new Vector2(0, 0));
        grid = new Grid(gridPosition, gridSize);
    }

    public Level(Vector2 gridSize, Vector2 gridPosition) {
        create(gridSize, gridPosition);
        grid = new Grid(gridPosition, gridSize);
    }

    public Level(Vector2 gridSize) {
        create(gridSize, new Vector2(0, 0));
        grid = new Grid(gridSize);
    }

    public Level(int gridPosX, int gridPosY) {
        create(new Vector2(grid.getDEFAULTGRIDSIZE(), grid.getDEFAULTGRIDSIZE()), new Vector2(gridPosX, gridPosY));
        grid = new Grid(gridPosition.x, gridPosition.y);
    }

    public void create(Vector2 gridSize, Vector2 gridPosition) {
        this.gridSize = gridSize;
        this.gridPosition = gridPosition;

    }

    public abstract void update();

}
