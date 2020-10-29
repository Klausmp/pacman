package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @since 0.9.5
 */
public interface ITargetControler {

    /**
     * TODO JAVA DOC
     *
     * @param ghost
     * @since 0.9.5
     */
    void findScatterTarget(Ghost ghost);

    /**
     * TODO JAVA DOC
     *
     * @param ghost
     * @since 0.9.5
     */
    void findChaseTarged(Ghost ghost);

    /**
     * TODO JAVA DOC
     *
     * @param ghost
     * @since 0.9.5
     */
    void findBed(Ghost ghost);
}
