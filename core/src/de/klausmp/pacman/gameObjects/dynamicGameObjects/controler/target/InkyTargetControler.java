package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.target;

import com.badlogic.gdx.math.Vector2;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.utils.Rotation;

/**
 * @author Klausmp
 * @since 0.9.5
 */
public class InkyTargetControler implements ITargetControler {

    @Override
    public void findScatterTarget(Ghost ghost) {
        ghost.setTarged(ghost.getCurrendGridTile().getGrid().getGridTile(new Vector2(26, -1)));
    }

    @Override
    public void findChaseTarged(Ghost ghost) {
        Rotation pacmanRotation = ghost.getCurrendGridTile().getGrid().getPacMan().getObjectRotation();
        Vector2 inFrontOfPacman = ghost.getCurrendGridTile().getGrid().getPacMan().getCurrendGridTile().getSurroundingGridTiles()[pacmanRotation.getInt()].getSurroundingGridTiles()[pacmanRotation.getInt()].getPosition();
        Vector2 blinkysPosition = ghost.getCurrendGridTile().getGrid().getBlinky().getCurrendGridTile().getPosition();
        Vector2 vector = new Vector2((blinkysPosition.x - inFrontOfPacman.x) * 2, (blinkysPosition.y - inFrontOfPacman.y) * 2);
        ghost.setTarged(ghost.getCurrendGridTile().getGrid().getGridTile((int) (blinkysPosition.x + vector.x), (int) (blinkysPosition.y + vector.y)));
    }

    @Override
    public void findBed(Ghost ghost) {

    }
}
