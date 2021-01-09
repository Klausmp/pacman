package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;

/**
 * TODO JAVA DOC
 *
 * @version 0.9.8
 * @since 0.9.8
 */
public abstract class GhostTargetControler {

    /**
     * TODO JAVA DOC
     *
     * @param ghost
     * @since 0.9.5
     */
    public abstract void findScatterTarget(Ghost ghost);

    /**
     * TODO JAVA DOC
     *
     * @param ghost
     * @since 0.9.5
     */
    public abstract void findChaseTarged(Ghost ghost);

    /**
     * TODO JAVA DOC
     *
     * @param ghost
     * @since 0.9.5
     */
    public void findBed(Ghost ghost) {
        ghost.setTarged(ghost.getGrid().getBed().getCurrendGridTile());
    }
}
