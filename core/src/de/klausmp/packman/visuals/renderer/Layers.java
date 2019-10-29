package de.klausmp.packman.visuals.renderer;

/**
 * @author Klausmp
 */

/*
 * dieses enum ist eine liste aller verfügbaren layer im renderer
 * zudem bietet sie eine DEFAULT
 * */
public enum Layers {

    //  layer für den hintergrund
    BACKGROUND,
    //  layer für alles was im hintergrund des spieles abläuft
    BACK,
    //  der normale layer in dem unter anderem der spieler gerendert wird, er representiert die mitte des spieles
    DEFAULT,
    //  layer für alles was im fordergrund angezeigt werden soll
    FRONT,
    //  layer für elemente die eigentlich nicht zum spiel gehören jedoch auch nicht zum text oder gui gehören
    INFRONT,
    //  layer für texte die im spiel erscheinen
    TEXT,
    //  layer für alle gui elemente
    GUI;

    //  default reihenfolger der layer in der sie gerendert werden
//  hierbei ist der erste layer der der zu erst gezeichnet wird
//  alles ander wird darüber gezeichnet
    public static Layers[] DEFAULTLAYERORDER() {
        Layers[] DEFAULTLAYERORDER = {Layers.BACKGROUND, Layers.BACK, Layers.DEFAULT, Layers.FRONT, Layers.INFRONT, Layers.TEXT, Layers.GUI};
        return DEFAULTLAYERORDER;
    }
}
