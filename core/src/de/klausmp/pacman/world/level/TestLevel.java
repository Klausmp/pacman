package de.klausmp.pacman.world.level;

import de.klausmp.pacman.world.Path;

/**
 * @author Klausmp
 */
public class TestLevel extends Level {

    private Path path;
    private boolean firstRun = false;
    private boolean veryFistRun = true;

    public TestLevel(String mapPath) {
        super("maps/a*.png");
        path = new Path(grid);

    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if (mapLoaded) {
            if (veryFistRun) {
                veryFistRun = false;
                //path.newPath(grid.getGridTile(2, 2), grid.getGridTile(5, 5));
            }
            if (path.isPathLoaded() && firstRun) {
                firstRun = false;
                path.print();
                grid.print();
            }
        }
    }
}
