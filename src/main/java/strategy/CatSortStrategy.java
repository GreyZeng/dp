package strategy;

import java.util.Comparator;

/**
 * @author Grey
 */
public class CatSortStrategy implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.getHeight() - o2.getHeight();
    }
}
