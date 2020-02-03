package de.klausmp.pacman.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import de.klausmp.pacman.Main;

/**
 * TODO JAVA DOC
 *
 * @author klausmp
 * @version 0.7.2
 * @since 0.7.1
 */
public class DesktopLauncher {

    /**
	 * TODO JAVA DOC
	 *
     * @param arg
     * @version 0.7.2
     * @since 0.7.1
     */
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.useVsync(true);
        config.setResizable(false);
        config.setWindowedMode(500, 500);
        config.setTitle("Pac Man");
        new Lwjgl3Application(new Main(), config);
    }
}
