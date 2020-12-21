package abstractfactory;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Pen extends WritingInstrument {
    @Override
    protected void write() {
        System.out.println("pen write");
    }
}
