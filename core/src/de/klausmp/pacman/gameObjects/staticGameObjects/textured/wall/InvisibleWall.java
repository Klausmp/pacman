package de.klausmp.pacman.gameObjects.staticGameObjects.textured.wall;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.visuals.renderer.LayerRenderer;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 *
 * @since 0.9.8
 * @version 0.9.8
 */
public class InvisibleWall extends Wall{

    /**
     *
     * @param position
     * @param gridTile
     * @since 0.9.8
     */
    public InvisibleWall(Vector2 position, GridTile gridTile) {
        super(position, GameObjectType.INVWALL, gridTile);
    }

    @Override
    public void setTexture(TextureAtlas atlas) {

    }

    @Override
    public void render(LayerRenderer renderer) {

    }

    @Override
    protected void animation() {

    }
}
