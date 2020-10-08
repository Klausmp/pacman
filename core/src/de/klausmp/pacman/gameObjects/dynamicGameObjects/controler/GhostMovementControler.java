package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.world.grid.GridTile;

public class GhostMovementControler implements IGhostDynamicMovementContoler {
    private GridTile lastSkipp;

    @Override
    public void choseNextRotationToMove(DynamicGameObject object) {
        if (object instanceof Ghost) {
            Ghost ghost = (Ghost) object;
            if (lastSkipp == null) {
                lastSkipp = object.getCurrendGridTile();
            }
            if (ghost.getCurrendGridTile() != lastSkipp) {
                lastSkipp = object.getCurrendGridTile();
                System.out.println(ghost.getPath().peek().peek());
                System.out.println("hit");
                if (lastSkipp.getSurroundingGridTiles()[object.getNextRotation().getInt()].getGridTileType() != GridTileType.WALL) {
                    ghost.getPath().peek().setDonw();
                }
                System.out.println(ghost.getPath().peek().peek());
                System.out.println();
            }
            if (ghost.getPath().isPathLoaded()) {
                if (ghost.getPath().peek().peek() == 0) {
                    object.setNextRotation(ghost.getPath().getNext());
                }
            }
        }
    }

    @Override
    public void generateNewPath(Ghost ghost) {
        setTarget(ghost);
        ghost.getPath().newPath(ghost.getTarged(), ghost.getCurrendGridTile(), ghost.getObjectRotation());
    }

    @Override
    public void setTarget(Ghost ghost) {
        ghost.setTarged(ghost.getCurrendGridTile().getGrid().getPacMan().getCurrendGridTile());
    }
}
