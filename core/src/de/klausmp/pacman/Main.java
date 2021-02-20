package de.klausmp.pacman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import de.klausmp.pacman.visuals.screens.GameScreen;

//TODO Klasse die dingine folgt aus geist auslagern für eventuell noch andere deinge dien den spieler z.b. nicht killen

//TODO Ersetze GameObject.getCurrentGridTile.getGrid mit GameObject.getGrid!!

//TODO v 0.1.* rendering, grid, und start des programmes    (fertig)
//TODO v 0.2.* walls mit automatischer wall bildung         (fertig)
//TODO v 0.3.* animationen klasse                           (fertig)
//TODO v 0.4.* player                                       (fertig)
//TODO v 0.5.* dots + score                                 (fertig)
//TODO v 0.6.* geister                                      (fertig bis auf texturen und animationen)
//TODO v 0.7.* map interpreter                              (fertig)
//TODO v 0.8.* menue + intro                                (fertig)
//TODO v 0.9.* geister ki + fertige geister                 (in arbeit)
//TODO v 0.9.3 neues movement                               (abgebrochen)
//TODO v 0.9.4 neues movement                               (fertig)
//TODO v 0.9.5 implementation der taget suche und texturen  (fertig)
//TODO v 0.9.6 richtiger ablauf der gameModes               (fertig)
//TODO v 0.9.7 geister blinken vor ende des frightend Modes (fertig)
//TODO v 0.9.8 geister betten                               (fertig)
//TODO v 0.10.* JAVA DOC Ausnahmen, generelles cleanup und nutzung neuer java fetures und vorlamme fucking streams!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//TODO v 0.11.* teleporter
//TODO v 0.12.* HUD
//TODO v 0.13.* esc menue in neuem screen (maby mit nem screenshoot oder so)
//TODO v 0.14.* start des levels mit space
//TODO v 0.15.* übergang zwischen leveln
//TODO v 0.16.* level kopieren / erstellen

/**
 * startmethode des haubtspieles (platformunabhaenig (Core))
 *
 * @author Klausmp
 * @version 0.10.6
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