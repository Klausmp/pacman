package de.klausmp.pacman.utils;

/**
 * TODO JAVA DOC
 * @author Klausmp
 * @since 0.7.5
 */
public enum GameModes {

    //TODO JAVA DOC
    CHASE(0),

    //TODO JAVA DOC
    SCATTER(1),

    //TODO JAVA DOC
    FRIGHTEND(2);

    private int mode;

    GameModes(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }
}
