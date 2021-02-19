package de.klausmp.pacman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement.PlayerMovementControler;
import de.klausmp.pacman.gameObjects.staticGameObjects.textured.DeadPacMan;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.10.3
 * @see de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject
 * @since 0.4.0
 */
public class PacMan extends DynamicGameObject {

    /**
     * TODO JAVA DOC
     *
     * @param position
     * @param gridTile
     * @since 0.4.2
     */
    public PacMan(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("pacMan0"), position, 100f, Rotation.RIGHT, GameObjectType.PACMAN, Layers.FRONT, 5f, gridTile, new PlayerMovementControler());
        String[] idleAnimationFrames = {"pacMan0", "pacMan1", "pacMan2", "pacMan1"};
        idle = new Animation(125, idleAnimationFrames);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        eatFood();
    }

    @Override
    public void kill() {
        currendGridTile.addGameObject(new DeadPacMan(new Vector2(getX(), getY()), getObjectRotation(), currendGridTile));
        super.kill();
    }

    /**
     * TODO JAVA DOC
     *
     * @version 0.7.0
     * @since 0.5.0
     */
    public void eatFood() {
        for (GameObjectType objectType : GameObjectType.edibles()) {
            //System.out.println(currendGridTile.getGameObjectByType(objectType));
            GameObject gameObject = currendGridTile.getGameObjectByType(objectType);
            if (gameObject != null) {
                gameObject.kill();
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