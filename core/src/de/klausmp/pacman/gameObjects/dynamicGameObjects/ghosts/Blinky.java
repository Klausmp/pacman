package de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.9.2
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
        super(GameScreen.getAtlas().findRegion("black"), position, 90f, Rotation.DEFAULTROTATION, GameObjectType.GHOST, Layers.DEFAULT, 5f, gridTile);
        String[] idleAnimationFrames = {"black"};
        idle = new Animation(125, idleAnimationFrames, GameScreen.getAtlas());
        targed = getGrid().getGridTile(10, 4);
    }

    @Override
    public void setTarged() {
        targed = getGrid().getPacMan().getCurrendGridTile();
    }
}
