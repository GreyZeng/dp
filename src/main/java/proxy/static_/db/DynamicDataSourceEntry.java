package proxy.static_.db;

/**
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since
 */
public class DynamicDataSourceEntry {
    public final static String DEFAULT_SOURCE = null;
    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntry() {

    }

    public static void clear() {
        local.remove();
    }

    public static String get() {
        return local.get();
    }

    public static void restore() {
        set(DEFAULT_SOURCE);
    }

    public static void set(String source) {
        local.set(source);
    }

    public static void set(int year) {
        set("DB_" + year);
    }
}
