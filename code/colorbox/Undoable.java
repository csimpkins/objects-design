/**
 * The creator of an Undoable object is responsible for providing it with
 * all the state it needs to execute an undo.
 */
public interface Undoable {
    void undo();
}
