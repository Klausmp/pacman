package de.klausmp.pacman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.world.grid.Grid;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.renderer.Layer;

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
 * @version 0.9.2
 * @see GameObject
 * @since 0.1.0
 */
public abstract class DynamicGameObject extends GameObject {

    protected float movementSpeed;

    /**
     * movement animation
     *
     * @since 0.3.0
     */
    protected Animation movement;

    /**
     * TODO JAVADOC
     *
     * @since 0.3.0
     */
    protected GridTile nextGridTile;

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.0
     */
    protected boolean isMoving = false;

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.2
     */
    protected Rotation lastRotation;


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
    public DynamicGameObject(TextureRegion region, Vector2 position, float movementSpeed, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region, position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
        this.movementSpeed = movementSpeed;
        setObjectRotation(rotation);
    }


    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if (nextGridTile != null) {
            movement(deltaTime);
        }
    }

    /**
     * hier geschieht das movement des {@link GameObject gameObjekts} in jedem tick.
     * @version 0.6.0
     * @since 0.1.0
     */
    protected void movement(float deltaTime) {
        moveToNextGridTile(deltaTime);
    }

    /**
     * TODO JAVA DOC
     *
     * @param nextRotation
     * @version 0.6.0
     * @since 0.6.0
     */
    protected void findNextGridTile(Rotation nextRotation) {
        if (currendGridTile.equals(nextGridTile) && !isMoving) {
            switch (nextRotation) {
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

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.0
     */
    public void moveToNextGridTile(float delataTime) {
        Vector2 pixelPositionFromNextGridTile = Grid.convertToPixelPosition(nextGridTile.getPosition());
        switch (getObjectRotation()) {
            case UP:
                if (pixelPositionFromNextGridTile.y >= getY()) {
                    setY(getY() + (movementSpeed * delataTime));
                    isMoving = true;
                } else {
                    setY(Grid.convertToPixelPosition(nextGridTile.getPosition()).y);
                    currendGridTile.getGrid().transverToOtherGridTile(this, nextGridTile);
                    currendGridTile = nextGridTile;
                    isMoving = false;
                }
                break;
            case DOWN:
                if (pixelPositionFromNextGridTile.y <= getY()) {
                    setY(getY() - (movementSpeed * delataTime));
                    isMoving = true;
                } else {
                    setY(Grid.convertToPixelPosition(nextGridTile.getPosition()).y);
                    currendGridTile.getGrid().transverToOtherGridTile(this, nextGridTile);
                    currendGridTile = nextGridTile;
                    isMoving = false;
                }
                break;
            case LEFT:
                if (pixelPositionFromNextGridTile.x <= getX()) {
                    setX(getX() - (movementSpeed * delataTime));
                    isMoving = true;
                } else {
                    setX(Grid.convertToPixelPosition(nextGridTile.getPosition()).x);
                    currendGridTile.getGrid().transverToOtherGridTile(this, nextGridTile);
                    currendGridTile = nextGridTile;
                    isMoving = false;
                }
                break;
            case RIGHT:
                if (pixelPositionFromNextGridTile.x >= getX()) {
                    setX(getX() + (movementSpeed * delataTime));
                    isMoving = true;
                } else {
                    setX(Grid.convertToPixelPosition(nextGridTile.getPosition()).x);
                    currendGridTile.getGrid().transverToOtherGridTile(this, nextGridTile);
                    currendGridTile = nextGridTile;
                    isMoving = false;
                }
                break;
            default:
                break;
        }
    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveUp() {
        if (currendGridTile.getUpperTile().getGridTileType() == GridTileType.ROAD && !isMoving) {
            nextGridTile = currendGridTile.getUpperTile();
            changeRotation(getObjectRotation());
        }
    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveRight() {
        if (currendGridTile.getRightGridTile().getGridTileType() == GridTileType.ROAD && !isMoving) {
            nextGridTile = currendGridTile.getRightGridTile();
            changeRotation(getObjectRotation());
        }
    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveDown() {
        if (currendGridTile.getLowerTile().getGridTileType() == GridTileType.ROAD && !isMoving) {
            nextGridTile = currendGridTile.getLowerTile();
            changeRotation(getObjectRotation());
        }
    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveLeft() {
        if (currendGridTile.getLeftGridTile().getGridTileType() == GridTileType.ROAD && !isMoving) {
            nextGridTile = currendGridTile.getLeftGridTile();
            changeRotation(getObjectRotation());
        }
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
        setRotation(rotation.getInt() * 90);
    }

    /**
     * TODO JAVA DOC
     *
     * @param rotation
     * @since 0.4.2
     */
    @Override
    public void setObjectRotation(Rotation rotation) {
        this.lastRotation = getObjectRotation();
        super.setObjectRotation(rotation);
    }

    public GridTile getNextGridTile() {
        return nextGridTile;
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
}
