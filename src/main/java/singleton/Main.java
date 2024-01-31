package singleton;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws Exception {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
    public static void test1() throws Exception{
    	// 获取私有构造函数
        Constructor<Singleton1> constructor = Singleton1.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 创建新的实例
        Singleton1 instance1 = constructor.newInstance();
        Singleton1 instance2 = constructor.newInstance();

        // 判断两个实例是否相同
        System.out.println(instance1 == instance2); // false
    }
    public static void test2() throws Exception{
    	// 获取私有构造函数
        Constructor<Singleton2> constructor = Singleton2.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 创建新的实例
        Singleton2 instance1 = constructor.newInstance();
        Singleton2 instance2 = constructor.newInstance();

        // 判断两个实例是否相同
        System.out.println(instance1 == instance2); // false
    }
    public static void test3() throws Exception{
    	// 获取私有构造函数
        Constructor<Singleton3> constructor = Singleton3.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 创建新的实例
        Singleton3 instance1 = constructor.newInstance();
        Singleton3 instance2 = constructor.newInstance();

        // 判断两个实例是否相同
        System.out.println(instance1 == instance2); // false
    }
    public static void test4() throws Exception{
    	// 获取私有构造函数
        Constructor<Singleton4> constructor = Singleton4.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 创建新的实例
        Singleton4 instance1 = constructor.newInstance();
        Singleton4 instance2 = constructor.newInstance();

        // 判断两个实例是否相同
        System.out.println(instance1 == instance2); // false
    }
    public static void test5() throws Exception{
    	// 获取私有构造函数
        Constructor<Singleton5> constructor = Singleton5.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 创建新的实例
        Singleton5 instance1 = constructor.newInstance();
        Singleton5 instance2 = constructor.newInstance();

        // 判断两个实例是否相同
        System.out.println(instance1 == instance2); // false
    }
    public static void test6() throws Exception{
    	// 获取私有构造函数
        Constructor<Singleton6> constructor = Singleton6.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 创建新的实例
        Singleton6 instance1 = constructor.newInstance();
        Singleton6 instance2 = constructor.newInstance();

        // 判断两个实例是否相同
        System.out.println(instance1 == instance2); // false
    }
    public static void test7() throws Exception{
    	// 获取私有构造函数
        Constructor<Singleton7> constructor = Singleton7.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 创建新的实例
        Singleton7 instance1 = constructor.newInstance();
        Singleton7 instance2 = constructor.newInstance();

        // 判断两个实例是否相同
        System.out.println(instance1 == instance2); // false
    }
    public static void test8() throws Exception{
    	// 获取私有构造函数
        Constructor<Singleton8> constructor = Singleton8.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // 创建新的实例
        Singleton8 instance1 = constructor.newInstance();
        Singleton8 instance2 = constructor.newInstance();

        // 判断两个实例是否相同
        System.out.println(instance1 == instance2); // false
    }
}
