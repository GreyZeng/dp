package abstractfactory;

/**
 * @author Grey
 * @date 2020/4/13
 */
public abstract class AbstractFactory {
    /**
     * 子类实现
     *
     * @return
     */
    protected abstract Transportation createTransportation();

    /**
     * 子类实现
     *
     * @return
     */
    protected abstract WritingInstrument createWritingInstrument();
}
