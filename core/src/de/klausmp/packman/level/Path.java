package de.klausmp.packman.level;

import com.badlogic.gdx.utils.Array;
import de.klausmp.packman.utils.Rotation;

/**
 * TODO JAVA DOC
 *
 * @author Klausmp
 * @since 0.6.0
 * @since 0.6.0
 */
public class Path {

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    private Array<Rotation> path;

    /**
     * TODO JAVA Doc
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    public Path() {
    }

    /**
     * TODO JAVA Doc
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    public Path(Array<Rotation> path) {
        this.setPath(path);
    }

    /**
     * TODO JAVA Doc
     *
     * @throws NullPointerException
     * @version 0.6.0
     * @since 0.6.0
     */
    public Rotation getNext() throws NullPointerException {
        Rotation result = path.get(0);
        path.removeIndex(0);
        return result;
    }

    /**
     * TODO JAVA Doc
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    public void setPath(Array<Rotation> newPath) {
        path.clear();
        path.addAll(newPath);
    }

    /**
     * TODO JAVA DOC
     *
     * @version 0.6.0
     * @since 0.6.0
     */
    public Array<Rotation> getPath() {
        return path;
    }
}