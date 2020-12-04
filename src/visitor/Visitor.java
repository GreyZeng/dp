package visitor;

/**
 * @author Grey
 * @date 2020/4/16
 */
public interface Visitor {
    void visitCPU(CPU cpu);

    void visitBoard(Board board);

    void visitMemory(Memory memory);
}
