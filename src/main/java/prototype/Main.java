package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        O o = new O();
        System.out.println(o.clone() == o); // false
        System.out.println(o.clone().equals(o)); // false
        System.out.println();
        Person p = new Person();
        System.out.println(p);
        Person p2 = (Person) p.clone();
        System.out.println(p2);
        System.out.println("使用序列化方式进行深度克隆");
        deepClone();
    }
    // 使用序列化的方式进行深克隆
    public static void deepClone() {
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
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
