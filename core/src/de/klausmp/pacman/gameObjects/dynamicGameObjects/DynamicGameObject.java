package de.klausmp.pacman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement.IDynamicMovementControler;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.renderer.Layer;
import de.klausmp.pacman.world.grid.Grid;
import de.klausmp.pacman.world.grid.GridTile;
import org.jetbrains.annotations.NotNull;

/**
 * dynamisches {@link GameObject gameObjekt}. <br>
 * <p>
 * es kann bewegt werden und ferfügt daher upber eine {@link #movement() movement} methode. <br>
 * <p>
 * dieses movement geschieht nach den updates die in der {@link GameObject#update() update}
 * methode des {@link GameObject gameObjekts} getätigt werden. <br>
 * <p>
 * dannach wird das erbende objekt geupdated.
 *
 * @author Klausmp
 * @version 0.9.8
 * @see GameObject
 * @since 0.1.0
 */
public abstract class DynamicGameObject extends GameObject {

    /**
     * TODO JAVA DOC
     *
     * @since 0.7.4
     */
    private float movementSpeed;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    protected Rotation nextRotation;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    protected Rotation rotation;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    private IDynamicMovementControler movementControler;

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param movementSpeed   geschwindigkeit mit dem sich das {@link GameObject gameObjekt} bewegt.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link de.klausmp.pacman.visuals.renderer.LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public DynamicGameObject(TextureRegion region, Vector2 position, float movementSpeed, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile, IDynamicMovementControler movementControler) {
        super(region, position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
        this.movementSpeed = movementSpeed;
        this.movementControler = movementControler;
        changeRotation(rotation);
        nextRotation = rotation;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        movement(deltaTime);
    }

    /**
     * hier geschieht das movement des {@link GameObject gameObjekts} in jedem tick.
     *
     * @version 0.9.4
     * @since 0.1.0
     */
    protected void movement(float deltaTime) {
        float remainingDistance;
        movementControler.choseNextRotationToMove(this);
        if (getObjectRotation() == nextRotation) {
            setObjectRotation(nextRotation);
        }
        if (currendGridTile.getSurroundingGridTiles()[rotation.getInt()].canWalkOn(gameObjectType)) {
            switch (rotation) {
                case UP:
                    if (Grid.convertToPixelPosition(currendGridTile.getSurroundingGridTiles()[rotation.getInt()].getPosition()).y > getY()) {
                        setY(getY() + getMovementSpeed() * deltaTime);
                    } else {
                        remainingDistance = getY() - Grid.convertToPixelPosition(currendGridTile.getSurroundingGridTiles()[rotation.getInt()].getPosition()).y;
                        moveToNextGridTile();
                        if (currendGridTile.getSurroundingGridTiles()[nextRotation.getInt()].canWalkOn(getGameObjectType())) {
                            setY(Grid.convertToPixelPosition(currendGridTile.getPosition()).y);
                            changeRotation(nextRotation);
                            moveRemainingDistance(remainingDistance);
                        }
                        movement(deltaTime);
                    }
                    break;
                case LEFT:
                    if (Grid.convertToPixelPosition(currendGridTile.getSurroundingGridTiles()[rotation.getInt()].getPosition()).x < getX()) {
                        setX(getX() - getMovementSpeed() * deltaTime);
                    } else {
                        remainingDistance = Grid.convertToPixelPosition(currendGridTile.getSurroundingGridTiles()[rotation.getInt()].getPosition()).x - getX();
                        moveToNextGridTile();
                        if (currendGridTile.getSurroundingGridTiles()[nextRotation.getInt()].canWalkOn(getGameObjectType())) {
                            setX(Grid.convertToPixelPosition(currendGridTile.getPosition()).x);
                            changeRotation(nextRotation);
                            moveRemainingDistance(remainingDistance);
                        }
                        movement(deltaTime);
                    }
                    break;
                case DOWN:
                    if (Grid.convertToPixelPosition(currendGridTile.getSurroundingGridTiles()[rotation.getInt()].getPosition()).y < getY()) {
                        setY(getY() - getMovementSpeed() * deltaTime);
                    } else {
                        remainingDistance = Grid.convertToPixelPosition(currendGridTile.getSurroundingGridTiles()[rotation.getInt()].getPosition()).y - getY();
                        moveToNextGridTile();
                        if (currendGridTile.getSurroundingGridTiles()[nextRotation.getInt()].canWalkOn(getGameObjectType())) {
                            setY(Grid.convertToPixelPosition(currendGridTile.getPosition()).y);
                            changeRotation(nextRotation);
                            moveRemainingDistance(remainingDistance);
                        }
                        movement(deltaTime);
                    }
                    break;
                case RIGHT:
                    if (Grid.convertToPixelPosition(currendGridTile.getSurroundingGridTiles()[rotation.getInt()].getPosition()).x > getX()) {
                        setX(getX() + getMovementSpeed() * deltaTime);
                    } else {
                        remainingDistance = getX() - Grid.convertToPixelPosition(currendGridTile.getSurroundingGridTiles()[rotation.getInt()].getPosition()).x;
                        moveToNextGridTile();
                        if (currendGridTile.getSurroundingGridTiles()[nextRotation.getInt()].canWalkOn(getGameObjectType())) {
                            setX(Grid.convertToPixelPosition(currendGridTile.getPosition()).x);
                            changeRotation(nextRotation);
                            moveRemainingDistance(remainingDistance);
                        }
                        movement(deltaTime);
                    }
                    break;
                default:
                    break;
            }
        } else {
            if (currendGridTile.getSurroundingGridTiles()[nextRotation.getInt()].canWalkOn(getGameObjectType())) {
                changeRotation(nextRotation);
            }
        }
    }

    /**
     * TODO JACA DOC
     *
     * @param remainingDistance
     * @since 0.9.4
     */
    private void moveRemainingDistance(float remainingDistance) {
        switch (rotation) {
            case UP:
                setY(getY() + remainingDistance);
                break;
            case LEFT:
                setX(getX() - remainingDistance);
                break;
            case DOWN:
                setY(getY() - remainingDistance);
                break;
            case RIGHT:
                setX(getX() + remainingDistance);
                break;
            default:
        }
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    private void moveToNextGridTile() {
        currendGridTile.getGrid().transverToOtherGridTile(this, currendGridTile.getSurroundingGridTiles()[rotation.getInt()]);
        currendGridTile = currendGridTile.getSurroundingGridTiles()[rotation.getInt()];
    }

    /**
     * TODO JAVA DOC
     *
     * @param currentRotation
     * @param rotation
     * @version 0.7.4
     * @since 0.4.2
     */
    protected void changeRotation(Rotation rotation) {
        this.rotation = rotation;
        setRotation(rotation.getInt() * 90);
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since0.9.4
     */
    public Rotation getNextRotation() {
        return nextRotation;
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since0.9.4
     */
    public void setNextRotation(@NotNull Rotation nextRotation) {
        this.nextRotation = nextRotation;
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since 0.9.4
     */
    public Rotation getObjectRotation() {
        return rotation;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.8.0
     */
    @Override
    public void dispose() {
        super.dispose();
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }
}
