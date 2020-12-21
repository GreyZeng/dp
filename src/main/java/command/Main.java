package command;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {
    public static void main(String[] args) {
        Content content = new Content();
        CopyCommand copyCommand = new CopyCommand(content);
        System.out.println("origin msg is " + content.msg);
        copyCommand.doit();
        System.out.println("do copy command , result is " + content.msg);
        copyCommand.undo();
        System.out.println("undo copy command, result is " + content.msg);

    }
}
