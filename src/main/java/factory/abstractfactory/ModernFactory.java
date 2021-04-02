package factory.abstractfactory;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class ModernFactory extends AbstractFactory {

    @Override
    protected Transportation createTransportation() {
        return new Car();
    }

    @Override
    protected WritingInstrument createWritingInstrument() {
        return new Pen();
    }
}
