package okan.proje.business.concretes;

import java.util.List;

import okan.proje.business.abstracts.IngredientService;
import okan.proje.business.constants.Messages;
import okan.proje.core.utilities.results.DataResult;
import okan.proje.core.utilities.results.ErrorDataResult;
import okan.proje.core.utilities.results.ErrorResult;
import okan.proje.core.utilities.results.Result;
import okan.proje.core.utilities.results.SuccessDataResult;
import okan.proje.core.utilities.results.SuccessResult;
import okan.proje.dataAccess.abstracts.IngredientDao;
import okan.proje.entities.concretes.Ingredient;

public class IngredientManager implements IngredientService {
	
	private IngredientDao ingredientDao;
	public IngredientManager(IngredientDao ingredientDao) {
		super();
		this.ingredientDao = ingredientDao;
	}

	
	@Override
	public Result add(Ingredient ingredient) {
		
		if(controlOfDuplicateIngredient(ingredient)) {
			return new ErrorResult(Messages.addedDuplicateIngredientFailed);
		}
		this.ingredientDao.add(ingredient);
		return new SuccessResult(Messages.ingredientsAdded);
		
	}

	@Override
	public Result delete(Ingredient ingredient) {
		if(!controlOfDuplicateIngredient(ingredient)) {
			return new ErrorResult(Messages.deletedDuplicateIngredientFailed);
		}
		this.ingredientDao.delete(ingredient);
		return new SuccessResult(Messages.ingredientsDeleted);
		
	}

	@Override
	public Result update(Ingredient ingredient) {
		if(!controlOfDuplicateIngredient(ingredient)) {
			return new ErrorResult(Messages.updatedDuplicateIngredientFailed);
		}
		this.ingredientDao.update(ingredient);
		return new SuccessResult(Messages.ingredientsUpdated);
		
	}

	@Override
	public DataResult<List<Ingredient>> getAll() {		
		return new SuccessDataResult<List<Ingredient>>(this.ingredientDao.getAll(),
																		Messages.ingredientsListed);
	}


	@Override
	public DataResult<Ingredient> getIngredientDetails(int id) {
		if(!controlOfDuplicateIngredient(new Ingredient(id, null, 0))) {
			return new ErrorDataResult<Ingredient>(null, Messages.ingredientListedFailed);
		}
		return new SuccessDataResult<Ingredient>(this.ingredientDao.getIngredientDetails(id),
																		Messages.ingredientsListed);
		
	}
	
	private boolean controlOfDuplicateIngredient(Ingredient ingredient) {
		for (var i : ingredientDao.getAll()) 
		{
			if(ingredient.getId() == i.getId())
			{
				return true;
			}
		}
		return false;
	}

}
