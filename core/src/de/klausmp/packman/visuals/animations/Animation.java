package de.klausmp.packman.visuals.animations;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author Klausmp
 * @version 0.2.0
 * @since 0.2.0
 */
public class Animation {

    /**
     * zeitpunkt zudem das letzte mal der frame gewechselt wird.
     *
     * @since 0.2.0
     */
    private long lastTime;

    /**
     * delay zwischen zwei frames in millisekunden.
     *
     * @since 0.2.0
     */
    private int delay;

    /**
     * nummer des frames der im moment angezeiggt wird.
     *
     * @since 0.2.0
     */
    private int currentFrame;

    /**
     * namen der {@link TextureRegion texturRegionen} zwischen denen wärend der animation gewchselt wird.
     *
     * @since 0.2.0
     */
    private String[] regionNames;

    /**
     * {@link TextureAtlas textureAtlas} aus dem die textur regionen gesucht werden.
     *
     * @since 0.2.0
     */
    private TextureAtlas atlas;

    /**
     * konstruktor mit verschiedenen einstellungsmöglicheiten.
     *
     * @param delay       zeit zwisches zwei frames in milisekunden
     * @param regionNames namen der regionen zwischen denen gewechselt wird
     * @param atlas       {@link TextureAtlas textureAtlas} aus dem die {@link TextureRegion textureRegionen} gesucht werden
     * @since 0.2.0
     */
    public Animation(int delay, String[] regionNames, TextureAtlas atlas) {
        this.delay = delay;
        this.regionNames = regionNames;
        this.atlas = atlas;
        lastTime = System.currentTimeMillis();
    }

    /**
     * errechnet den passenden frame
     *
     * @return gibt immer den paaenden frame zurrück
     * @since 0.2.0
     */
    public TextureRegion getTextureRegion() {
        if ((System.currentTimeMillis() - lastTime) >= delay) {
            lastTime = System.currentTimeMillis();
            currentFrame++;
            if ((regionNames.length - 1) < currentFrame) {
                currentFrame = 0;
            }
        }
        return atlas.findRegion(regionNames[currentFrame]);
    }
}
