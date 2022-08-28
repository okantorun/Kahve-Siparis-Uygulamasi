package okan.proje;
import java.util.List;
import java.util.Map;

import org.junit.Test;

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
		
		IngredientService ingredientService = new IngredientManager(new InMemoryIngredientDao());
		
		CoffeeService coffeeService = new CoffeeManager(new InMemoryCoffeeDao(),ingredientService);
		
		
		
		/*System.out.println(ingredientService.getIngredientDetails(5));
		coffeeService.order(6);
		System.out.println(ingredientService.getIngredientDetails(5));*/
		//ingredientService.delete(new Ingredient(1,"Espresso",10));
		for (var ingredient : ingredientService.getAll().getData()) {
			System.out.println(ingredient);
		}
		/*ingredientService.add(new Ingredient(1,"Espresso",10));
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
