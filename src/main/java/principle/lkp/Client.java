package principle.lkp;

/**
 * 不符合迪米特法则
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2022/11/6
 * @since 1.8
 */
public class Client {
    public static void main(String[] args) {
        ICoffeeMachine coffeeMachine = new CoffeeMachine();
        IMan man = new Man(coffeeMachine);
        man.makeCoffee();
    }

    /**
     * 咖啡机抽象接口
     */
    interface ICoffeeMachine {

        //加咖啡豆
        void addCoffeeBean();

        //加水
        void addWater();

        //制作咖啡
        void makeCoffee();
    }


    static class CoffeeMachine implements ICoffeeMachine {

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
        private ICoffeeMachine coffeeMachine;

        public Man(ICoffeeMachine coffeeMachine) {
            this.coffeeMachine = coffeeMachine;
        }

        /**
         * 制作咖啡
         * 其实人根本不关心咖啡机具体制作咖啡的过程。
         */
        public void makeCoffee() {
            coffeeMachine.addWater();
            coffeeMachine.addCoffeeBean();
            coffeeMachine.makeCoffee();
        }
    }
}

