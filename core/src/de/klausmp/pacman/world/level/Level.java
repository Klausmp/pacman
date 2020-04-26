package de.klausmp.pacman.world.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.pacman.world.MapInterpreter;
import de.klausmp.pacman.world.grid.Grid;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * stellt alle grundmethoden des level zu ferfügung. <br>
 * es müssen nur noch {@link de.klausmp.pacman.gameObjects.GameObject gameObjekte} hinzugefügt werden.
 *
 * @author Klausmp
 * @version 0.8.1
 * @since 0.0.1
 */
public class Level implements Runnable, Disposable {

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
     * TODO JAVA DOC
     *
     * @version 0.7.3
     * @since 0.7.3
     */
    protected String mapPath;

    protected boolean mapLoaded = false;

    /**
     * konstruktor mit default einstellungen
     *
     * @since 0.0.1
     */
    public Level(String mapPath) {
        create(new Vector2(Grid.getDEFAULTGRIDSIZE(), Grid.getDEFAULTGRIDSIZE()), new Vector2(0, 0), mapPath);
    }

    /**
     * konstruktor mit einstellungsmöglichkeit der {@link #gridPosition}
     *
     * @param gridPosX setzt den x wert der {@link #gridPosition gridposition}.
     * @param gridPosY setzt den y wert der {@link #gridPosition gridposition}.
     * @since 0.0.1
     */
    public Level(int gridPosX, int gridPosY, String mapPath) {
        create(new Vector2(Grid.getDEFAULTGRIDSIZE(), Grid.getDEFAULTGRIDSIZE()), new Vector2(gridPosX, gridPosY), mapPath);
    }

    /**
     * setzt die werte bei der erstellung eines {@link Level levels}. <br>
     * wird nur im konstruktor verwendet.
     *
     * @param gridSize     {@link #gridSize siehe gridSize}
     * @param gridPosition {@link #gridPosition siehe gridPosition}.
     * @since 0.0.1
     */
    public void create(Vector2 gridSize, Vector2 gridPosition, String mapPath) {
        this.gridSize = gridSize;
        this.gridPosition = gridPosition;
        this.mapPath = mapPath;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * rendert alle {@link de.klausmp.pacman.gameObjects.GameObject gameObjekte} im {@link Grid grid}
     * mit dem {@link LayerRenderer layerRendere}.
     *
     * @param renderer instance des {@link LayerRenderer layerRenderes} aus dem genutzten {@link com.badlogic.gdx.Screen screen}.
     * @since 0.0.1
     */
    public void render(LayerRenderer renderer) {
        if (mapLoaded) {
            grid.render(renderer);
        }
    }

    /**
     * updated das {@link #grid grid} des {@link Level levels} und damit
     * alle {@link de.klausmp.pacman.gameObjects.GameObject gameObjekte}.
     *
     * @version 0.7.3
     * @since 0.0.1
     */
    public void update(float deltaTime) {
        if (mapLoaded) {
            grid.update(deltaTime);
        }
    }

    /**
     * TODO JAVA DOC
     * @since 0.7.3
     */
    @Override
    public void run() {
        grid = MapInterpreter.loadMap(mapPath);
        mapLoaded = true;
    }

    public boolean isMapLoaded() {
        return mapLoaded;
    }

    @Override
    public void dispose() {
        pacMan.dispose();
        for (GridTile gridTile : grid.getGridTiles()) {
            for (GameObject gameObject : gridTile.getGameObjects()) {
                gameObject.dispose();
            }
        }
    }
}