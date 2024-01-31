package prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用序列化的方式进行深克隆,待克隆对象
 *
 * @author <a href="mailto:410486047@qq.com">Grey</a>
 * @date 2021/12/14
 * @since 1.8
 */

public class Prototype implements Cloneable, Serializable {
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
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Prototype{" + "age=" + age + ", name='" + name + '\'' + ", hobbits=" + hobbits + '}';
    }
}
