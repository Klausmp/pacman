package de.klausmp.packman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import de.klausmp.packman.visuals.screens.GameScreen;

/**
 * @author Klausmp
 */
//todo menues etc for den rest der level etc machen
public class Main extends Game {

	private static Main INSTANCE;

	@Override
	public void create () {
	//erstellung einer neuen instance von main wenn keine vorhanden ist
		if (INSTANCE == null){
			INSTANCE = this;
		}
		//setzen des Start Screens
		setScreen(new GameScreen());
	}

	@Override
	public void render () {
		//rendern des aktiven screens
		getScreen().render(Gdx.graphics.getDeltaTime());
		//schließung der anwendung beim drücken von ESC
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
	}

	@Override
	public void dispose () {

	}

	//methode um den anktiven screen von überall zu ändern
	public static void setActiveScreen(Screen screen){
		INSTANCE.setScreen(screen);
	}
}
