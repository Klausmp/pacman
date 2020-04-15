package de.klausmp.pacman.visuals.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.klausmp.pacman.world.level.Level;

/**
 * @author Klausmp
 * @version 0.8.0
 * @since 0.8.0
 */
public class LoadingScreen extends ScreenAdapter implements Runnable {

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch = new SpriteBatch();

    /**
     * TODO JAVA DOC
     *
     * @param levelToLoad
     * @since 0.8.0
     */
    public LoadingScreen(int levelToLoad) {
        camera = new OrthographicCamera();
        viewport = new FitViewport(500, 500, camera);
        //camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
        //camera.update();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(new Texture("pacMan.png"), 0, 0);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void run() {
        Level level = new Level("");

    }
}
