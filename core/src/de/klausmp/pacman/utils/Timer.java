package de.klausmp.pacman.utils;

/**
 * @author Klausmp
 * @version 0.9.8
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
     * @since 0.9.6
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * TODO JAVA DOC
     * @since 0.9.7
     */
    public int getRemainingTime() {
        int remainingTime = (int) (delay - (System.currentTimeMillis() - start));
        //System.out.println(remainingTime);
        if (remainingTime <= 0) {
            return 0;
        } else {
            return remainingTime;
        }
    }

    /**
     * TODO JAVA DOC
     *
     * @return
     * @since 0.4.1
     */
    public boolean isExpired() {
        return System.currentTimeMillis() - delay >= start;
    }
}
