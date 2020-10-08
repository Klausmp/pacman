package de.klausmp.pacman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import de.klausmp.pacman.visuals.screens.GameScreen;

//TODO Klasse die dingine folgt aus geist auslagern für eventuell noch andere deinge dien den spieler z.b. nicht killen

//TODO v 0.1.0 rendering, grid, und start des programmes    (fertig)
//TODO v 0.2.0 walls mit automatischer wall bildung         (fertig)
//TODO v 0.3.0 animationen klasse                           (fertig)
//TODO v 0.4.0 player                                       (fertig)
//TODO v 0.5.0 dots + score                                 (fertig)
//TODO v 0.6.0 geister                                      (fertig bis auf texturen und animationen)
//TODO v 0.7.0 map interpreter                              (fertig)
//TODO v 0.8.0 menue + intro                                (fertig)
//TODO v 0.9.0 geister ki                                   (unterbrochen)
//TODO v 0.9.3 neues movement                               (abgebrochen)
//TODO v 0.9.4 neues movement                               (in arbeit)
//TODO v 0.10.0 teleporter
//TODO v 0.11.0 HUD
//TODO v 0.12.0 esc menue in neuem screen (maby mit nem screenshoot oder so)
//TODO v 0.13.0 start des levels mit space
//TODO v 0.14.0 übergang zwischen leveln
//TODO v 0.15.0 level kopieren / erstellen

/**
 * startmethode des haubtspieles (platformunabhaenig (Core))
 *
 * @author Klausmp
 * @version 0.9.4
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
        if (getActiveScreen() != null) {
            getActiveScreen().dispose();
        }
        INSTANCE.setScreen(screen);
    }

    public static Screen getActiveScreen() {
        return INSTANCE.getScreen();
    }

    /**
     * erstellung des spieles mit der erschaimport de.klausmp.pacman.visuals.screens.MainMenue;ffung einer main-instance
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
        Main.setActiveScreen(new GameScreen());
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
            System.exit(0);
        }
    }

    @Override
    public void dispose() {
        screen.dispose();
    }
}