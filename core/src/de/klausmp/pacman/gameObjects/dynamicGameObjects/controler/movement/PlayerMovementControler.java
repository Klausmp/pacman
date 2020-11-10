package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.utils.Rotation;

/**
 * TODO JAVA DOC
 * @version 0.9.6
 * @since 0.9.4
 */
public class PlayerMovementControler implements IDynamicMovementControler {

    @Override
    public void choseNextRotationToMove(DynamicGameObject object) {
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            object.setNextRotation(Rotation.UP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            object.setNextRotation(Rotation.LEFT);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)  || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            object.setNextRotation(Rotation.DOWN);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)  || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            object.setNextRotation(Rotation.RIGHT);
        }
    }
}
