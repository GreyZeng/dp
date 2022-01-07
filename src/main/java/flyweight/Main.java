package flyweight;

public class Main {
    public static void main(String[] args) {
        System.out.println(new BulletPool().getBullet());

        // jdk中这个方法也用到了享元模式
        Boolean value = Boolean.valueOf(true);
        System.out.println(value);

        // 有两个参数可以配置
        // 方法一：
        // -Djava.lang.Integer.IntegerCache.high=255
        // 方法二：
        // -XX:AutoBoxCacheMax=255
        Integer i1 = Integer.valueOf(127);
        Integer i2 = Integer.valueOf(127);
        System.out.println(i1 == i2);
        i1 = Integer.valueOf(128);
        i2 = Integer.valueOf(128);
        System.out.println(i1 == i2);

    }
}
