package de.klausmp.packman.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.gameObjects.GameObject;
import de.klausmp.packman.gameObjects.ObjectType;
import de.klausmp.packman.visuals.renderer.LayerRenderer;

/**
 * @author Klausmp
 */
public class GridTile {

    private Vector2 position;
    private Grid grid;
    private Array<GameObject> gameObjects = new Array<GameObject>();

    public GridTile(Vector2 position, Grid grid) {
        this.position = position;
        this.grid = grid;
    }

    public void update() {
        for (GameObject object : gameObjects) {
            object.update();
        }
        removeDeadGameObjects();
        if (gameObjects.size >= 1)
        System.out.println(gameObjects.size);
    }

    public void render(LayerRenderer renderer) {
        for (GameObject object : gameObjects) {
            object.render(renderer);
        }
    }

    private void removeDeadGameObjects() {
        Array<GameObject> gameObjectsToRemove = new Array<GameObject>();
        for (GameObject object : gameObjects) {
            if (object.isAlive() == false){
                gameObjectsToRemove.add(object);
            }
        }
        gameObjects.removeAll(gameObjectsToRemove, true);
    }

    public void removeAllGameObject() {
        gameObjects.clear();
    }

    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public GameObject getGameObjectByType(ObjectType objectType) {
        for (GameObject object : gameObjects) {
            if (object.getObjectType().equals(objectType)) {
                return object;
            }
        }
        return null;
    }

    public Vector2 getPosition() {
        return position;
    }
}