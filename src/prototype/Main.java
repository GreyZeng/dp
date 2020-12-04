package prototype;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        System.out.println(p);
        Person p2 = (Person) p.clone();
        System.out.println(p2);
    }
}
