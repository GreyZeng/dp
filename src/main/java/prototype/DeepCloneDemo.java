package prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用序列化的方式进行深克隆
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since 1.8
 */
public class DeepCloneDemo {
    public static void main(String[] args) {
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

// 待克隆对象
class Prototype implements Cloneable, Serializable {
    private int age;
    private String name;
    private List<String> hobbits;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHobbits() {
        return hobbits;
    }

    public void setHobbits(List<String> hobbits) {
        this.hobbits = hobbits;
    }

    @Override
    protected Prototype clone() {
        return deepClone();
    }

    public Prototype deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Prototype) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Prototype{" + "age=" + age + ", name='" + name + '\'' + ", hobbits=" + hobbits + '}';
    }
}
