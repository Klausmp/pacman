package de.klausmp.packman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.kinematicGameObjects.DeadPacMan;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.animation.Animation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.7.0
 * @see de.klausmp.packman.gameObjects.dynamicGameObjects.DynamicGameObject
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
}