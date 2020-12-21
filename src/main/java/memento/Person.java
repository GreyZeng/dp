package memento;

import java.io.Serializable;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Person implements Serializable {
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
