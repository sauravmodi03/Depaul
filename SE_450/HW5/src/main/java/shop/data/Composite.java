package shop.data;

import shop.command.UndoableCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Composite implements UndoableCommand {

    private List<UndoableCommand> newCmd;
    private Stack<List<UndoableCommand>> _undoStack;
    private  Stack<List<UndoableCommand>> _redoStack;

    public Composite() {
        newCmd = new ArrayList<>();
        _undoStack = new Stack<List<UndoableCommand>>();
        _redoStack = new Stack<List<UndoableCommand>>();
    }

    public void add(UndoableCommand cmd) {
        newCmd.add(cmd);
    }

    public boolean run() {
        for (UndoableCommand l : newCmd) {
            l.run();
        }
        _undoStack.push(new ArrayList<>(newCmd));
        _redoStack.clear();
        newCmd.clear();
        return true;
    }

    public void undo() {
        _redoStack.push(_undoStack.peek());
        for(UndoableCommand cmd : _undoStack.pop()){
            cmd.undo();
        }
    }

    public void redo() {
        _undoStack.push(_redoStack.peek());
        for(UndoableCommand cmd : _redoStack.pop()){
            cmd.redo();
        }
    }
}