package principle.dip;

/**
 * 不符合依赖倒置原则
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public class CarTest {
    private static class Benz {
        public void run() {
            System.out.println("奔驰跑起来了!");
        }
    }

    private static class Driver {
        private String name;

        public Driver(String name) {
            this.name = name;
        }

        // driver方法参数里面写了具体的车的实现，如果以后要换一种车，只能修改代码实现。
        // 不符合依赖倒置原则
        public void driver(Benz benz) {
            benz.run();
        }
    }

    public static void main(String[] args) {
        Benz benz = new Benz();
        Driver driver = new Driver("张三");
        driver.driver(benz);
    }
}
