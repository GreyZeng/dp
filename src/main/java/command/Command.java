package command;

/**
 * @author Grey
 * @date 2020/4/17
 */
public abstract class Command {
    abstract void doit();

    abstract void undo();
}
