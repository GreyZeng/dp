package Iterator;

/**
 * @author Grey
 * @date 2020/4/15
 */
public class Main {
    public static void main(String[] args) {
        testIterator();
        testIterator2();
    }

    private static void testIterator2() {
        ArrayList_<Obj> list = new ArrayList_<>();
        for (int i = 0; i < 12; i++) {
            list.add(new Obj(i));
        }
        System.out.println(list.size());
        Iterator_<Obj> iterator_ = list.iterator();
        while (iterator_.hasNext()) {
            System.out.println(iterator_.next());
        }
    }

    private static void testIterator() {
        ArrayList_<String> list = new ArrayList_<>();
        for (int i = 0; i < 12; i++) {
            list.add("str" + i);
        }
        System.out.println(list.size());
        Iterator_<String> iterator_ = list.iterator();
        while (iterator_.hasNext()) {
            System.out.println(iterator_.next());
        }
    }
}

class Obj {
    private final int num;

    public Obj(int n) {
        num = n;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "num=" + num +
                '}';
    }
}