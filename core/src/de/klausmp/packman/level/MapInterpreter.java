package de.klausmp.packman.level;

import java.awt.image.BufferedImage;

/**
 * liest ein bild ein und füllt nach den angaben des bildes ein grid mit den passenden gameObjecten
 * <p>
 * ##COLORS##
 * <p>
 * #Wall RGB 0 0 255
 * #Food RGB 200 255 0
 * #BigFood RGB 100 255 0
 *
 * @author Klausmp
 * @versiom 0.7.0
 * @since 0.7.0
 */
//TODO Texture interpreter der aus verschiedenen farben auf einem png oder so das level aufbaut.
public abstract class MapInterpreter {

    /**
     * @param map
     * @return
     * @version 0.7.1
     * @since 0.7.1
     */
    public Grid loadMap(BufferedImage map) {

        return null;
    }
}