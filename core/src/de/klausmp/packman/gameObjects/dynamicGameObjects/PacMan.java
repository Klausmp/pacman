package de.klausmp.packman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.kinematicGameObjects.DeadPacMan;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.utils.Timer;
import de.klausmp.packman.visuals.animations.Animation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 * @version 0.4.1
 * @see de.klausmp.packman.gameObjects.dynamicGameObjects.DynamicGameObject
 * @since 0.3.0
 */
public class PacMan extends DynamicGameObject {

    private Timer test = new Timer(10000);

    public PacMan(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("pacMan0"), position, 1f, Rotation.DEFAULTROTATION, GameObjectType.PACMAN, Layers.FRONT, 15f, gridTile);
        String[] idleAnimationFrames = {"pacMan0", "pacMan1", "pacMan2"};
        idle = new Animation(125, idleAnimationFrames, GameScreen.getAtlas());
        nextGridTiles = currendGridTile;
        test.start();
    }

    @Override
    public void update() {
        super.update();
        if (test.isExpired()) {
            kill();
        }
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
    protected void animation() {
        setRegion(idle.getCurrentFrame());
    }

    @Override
    public void kill() {
        super.kill();
        currendGridTile.addGameObject(new DeadPacMan(new Vector2(getX(), getY()), rotation, currendGridTile));
    }
}
