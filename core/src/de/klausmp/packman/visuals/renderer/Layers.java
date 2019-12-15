package de.klausmp.packman.visuals.renderer;

/**
 * liste aller verfügbaren {@link Layer layer} im renderer.
 *
 * @author Klausmp
 * @version 0.0.1
 */
public enum Layers {

    /**
     * layer für den hintergrund
     *
     * @since 0.0.1
     */
    BACKGROUND,
    /**
     * layer für alles was im hintergrund des spieles abläuft
     *
     * @since 0.0.1
     */
    BACK,
    /**
     * der normale layer in dem unter anderem der spieler gerendert wird, er representiert die mitte des spieles
     *
     * @since 0.0.1
     */
    DEFAULT,
    /**
     * layer für alles was im fordergrund angezeigt werden soll
     */
    FRONT,
    /**
     * layer für elemente die eigentlich nicht zum spiel gehören jedoch auch nicht zum text oder gui gehören
     *
     * @since 0.0.1
     */
    INFRONT,
    /**
     * layer für texte die im spiel erscheinen
     *
     * @since 0.0.1
     */
    TEXT,
    /**
     * layer für alle gui elemente
     *
     * @since 0.0.1
     */
    GUI;

    /**
     * {@link Layer layer} mit kleinem index werden unter {@link Layer layern} mit großem index gezeichnet. <br>
     * dadurch sind {@link Layer layer} mit hohem index im vordergrund
     *
     * @return default zeichenreihenfolge der layer.
     */
    public static Layers[] DEFAULTLAYERORDER() {
        return new Layers[]{Layers.BACKGROUND, Layers.BACK, Layers.DEFAULT, Layers.FRONT, Layers.INFRONT, Layers.TEXT, Layers.GUI};
    }
}
