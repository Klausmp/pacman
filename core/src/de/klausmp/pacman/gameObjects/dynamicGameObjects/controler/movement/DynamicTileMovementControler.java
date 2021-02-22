package de.klausmp.pacman.gameObjects.dynamicGameObjects.controler.movement;

import de.klausmp.pacman.gameObjects.dynamicGameObjects.DynamicGameObject;
import de.klausmp.pacman.gameObjects.dynamicGameObjects.ghosts.Ghost;
import de.klausmp.pacman.utils.Rotation;
import de.klausmp.pacman.world.grid.Grid;

/**
 * TODO JAVA DOC
 *
 * @version  0.10.7
 * @since 0.10.7
 */
public class DynamicTileMovementControler implements IDynamicMovementControler {

    @Override
    public void move(DynamicGameObject dynObject, float deltaTime) {
        float remainingDistance;
        dynObject.getNextRotationChooser().choseNextRotationToMove(dynObject);
        if (dynObject.getObjectRotation() == null) {
            dynObject.setObjectRotation(Rotation.UP);
        }
        if (dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].canWalkOn(dynObject.getGameObjectType())) {
            switch (dynObject.getObjectRotation()) {
                case UP:
                    if (Grid.convertToPixelPosition(
                            dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].getPosition()).y > dynObject.getY()) {
                        dynObject.setY(dynObject.getY() + dynObject.getMovementSpeed() * deltaTime);
                    } else {
                        remainingDistance = dynObject.getY() - Grid.convertToPixelPosition(
                                dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].getPosition()).y;
                        moveToNextGridTile(dynObject);
                        if (dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getNextRotation().getInt()].canWalkOn(dynObject.getGameObjectType())) {
                            dynObject.setY(Grid.convertToPixelPosition(dynObject.getCurrendGridTile().getPosition()).y);
                            setRotation(dynObject, dynObject.getNextRotation());
                            moveRemainingDistance(dynObject, remainingDistance);
                        }
                        move(dynObject, deltaTime);
                    }
                    break;
                case LEFT:
                    if (Grid.convertToPixelPosition(
                            dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].getPosition()).x < dynObject.getX()) {
                        dynObject.setX(dynObject.getX() - dynObject.getMovementSpeed() * deltaTime);
                    } else {
                        remainingDistance = Grid.convertToPixelPosition(
                                dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].getPosition()).x - dynObject.getX();
                        moveToNextGridTile(dynObject);
                        if (dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()]
                                .canWalkOn(dynObject.getGameObjectType())) {
                            dynObject.setX(Grid.convertToPixelPosition(dynObject.getCurrendGridTile().getPosition()).x);
                            setRotation(dynObject, dynObject.getNextRotation());
                            moveRemainingDistance(dynObject, remainingDistance);
                        }
                        move(dynObject, deltaTime);
                    }
                    break;
                case DOWN:
                    if (Grid.convertToPixelPosition(
                            dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].getPosition()).y < dynObject.getY()) {
                        dynObject.setY(dynObject.getY() - dynObject.getMovementSpeed() * deltaTime);
                    } else {
                        remainingDistance = Grid.convertToPixelPosition(
                                dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].getPosition()).y - dynObject.getY();
                        moveToNextGridTile(dynObject);
                        if (dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getNextRotation().getInt()]
                                .canWalkOn(dynObject.getGameObjectType())) {
                            dynObject.setY(Grid.convertToPixelPosition(dynObject.getCurrendGridTile().getPosition()).y);
                            setRotation(dynObject, dynObject.getNextRotation());
                            moveRemainingDistance(dynObject, remainingDistance);
                        }
                        move(dynObject, deltaTime);
                    }
                    break;
                case RIGHT:
                    if (Grid.convertToPixelPosition(
                            dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].getPosition()).x > dynObject.getX()) {
                        dynObject.setX(dynObject.getX() + dynObject.getMovementSpeed() * deltaTime);
                    } else {
                        remainingDistance = dynObject.getX() - Grid.convertToPixelPosition(
                                dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()].getPosition()).x;
                        moveToNextGridTile(dynObject);
                        if (dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getNextRotation().getInt()].canWalkOn(dynObject.getGameObjectType())) {
                            dynObject.setX(Grid.convertToPixelPosition(dynObject.getCurrendGridTile().getPosition()).x);
                            setRotation(dynObject, dynObject.getNextRotation());
                            moveRemainingDistance(dynObject, remainingDistance);
                        }
                        move(dynObject, deltaTime);
                    }
                    break;
                default:
                    break;
            }
        } else {
            if (dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getNextRotation().getInt()].canWalkOn(dynObject.getGameObjectType())) {
                setRotation(dynObject, dynObject.getNextRotation());
            }
        }

    }

    private void moveRemainingDistance(DynamicGameObject dynObject,float remainingDistance) {
        switch (dynObject.getObjectRotation()) {
            case UP:
                dynObject.setY(dynObject.getY() + remainingDistance);
                break;
            case LEFT:
                dynObject.setX(dynObject.getX() - remainingDistance);
                break;
            case DOWN:
                dynObject.setY(dynObject.getY() - remainingDistance);
                break;
            case RIGHT:
                dynObject.setX(dynObject.getX() + remainingDistance);
                break;
            default:
        }
    }

    private void setRotation(DynamicGameObject dynObject, Rotation rotation) {
        if (dynObject instanceof Ghost) {
            Ghost ghost = (Ghost) dynObject;
            ghost.setObjectRotation(rotation);
        } else {
            dynObject.setObjectRotation(rotation);
        }
    }

    private void moveToNextGridTile(DynamicGameObject dynObject) {
        dynObject.getCurrendGridTile().getGrid().transverToOtherGridTile(dynObject, dynObject.getCurrendGridTile().getSurroundingGridTiles()[dynObject.getObjectRotation().getInt()]);
    }
}
