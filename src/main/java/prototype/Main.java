package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        shallowClone();
        deepClone();
    }

    // 浅克隆(基本类型是复制，对象类型只拷贝引用）
    public static void shallowClone() throws CloneNotSupportedException {
        System.out.println("浅克隆");
        O o = new O();
        O clonedO = (O)o.clone();
        System.out.println(clonedO == o); // false
        System.out.println(clonedO.equals(o)); // false
        System.out.println(o.obj1 == clonedO.obj1); // true
        System.out.println();
        Person p = new Person();
        System.out.println(p);
        Person p2 = (Person) p.clone();
        System.out.println(p2);
    }

    // 使用序列化的方式进行深克隆
    public static void deepClone() {
        System.out.println("使用序列化方式进行深度克隆");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("唱歌");
        hobbies.add("跳舞");
        Prototype p = new Prototype();
        p.setAge(18);
        p.setName("zhangsan");
        p.setHobbits(hobbies);
        Prototype clone = p.clone();
        System.out.println(clone.getAge());
        System.out.println(clone.getName());
        System.out.println(clone.getHobbits());
    }
}

class O implements Cloneable {

    public int num;
    public MyObject obj1;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class MyObject {

}
