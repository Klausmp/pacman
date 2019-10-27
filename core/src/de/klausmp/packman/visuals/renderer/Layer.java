package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * @author Klausmp
 */

public class Layer {

    private Array<LayerRendererQueQueElement> elementsToRender;
    private Layers layerToRenderOn;

    public Layer() {
        this.layerToRenderOn = Layers.DEFAULT;
        this.elementsToRender = new Array<LayerRendererQueQueElement>();
    }

    public Layer(Layers layerToRenderOn) {
        this.layerToRenderOn = layerToRenderOn;
        this.elementsToRender = new Array<LayerRendererQueQueElement>();
    }

    public void render(SpriteBatch batch) {
        sortElementsToRdender();
        for (LayerRendererQueQueElement element : elementsToRender) {
            element.getSprite().draw(batch);
        }
        clear();
    }

    private void sortElementsToRdender() {
        for (int s = elementsToRender.size; s > -1; s--) {
            for (int x = 0; x < s - 1; x++) {
                if (elementsToRender.get(x).getPriority() > elementsToRender.get(x + 1).getPriority()) {
                    swap(x, x + 1);
                }
            }
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        LayerRendererQueQueElement save = elementsToRender.get(firstIndex);
        elementsToRender.removeIndex(firstIndex);
        elementsToRender.insert(firstIndex, elementsToRender.get(secondIndex - 1));
        elementsToRender.removeIndex(secondIndex);
        elementsToRender.insert(secondIndex, save);
    }

    public void add(LayerRendererQueQueElement queQueElement) {
        elementsToRender.add(queQueElement);
    }

    private void clear() {
        elementsToRender.clear();
    }

    public Layers getLayerToRenderOn() {
        return layerToRenderOn;
    }
}
