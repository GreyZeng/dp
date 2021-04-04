package singleton;

/**
 * 静态内部类方式，JVM保证单例，加载外部类时不会加载内部类，这样可以实现懒加载
 *
 * @author Grey
 * @date 2020/4/9
 */
public class Singleton7 {
	private Singleton7() {
	}

	public static Singleton7 getInstance() {
		return Holder.INSTANCE;
	}

	private static class Holder {
		private static final Singleton7 INSTANCE = new Singleton7();
	}
}
