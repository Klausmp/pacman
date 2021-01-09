package de.klausmp.pacman.gameObjects.staticGameObjects.textured.wall;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.GameObject;
import de.klausmp.pacman.gameObjects.staticGameObjects.textured.StaticGameObjekt;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * wände im spiel.
 *
 * @author Klausmp
 * @version 0.9.8
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
        super(GameScreen.getAtlas().findRegion("black"), position, Rotation.UP, GameObjectType.WALL, Layers.BACKGROUND, 5.0f, gridTile);
    }

    public Wall(Vector2 position, GameObjectType gameObjectType,GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("black"), position, Rotation.UP, gameObjectType, Layers.BACKGROUND, 5.0f, gridTile);
    }

    public Wall(TextureRegion region, Vector2 position, GameObjectType gameObjectType, GridTile gridTile) {
        super(region, position, Rotation.UP, gameObjectType, Layers.BACKGROUND, 5.0f, gridTile);
    }

    /**
     * setzt die {@link com.badlogic.gdx.graphics.g2d.Sprite sprite} passend zu
     * den umliegenen {@link GridTile gridTiles} um eine durchgehende wand zu erschaffen
     *
     * @param atlas {@link TextureAtlas textureAtlas} mit den gameTexturen;
     * @version 0.7.3
     * @since 0.1.4
     */
    public void setTexture(TextureAtlas atlas) {
        GridTileType[] surroundings = currendGridTile.getSurroundingGridTileTypes();
        for (int i = 0; i <= 3; i++) {
            if (surroundings[Rotation.UP.getInt()] == GridTileType.WALL && surroundings[Rotation.RIGHT.getInt()] == GridTileType.WALL && surroundings[Rotation.DOWN.getInt()] == GridTileType.WALL && surroundings[Rotation.LEFT.getInt()] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallBigCrossing"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[Rotation.UP.getInt()] == GridTileType.WALL && surroundings[Rotation.RIGHT.getInt()] == GridTileType.WALL && surroundings[Rotation.DOWN.getInt()] != GridTileType.WALL && surroundings[Rotation.LEFT.getInt()] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallBigTPice"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[Rotation.UP.getInt()] != GridTileType.WALL && surroundings[Rotation.RIGHT.getInt()] == GridTileType.WALL && surroundings[Rotation.DOWN.getInt()] != GridTileType.WALL && surroundings[Rotation.LEFT.getInt()] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallBig"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[Rotation.UP.getInt()] != GridTileType.WALL && surroundings[Rotation.RIGHT.getInt()] != GridTileType.WALL && surroundings[Rotation.DOWN.getInt()] == GridTileType.WALL && surroundings[Rotation.LEFT.getInt()] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallBigCurve"));
                setRotation(90 * i);
                return;
            }
            if (surroundings[Rotation.UP.getInt()] != GridTileType.WALL && surroundings[Rotation.RIGHT.getInt()] != GridTileType.WALL && surroundings[Rotation.DOWN.getInt()] != GridTileType.WALL && surroundings[Rotation.LEFT.getInt()] == GridTileType.WALL) {
                setRegion(atlas.findRegion("wallBigEnd"));
                setRotation(90 * i);
                return;
            }
            surroundings = GridTile.rotateSuroundings(surroundings);
        }
    }

    @Override
    protected void animation() {

    }
}