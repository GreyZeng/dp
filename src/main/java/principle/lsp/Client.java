package principle.lsp;

/**
 * 不符合里氏替换法则
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public class Client {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("100-50=" + a.func1(100, 50));
        System.out.println("100-80=" + a.func1(100, 80));
    }
}

class A {
    public int func1(int a, int b) {
        return a - b;
    }
}