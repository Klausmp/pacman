package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;

/**
 * @author Klausmp
 * @since 0.9.5
 */
public class PinkyTargetControler implements ITargetControler {

    @Override
    public void findScatterTarget(Ghost ghost) {
        ghost.setTarged(ghost.getCurrendGridTile().getGrid().getGridTile(new Vector2(2, 28)));
    }

    @Override
    public void findChaseTarged(Ghost ghost) {
        int pacManRotation = ghost.getCurrendGridTile().getGrid().getPacMan().getObjectRotation().getInt();
        ghost.setTarged(ghost.getCurrendGridTile().getGrid().getPacMan().getCurrendGridTile().getSurroundingGridTiles()[pacManRotation].getSurroundingGridTiles()[pacManRotation].getSurroundingGridTiles()[pacManRotation].getSurroundingGridTiles()[pacManRotation]);
    }

    @Override
    public void findBed(Ghost ghost) {

    }
}
