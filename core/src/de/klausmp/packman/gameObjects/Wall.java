package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.visuals.renderer.Layers;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 */
//TODO JAVA DOC MACHEN
public class Wall extends GameObject {
    public Wall(Vector2 position) {
        super(GameScreen.getAtlas().findRegion("wall"), position, GameObjectType.WALL, Layers.BACKGROUND, 5.0f);
    }
}