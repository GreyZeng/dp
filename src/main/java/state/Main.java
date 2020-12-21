package state;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {
    public static void main(String[] args) {
        MM mm = new MM(new SadState());
        mm.cry();
        mm.say();
        mm.smile();
        mm = new MM(new HappyState());
        mm.cry();
        mm.say();
        mm.smile();

    }
}
