package de.klausmp.packman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.level.Grid;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.GridTileType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.animations.Animation;
import de.klausmp.packman.visuals.renderer.Layer;

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
 * @version 0.4.0
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
    protected GridTile nextGridTiles;

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.0
     */
    protected boolean isMoving = false;


    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param movementSpeed   geschwindigkeit mit dem sich das {@link GameObject gameObjekt} bewegt.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link de.klausmp.packman.visuals.renderer.LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public DynamicGameObject(TextureRegion region, Vector2 position, float movementSpeed, Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region, position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
        this.movementSpeed = movementSpeed;
    }


    @Override
    public void update() {
        super.update();
        movement();
    }

    /**
     * hier geschieht das movement des {@link GameObject gameObjekts} in jedem tick.
     *
     * @since 0.1.0
     */
    protected abstract void movement();

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.0
     */
    public void moveToNextGridTile() {
        Vector2 pixelPositionFromNextGridTile = Grid.convertToPixelPosition(nextGridTiles.getPosition());
        switch (rotation) {
            case UP:
                if (pixelPositionFromNextGridTile.y >= getY()) {
                    setY(getY() + movementSpeed);
                    isMoving = true;
                } else {
                    setY(Grid.convertToPixelPosition(nextGridTiles.getPosition()).y);
                    currendGridTile.getGrid().transverToOtherGridTile(this, nextGridTiles);
                    currendGridTile = nextGridTiles;
                    isMoving = false;
                }
                break;
            case DOWN:
                if (pixelPositionFromNextGridTile.y <= getY()) {
                    setY(getY() - movementSpeed);
                    isMoving = true;
                } else {
                    setY(Grid.convertToPixelPosition(nextGridTiles.getPosition()).y);
                    currendGridTile.getGrid().transverToOtherGridTile(this, nextGridTiles);
                    currendGridTile = nextGridTiles;
                    isMoving = false;
                }
                break;
            case LEFT:
                if (pixelPositionFromNextGridTile.x <= getX()) {
                    setX(getX() - movementSpeed);
                    isMoving = true;
                } else {
                    setX(Grid.convertToPixelPosition(nextGridTiles.getPosition()).x);
                    currendGridTile.getGrid().transverToOtherGridTile(this, nextGridTiles);
                    currendGridTile = nextGridTiles;
                    isMoving = false;
                }
                break;
            case RIGHT:
                if (pixelPositionFromNextGridTile.x >= getX()) {
                    setX(getX() + movementSpeed);
                    isMoving = true;
                } else {
                    setX(Grid.convertToPixelPosition(nextGridTiles.getPosition()).x);
                    currendGridTile.getGrid().transverToOtherGridTile(this, nextGridTiles);
                    currendGridTile = nextGridTiles;
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
            nextGridTiles = currendGridTile.getUpperTile();
            rotation = Rotation.UP;
        }
    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveRight() {
        if (currendGridTile.getRightGridTile().getGridTileType() == GridTileType.ROAD && !isMoving) {
            nextGridTiles = currendGridTile.getRightGridTile();
            rotation = Rotation.RIGHT;
        }
    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveDown() {
        if (currendGridTile.getLowerTile().getGridTileType() == GridTileType.ROAD && !isMoving) {
            nextGridTiles = currendGridTile.getLowerTile();
            rotation = Rotation.DOWN;
        }
    }

    /**
     * TODO JAVADC
     *
     * @since 0.3.0
     */
    protected void moveLeft() {
        if (currendGridTile.getLeftGridTile().getGridTileType() == GridTileType.ROAD && !isMoving) {
            nextGridTiles = currendGridTile.getLeftGridTile();
            rotation = Rotation.LEFT;
        }
    }

    public GridTile getNextGridTiles() {
        return nextGridTiles;
    }
}
