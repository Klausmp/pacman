package de.klausmp.packman.utils;

import static de.klausmp.packman.utils.GridTileType.EMTY;
import static de.klausmp.packman.utils.GridTileType.ROAD;

/**
 * liste aller {@link de.klausmp.packman.gameObjects.Wall wall}-Typen.
 *
 * @author Klausmp
 * @version 0.1.4
 * @since 0.1.0
 */
public enum WallTypes {

    /**
     * standart {@link de.klausmp.packman.gameObjects.Wall wall}-Textur
     *
     * @since 0.1.1
     */
    WALL("wall", ROAD, GridTileType.WALL, GridTileType.WALL, EMTY);

    /**
     * textur des {@link de.klausmp.packman.gameObjects.Wall wall}Typen.
     *
     * @since 0.1.4
     */
    private String textureRegion;

    /**
     * vorlage der {@link GridTileType grifTileTypen} um zu entscheiden welcher {@link WallTypes wallType} genutzt werden soll
     *
     * @since 0.1.4
     */
    private GridTileType[] surroundings = new GridTileType[4];

    WallTypes(String textureRegion, GridTileType zero, GridTileType one, GridTileType two, GridTileType three) {
        this.textureRegion = textureRegion;
        surroundings[0] = zero;
        surroundings[1] = one;
        surroundings[2] = two;
        surroundings[3] = three;
    }

    /**
     * gibt die {@link com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion} des {@link WallTypes wallTypes} zurrück
     *
     * @return die {@link com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion} des {@link WallTypes wallTypes}
     * @since 0.1.4
     */
    public String getTextureRegion() {
        return textureRegion;
    }
}
