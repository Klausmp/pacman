package de.klausmp.packman.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import de.klausmp.packman.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
//		einschaltung von vertikaler synkronisation
		config.useVsync(true);
//		setzen des fenster titels
		config.setTitle("Pac Man");
//		verhinderung der größenänderung des fensters
		config.setResizable(false);
//		setzen der größe des fensters
		config.setWindowedMode(500, 500);
		new Lwjgl3Application(new Main(), config);
	}
}
