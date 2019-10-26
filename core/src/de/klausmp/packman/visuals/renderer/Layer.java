package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

//TODO priority muss implementiert werden

public class Layer {

    public Array<LayerRendererQueQueElement> elementsToRender;
    public Layers layerToRenderOn;

    public Layer(Layers layerToRenderOn) {
        this.layerToRenderOn = layerToRenderOn;
        this.elementsToRender = new Array<LayerRendererQueQueElement>();
    }

    public void render(SpriteBatch batch) {
        for (LayerRendererQueQueElement element : elementsToRender) {
            element.sprite.draw(batch);
        }
        clear();
    }

    public void sortElementsToRdender() {
//        implementierung eines sortieralgerytmusses nach der priority
//        dabei größte priority zu erst ind der liste
    }

    public void add(LayerRendererQueQueElement queQueElement) {
        elementsToRender.add(queQueElement);
    }

    public void clear() {
        elementsToRender.clear();
    }
}
