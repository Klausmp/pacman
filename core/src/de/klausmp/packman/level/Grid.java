package de.klausmp.packman.level;

        import com.badlogic.gdx.utils.Array;

/**
 * @author Klausmp
 */
public class Grid {
    private Array<GridTile> gridTiles = new Array<GridTile>();

    public Grid() {

    }

    public void update(){
        for (GridTile gridTile: gridTiles) {
            gridTile.update();
        }
    }

    public void addTile(GridTile gridTile){
        gridTiles.add(gridTile);
    }
}