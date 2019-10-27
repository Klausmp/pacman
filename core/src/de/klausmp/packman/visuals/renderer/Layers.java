package de.klausmp.packman.visuals.renderer;

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
}
