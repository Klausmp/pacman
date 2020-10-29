package de.klausmp.pacman.gameObjects.staticGameObjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.utils.Timer;
import de.klausmp.pacman.visuals.animation.Animation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * @author Klausmp
 * @version 0.9.4
 * @see de.klausmp.pacman.gameObjects.kinematicGameObjects.KinematicGameObject
 * @since 0.4.1
 */
public class DeadPacMan extends StaticGameObjekt {

    private final Timer deadTimer;

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
        idle = new Animation(60, idleAnimationFrames);
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
