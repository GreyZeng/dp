package principle.lkp;

/**
 * 符合迪米特法则
 * 通过减少CoffeeMachine对外暴露的方法，减少Man对CoffeeMachine的了解，从而降低了它们之间的耦合。
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public class Client2 {
    public static void main(String[] args) {
        ICoffeeMachine2 coffeeMachine = new CoffeeMachine2();
        IMan man = new Man(coffeeMachine);
        man.makeCoffee();

    }

    /**
     * 咖啡机抽象接口
     */
    interface ICoffeeMachine2 {

        //咖啡机工作
        void work();

    }

    /**
     * 咖啡机实现类
     */
    static class CoffeeMachine2 implements ICoffeeMachine2 {

        //加咖啡豆
        public void addCoffeeBean() {
            System.out.println("放咖啡豆");
        }

        //加水
        public void addWater() {
            System.out.println("加水");
        }

        //制作咖啡
        public void makeCoffee() {
            System.out.println("制作咖啡");
        }

        @Override
        public void work() {
            addCoffeeBean();
            addWater();
            makeCoffee();
        }
    }

    /**
     * 人, 制作咖啡
     */
    interface IMan {
        /**
         * 制作咖啡
         */
        void makeCoffee();
    }


    /**
     * 人制作咖啡
     */
    static class Man implements IMan {
        private ICoffeeMachine2 coffeeMachine;

        public Man(ICoffeeMachine2 coffeeMachine) {
            this.coffeeMachine = coffeeMachine;
        }

        /**
         * 制作咖啡
         */
        public void makeCoffee() {
            coffeeMachine.work();
        }
    }
}

