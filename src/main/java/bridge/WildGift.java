package bridge;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class WildGift extends Gift {

    public WildGift(GiftImpl impl) {
        this.impl = impl;
    }

    @Override
    public String toString() {
        return "WildGift{}";
    }
}
