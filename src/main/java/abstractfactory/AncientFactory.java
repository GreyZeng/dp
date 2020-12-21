package abstractfactory;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class AncientFactory extends AbstractFactory {


    @Override
    protected Transportation createTransportation() {
        return new Coach();
    }

    @Override
    protected WritingInstrument createWritingInstrument() {
        return new Brush();
    }
}
