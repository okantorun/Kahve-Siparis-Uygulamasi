package okan.proje.business.abstracts;

import java.util.List;

import okan.proje.core.utilities.results.DataResult;
import okan.proje.core.utilities.results.Result;
import okan.proje.entities.concretes.Ingredient;

public interface IngredientService {
	
	Result add(Ingredient ingredient);
	Result delete(Ingredient ingredient);
	Result update(Ingredient ingredient);
	DataResult<Ingredient> getIngredientDetails(int id);
	DataResult<List<Ingredient>> getAll();
}
