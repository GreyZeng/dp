package strategy;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(10, 20), new Cat(19, 41), new Cat(15, 40), new Cat(18, 33), new Cat(14, 23)};
        Sorter<Cat> sorter = new Sorter<>();
        // Cat[] sortedCats = sorter.sort(cats, new CatSortStrategy());
        /*Cat[] sortedCats = sorter.sort(cats, (o1, o2) -> {
            return o1.getWeight() - o2.getWeight();
        });*/
        Cat[] sortedCats = sorter.sort(cats, Comparator.comparingInt(Cat::getWeight));
        for (Cat cat : sortedCats) {
            System.out.println(cat);
        }
    }
}
