package de.klausmp.pacman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.kinematicGameObjects.DeadPacMan;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.9.3
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
        super(GameScreen.getAtlas().findRegion("pacMan0"), position, 100f, Rotation.DEFAULTROTATION, GameObjectType.PACMAN, Layers.FRONT, 5f, gridTile);
        String[] idleAnimationFrames = {"pacMan0", "pacMan1", "pacMan2", "pacMan1"};
        idle = new Animation(125, idleAnimationFrames, GameScreen.getAtlas());
        nextGridTile = currendGridTile;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        eatFood();
    }

    @Override
    protected void findNextGridTile() {
        if (currendGridTile.equals(nextGridTile)) {
            GridTile[] sorroundings = currendGridTile.getSurroundingGridTiles();
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                if (sorroundings[Rotation.UP.getInt()].getGridTileType() == GridTileType.ROAD) {
                    setNextGridTile(sorroundings[Rotation.UP.getInt()]);
                    return;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                if (sorroundings[Rotation.RIGHT.getInt()].getGridTileType() == GridTileType.ROAD) {
                    setNextGridTile(sorroundings[Rotation.RIGHT.getInt()]);
                    return;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                if (sorroundings[Rotation.DOWN.getInt()].getGridTileType() == GridTileType.ROAD) {
                    setNextGridTile(sorroundings[Rotation.DOWN.getInt()]);
                    return;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                if (sorroundings[Rotation.LEFT.getInt()].getGridTileType() == GridTileType.ROAD) {
                    setNextGridTile(sorroundings[Rotation.LEFT.getInt()]);
                    return;
                }
            }
            switch (getObjectRotation()) {
                case UP:
                    if (sorroundings[Rotation.UP.getInt()].getGridTileType() == GridTileType.ROAD) {
                        setNextGridTile(sorroundings[Rotation.UP.getInt()]);
                        return;
                    }
                    break;
                case DOWN:
                    if (sorroundings[Rotation.DOWN.getInt()].getGridTileType() == GridTileType.ROAD) {
                        setNextGridTile(sorroundings[Rotation.DOWN.getInt()]);
                        return;
                    }
                    break;
                case LEFT:
                    if (sorroundings[Rotation.LEFT.getInt()].getGridTileType() == GridTileType.ROAD) {
                        setNextGridTile(sorroundings[Rotation.LEFT.getInt()]);
                        return;
                    }
                    break;
                case RIGHT:
                    if (sorroundings[Rotation.RIGHT.getInt()].getGridTileType() == GridTileType.ROAD) {
                        setNextGridTile(sorroundings[Rotation.RIGHT.getInt()]);
                        return;
                    }
                    break;
                default:
                    break;
            }
        }
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
    public void eatFood() {
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