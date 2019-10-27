package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class LayerRenderer {

    private static SpriteBatch batch;
    private static Array<Layer> layerArry;
    private static Array<Layers> layerOrder;

    public LayerRenderer(Layers[] layers) {
        this.layerArry = new Array<Layer>();
        layerOrder = convertLayersArray(layers);
        this.batch = new SpriteBatch();
        addLAyersFromOrder();
    }

    public void render() {
        batch.begin();
        for (Layers layers : layerOrder) {
            for (Layer layer : layerArry) {
                if (layers.equals(layer.layerToRenderOn)) {
                    layer.render(batch);
                }
            }
        }
        batch.end();
    }

    private void addLAyersFromOrder() {
        layerArry.clear();
        for (Layers layers: layerOrder) {
            layerArry.add(new Layer(layers));
        }
    }

    private void addLayer(Layers layer, int index) {
        layerOrder.insert(index, layer);
        layerArry.add(new Layer(layer));
    }

    private Array<Layers> convertLayersArray(Layers[] layers) {
        Array<Layers> result = new Array<Layers>();
        for (int i = 0; i < layers.length; i++) {
            result.add(layers[i]);
        }
        return result;
    }

    public void addToQueque(LayerRendererQueQueElement queQueElement) {
        for (Layer layer : layerArry) {
            if (layer.layerToRenderOn.equals(queQueElement.layerToRenderOn)) {
                layer.add(queQueElement);
            }
        }
    }
}