package Iterator;

/**
 * @author Grey
 * @date 2020/4/15
 */
public class Main {
    public static void main(String[] args) {
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
