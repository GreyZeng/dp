package strategy;

/**
 * @author Grey
 */
public class Cat {
    private final int height;
    private final int weight;

    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Cat{" + "height=" + getHeight() + ", weight=" + getWeight() + '}';
    }
}
