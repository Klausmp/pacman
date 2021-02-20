package de.klausmp.pacman.world.mapinterpreter;

import de.klausmp.pacman.world.grid.Grid;

/**
 * TODO JAVA DOC
 * 
 * @version 0.10.6
 * @since 0.10.6
 */
public interface MapInterpreter {

    /**
     * TODO JAVA DOC
     * 
     * @param mapPath
     * @return Grid mit allen GameObjecten
     * @since 0.10.6
     */
    public Grid loadMap(String mapPath);

}
