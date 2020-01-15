package de.klausmp.packman.gameObjects.dynamicGameObjects;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.animations.Animation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 * @version 0.3.0
 * @since 0.3.0
 */
public class PacMan extends GameObject {
    public PacMan(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("pacMan0"), position, Rotation.getRotationFromInt(0), GameObjectType.PACMAN, Layers.FRONT, 15f, gridTile);
        String[] idleAnimationFrames = {"pacMan0", "pacMan1", "pacMan2"};
        idle = new Animation(125, idleAnimationFrames, GameScreen.getAtlas());
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    protected void animatiom() {
        setRegion(idle.getCurrentFrame());
    }
}
