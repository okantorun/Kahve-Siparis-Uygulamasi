package okan.proje.dataAccess.abstracts;

import java.util.List;

import okan.proje.entities.concretes.Ingredient;

public interface IngredientDao {

	void add(Ingredient ingredient);
	void delete(Ingredient ingredient);
	void update(Ingredient ingredient);
	Ingredient getIngredientDetails(int id);
	List<Ingredient> getAll();
}
