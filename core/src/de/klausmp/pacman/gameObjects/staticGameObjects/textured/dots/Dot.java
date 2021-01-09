package de.klausmp.pacman.gameObjects.staticGameObjects.textured.dots;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.staticGameObjects.textured.StaticGameObjekt;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.utils.Layers;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.visuals.screens.GameScreen;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.9.8
 * @see StaticGameObjekt
 * @since 0.5.0
 */
public class Dot extends StaticGameObjekt {

    /**
     * TODO JAVA DOC
     *
     * @since 0.5.0
     */
    private int score;

    public Dot(Vector2 position, GridTile gridTile) {
        super(GameScreen.getAtlas().findRegion("food"), position, Rotation.DEFAULTROTATION, GameObjectType.DOT, Layers.BACKGROUND, 10f, gridTile);
        score = 10;
    }

    public Dot(TextureRegion region, Vector2 position, int score,Rotation rotation, GameObjectType gameObjectType, Layers layerToRenderOn, float renderPriority, GridTile gridTile) {
        super(region, position, rotation, gameObjectType, layerToRenderOn, renderPriority, gridTile);
        this.score = score;
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void kill() {
        super.kill();
        GameScreen.score += score;
    }

    @Override
    protected void animation() {

    }
}
