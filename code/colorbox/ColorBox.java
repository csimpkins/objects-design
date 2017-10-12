import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class ColorBox extends JFrame {

    private JPanel colorPanel;
    private Stack<Undoable> undoStack;

    public ColorBox() {
        super("Color, Box, and Nesting Demo");

        // Set up color panel
        colorPanel = new JPanel();
        colorPanel.setSize(200, 200);
        undoStack = new Stack<>();
        List<Action> colorActions = createColorActions(colorPanel, undoStack);

        // Grid layout with 1 row, 2 columns
        setLayout(new GridLayout(1, 2));
        add(createButtonPanel(colorActions));
        add(colorPanel);
        setJMenuBar(createJMenuBar(colorActions));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private List<Action> createColorActions(Component receiver,
            Stack<Undoable> undoStack) {
        return Arrays.asList(new Action[] {
            new ColorAction("Red", Color.RED, receiver, undoStack),
            new ColorAction("Orange", Color.ORANGE, receiver, undoStack),
            new ColorAction("Yellow", Color.YELLOW, receiver, undoStack),
            new ColorAction("Green", Color.GREEN, receiver, undoStack),
            new ColorAction("Blue", Color.BLUE, receiver, undoStack),
            new ColorAction("Indigo", Color.CYAN, receiver, undoStack),
            new ColorAction("Violet", Color.MAGENTA, receiver, undoStack),
        });
    }

    private JPanel createButtonPanel(List<Action> colorActions) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        for (Action action: colorActions) {
            buttonPanel.add(new JButton(action));
        }
        return buttonPanel;
    }

    private JMenuBar createJMenuBar(List<Action> colorActions) {
        JMenu colorMenu = new JMenu("Color");
        for (Action action: colorActions) {
            colorMenu.add(new JMenuItem(action));
        }
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(colorMenu);

        JMenu editMenu = new JMenu("Edit");
        editMenu.add(new AbstractAction("Undo") {
            public void actionPerformed(ActionEvent e) {
                if (!undoStack.isEmpty()) {
                    undoStack.pop().undo();
                }
            }
        });
        menuBar.add(editMenu);
        return menuBar;
    }

    public static void main(String[] args) {
        ColorBox cb = new ColorBox();
        cb.pack();
        cb.setVisible(true);
    }
}
