package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
//TODO JAVA DOC MACHEN

/**
 * @author Klausmp.
 * ein Layer der im layerRenderer verwendet wird.
 * die klasse layer sortiert ihre elemente nach prioritat.
 * und zeichnet sie in der richtigen reihenfloge auf den screen.
 */
public class Layer {
    //liste aller elemente die in diesem layer gerendert werden
    private Array<LayerRendererQueQueElement> elementsToRender;
    //der layer in dem dieser layer rendert
    private Layers layerToRenderOn;

    //konstruktor ohne einstellungsmöglichkeiten mit default werten
    public Layer() {
        this.layerToRenderOn = Layers.DEFAULT;
        this.elementsToRender = new Array<LayerRendererQueQueElement>();
    }

    //konstruktor mit einstellungsmöglichkeiten für den dargestellten layer
    public Layer(Layers layerToRenderOn) {
        this.layerToRenderOn = layerToRenderOn;
        this.elementsToRender = new Array<LayerRendererQueQueElement>();
    }

    //rendert alle elemente aus der "elementsToRender" liste
    //nach prorität
    public void render(SpriteBatch batch) {
        //sortiert die elemente vor dem rendern nach priorität
        sortElementsToRdender();
        //rendert alle elemente aus "elementsToRender" nach priorität
        //kleinste zu erst, dadurch sind elemente mit hoher priorität
        //vor elementen mit niediriger priorität gezeichnet
        //System.out.println("anzahl der elemente" + elementsToRender.size + "    " + this.layerToRenderOn);
        for (LayerRendererQueQueElement element : elementsToRender) {
            //rendert elemente auf den screen
            element.getSprite().draw(batch);
        }
        //löscht "elementsToRender" um im nächsten frame nicht alte
        //elemente erneut zu rendern
        clear();
    }

    //sortiert "elementsToRender" nach ihrer priorität (kleinste zu erst)
    //dafür wird bubblesort verwendet
    private void sortElementsToRdender() {
        for (int s = elementsToRender.size; s > -1; s--) {
            for (int x = 0; x < s - 1; x++) {
                if (elementsToRender.get(x).getPriority() > elementsToRender.get(x + 1).getPriority()) {
                    swap(x, x + 1);
                }
            }
        }
    }

    //tauscht zwei elemente aus "elementsToRender"
    private void swap(int firstIndex, int secondIndex) {
        LayerRendererQueQueElement save = elementsToRender.get(firstIndex);
        elementsToRender.removeIndex(firstIndex);
        elementsToRender.insert(firstIndex, elementsToRender.get(secondIndex - 1));
        elementsToRender.removeIndex(secondIndex);
        elementsToRender.insert(secondIndex, save);
    }

    //fügt neue elemente zu "elementsToRender" hinzu
    public void add(LayerRendererQueQueElement queQueElement) {
        elementsToRender.add(queQueElement);
    }

    //löscht "elementsToRender"
    private void clear() {
        elementsToRender.clear();
    }

    public Layers getLayerToRenderOn() {
        return layerToRenderOn;
    }
}

/**
 *
 */
