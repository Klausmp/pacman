package de.klausmp.packman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import de.klausmp.packman.screens.GameScreen;

public class Main extends Game {

	private static Main INSTANCE;
	@Override
	public void create () {
//		erstellung einer neuen instance von main wenn keine vorhanden ist
		if (INSTANCE == null){
			INSTANCE = this;
		}
//		setzen des Start Screens
		setScreen(new GameScreen());
	}

	@Override
	public void render () {
//	    rendern des aktiven screens
		getScreen().render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose () {

	}

//	methode um den anktiven screen von überall zu ändern
	public static void setActiveScreen(Screen screen){
		INSTANCE.setScreen(screen);
	}
}
