package de.klausmp.pacman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.kinematicGameObjects.DeadPacMan;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.screens.GameScreen;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.8.0
 * @see de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject
 * @since 0.4.0
 */
public class PacMan extends DynamicGameObject {

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.2
     */
    private Rotation lastInput;

    /**
     * TODO JAVA DOC
     *
     * @param position
     * @param gridTile
     * @version 0.6.0
     * @since 0.4.2
     */
    public PacMan(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("pacMan0"), position, 100f, Rotation.DEFAULTROTATION, GameObjectType.PACMAN, Layers.FRONT, 5f, gridTile);
        lastInput = getObjectRotation();
        String[] idleAnimationFrames = {"pacMan0", "pacMan1", "pacMan2"};
        idle = new Animation(125, idleAnimationFrames, GameScreen.getAtlas());
        nextGridTile = currendGridTile;
    }

    @Override
    protected void movement(float deltaTime) {
        findNextGridTile(getObjectRotation());
        super.movement(deltaTime);
        checkForFood();
    }

    /**
     * @version 0.6.0
     * @since 0.6.0
     */
    @Override
    protected void findNextGridTile(Rotation nextRotation) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            lastInput = Rotation.UP;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            lastInput = Rotation.RIGHT;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            lastInput = Rotation.DOWN;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            lastInput = Rotation.LEFT;
        }

        if (!isMoving) {
            setObjectRotation(lastInput);
        }
        super.findNextGridTile(lastInput);
    }

    @Override
    protected void animation() {
       super.animation();
    }

    @Override
    public void kill() {
        super.kill();
        currendGridTile.addGameObject(new DeadPacMan(new Vector2(getX(), getY()), getObjectRotation(), currendGridTile));
    }

    /**
     * TODO JAVA DOC
     *
     * @version 0.7.0
     * @since 0.5.0
     */
    public void checkForFood() {
        for (GameObjectType objectType : GameObjectType.edibles()) {
            if (currendGridTile.getGameObjectByType(objectType) != null) {
                currendGridTile.getGameObjectByType(objectType).kill();
            }
        }
    }

    /**
     * @since 0.8.0
     */
    @Override
    public void dispose() {
        super.dispose();
    }
}