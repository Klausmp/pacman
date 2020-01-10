package de.klausmp.packman.utils;

/**
 * zeigt die rotation an.
 *
 * @author Klausmp
 * @version 0.1.4
 * @since 0.1.0
 */
public enum Rotation {
    /**
     * links
     *
     * @since 0.1.0
     */
    LEFT(1),

    /**
     * rechts
     *
     * @since 0.1.0
     */
    RIGHT(2),

    /**
     * oben
     *
     * @since 0.1.0
     */
    UP(0),

    /**
     * unten
     *
     * @since 0.1.0
     */
    DOWN(3);

    /**
     * standart richtung
     *
     * @since 0.1.0
     */
    public static Rotation DEFAULTROTATION = UP;

    /**
     * TODO JAVA DOC
     *
     * @since 0.1.4
     */
    private int rotation;

    /**
     * TODO JAVA DOC
     *
     * @param rotation
     * @since 0.1.4
     */
    Rotation(int rotation) {
        rotation = rotation;
    }

    /**
     * TODO JAVA DOC
     *
     * @param rotation
     * @return
     * @sine 0.1.4
     */
    public static Rotation getRotationFromInt(int rotation) {
        switch (rotation){
            case 0:
                return UP;
            case 1:
                return LEFT;
            case 2:
                return RIGHT;
            case 3:
                return DOWN;
            default:
                return DEFAULTROTATION;
        }
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.1.4
     */
    public int getRotation() {
        return rotation;
    }
}
