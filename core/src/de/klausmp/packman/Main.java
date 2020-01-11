package de.klausmp.packman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import de.klausmp.packman.visuals.screens.GameScreen;

//TODO v 0.1.0 rendering, grid, und start des programmes    (fertig)
//TODO v 0.02.0 walls mit automatischer wall bildung        (fertig)
//TODO v 0.3.0 animationen klasse                          (fertig)
//TODO v 0.4.0 player                                      (in arbeit)
//TODO V 0.5.0 bounding
//TODO v 0.6.0 dots + score
//TODO v 0.7.0 map interpreter
//TODO v 0.8.0 geister mit ki
//TODO v 0.9.0 main menue
//TODO v 0.10.0 intro
//TODO v 0.11.0 esc menue in neuem screen (maby mit nem screenshoot oder so)
//TODO v 0.12.0 start des levels mit space
//TODO v 0.13.0 übergang zwischen leveln
//TODO v 0.14.0 level kopieren / erstellen

/**
 * startmethode des haubtspieles (platformunabhaenig (Core))
 *
 * @author Klausmp
 * @version 0.2.0
 * @see Game
 * @since 0.0.1
 */
public class Main extends Game {

    /**
     * instance des spieles. alle dinge aus der mainInstance sind damit zu erreichen. <br>
     * kann und darf nur einmal existieren.
     *
     * @since 0.0.1
     */
    private static Main INSTANCE;

    /**
     * methode um den anktiven screen von überall zu ändern
     *
     * @param screen neuer {@link Screen screen} der von nun an dargestellt wird
     * @since 0.0.1
     */
    public static void setActiveScreen(Screen screen) {
        INSTANCE.setScreen(screen);
    }

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

    @Override
    public void dispose() {
        screen.dispose();
    }
}