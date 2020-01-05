package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.utils.Layers;

/**
 * ein Layer der im {@link LayerRenderer layerRenderer} gezeichnet wird.
 * die klasse layer sortiert ihre elemente nach prioritat.
 * und zeichnet sie in der richtigen reihenfloge auf den screen.
 *
 * @author Klausmp.
 * @version 0.0.1
 * @since 0.0.1
 */
public class Layer {
    /**
     * liste aller elemente die in diesem layer gerendert werden
     *
     * @since 0.0.1
     */
    private Array<LayerRendererQueQueElement> elementsToRender;
    /**
     * der layer in dem dieser layer rendert
     *
     * @since 0.0.1
     */
    private Layers layerToRenderOn;

    /**
     * konstruktor ohne einstellungsmöglichkeiten mit {@link Layers#DEFAULT default layer} als {@link #layerToRenderOn layerToRenderOn}
     *
     * @since 0.0.1
     */
    public Layer() {
        this.layerToRenderOn = Layers.DEFAULT;
        this.elementsToRender = new Array<LayerRendererQueQueElement>();
    }

    /**
     * konstruktor mit einstellungsmöglichkeiten für den dargestellten layer
     *
     * @param layerToRenderOn {@link Layers Layer} auf dem der {@link LayerRenderer#layerOrder layerOrder} folgend gerendert wird.
     * @since 0.0.1
     */
    public Layer(Layers layerToRenderOn) {
        this.layerToRenderOn = layerToRenderOn;
        this.elementsToRender = new Array<LayerRendererQueQueElement>();
    }

    /**
     * rendert alle elemente aus der "elementsToRender" liste nach {@link LayerRendererQueQueElement#priority priorität}
     *
     * @param batch {@link SpriteBatch SpriteBatch} auf dem gerendert wird. dieser befindet sich im {@link LayerRenderer#batch layerRenderer}
     * @since 0.0.1
     */
    public void render(SpriteBatch batch) {
        sortElementsToRdender();
        /**
         * rendert alle elemente aus "elementsToRender" nach priorität mit dem kleinsten element zu erst. dadurch sind elemente mit hoher priorität
         * vor elementen mit niediriger priorität gezeichnet
         *
         * @since 0.0.1
         */
        for (LayerRendererQueQueElement element : elementsToRender) {
            /**
             * rendert elemente auf den screen
             *
             * @since 0.0.1
             */
            element.getSprite().draw(batch);
        }
        clear();
    }

    /**
     * sortiert "elementsToRender" nach ihrer priorität (kleinste zu erst). <br>
     * dafür wird bubblesort verwendet.
     *
     * @since 0.0.1
     */
    private void sortElementsToRdender() {
        for (int s = elementsToRender.size; s > -1; s--) {
            for (int x = 0; x < s - 1; x++) {
                if (elementsToRender.get(x).getPriority() > elementsToRender.get(x + 1).getPriority()) {
                    swap(x, x + 1);
                }
            }
        }
    }

    /**
     * tauscht zwei elemente aus {@link #elementsToRender elementsToRender}.
     *
     * @param firstIndex  index des ersten elements
     * @param secondIndex index des zweiten elements
     * @since 0.0.1
     */
    private void swap(int firstIndex, int secondIndex) {
        LayerRendererQueQueElement save = elementsToRender.get(firstIndex);
        elementsToRender.removeIndex(firstIndex);
        elementsToRender.insert(firstIndex, elementsToRender.get(secondIndex - 1));
        elementsToRender.removeIndex(secondIndex);
        elementsToRender.insert(secondIndex, save);
    }

    /**
     * fügt neue elemente zu {@link #elementsToRender elementsToRender} hinzu
     *
     * @param queQueElement {@link LayerRendererQueQueElement layerRendererQueQueElement} welches zum {@link Layer layer} hinzugefügt werden soll
     * @since 0.0.1
     */
    public void add(LayerRendererQueQueElement queQueElement) {
        elementsToRender.add(queQueElement);
    }

    /**
     * löscht die liste {@link #elementsToRender elementsToRender}
     *
     * @since 0.0.1
     */
    private void clear() {
        elementsToRender.clear();
    }

    public Layers getLayerToRenderOn() {
        return layerToRenderOn;
    }
}