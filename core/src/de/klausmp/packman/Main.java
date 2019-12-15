package de.klausmp.packman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import de.klausmp.packman.visuals.screens.GameScreen;

//todo menues etc for den rest der level etc machen

/**
 * startmethode des haubtspieles platformunabhänig (Core)
 *
 * @author Klausmp
 * @version 0.0.1
 * @see Game
 */
public class Main extends Game {

    private static Main INSTANCE;

    /**
     * erstellung des spieles mit der erschaffung einer main-instance
     * und setzung des startscreens.
     *
     * @Override
     * @since 0.0.1
     */
    public void create() {
        /**
         * erstellung einer neuen instance von main wenn keine vorhanden ist
         */
        if (INSTANCE == null) {
            INSTANCE = this;
        }
        /**
         * setzen des Start Screens
         */
        setScreen(new GameScreen());
    }

    /**
     * rendert und updated alle objecte im spiel.
     * einstellungsmöglichkeiten für PC im DesktopLauncher.
     *
     * @Override
     * @since 0.0.1
     */
    public void render() {
        /**
         * rendern des aktiven screens
         */
        getScreen().render(Gdx.graphics.getDeltaTime());
        /**
         * schließung der anwendung beim drücken von ESC
         */
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    /**
     * @Override
     * @since 0.0.1
     */
    public void dispose() {
        screen.dispose();
    }

    /**
     * methode um den anktiven screen von überall zu ändern
     *
     * @since 0.0.1
     */
    public static void setActiveScreen(Screen screen) {
        INSTANCE.setScreen(screen);
    }
}
