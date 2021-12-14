package prototype;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        O o = new O();
        System.out.println(o.clone() == o);
        System.out.println(o.clone().equals(o));
        System.out.println();
        Person p = new Person();
        System.out.println(p);
        Person p2 = (Person) p.clone();
        System.out.println(p2);
    }
}

class O  implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
