package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;

/**
 * @author Klausmp
 * @since 0.9.5
 */
public class BlinkyTargetControler implements ITargetControler {

    @Override
    public void findScatterTarget(Ghost ghost) {
        ghost.setTarged(ghost.getCurrendGridTile().getGrid().getGridTile(new Vector2(25, 28)));
    }

    @Override
    public void findChaseTarged(Ghost ghost) {
        ghost.setTarged(ghost.getCurrendGridTile().getGrid().getPacMan().getCurrendGridTile());
    }

    @Override
    public void findBed(Ghost ghost) {

    }
}
