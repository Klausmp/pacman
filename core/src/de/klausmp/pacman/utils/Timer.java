package de.klausmp.pacman.utils;

/**
 * @author Klausmp
 * @version 0.4.1
 * @since 0.4.1
 */
public class Timer {

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.1
     */
    private int delay;

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.1
     */
    private long start;

    /**
     * TODO JAVA DOC
     *
     * @param delay
     * @since 0.4.1
     */
    public Timer(int delay) {
        this.delay = delay;
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.1
     */
    public void start() {
        start = System.currentTimeMillis();
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.4.1
     * @return
     */
    public boolean isExpired() {
        return System.currentTimeMillis() - delay >= start;
    }
}
