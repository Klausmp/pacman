package de.klausmp.pacman.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.PacMan;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Blinky;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Clyde;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Inky;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Pinky;
import de.klausmp.pacman.gameObjects.staticGameObjects.dots.BigDot;
import de.klausmp.pacman.gameObjects.staticGameObjects.dots.Dot;
import de.klausmp.pacman.gameObjects.staticGameObjects.wall.Door;
import de.klausmp.pacman.gameObjects.staticGameObjects.wall.Wall;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.visuals.screens.GameScreen;
import de.klausmp.pacman.world.grid.Grid;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * liest ein bild ein und füllt nach den angaben des bildes ein grid mit den passenden gameObjecten
 * <p>
 * ##COLORS##
 * <p>
 * #Wall RGB 0 0 255
 * #Food RGB 200 255 0
 * #BigFood RGB 100 255 0
 *
 * @author Klausmp
 * @versiom 0.9.2
 * @since 0.7.0
 */
//TODO Texture interpreter der aus verschiedenen farben auf einem png oder so das level aufbaut.
public abstract class MapInterpreter {

    /**
     * TODO JAVA DOC
     *
     * @param mapPath
     * @return
     * @version 0.7.3
     * @since 0.7.1
     */
    public static Grid loadMap(String mapPath) {
        File file = new File(Gdx.files.internal(mapPath).path());
        BufferedImage map = null;
        try {
            map = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Grid result = new Grid();
        assert map != null;
        result.setSize(new Vector2(map.getWidth(), map.getHeight()));
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                int color = map.getRGB(map.getWidth() - x - 1, y);
                int r = (color & 0x00ff0000) >> 16;
                int g = (color & 0x0000ff00) >> 8;
                int b = (color & 0x000000ff);
                //System.out.println(r);
                //System.out.println(g);
                //System.out.println(b);
                //System.out.println();

                int x1 = map.getWidth() - x;
                int y1 = map.getHeight() - y;
                switch (GameObjectType.getGameObjecTypeFromColor(r, g, b)) {
                    case DOOR:
                        result.addToGridTile(new Door(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        break;
                    case WALL:
                        result.addToGridTile(new Wall(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        break;
                    case DOT:
                        result.addToGridTile(new Dot(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        break;
                    case BIGDOT:
                        result.addToGridTile(new BigDot(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        break;
                    case GHOST:
                        result.addToGridTile(new Blinky(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        result.addToGridTile(new Inky(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        result.addToGridTile(new Pinky(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        result.addToGridTile(new Clyde(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        break;
                    case PACMAN:
                        result.addToGridTile(new PacMan(new Vector2(Grid.getGridTileSize().x * x1, Grid.getGridTileSize().y * y1), result.getGridTile(x1, y1)), x1, y1);
                        break;
                }
            }
        }
        for (int x = 0; x <= result.getSize().x; x++) {
            for (int y = 0; y <= result.getSize().y; y++) {
                if (result.getGridTile(x, y).getGameObjectByType(GameObjectType.WALL) != null && result.getGridTile(x, y).getGameObjects().get(0) instanceof Wall) {
                    Wall wall = (Wall) result.getGridTile(x, y).getGameObjects().get(0);
                    wall.setTexture(GameScreen.getAtlas());
                }
            }
        }

        for (int x = 0; x <= result.getSize().x; x++) {
            for (int y = 0; y <= result.getSize().y; y++) {
                if (result.getGridTile(x, y).getGridTileType() == GridTileType.ROAD) {
                    int amountOfRoads = 0;
                    for (int i = 0; i < 4; i++) {
                        if (result.getGridTile(x, y).getSurroundingGridTiles()[i].getGridTileType() == GridTileType.ROAD) {
                            amountOfRoads++;
                        }
                    }
                    if (amountOfRoads >= 3) {
                        result.getGridTile(x, y).setGridTileType(GridTileType.INTERSECTION);
                    }
                }
            }
        }
        return result;
    }
}