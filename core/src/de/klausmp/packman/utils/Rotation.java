package de.klausmp.packman.utils;

/**
 * zeigt die rotation an.
 *
 * @author Klausmp
 * @version 0.1.0
 * @since 0.1.0
 */
public enum Rotation {
    /**
     * links
     *
     * @since 0.1.0
     */
    LEFT,

    /**
     * rechts
     *
     * @since 0.1.0
     */
    RIGHT,

    /**
     * oben
     *
     * @since 0.1.0
     */
    UP,

    /**
     * unten
     *
     * @since 0.1.0
     */
    DOWN;

    /**
     * standart richtung
     *
     * @since 0.1.0
     */
    public static Rotation DEFAULTROTATION = DOWN;

}
