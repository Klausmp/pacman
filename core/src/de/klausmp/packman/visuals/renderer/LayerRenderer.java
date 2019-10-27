package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * @author Klausmp
 */

public class LayerRenderer {

    private static SpriteBatch batch;
    private static Array<Layer> layerArry;
    private static Array<Layers> layerOrder;

    public LayerRenderer(Layers[] layers) {
        layerArry = new Array<Layer>();
        layerOrder = convertLayersArray(layers);
        batch = new SpriteBatch();
        addLAyersFromOrder();
    }

    public void render() {
        batch.begin();
        for (Layers layers : layerOrder) {
            for (Layer layer : layerArry) {
                if (layers.equals(layer.getLayerToRenderOn())) {
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
        for (Layers layer : layers) {
            result.add(layer);
        }
        return result;
    }

    public void addToQueque(LayerRendererQueQueElement queQueElement) {
        for (Layer layer : layerArry) {
            if (layer.getLayerToRenderOn().equals(queQueElement.getLayerToRenderOn())) {
                layer.add(queQueElement);
            }
        }
    }
}