package de.klausmp.packman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.animations.Animation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 * @version 0.4.0
 * @see de.klausmp.packman.gameObjects.dynamicGameObjects.DynamicGameObject
 * @since 0.3.0
 */
public class PacMan extends DynamicGameObject {
    public PacMan(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("pacMan0"), position, 1f, Rotation.DEFAULTROTATION, GameObjectType.PACMAN, Layers.FRONT, 15f, gridTile);
        String[] idleAnimationFrames = {"pacMan0", "pacMan1", "pacMan2"};
        idle = new Animation(125, idleAnimationFrames, GameScreen.getAtlas());
        nextGridTiles = currendGridTile;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    protected void movement() {
        moveToNextGridTile();

        if (!isMoving) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                rotation = Rotation.UP;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                rotation = Rotation.RIGHT;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                rotation = Rotation.DOWN;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                rotation = Rotation.LEFT;
            }
        }

        if (currendGridTile.equals(nextGridTiles) && !isMoving) {
            switch (rotation) {
                case RIGHT:
                    moveRight();
                    break;
                case LEFT:
                    moveLeft();
                    break;
                case DOWN:
                    moveDown();
                    break;
                case UP:
                    moveUp();
                    break;
            }
        }
    }

    @Override
    protected void animatiom() {
        setRegion(idle.getCurrentFrame());
    }
}
