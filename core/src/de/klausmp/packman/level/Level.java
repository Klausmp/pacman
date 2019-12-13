package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.PacMan;
import de.klausmp.packman.visuals.renderer.LayerRenderer;

/**
 * @author Klausmp
 */
public abstract class Level {
    protected PacMan pacMan;
    protected Grid grid;
    protected Vector2 gridSize;
    protected Vector2 gridPosition;

    public Level() {
        grid = new Grid();
        create(new Vector2(grid.getDEFAULTGRIDSIZE(), grid.getDEFAULTGRIDSIZE()), new Vector2(0, 0));
    }

    public Level(Vector2 gridSize, Vector2 gridPosition) {
        grid = new Grid(gridPosition, gridSize);
        create(gridSize, gridPosition);
    }

    public Level(Vector2 gridSize) {
        grid = new Grid(gridSize);
        create(gridSize, new Vector2(0, 0));
    }

    public Level(int gridPosX, int gridPosY) {
        grid = new Grid(gridPosition.x, gridPosition.y);
        create(new Vector2(grid.getDEFAULTGRIDSIZE(), grid.getDEFAULTGRIDSIZE()), new Vector2(gridPosX, gridPosY));
    }

    public void create(Vector2 gridSize, Vector2 gridPosition) {
        this.gridSize = gridSize;
        this.gridPosition = gridPosition;

    }

    public void render(LayerRenderer renderer){
        grid.render(renderer);
    }

    public void update(){
        grid.update();
    }

}
