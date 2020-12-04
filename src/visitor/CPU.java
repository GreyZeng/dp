package visitor;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class CPU extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitCPU(this);
    }

    @Override
    int getPrice() {
        return 200;
    }
}
