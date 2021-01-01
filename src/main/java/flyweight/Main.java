package flyweight;

public class Main {
    public static void main(String[] args) {
        System.out.println(new BulletPool().getBullet());

        // jdk中这个方法也用到了享元模式
        Boolean value = Boolean.valueOf(true);
        System.out.println(value);
    }
}
