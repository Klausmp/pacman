package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;

/**
 * TODO JAVA DOC
 *
 * @version 0.10.7
 * @since 0.10.7
 */
public interface IDynamicMovementControler {

    /**
     * TODO JAVA DOC
     *
     * @since 0.10.7
     * @param dynamicObject
     * @param deltaTime
     */
    public void move(DynamicGameObject dynamicObject, float deltaTime);
}