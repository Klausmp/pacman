package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.utils.Rotation;

/**
 * TODO JAVA DOC
 *
 * @since 0.9.4
 */
public class PlayerMovementControler implements IDynamicMovementControler {

    @Override
    public void choseNextRotationToMove(DynamicGameObject object) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            object.setNextRotation(Rotation.UP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            object.setNextRotation(Rotation.LEFT);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            object.setNextRotation(Rotation.DOWN);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            object.setNextRotation(Rotation.RIGHT);
        }
    }
}
