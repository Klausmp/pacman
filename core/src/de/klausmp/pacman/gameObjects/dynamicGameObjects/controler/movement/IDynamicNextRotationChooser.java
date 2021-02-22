package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;

/**
 * TODO JAVA DOC
 *
 * @version 0.10.7
 * @since 0.9.4
 */

public interface IDynamicNextRotationChooser {

    /**
     * TODO JAVA DOC
     *
     * @param object
     * @since 0.9.4
     */
    void choseNextRotationToMove(DynamicGameObject dynObject);

}