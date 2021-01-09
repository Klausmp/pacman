package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;

/**
 * @author Klausmp
 * @since 0.9.8
 */
public class ClydeGhostTargetControler extends GhostTargetControler {

    @Override
    public void findScatterTarget(Ghost ghost) {
        ghost.setTarged(ghost.getCurrendGridTile().getGrid().getGridTile(new Vector2(0, -1)));
    }

    @Override
    public void findChaseTarged(Ghost ghost) {
        Vector2 pacmanPosition = ghost.getGrid().getPacMan().getCurrendGridTile().getPosition();
        float distance = pacmanPosition.dst(ghost.getCurrendGridTile().getPosition());
        if (distance <= 8) {
            findScatterTarget(ghost);
        } else {
            ghost.setTarged(ghost.getCurrendGridTile().getGrid().getPacMan().getCurrendGridTile());
        }
    }

}
