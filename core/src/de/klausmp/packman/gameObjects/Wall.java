package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.utils.WallTypes;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * wände im spiel.
 *
 * @author Klausmp
 * @version 0.1.1
 * @since 0.01.0
 */
public class Wall extends StaticGameObjekt {

    /**
     * konstrucktor mit einstellungsmöglichkeiten bei der startposition.
     *
     * @param position startposition der {@link Wall wall}.
     * @since 0.1.0
     */
    public Wall(Vector2 position) {
        super(GameScreen.getAtlas().findRegion(WallTypes.WALL.getTextureRegion()), position, Rotation.DEFAULTROTATION, GameObjectType.WALL, Layers.BACKGROUND, 5.0f);
    }

    /**
     * 0.1.0
     */
    public void updateWallType() {

    }

    /**
     * @since 0.1.0
     */
    private void setWallType() {

    }
}