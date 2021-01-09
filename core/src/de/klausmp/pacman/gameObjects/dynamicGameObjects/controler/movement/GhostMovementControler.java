package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement;

import com.badlogic.gdx.utils.Array;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.utils.GameMode;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.world.grid.GridTile;
import de.klausmp.pacman.world.level.Level;

/**
 * TODO JAVA DOC
 * @version 0.9.8
 * @since 0.9.5
 */
public class GhostMovementControler implements IDynamicMovementControler {

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.5
     */
    private GridTile lastGridTile = null;

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
            if (lastGridTile == null) {
                lastGridTile = ghost.getCurrendGridTile().getSurroundingGridTiles()[Rotation.getOpposite(ghost.getObjectRotation()).getInt()];
            }

            if (ghost.getCurrendGridTile() != lastGridTile) {
                ghost.choseTarget();
                lastGridTile = ghost.getCurrendGridTile();
                if (ghost.getCurrendGridTile().getGridTileType() == GridTileType.INTERSECTION) {
                    useTunnelMode = true;
                }

                if (useTunnelMode) {
                    for (int i = 0; i < 4; i++) {
                        if (ghost.getCurrendGridTile().getSurroundingGridTiles()[i].canWalkOn(object.getGameObjectType())) {
                            if (Rotation.getRotationFromInt(i) != Rotation.getOpposite(ghost.getObjectRotation())) {
                                ghost.setNextRotation(Rotation.getRotationFromInt(i));
                            }
                        }
                    }

                    Array<Rotation> options = new Array<Rotation>();
                    if (ghost.getCurrendGridTile().getSurroundingGridTiles()[ghost.getObjectRotation().getInt()].getGridTileType() == GridTileType.INTERSECTION) {
                        GridTile intersection = ghost.getCurrendGridTile().getSurroundingGridTiles()[ghost.getObjectRotation().getInt()];
                        useTunnelMode = false;
                        float bestCost = Integer.MAX_VALUE;
                        for (int j = 0; j < 4; j++) {
                            if (intersection.getSurroundingGridTiles()[j].canWalkOn(object.getGameObjectType())) {
                                if (Rotation.getRotationFromInt(j) != Rotation.getOpposite(ghost.getObjectRotation())) {
                                    if (Level.getGameMode() == GameMode.FRIGHTEND) {
                                        if (!ghost.isEaten()) {
                                            options.add(Rotation.getRotationFromInt(j));
                                            if (!options.isEmpty()) {
                                                ghost.setNextRotation(options.get((int) (Math.random() * options.size)));
                                            }
                                        } else {
                                            float cost = intersection.getSurroundingGridTiles()[j].getPosition().dst(ghost.getTarged().getPosition());
                                            if (cost < bestCost) {
                                                bestCost = cost;
                                                ghost.setNextRotation(Rotation.getRotationFromInt(j));
                                            }
                                        }
                                    } else {
                                        float cost = intersection.getSurroundingGridTiles()[j].getPosition().dst(ghost.getTarged().getPosition());
                                        if (cost < bestCost) {
                                            bestCost = cost;
                                            ghost.setNextRotation(Rotation.getRotationFromInt(j));
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
}
