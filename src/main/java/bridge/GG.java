package bridge;

public class GG {
    public void chase(MM mm) {
        give(mm, new WarmGift(new Flower()));
    }

    public void give(MM mm, Gift g) {
        System.out.println(g + "gived!");
    }
}
