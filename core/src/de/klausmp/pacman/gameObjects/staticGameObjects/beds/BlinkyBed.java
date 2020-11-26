package de.klausmp.pacman.gameObjects.staticGameObjects.beds;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.utils.GameObjectType;
import de.klausmp.pacman.world.grid.GridTile;

public class BlinkyBed extends Bed{

    /**
     * konstruktor mit allen nötien einstellungen.
     *
     * @param position       position an dem das {@link GameObject gameObjekt} gespawned wird.
     * @param gridTile       {@link GridTile gridTile} indem sich dieses {@link GameObject gameObjekt} befindet
     * @param gameObjectType type des {@link GameObject gameObjekts}.
     * @since 0.1.4
     */
    public BlinkyBed(Vector2 position, GridTile gridTile) {
        super(position, gridTile, GameObjectType.BLINKYBED);
    }
}
