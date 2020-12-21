package visitor;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class Main {
    public static void main(String[] args) {
        ComputerPart cpu = new CPU();
        ComputerPart memory = new Memory();
        ComputerPart board = new Board();
        PersonalVisitor personalVisitor = new PersonalVisitor();
        cpu.accept(personalVisitor);
        memory.accept(personalVisitor);
        board.accept(personalVisitor);
        System.out.println(personalVisitor.getTotalPrice());

        ComputerPart cpu2 = new CPU();
        ComputerPart memory2 = new Memory();
        ComputerPart board2 = new Board();
        CorpVisitor corpVisitor = new CorpVisitor();
        cpu2.accept(corpVisitor);
        memory2.accept(corpVisitor);
        board2.accept(corpVisitor);
        System.out.println(corpVisitor.getTotalPrice());


    }

}
