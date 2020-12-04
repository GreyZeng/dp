package visitor;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class Memory extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }

    @Override
    int getPrice() {
        return 11;
    }
}