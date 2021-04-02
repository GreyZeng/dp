package factory.abstractfactory;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Brush extends WritingInstrument {
    @Override
    protected void write() {
        System.out.println("brush write");
    }
}
