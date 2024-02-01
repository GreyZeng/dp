package bridge;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class WarmGift extends Gift {
    public WarmGift(GiftImpl impl) {
        this.impl = impl;
    }

    @Override
    public String toString() {
        return "WarmGift{}";
    }
}
