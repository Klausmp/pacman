package de.klausmp.pacman.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import de.klausmp.pacman.utils.GridTileType;
import de.klausmp.pacman.world.grid.Grid;
import de.klausmp.pacman.world.grid.GridTile;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @version 0.9.3
 * @since 0.9.0
 */
public class Path implements Runnable {

    private boolean pathLoaded = false;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.0
     */
    private final Array<GridTile> path;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.0
     */
    private final Grid grid;

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.0
     */
    private GridTile target;


    /**
     * TODO JAVA DOC
     *
     * @since 0.9.0
     */
    private GridTile root;

    /**
     * TODO JAVA Doc
     *
     * @since 0.9.0
     */
    public Path(Grid grid) {
        this.grid = grid;
        path = new Array<GridTile>();
    }

    /**
     * TODO JAVA Doc
     *
     * @throws NullPointerException
     * @since 0.9.0
     */
    public GridTile getNext() throws NullPointerException {
        if (path != null && !path.isEmpty()) {
            GridTile result = path.get(0);
            path.removeIndex(0);
            return result;
        } else return null;
    }

    public void newPath(GridTile target, GridTile root) {
        this.target = target;
        this.root = root;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * TODO JAVA Doc
     *
     * @since 0.9.0
     */
    public void setPath(Array<GridTile> newPath) {
        path.clear();
        path.addAll(newPath);
        pathLoaded = true;
    }

    private Node gridTileToNode(Node parent, Node targetNode, GridTile gridTile) {
        return new Node(parent, targetNode, gridTile.getPosition());
    }

    private boolean isNodeInList(Array<Node> nodeList, int nodePosX, int nodePosY) {
        for (Node node : nodeList) {
            if (node.pos.x == nodePosX && node.pos.y == nodePosY) {
                return true;
            }
        }
        return false;
    }

    private void setInvertedPath(Array<GridTile> newPath) {
        Array<GridTile> result = new Array<GridTile>();
        for (GridTile gridTile: newPath) {
            result.add(gridTile);
        }
        setPath(result);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        Node targetNode = new Node(null, null, target.getPosition());
        Node rootNode = new Node(null, targetNode, root.getPosition());
        Array<Node> openList = new Array<Node>();
        Array<Node> closedList = new Array<Node>();
        openList.add(rootNode);
        boolean running = true;
        while (running) {
            Node bestNode = null;
            int bestCost = Integer.MAX_VALUE;
            if (openList.size == 1) {
                bestNode = openList.get(0);
            } else {
                for (Node node : openList) {
                    if (node.f <= bestCost && node.f >= 0) {
                        bestCost = node.f;
                        bestNode = node;
                    }
                }
            }
            closedList.add(bestNode);
            openList.removeValue(bestNode, true);

            if (grid.getGridTile((int) bestNode.pos.x + 1, (int) bestNode.pos.y).getGridTileType() == GridTileType.ROAD && !isNodeInList(closedList, (int) bestNode.pos.x + 1, (int) bestNode.pos.y) && !isNodeInList(closedList, (int) bestNode.pos.x + 1, (int) bestNode.pos.y)) {
                openList.add(new Node(bestNode, targetNode, new Vector2(bestNode.pos.x + 1, bestNode.pos.y)));
            }
            if (grid.getGridTile((int) bestNode.pos.x - 1, (int) bestNode.pos.y).getGridTileType() == GridTileType.ROAD && !isNodeInList(closedList, (int) bestNode.pos.x - 1, (int) bestNode.pos.y) && !isNodeInList(closedList, (int) bestNode.pos.x - 1, (int) bestNode.pos.y)) {
                openList.add(new Node(bestNode, targetNode, new Vector2(bestNode.pos.x - 1, bestNode.pos.y)));
            }
            if (grid.getGridTile((int) bestNode.pos.x, (int) bestNode.pos.y + 1).getGridTileType() == GridTileType.ROAD && !isNodeInList(closedList, (int) bestNode.pos.x, (int) bestNode.pos.y + 1) && !isNodeInList(closedList, (int) bestNode.pos.x, (int) bestNode.pos.y + 1)) {
                openList.add(new Node(bestNode, targetNode, new Vector2(bestNode.pos.x, bestNode.pos.y + 1)));
            }
            if (grid.getGridTile((int) bestNode.pos.x, (int) bestNode.pos.y - 1).getGridTileType() == GridTileType.ROAD && !isNodeInList(closedList, (int) bestNode.pos.x, (int) bestNode.pos.y - 1) && !isNodeInList(closedList, (int) bestNode.pos.x, (int) bestNode.pos.y - 1)) {
                openList.add(new Node(bestNode, targetNode, new Vector2(bestNode.pos.x, bestNode.pos.y - 1)));
            }
            for (Node node : closedList) {
                if (node.pos.x == targetNode.pos.x && node.pos.y == targetNode.pos.y) {
                    targetNode.parrent = node;
                    running = false;
                    openList.clear();
                }
            }
            if (System.currentTimeMillis() - startTime >= 30) {
                return;
            }
        }
        Array<GridTile> newPath = new Array<GridTile>();
        Node currentNode = targetNode;
        do {
            newPath.add(grid.getGridTile(currentNode.pos));
            currentNode = currentNode.parrent;
        } while (currentNode != null);
        setInvertedPath(newPath);
        if (path.get(0).getPosition().x == path.get(1).getPosition().x &&
                path.get(0).getPosition().y == path.get(1).getPosition().y) {
            getNext();
        }
        pathLoaded = true;
        //grid.print();
        //print();
    }

    /**
     * TODO JAVA DOC
     *
     * @since 0.9.0
     */
    private Array<GridTile> getPath() {
        return path;
    }

    public boolean isPathLoaded() {
        return pathLoaded;
    }

    /**
     * @return
     * @since 0.9.3
     */
    public GridTile peak() throws NullPointerException {
        return path.get(0);
    }

    /**
     * @return
     * @since 0.9.3
     */
    public int getRemainingLenght() {
        return path.size;
    }

    /**
     * @since 0.9.3
     */
    public void print() {
        System.out.println(path.size);
        for (GridTile gridTile : path) {
            System.out.println(gridTile.getPosition().toString());
        }
    }

    public class Node {

        /**
         * TODO JAVA DOC
         *
         * @since 0.9.0
         */
        private Node parrent;

        /**
         * TODO JAVA DOC
         *
         * @since 0.9.0
         */
        private final Vector2 pos;
        private final int g = 10;
        /**
         * TODO JAVA DOC
         *
         * @since 0.9.0
         */
        private int f = 0;
        private int h = 0;

        public Node(Node parent, Node target, Vector2 pos) {
            this.parrent = parent;
            this.pos = pos;
            if (target != null) {
                h = (int) (10 * (Math.abs(pos.x - target.pos.x) + Math.abs(pos.y - target.pos.y)));
            } else {
                h = 0;
            }
            f = h + g;
        }
    }
}