package okan.proje.business.concretes;

import java.util.List;

import okan.proje.business.abstracts.IngredientService;
import okan.proje.dataAccess.abstracts.IngredientDao;
import okan.proje.entities.concretes.Ingredient;

public class IngredientManager implements IngredientService {
	
	private IngredientDao ingredientDao;
	public IngredientManager(IngredientDao ingredientDao) {
		super();
		this.ingredientDao = ingredientDao;
	}

	
	@Override
	public void add(Ingredient ingredient) {
		
		this.ingredientDao.add(ingredient);
		
	}

	@Override
	public void delete(Ingredient ingredient) {
		this.ingredientDao.delete(ingredient);
		
	}

	@Override
	public void update(Ingredient ingredient) {
		this.ingredientDao.update(ingredient);
		
	}

	@Override
	public List<Ingredient> getAll() {
		
		return this.ingredientDao.getAll();
	}


	@Override
	public Ingredient getIngredientDetails(int id) {
		return this.ingredientDao.getIngredientDetails(id);
	}

}
