package visitor;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class CorpVisitor implements Visitor {
    private int totalPrice;

    @Override
    public void visitCPU(CPU cpu) {
        totalPrice += cpu.getPrice() - 1;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice() - 2;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() - 3;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
