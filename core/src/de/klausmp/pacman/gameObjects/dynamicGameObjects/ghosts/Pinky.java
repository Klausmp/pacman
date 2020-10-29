package de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target.PinkyTargetControler;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * @version 0.9.2
 * @since 0.6.0
 * @author Klausmp
 */
public class Pinky extends Ghost {
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
    public Pinky(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("pinkyUp1"), position, gridTile, new PinkyTargetControler());
        this.idleUP = new Animation(idleAnimationTime, new String[]{"pinkyUp1", "pinkyUp2"});
        this.idleLeft = new Animation(idleAnimationTime, new String[]{"pinkyLeft1", "pinkyLeft2"});
        this.idleDonw = new Animation(idleAnimationTime, new String[]{"pinkyDown1", "pinkyDown2"});
        this.idleRight = new Animation(idleAnimationTime, new String[]{"pinkyRight1", "pinkyRight2"});
    }
}
