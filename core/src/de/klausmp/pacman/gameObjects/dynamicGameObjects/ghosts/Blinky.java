package de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target.BlinkyTargetControler;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.9.4
 * @see de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost
 * @since 0.6.0
 */
public class Blinky extends Ghost {
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
    public Blinky(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("blinkyUp1"), position, gridTile, new BlinkyTargetControler());
        this.idleUP = new Animation(idleAnimationTime, new String[]{"blinkyUp1", "blinkyUp2"});
        this.idleLeft = new Animation(idleAnimationTime, new String[]{"blinkyLeft1", "blinkyLeft2"});
        this.idleDonw = new Animation(idleAnimationTime, new String[]{"blinkyDown1", "blinkyDown2"});
        this.idleRight = new Animation(idleAnimationTime, new String[]{"blinkyRight1", "blinkyRight2"});
    }
}
