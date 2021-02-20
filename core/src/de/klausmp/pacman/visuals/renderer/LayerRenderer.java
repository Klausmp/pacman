package de.klausmp.pacman.visuals.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import de.klausmp.pacman.utils.Layers;

/**
 * diese klasse rendert sprites mit einem {@link SpriteBatch spriteBatch} auf den screen. <br>
 * dies geschieht nach {@link Layer layern} sortiert. <br>
 * innerhalb eins {@link Layer layern} kann auch noch mit
 * {@link LayerRendererQueQueElement#priority prioritäten} die rendering reihenfolge
 * beinflusst werden. <br>
 * um etwas zu rednern wird ein {@link LayerRendererQueQueElement queQueElement}
 * erstellt un mit {@link #addToQueque(LayerRendererQueQueElement) addToQueQue} in die liste der
 * zu rendernen elemente hinzugefügt.
 *
 * @author Klausmp
 * @version 0.10.4
 * @since 0.0.1
 */
public class LayerRenderer implements Disposable {

    /**
     * mit dem sprite batch werden die sprites auf den screen gezeichnet
     *
     * @since 0.0.1
     */
    private SpriteBatch batch;

    /**
     * liste mit allen lyern die zu verfügung stehen
     *
     * @since 0.0.1
     */
    private static Array<Layer> layerArry;

    /**
     * reihenfolge in der die layer gerendert werden. <br>
     * layer die weiter hinten im array liegen werden
     * über den fohrigen layern gezeichnet. <br>
     * mit default layerOrder in {@link Layers#DEFAULTLAYERORDER() Layers}.
     *
     * @since 0.0.1
     */
    private static Array<Layers> layerOrder;

    /**
     * konstruktor mit individueller {@link #layerOrder layerOrder}
     *
     * @param layerOrder siehe {@link #layerOrder layerOrder}
     * @since 0.0.1
     */
    public LayerRenderer(Layers[] layerOrder) {
        create(layerOrder);
    }

    /**
     * konstruktor mit defaultLayerOrder
     *
     * @since 0.0.1
     */
    public LayerRenderer() {
        create(Layers.DEFAULTLAYERORDER());
    }

    /**
     * setzt die parameter bei der erstellung. <br>
     * wird eigentlich nur im konstruktor verwendet.
     *
     * @param layerOrder siehe {@link #layerOrder layerOrder}
     * @since 0.0.1
     */
    public void create(Layers[] layerOrder) {
        layerArry = new Array<Layer>();
        LayerRenderer.layerOrder = new Array<Layers>();
        setLayerOrder(layerOrder);
        batch = new SpriteBatch();
        addLayersFromOrder();
    }

    /**
     * muss in jedem frame aufgerufen werden um die elemente aus dem {@link #layerArry layerArray}
     * zu zeichnen <br>
     *
     * @since 0.0.1
     */
    public void render() {
        /*
         * setzt die farbe mit der der Screen übermahlt wird auf schwarz
         */
        Gdx.gl.glClearColor(0, 0, 0, 1);

        /*
         * setzt die farbe mit der der Screen übermahlt wird auf schwarz
         */
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
         * begin des spritebatches mit dem gezeichnet wird
         */
        batch.begin();

        /*
         * alle layer werden in der Reihenfolge der layerOrder
         * durchgegenagen und zum richtigen zeitpunkt gerendert
         */
        for (Layers layers : layerOrder) {
            for (Layer layer : layerArry) {
                if (layers.equals(layer.getLayerToRenderOn())) {
                    layer.render(batch);
                    break;
                }
            }
        }

        /*
         * ende des {@link SpriteBatch spritebatches} hier werden alle
         * {@link com.badlogic.gdx.graphics.g2d.Sprite sprites} an die
         * graphikkarte übergeben und gezeichnet
         */
        batch.end();
    }

    /**
     * initalisiert alle layer die in der layerOrder vorhanden sind
     *
     * @since 0.0.1
     */
    private void addLayersFromOrder() {
        /**
         * damit kein layer doppelt vorkommen kann wird zuerst
         * die alte layerListe gelöscht
         */
        layerArry.clear();
        for (Layers layers : layerOrder) {
            layerArry.add(new Layer(layers));
        }
    }

    /**
     * fügt einen meuen layer an gewünschtem index in die LayerOrder hinzu
     *
     * @param layer {@link Layers layerTyp} der zur layerOrder hinzugefügt werden soll
     * @param index index an dem der {@link Layer layer} in die {@link #layerOrder layerOrder} aufggenommen werden soll.
     * @since 0.0.1
     */
    private void addLayer(Layers layer, int index) {
		layerOrder.insert(index, layer);
        layerArry.add(new Layer(layer));
    }

    /**
     * setzt die layer order aus einem array aus {@link Layers layern}.
     *
     * @param layers array von {@link Layers layern} welches die neue {@link #layerOrder layerOrder} festlegt
     * @since 0.0.1
     */
    private void setLayerOrder(Layers[] layers) {
        layerOrder.clear();
        for (Layers layer : layers) {
            layerOrder.add(layer);
        }
    }

    /**
     * fügt eine neues eslement in die render liste hinzu. <br>
     * jedes element wird am ende jedes frames gerendert und dan aus der liste entfernt. <br>
     * daher muss es in jedem tick erneut hinugefügt werden.
     *
     * @param queQueElement neues {@link LayerRendererQueQueElement element} welches in die render warteschlage hinzugefügt wird.
     * @since 0.0.1
     */
    public void addToQueque(LayerRendererQueQueElement queQueElement) {
        for (Layer layer : layerArry) {
            if (layer.getLayerToRenderOn().equals(queQueElement.getLayerToRenderOn())) {
                layer.add(queQueElement);
            }
        }
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    /**
     * @since 0.8.0
     */
    @Override
    public void dispose() {
       batch.dispose();
    }
}