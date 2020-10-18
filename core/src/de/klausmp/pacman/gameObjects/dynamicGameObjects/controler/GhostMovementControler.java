package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 *
 * @since 0.9.4
 */
public class GhostMovementControler implements IDynamicMovementControler {

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.4
     */
    private boolean useTunnelMode = true;

    @Override
    public void choseNextRotationToMove(DynamicGameObject object) {
        if (object instanceof Ghost) {
            Ghost ghost = (Ghost) object;
            if (ghost.getCurrendGridTile().getGridTileType() == GridTileType.INTERSECTION) {
                useTunnelMode = true;
            }
            if (useTunnelMode) {
                for (int i = 0; i < 4; i++) {
                    if (object.getCurrendGridTile().getSurroundingGridTiles()[i].getGridTileType() == GridTileType.ROAD) {
                        if (Rotation.getRotationFromInt(i) != Rotation.getOpposite(object.getObjectRotation())) {
                            object.setNextRotation(Rotation.getRotationFromInt(i));
                        }
                    }
                }

                for (int i = 0; i < 4; i++) {
                    if (object.getCurrendGridTile().getSurroundingGridTiles()[object.getObjectRotation().getInt()].getGridTileType() == GridTileType.INTERSECTION) {
                        GridTile intersection = object.getCurrendGridTile().getSurroundingGridTiles()[object.getObjectRotation().getInt()];
                        ghost.setTarged();
                        useTunnelMode = false;
                        float bestCost = Integer.MAX_VALUE;
                        for (int j = 0; j < 4; j++) {
                            if (intersection.getSurroundingGridTiles()[j].getGridTileType() == GridTileType.ROAD) {
                                if (Rotation.getRotationFromInt(j) != Rotation.getOpposite(object.getObjectRotation())) {
                                    float cost = intersection.getSurroundingGridTiles()[j].getPosition().dst(ghost.getTarged().getPosition());
                                    if (cost < bestCost) {
                                        bestCost = cost;
                                        object.setNextRotation(Rotation.getRotationFromInt(j));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
