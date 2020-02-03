package de.klausmp.pacman.level;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;

/**
 * stellt alle grundmethoden des level zu ferfügung. <br>
 * es müssen nur noch {@link de.klausmp.pacman.gameObjects.GameObject gameObjekte} hinzugefügt werden.
 *
 * @author Klausmp
 * @version 0.0.1
 * @since 0.0.1
 */
public abstract class Level {

    /**
     * instance von {@link PacMan pacMan} in einem {@link Level level}.
     *
     * @since 0.0.1
     */
    protected PacMan pacMan;

    /**
     * instance von {@link Grid grid} in einem {@link Level level}.
     *
     * @since 0.0.1
     */
    protected Grid grid;

    /**
     * größe des {@link Grid grids} in x und y richtung
     *
     * @since 0.0.1
     */
    protected Vector2 gridSize;

    /**
     * position des {@link Grid grids}
     *
     * @since 0.0.1
     */
    protected Vector2 gridPosition;

    /**
     * konstruktor mit default einstellungen
     *
     * @since 0.0.1
     */
    public Level() {
        grid = new Grid();
        create(new Vector2(grid.getDEFAULTGRIDSIZE(), grid.getDEFAULTGRIDSIZE()), new Vector2(0, 0));
    }

    /**
     * konstruktor mit einstellungsmöglichkeit der {@link #gridSize gridSize}
     * und der {@link #gridPosition gridposition}.
     *
     * @param gridSize     {@link #gridSize siehe gridSize}
     * @param gridPosition {@link #gridPosition siehe gridPosition}
     * @since 0.0.1
     */
    public Level(Vector2 gridSize, Vector2 gridPosition) {
        grid = new Grid();
        create(gridSize, gridPosition);
    }

    /**
     * konstruktor mit einstellungsmöglichkeit der {@link #gridSize}.
     *
     * @param gridSize {@link #gridSize siehe gridSize}
     * @since 0.0.1
     */
    public Level(Vector2 gridSize) {
        grid = new Grid();
        create(gridSize, new Vector2(0, 0));
    }

    /**
     * konstruktor mit einstellungsmöglichkeit der {@link #gridPosition}
     *
     * @param gridPosX setzt den x wert der {@link #gridPosition gridposition}.
     * @param gridPosY setzt den y wert der {@link #gridPosition gridposition}.
     * @since 0.0.1
     */
    public Level(int gridPosX, int gridPosY) {
        grid = new Grid();
        create(new Vector2(grid.getDEFAULTGRIDSIZE(), grid.getDEFAULTGRIDSIZE()), new Vector2(gridPosX, gridPosY));
    }

    /**
     * setzt die werte bei der erstellung eines {@link Level levels}. <br>
     * wird nur im konstruktor verwendet.
     *
     * @param gridSize     {@link #gridSize siehe gridSize}
     * @param gridPosition {@link #gridPosition siehe gridPosition}.
     * @since 0.0.1
     */
    public void create(Vector2 gridSize, Vector2 gridPosition) {
        this.gridSize = gridSize;
        this.gridPosition = gridPosition;
    }

    /**
     * rendert alle {@link de.klausmp.pacman.gameObjects.GameObject gameObjekte} im {@link Grid grid}
     * mit dem {@link LayerRenderer layerRendere}.
     *
     * @param renderer instance des {@link LayerRenderer layerRenderes} aus dem genutzten {@link com.badlogic.gdx.Screen screen}.
     * @since 0.0.1
     */
    public void render(LayerRenderer renderer) {
        grid.render(renderer);
    }

    /**
     * updated das {@link #grid grid} des {@link Level levels} und damit
     * alle {@link de.klausmp.pacman.gameObjects.GameObject gameObjekte}.
     *
     * @version 0.5.0
     * @since 0.0.1
     */
    public void update(float deltaTime) {
        grid.update(deltaTime);
    }

}