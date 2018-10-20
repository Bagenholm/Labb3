package sample.UndoRedo;

interface Command {
    void execute();
    void unExecute();
}
