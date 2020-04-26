package de.klausmp.pacman.visuals.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.klausmp.pacman.Main;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.8.1
 * @since 0.8.0
 */
public class MainMenue extends ScreenAdapter {

    private static final float PAC_MAN_TEXT_SCALE = 0.65f;

    private Texture pacManText;

    private SpriteBatch batch = new SpriteBatch();

    private OrthographicCamera camera;

    private Viewport viewport;

    private Stage stage;

    public MainMenue() {
        create();
    }

    public void create() {
        pacManText = new Texture("pacMan.png");
        camera = new OrthographicCamera();
        viewport = new FitViewport(500, 500, camera);
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
        camera.update();
        stage = new Stage(viewport);
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.up =  new TextureRegionDrawable(new TextureRegion(new Texture("buttonUp.png")));
        buttonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture("buttonDown.png")));
        buttonStyle.font = new BitmapFont();

        TextButton start_new_game = new TextButton("Start New Game", buttonStyle);
        start_new_game.setWidth(150);
        start_new_game.setHeight(30);
        start_new_game.setPosition((viewport.getWorldWidth() / 2) - (start_new_game.getWidth() / 2),  130);
        start_new_game.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.setActiveScreen(new GameScreen());
            }
        });
        stage.addActor(start_new_game);

        TextButton credits = new TextButton("Credits", buttonStyle);
        credits.setWidth(100);
        credits.setHeight(30);
        credits.setPosition((viewport.getWorldWidth() / 2) - (credits.getWidth() / 2),  100);
        credits.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.setActiveScreen(new Credits());
            }
        });
        stage.addActor(credits);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        /*
         * setzt die farbe mit der der Screen übermahlt wird auf schwarz
         */
        Gdx.gl.glClearColor(0, 0, 0, 1);

        /*
         * setzt die farbe mit der der Screen übermahlt wird auf schwarz
         */
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);

        /*
         * begin des spritebatches mit dem gezeichnet wird
         */
        stage.act(delta);
        stage.draw();
        batch.begin();

        /*
         * alle layer werden in der Reihenfolge der layerOrder
         * durchgegenagen und zum richtigen zeitpunkt gerendert
         */

        batch.draw(pacManText, (viewport.getWorldWidth() / 2) - ((pacManText.getWidth() * PAC_MAN_TEXT_SCALE)/ 2), viewport.getWorldHeight() - pacManText.getHeight() - 15, pacManText.getWidth() * PAC_MAN_TEXT_SCALE, pacManText.getHeight() * PAC_MAN_TEXT_SCALE);

        /*
         * ende des {@link SpriteBatch spritebatches} hier werden alle
         * {@link com.badlogic.gdx.graphics.g2d.Sprite sprites} an die
         * graphikkarte übergeben und gezeichnet
         */
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
        pacManText.dispose();
        stage.dispose();
    }
}
