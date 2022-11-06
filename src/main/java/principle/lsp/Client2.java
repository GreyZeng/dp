package principle.lsp;

/**
 * 我们发现原本运行正常的相减功能发生了错误。
 * 原因就是类B在给方法起名时无意中重写了父类的方法，
 * 造成所有运行相减功能的代码全部调用了类B重写后的方法，
 * 造成原本运行正常的功能出现了错误。在本例中，引用基类A完成的功能，
 * 换成子类B之后，发生了异常。
 * 在实际编程中，我们常常会通过重写父类的方法来完成新的功能，
 * 这样写起来虽然简单，但是整个继承体系的可复用性会比较差，
 * 特别是运用多态比较频繁时，程序运行出错的几率非常大。
 * 如果非要重写父类的方法，比较通用的做法是：
 * 原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉，
 * 采用依赖、聚合，组合等关系代替。
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
class B extends A {
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 100;
    }
}

public class Client2 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println("100-50=" + b.func1(100, 50));
        System.out.println("100-80=" + b.func1(100, 80));
        System.out.println("100+20+100=" + b.func2(100, 20));
    }
}