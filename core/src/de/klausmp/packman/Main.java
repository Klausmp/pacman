package de.klausmp.packman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Main extends Game {

	private static Main INSTANCE;

	public Main() {
//		erstellung einer neuen instance von main wenn keine vorhanden ist
		if (INSTANCE == null){
			INSTANCE = this;
		}
	}

	@Override
	public void create () {
	}

	@Override
	public void render () {
	}

	@Override
	public void dispose () {

	}

//	methode um den anktiven screen von überall zu ändern
	public static void setActiveScreen(Screen screen){
		INSTANCE.setScreen(screen);
	}
}
