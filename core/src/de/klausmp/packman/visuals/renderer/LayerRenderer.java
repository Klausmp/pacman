package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * @author Klausmp
 */

/*
 *   diese klasse rendert sprites auf den screen
 *   dies geschieht nach layern sortiert
 *   innerhalb eins layers kann auch noch mit
 *   prioritäten die renderring reihenfolge
 *   beinflusst werden
 * */

public class LayerRenderer {
    //  mit dem sprite batch werden die sprites auf den screen gezeichnet
    private static SpriteBatch batch;
    //  liste mit allen lyern die zu verfügung stehen
    private static Array<Layer> layerArry;
    //  reihenfolge in der die layer gerendert werden
//  layer die weiter hinten im array liegen werden
//  über den fohrigen layern gezeichnet
    private static Array<Layers> layerOrder;

    //  konstruktor mit individueller layerOrder
    public LayerRenderer(Layers[] layers) {
        layerArry = new Array<Layer>();
        layerOrder = convertLayersArray(layers);
        batch = new SpriteBatch();
        addLayersFromOrder();
    }

    //  konstruktor mit defaultLayerOrder
    public LayerRenderer() {
        layerArry = new Array<Layer>();
        layerOrder = convertLayersArray(Layers.DEFAULTLAYERORDER());
        batch = new SpriteBatch();
        addLayersFromOrder();
    }

    public void render() {
//      begin des spritebatches mit dem gezeichnet wird
        batch.begin();
//      alle layer werden in der Reihenfolge der layerOrder
//      durchgegenagen und zum richtigen zeitpunkt gerendert
        for (Layers layers : layerOrder) {
            for (Layer layer : layerArry) {
                if (layers.equals(layer.getLayerToRenderOn())) {
                    layer.render(batch);
                    break;
                }
            }
        }
//      ende des spritebatches hier werden alle sprites an die
//      graphikkarte 
        batch.end();
    }

    //  initalisiert alle layer die in der layerOrder vorhanden sind
    private void addLayersFromOrder() {
//      damit kein layer doppelt vorkommen kann wird zuerst
//      die alte layerListe gelöscht
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