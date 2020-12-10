package strategy;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(10, 20), new Cat(19, 41), new Cat(15, 40), new Cat(18, 33), new Cat(14, 23)};
        Sorter<Cat> sorter = new Sorter<>();
        Cat[] sortedCats = sorter.sort(cats, new CatSortStrategy());
        for (Cat cat : sortedCats) {
            System.out.println(cat);
        }
    }
}
