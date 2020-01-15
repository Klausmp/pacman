package de.klausmp.packman.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import de.klausmp.packman.Main;

/**
 * starter für die desktopanwendung.
 *
 * @author Klausmp
 * @version 0.1.0
 * @since 0.0.1
 */
public class DesktopLauncher {

    /**
     * main methode für die desktop anwendung.
     *
     * @param arg start argumente.
     */
    public static void main(String[] arg) {
        packer();
        startDesktop();
    }

    /**
     * startet die desktop anwendung mit den in der methode festgelegten einstellungen.
     *
     * @since 0.0.1
     */
    public static void startDesktop() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        //einschaltung von vertikaler synkronisation
        config.useVsync(true);
        //setzen des fenster titels
        config.setTitle("Pac Man");
        //verhinderung der größenänderung des fensters
        config.setResizable(true);
        //setzen der größe des fensters
        config.setWindowedMode(500, 500);
        new Lwjgl3Application(new Main(), config);
    }

    /**
     * texturePacker <br>
     * erstellt eine sprite sheet und einen texture atlas mit allen texturen die in "core/assets/pacMan"
     * vorhanden sind. "core/assets" ist des output ordner.
     *
     * @since 0.0.1
     */
    public static void packer() {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.maxWidth = 4096;
        settings.maxHeight = 4096;
        settings.edgePadding = true;
        settings.duplicatePadding = true;
        settings.filterMin = Texture.TextureFilter.Linear;
        settings.filterMag = Texture.TextureFilter.Linear;
        TexturePacker.process(settings, "pacMan", ".", "spriteSheed");
    }
}