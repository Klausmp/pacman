package de.klausmp.packman.visuals.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * diese klasse rendert sprites auf den screen
 * dies geschieht nach layern sortiert
 * innerhalb eins layers kann auch noch mit
 * prioritäten die renderring reihenfolge
 * beinflusst werden
 *
 * @author Klausmp
 * @version 0.0.1
 */
//TODO JAVA DOC
public class LayerRenderer {
    //mit dem sprite batch werden die sprites auf den screen gezeichnet
    private static SpriteBatch batch;
    //liste mit allen lyern die zu verfügung stehen
    private static Array<Layer> layerArry;
    //reihenfolge in der die layer gerendert werden
    //layer die weiter hinten im array liegen werden
    //über den fohrigen layern gezeichnet
    private static Array<Layers> layerOrder;

    //konstruktor mit individueller layerOrder
    public LayerRenderer(Layers[] layerOrder) {
       create(layerOrder);
    }

    //konstruktor mit defaultLayerOrder
    public LayerRenderer() {
        create(Layers.DEFAULTLAYERORDER());
    }

    /**
     * @since 0.0.1
     */
    public void create(Layers[] layerOrder) {
        layerArry = new Array<Layer>();
        this.layerOrder = convertLayersArray(layerOrder);
        batch = new SpriteBatch();
        addLayersFromOrder();
    }

    public void render() {
        //setzt die farbe mit der der Screen übermahlt wird auf schwarz
        Gdx.gl.glClearColor(0, 0, 0, 1);
        //übermahlt den screen mit der gesetzten farbe
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //begin des spritebatches mit dem gezeichnet wird
        batch.begin();
        //alle layer werden in der Reihenfolge der layerOrder
        //durchgegenagen und zum richtigen zeitpunkt gerendert
        for (Layers layers : layerOrder) {
            for (Layer layer : layerArry) {
                if (layers.equals(layer.getLayerToRenderOn())) {
                    layer.render(batch);
                    break;
                }
            }
        }
        //ende des spritebatches hier werden alle sprites an die
        //graphikkarte
        batch.end();
    }

    //initalisiert alle layer die in der layerOrder vorhanden sind
    private void addLayersFromOrder() {
        //damit kein layer doppelt vorkommen kann wird zuerst
        //die alte layerListe gelöscht
        layerArry.clear();
        for (Layers layers : layerOrder) {
            layerArry.add(new Layer(layers));
        }
    }

    //fügt einen meuen layer an gewünschtem index in die LayerOrder hinzu
    private void addLayer(Layers layer, int index) {
        layerOrder.insert(index, layer);
        layerArry.add(new Layer(layer));
    }

    //konvertiert ein ARRAY zu einem GDX ARRAY
    private Array<Layers> convertLayersArray(Layers[] layers) {
        Array<Layers> result = new Array<Layers>();
        for (Layers layer : layers) {
            result.add(layer);
        }
        return result;
    }

    //fügt eine neues eslement in die render liste hinzu
    //jedes element wird am ende jedes frames gerendert
    public void addToQueque(LayerRendererQueQueElement queQueElement) {
        for (Layer layer : layerArry) {
            if (layer.getLayerToRenderOn().equals(queQueElement.getLayerToRenderOn())) {
                layer.add(queQueElement);
            }
        }
    }
}