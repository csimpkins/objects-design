import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Stack;
import javax.swing.AbstractAction;

/**
 * javax.swing.Action plays the role of Command in the Command pattern
 * ColorAction plays the role of ConcreteCommand
 * The class that instantiates ColorAction objects is the client
 * The buttons and menu items are the invokers
 * The receiver component is the target of the command
 */
public class ColorAction extends AbstractAction {

    private Component receiver;
    private Color color;
    private Stack<Undoable> undoStack;

    public ColorAction(String name, Color color, Component receiver,
        Stack<Undoable> undoStack) {
        super(name);
        this.color = color;
        this.receiver = receiver;
        this.undoStack = undoStack;
    }

    public void actionPerformed(ActionEvent e) {
        // prevColor is "closed over" by the anonymous inner class
        // prevColor must be final so that the compiler knows its value
        // won't change
        final Color prevColor = receiver.getBackground();
        undoStack.push(new Undoable() {
            public void undo() {
                receiver.setBackground(prevColor);
            }
        });
        receiver.setBackground(color);
    }
}
