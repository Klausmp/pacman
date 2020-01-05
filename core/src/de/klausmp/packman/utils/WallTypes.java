package de.klausmp.packman.utils;

/**
 * liste aller {@link de.klausmp.packman.gameObjects.Wall wall}-Typen.
 *
 * @author Klausmp
 * @version 0.1.1
 * @since 0.1.0
 */
public enum WallTypes {

    /**
     * @since 0.1.1
     */
    WALL("wall");

    /**
     * @since 0.1.1
     */
    private String textureRegion;
    WallTypes(String textureRegion ){
        this.textureRegion = textureRegion;
    }

    /**
     * @since 0.1.1
     */
    public String getTextureRegion() {
        return textureRegion;
    }
}
