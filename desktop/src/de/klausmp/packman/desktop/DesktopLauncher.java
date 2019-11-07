package de.klausmp.packman.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import de.klausmp.packman.Main;

/**
 * @author Klausmp
 */

public class DesktopLauncher {
	public static void main (String[] arg) {
		startDesktop();
	}

	public static void startDesktop(){
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		//einschaltung von vertikaler synkronisation
		config.useVsync(true);
		//setzen des fenster titels
		config.setTitle("Pac Man");
		//verhinderung der größenänderung des fensters
		config.setResizable(false);
		//setzen der größe des fensters
		config.setWindowedMode(500, 500);
		new Lwjgl3Application(new Main(), config);
	}

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
