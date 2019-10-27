package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Layer {

    public Array<LayerRendererQueQueElement> elementsToRender;
    public Layers layerToRenderOn;

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
            element.sprite.draw(batch);
        }
        clear();
    }

    private void sortElementsToRdender() {
        for (LayerRendererQueQueElement element : elementsToRender) {
            System.out.println(element.priority);
        }
        for (int s = elementsToRender.size; s > -1; s--) {
            for (int x = 0; x < s - 1; x++) {
                if (elementsToRender.get(x).priority < elementsToRender.get(x + 1).priority) {
                    swap(x, x + 1);
                }
            }
        }
        for (LayerRendererQueQueElement element : elementsToRender) {
            System.out.println(element.priority);
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
}
