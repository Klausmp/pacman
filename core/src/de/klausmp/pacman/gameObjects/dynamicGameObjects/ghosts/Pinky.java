package de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.utils.Rotation;
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
        super(GameScreen.getAtlas().findRegion("black"), position, Rotation.DEFAULTROTATION, gridTile);
        String[] idleAnimationFrames = {"black"};
        idle = new Animation(125, idleAnimationFrames, GameScreen.getAtlas());
    }

    @Override
    public void setTarged() {
        int pacManRotation = currendGridTile.getGrid().getPacMan().getObjectRotation().getInt();
        this.targed = currendGridTile.getGrid().getPacMan().getCurrendGridTile().getSurroundingGridTiles()[pacManRotation].getSurroundingGridTiles()[pacManRotation].getSurroundingGridTiles()[pacManRotation].getSurroundingGridTiles()[pacManRotation];
    }
}
