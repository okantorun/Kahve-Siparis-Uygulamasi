package okan.proje;
import java.util.List;
import java.util.Map;

import okan.proje.business.abstracts.CoffeeService;
import okan.proje.business.abstracts.IngredientService;
import okan.proje.business.concretes.CoffeeManager;
import okan.proje.business.concretes.IngredientManager;
import okan.proje.dataAccess.abstracts.IngredientDao;
import okan.proje.dataAccess.concretes.InMemoryCoffeeDao;
import okan.proje.dataAccess.concretes.InMemoryIngredientDao;
import okan.proje.entities.concretes.Coffee;
import okan.proje.entities.concretes.Ingredient;

public class Main {

	public static void main(String[] args) {
		
		CoffeeService coffeeService = new CoffeeManager(new InMemoryCoffeeDao(),
																	new IngredientManager(new InMemoryIngredientDao()));
		
		IngredientService ingredientService = new IngredientManager(new InMemoryIngredientDao());
		
		coffeeService.order(new Coffee(3,"Cappuccino",22,Map.of(1,1,2,4)));
		/*ingredientService.delete(new Ingredient(1,"Espresso",10));
		for (var ingredient : ingredientService.getAll()) {
			System.out.println(ingredient.getIngredientName());
		}
		ingredientService.add(new Ingredient(1,"Espresso",10));
		for (var ingredient : ingredientService.getAll()) {
			System.out.println(ingredient.getIngredientName());
		}*/
		/*Map<Integer, Integer> hm =  Map.of(
			    1, 2,
			    2, 3
				);
		hm.put(1, 2);
		hm.put(2, 3);
		Coffee coffee = new Coffee(1,"Espresso",17,Map.of(
															1,2,
															2,3));
		coffeeService.add(coffee);*/

	}

}
