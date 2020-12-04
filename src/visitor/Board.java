package visitor;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class Board extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitBoard(this);
    }

    @Override
    int getPrice() {
        return 20;
    }
}