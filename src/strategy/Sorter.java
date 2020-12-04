package strategy;

import java.util.Comparator;

/**
 * @param <T>
 * @author Grey
 */
public class Sorter<T> {

    public T[] sort(T[] items, Comparator<T> strategy) {
        int length = items.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (strategy.compare(items[i], items[j]) > 0) {
                    T tmp = items[i];
                    items[i] = items[j];
                    items[j] = tmp;
                }
            }
        }
        return items;
    }
}
