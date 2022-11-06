package principle.dip;

/**
 * 符合依赖倒置原则
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public class CarTest1 {
    public static void main(String[] args) {
        IDriver driver = new Driver();
        driver.driver(new Benz());
        driver.driver(new BMW());
    }

    private interface ICar {
        void run();
    }

    public static class Benz implements ICar {
        public void run() {
            System.out.println("奔驰跑起来了!");
        }
    }

    public static class BMW implements ICar {
        public void run() {
            System.out.println("宝马跑起来了!");
        }
    }

    private interface IDriver {
        void driver(ICar car);
    }

    public static class Driver implements IDriver {

        @Override
        public void driver(ICar car) {
            car.run();
        }
    }
}
