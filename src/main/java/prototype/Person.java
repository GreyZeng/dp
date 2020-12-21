package prototype;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Person implements Cloneable {
    String name = "lisa";
    int age = 1;
    Location loc = new Location("xy", 10);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", loc=" + loc +
                '}';
    }
}
