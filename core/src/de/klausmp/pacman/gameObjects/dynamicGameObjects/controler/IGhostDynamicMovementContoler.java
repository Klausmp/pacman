package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;

public interface IGhostDynamicMovementContoler extends IDynamicMovementControler {

    /**
     * TODO JAVA DOC
     *
     * @param ghost
     * @since 0.9.4
     */
    public void generateNewPath(Ghost ghost);

    /**
     * TODO JAVA DOC
     *
     * @param ghost
     * @since 0.9.4
     */
    public void setTarget(Ghost ghost);

}
