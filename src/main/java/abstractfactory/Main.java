package abstractfactory;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ModernFactory();
        factory.createTransportation().go();
        factory.createWritingInstrument().write();

        factory = new AncientFactory();
        factory.createTransportation().go();
        factory.createWritingInstrument().write();
    }
}
