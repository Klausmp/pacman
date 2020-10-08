package de.klausmp.pacman.world;

import de.klausmp.pacman.utils.Rotation;

import javax.sound.midi.SoundbankResource;

/**
 * TODO JAVA DOC
 *
 * @since 0.9.4
 */
public class PathElement {

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    private Rotation rotation;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    private int amountOfSkips = 0;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    public PathElement(Rotation rotation, int amountOfSkip) {
        this.rotation = rotation;
        this.amountOfSkips = amountOfSkip;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    public Rotation getRotation() {
        return rotation;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    public int peek() {
        return amountOfSkips;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    public void setDonw() {
        if (amountOfSkips > 0) {
            amountOfSkips--;
        }
    }

}
