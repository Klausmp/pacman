package de.klausmp.packman.gameObjects.kinematicGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.utils.Timer;
import de.klausmp.packman.visuals.animation.Animation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 * @version 0.4.2
 * @see de.klausmp.packman.gameObjects.kinematicGameObjects.KinematicGameObject
 * @since 0.4.1
 */
public class DeadPacMan extends KinematicGameObject {

    private Timer deadTimer;

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param region          {@link TextureRegion textur} mit welcher das {@link GameObject gameObject} am start versehen wird.
     * @param position        position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param rotation        start rotation des {@link GameObject gameObjekts}.
     * @param gameObjectType  type des {@link GameObject gameObjekts}.
     * @param layerToRenderOn {@link Layer layer} auf dem das {@link GameObject gameObjekt} gernder werden soll.
     * @param renderPriority  bestimmt an welcher stelle im layer das {@link GameObject gameObjekt} gerendert wird. weitere informationen {@link LayerRendererQueQueElement#priority hier}.
     * @param gridTile        {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.4.2
     */
    public DeadPacMan(Vector2 position, Rotation rotation, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("pacManDead0"), position, rotation, GameObjectType.PACMAN, Layers.DEFAULT, 10, gridTile);
        rotate(rotation.getInt() * -90);
        String[] idleAnimationFrames = new String[11];
        for (int i = 0; i < idleAnimationFrames.length; i++) {
            idleAnimationFrames[i] = "pacManDead" + i;
        }
        idle = new Animation(60, idleAnimationFrames, GameScreen.getAtlas());
        deadTimer = new Timer(60 * (idleAnimationFrames.length + 1));
        deadTimer.start();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if (deadTimer.isExpired()) {
            kill();
        }
    }

    @Override
    protected void animation() {
        setRegion(idle.getCurrentFrame());
    }
}
