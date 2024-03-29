package builder;

import static builder.NyPizza.Size.SMALL;
import static builder.Pizza.Topping.*;

public class Main {
	public static void main(String[] args) {
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();

		System.out.println(cocaCola);
		NyPizza pizza = new NyPizza.Builder(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
		System.out.println(pizza);
		Calzone calzone = new Calzone.Builder().addTopping(HAM).sauceInside().build();
		System.out.println(calzone);
	}
}
