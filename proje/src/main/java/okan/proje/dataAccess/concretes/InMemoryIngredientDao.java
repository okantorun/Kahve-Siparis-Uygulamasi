package okan.proje.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okan.proje.dataAccess.abstracts.IngredientDao;
import okan.proje.entities.concretes.Ingredient;

public class InMemoryIngredientDao implements IngredientDao {
	
	private List<Ingredient> ingredients;
	
	public InMemoryIngredientDao() {
		ingredients = new ArrayList<Ingredient>(
				Arrays.asList(new Ingredient(1,"Espresso",1),
							  new Ingredient(2,"Hot Water",4),
							  new Ingredient(3,"Steamed Milk",12),
							  new Ingredient(4,"Milk Foam",13),
							  new Ingredient(5,"Hot Chocolate",14))						
		);
	}
	
	@Override
	public void add(Ingredient ingredient) {
		ingredients.add(ingredient);
		
	}

	@Override
	public void delete(Ingredient ingredient) {
		Ingredient ingredientDelete = findReferenceOfIngredient(ingredient);
		ingredients.remove(ingredientDelete);
		
	}

	@Override
	public void update(Ingredient ingredient) {
		Ingredient ingredientUpdate = findReferenceOfIngredient(ingredient);
		ingredientUpdate.setIngredientName(ingredient.getIngredientName());
		ingredientUpdate.setUnitInStock(ingredient.getUnitInStock());
		
		
	}
	
	@Override
	public Ingredient getIngredientDetails(int id) {
		Ingredient ingredientDetails = findReferenceOfIngredient(new Ingredient(id, null, 0));
		return ingredientDetails;
	}

	@Override
	public List<Ingredient> getAll() {
		return ingredients;
	}
	
	private Ingredient findReferenceOfIngredient(Ingredient ingredient) {
		Ingredient ingredientWanted = null;
		for (var i : ingredients) 
		{
			if(ingredient.getId() == i.getId())
			{
				ingredientWanted = i;
			}
		}
		return ingredientWanted;
	}

	
	
}
