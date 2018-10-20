package sample.UndoRedo;

import java.util.ArrayList;

public class CommandManager {

    private ArrayList<Command> undoStack = new ArrayList<>();
    private ArrayList<Command> redoStack = new ArrayList<>();


    //Add to redoStack, unexecute last command in undoStack, remove last command in undoStack.
    public void undo() {
        if (undoStack.size() > 0) {
            redoStack.add(undoStack.get(undoStack.size() - 1));
            undoStack.get(undoStack.size() - 1).unExecute();
            undoStack.remove(undoStack.size() - 1);
        }
    }

    //Add to undoStack, execute last command in redoStack, remove last command in redoStack.
    public void redo() {
        if (redoStack.size() > 0) {
            undoStack.add(redoStack.get(redoStack.size()-1));
            redoStack.get(redoStack.size()-1).execute();
            redoStack.remove(redoStack.get(redoStack.size()-1));
        }
    }

    //Add command to undoStack, execute command, clear redoStack.
    public void doCommand(Command command) {
        undoStack.add(command);
        command.execute();
        redoStack.clear();
    }
}
