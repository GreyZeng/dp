package factory.abstractfactory;

/**
 * @author Grey
 * @date 2020/4/13
 */
public class Main {
    public static void main(String[] args) {
    	toolCreate(new ModernFactory());
    	toolCreate(new AncientFactory());
    }
    public static void toolCreate(AbstractFactory factory) {
    	 factory.createTransportation().go();
         factory.createWritingInstrument().write();
    }
}
