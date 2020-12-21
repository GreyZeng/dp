package visitor;

/**
 * @author Grey
 * @date 2020/4/16
 */
public abstract class ComputerPart {
    abstract void accept(Visitor visitor);

    abstract int getPrice();
}
