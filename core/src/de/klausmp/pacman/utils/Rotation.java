package de.klausmp.pacman.utils;

/**
 * zeigt die rotation an.
 *
 * @author Klausmp
 * @version 0.9.2
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
    RIGHT(3),

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
    DOWN(2);

    /**
     * standart rotation
     *
     * @since 0.1.0
     */
    public static Rotation DEFAULTROTATION = getRotationFromInt(0);

    /**
     * integer wert passend zu den werten des enums <br>
     * (ganze zahlen von 0-3)
     *
     * @since 0.1.4
     */
    private final int rotation;

    /**
     * konstruktor mit einstellungsmöglichkeit der rotation
     *
     * @param rotation integerwert der rotation
     * @since 0.1.4
     */
    Rotation(int rotation) {
        this.rotation = rotation;
    }

    /**
     * wandelt einen integer wert zu einem enum wert um.
     *
     * @param rotation integer wert zu einer rotation (ganze zahl von 0-3)
     * @return enum wert zum eingegebenen integer wert
     * @since 0.1.4
     */
    public static Rotation getRotationFromInt(int rotation) {
        switch (rotation) {
            case 0:
                return UP;
            case 1:
                return LEFT;
            case 2:
                return DOWN;
            case 3:
                return RIGHT;
            default:
                return DEFAULTROTATION;
        }
    }

    /**
     * gibt den integer wert passen zum enum wert zurrück.
     *
     * @return integer wert passend zum enum wert.
     * @since 0.4.2
     */
    public int getInt() {
        return rotation;
    }

    public static Rotation getOpposite(Rotation rotation) {
        switch (rotation) {
            case UP:
                return Rotation.DOWN;
            case LEFT:
                return Rotation.RIGHT;
            case DOWN:
                return Rotation.UP;
            case RIGHT:
                return Rotation.LEFT;
        }
        return null;
    }
}
