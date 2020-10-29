package de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement.GhostMovementControler;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target.ITargetControler;
import de.klausmp.pacman.utils.GameMode;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.renderer.LayerRendererQueQueElement;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.world.level.Level;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.9.3
 * @see de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject
 * @see java.lang.Runnable
 * @since 0.6.0
 */
public abstract class Ghost extends DynamicGameObject {

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.1
     */
    protected GridTile targed;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected ITargetControler targetControler;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected boolean eaten = false;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected TextureRegion eatenTexture;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected TextureRegion eatenTextureUp;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected TextureRegion eatenTextureLeft;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected TextureRegion eatenTextureDown;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected TextureRegion eatenTextureRight;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected Animation idleUP;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected Animation idleLeft;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected Animation idleDonw;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected Animation idleRight;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    protected Animation frightendAnimation;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    int idleAnimationTime = 200;


    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param movementSpeed   geschwindigkeit mit dem sich das {@link GameObject gameObjekt} bewegt.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public Ghost(TextureRegion region, Vector2 position, GridTile gridTile, ITargetControler targetControler) {
        super(region, position, 80f, Rotation.DEFAULTROTATION, GameObjectType.GHOST, Layers.DEFAULT, 5f, gridTile, new GhostMovementControler());
        this.targetControler = targetControler;
        this.eatenTextureUp = GameScreen.getAtlas().findRegion("eyeUp");
        this.eatenTextureLeft = GameScreen.getAtlas().findRegion("eyeLeft");
        this.eatenTextureDown = GameScreen.getAtlas().findRegion("eyeDown");
        this.eatenTextureRight = GameScreen.getAtlas().findRegion("eyeRight");
        this.frightendAnimation = new Animation(125, new String[]{"blueGhost1", "blueGhost2"});
        this.eatenTexture = eatenTextureUp;
    }

    /**
     * @version 0.6.0
     * @since 0.6.0
     */
    @Override
    public void update(float deltaTime) {
        if (eaten && Level.getGameMode() != GameMode.FRIGHTEND) {
            eaten = false;
        }
        super.update(deltaTime);
        killPacMan();
    }


    /**
     * TODO JAVA DOC
     *
     * @param targed
     * @sijnce 0.9.4
     */
    public void setTarged(GridTile targed) {
        this.targed = targed;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    public void choseTarget() {
        switch (Level.getGameMode()) {
            case CHASE:
                targetControler.findChaseTarged(this);
                break;
            case SCATTER:
                targetControler.findScatterTarget(this);
                break;
            case FRIGHTEND:
                if (eaten) {
                    targetControler.findBed(this);
                }
                break;
        }
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since 0.9.5
     */
    public Rotation getRotationRelativeToPacMan() {
        Vector2 ghost = currendGridTile.getPosition();
        Vector2 pacMan = currendGridTile.getGrid().getPacMan().getCurrendGridTile().getPosition();
        Vector2 direction = new Vector2(ghost.x - pacMan.x, ghost.y - pacMan.y);
        if (direction.angle() >= 315) {
            return Rotation.LEFT;
        }
        if (direction.angle() <= 45) {
            return Rotation.LEFT;
        }
        if (direction.angle() >= 45 && direction.angle() <= 135) {
            return Rotation.DOWN;
        }
        if (direction.angle() >= 135 && direction.angle() <= 225) {
            return Rotation.RIGHT;
        }
        if (direction.angle() >= 225 && direction.angle() <= 315) {
            return Rotation.UP;
        }
        return Rotation.DEFAULTROTATION;
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since 0.9.4
     */
    public GridTile getTarged() {
        return targed;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    private void setRightAnmationOrientation() {
        switch (getRotationRelativeToPacMan()) {
            case UP:
                eatenTexture = eatenTextureUp;
                idle = idleUP;
                break;
            case LEFT:
                eatenTexture = eatenTextureLeft;
                idle = idleLeft;
                break;
            case DOWN:
                eatenTexture = eatenTextureDown;
                idle = idleDonw;
                break;
            case RIGHT:
                eatenTexture = eatenTextureRight;
                idle = idleRight;
                break;
        }
    }

    @Override
    protected void animation() {
        setRightAnmationOrientation();
        switch (Level.getGameMode()) {
            case SCATTER:
            case CHASE:
                setRegion(idle.getCurrentFrame());
                break;
            case FRIGHTEND:
                if (eaten) {
                    setRegion(eatenTexture);
                } else {
                    setRegion(frightendAnimation.getCurrentFrame());
                }
                break;
        }
    }

    @Override
    public void setObjectRotation(Rotation rotation) {
        this.rotation = rotation;
    }

    @Override
    protected void movement(float deltaTime) {
        super.movement(deltaTime);
        setRotation(0f);
    }

    private void killPacMan() {
        if (currendGridTile == currendGridTile.getGrid().getPacMan().getCurrendGridTile()) {
            if (Level.getGameMode() == GameMode.FRIGHTEND) {
                eaten = true;
            } else if (!eaten) {
                currendGridTile.getGrid().getPacMan().kill();
            }
        }
    }
}
