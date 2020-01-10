package de.klausmp.packman.gameObjects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.packman.level.GridTile;
import de.klausmp.packman.utils.GameObjectType;
import de.klausmp.packman.utils.GridTileType;
import de.klausmp.packman.utils.Layers;
import de.klausmp.packman.utils.Rotation;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * wände im spiel.
 *
 * @author Klausmp
 * @version 0.1.4
 * @see StaticGameObjekt
 * @since 0.1.0
 */
public class Wall extends StaticGameObjekt {

    /**
     * konstrucktor mit einstellungsmöglichkeiten bei der startposition.
     *
     * @param position startposition der {@link Wall wall}.
     * @param gridTile {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @since 0.1.4
     */
    public Wall(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("wall"), position, Rotation.UP, GameObjectType.WALL, Layers.BACKGROUND, 5.0f, gridTile);
    }

    /**
     * setzt die {@link com.badlogic.gdx.graphics.g2d.Sprite sprite} passend zu
     * den umliegenen {@link GridTile gridTiles} um eine durchgehende wand zu erschaffen
     *
     * @param atlas {@link TextureAtlas textureAtlas} mit den gameTexturen;
     * @since 0.1.4
     */
    public void setTexture(TextureAtlas atlas) {
        GridTileType[] surroundings = gridTile.getSurroundings();
        for (int i = 0; i <= 3; i++) {
            if (surroundings[0] == GridTileType.ROAD && surroundings[1] == GridTileType.WALL && surroundings[2] == GridTileType.EMTY && surroundings[3] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wall"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[0] == GridTileType.ROAD && surroundings[1] == GridTileType.WALL && surroundings[2] == GridTileType.ROAD && surroundings[3] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallBig"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[0] == GridTileType.WALL && surroundings[1] == GridTileType.WALL && surroundings[2] == GridTileType.WALL && surroundings[3] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallBigCrossing"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[0] == GridTileType.WALL && surroundings[1] == GridTileType.WALL && surroundings[2] == GridTileType.ROAD && surroundings[3] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallBigTPice"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[0] == GridTileType.EMTY && surroundings[1] == GridTileType.WALL && surroundings[2] == GridTileType.WALL && surroundings[3] == GridTileType.EMTY) {
                setRegion(atlas.findRegion("wallCurve"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[0] == GridTileType.WALL && surroundings[1] == GridTileType.ROAD && surroundings[2] == GridTileType.ROAD && surroundings[3] == GridTileType.ROAD) {
                setRegion(atlas.findRegion("wallEnd"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[0] == GridTileType.WALL && surroundings[1] == GridTileType.WALL && surroundings[2] == GridTileType.EMTY && surroundings[3] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallToBigTPice"));
                setRotation(90 * i);
                return;
            }
            surroundings = GridTile.rotateSuroundings(surroundings);
        }
    }
}