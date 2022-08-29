package okan.proje.business.concretes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okan.proje.business.abstracts.CoffeeService;
import okan.proje.business.abstracts.IngredientService;
import okan.proje.business.constants.Messages;
import okan.proje.core.utilities.results.DataResult;
import okan.proje.core.utilities.results.ErrorResult;
import okan.proje.core.utilities.results.Result;
import okan.proje.core.utilities.results.SuccessDataResult;
import okan.proje.core.utilities.results.SuccessResult;
import okan.proje.dataAccess.abstracts.CoffeeDao;
import okan.proje.entities.concretes.Coffee;
import okan.proje.entities.concretes.Ingredient;

public class CoffeeManager implements CoffeeService {
	
	private CoffeeDao coffeeDao;
	private IngredientService ingredientService;
	
	public CoffeeManager(CoffeeDao coffeeDao,IngredientService ingredientService) {
		super();
		this.coffeeDao = coffeeDao;
		this.ingredientService = ingredientService;
	}

	@Override
	public Result order(int id) {
		
		Coffee coffeeOrdered = findReferenceOfCoffee(new Coffee(id, null, 0, null));
		if(!controlOfIngredientStock(coffeeOrdered)) {
			return new ErrorResult(Messages.insufficientIngredient);
		}
		takeIngredientsOutOfStock(coffeeOrdered);
		this.coffeeDao.order(coffeeOrdered);
		return new SuccessResult(Messages.coffeeOrdered);
	}

	@Override
	public Result add(Coffee coffee) {
		
		this.coffeeDao.add(coffee);
		return new SuccessResult(Messages.coffeeAdded);
	}

	@Override
	public Result delete(Coffee coffee) {
		this.coffeeDao.delete(coffee);
		return new SuccessResult(Messages.coffeeDeleted);
		
	}

	@Override
	public Result update(Coffee coffee) {
		this.coffeeDao.update(coffee);
		return new SuccessResult(Messages.coffeeUpdated);
		
	}

	@Override
	public DataResult<Coffee> getCoffeeDetails(int id) {
				
		return new SuccessDataResult<Coffee>(this.coffeeDao.getCoffeeDetails(id),
																Messages.coffeesListed);
	}

	@Override
	public DataResult<List<Coffee>> getAll() {

		return new SuccessDataResult<List<Coffee>>
					(this.coffeeDao.getAll(),Messages.coffeesListed);
				
				
	}
	
	private boolean controlOfIngredientStock(Coffee coffee) {
		 Map<Integer, Integer> hm	= coffee.getIngredientsOfCoffee();
		
		 Iterator hmIterator = hm.entrySet().iterator();
		 while (hmIterator.hasNext()) {		 
			 
	         Map.Entry mapElement
	             = (Map.Entry)hmIterator.next();       
	         
	         int ingredientId = (int)mapElement.getKey();
	         int requiredSpecifiedIngredient = (int)mapElement.getValue();
	         int stockOfRequiredIngredient = this.ingredientService.getIngredientDetails(ingredientId).getData().getUnitInStock();
	         if(stockOfRequiredIngredient < requiredSpecifiedIngredient) {
	        	 return false;
	         }
	     }
	     
		 return true;
	}
	
	private void takeIngredientsOutOfStock(Coffee coffee) {
		 
		 String coffeeName=coffeeDao.getCoffeeDetails(coffee.getId()).getCoffeeName();
		 System.out.println("Teşekkürler kahveniz hazırlanıyor.");
		 System.out.println(coffeeName+" seçtiniz.Bu kahvenin içindekiler");
		 
		 Map<Integer, Integer> hm	= coffee.getIngredientsOfCoffee();
		 Iterator hmIterator = hm.entrySet().iterator();
		 while (hmIterator.hasNext()) {		 
			 
	         Map.Entry mapElement
	             = (Map.Entry)hmIterator.next();       
	         
	         int ingredientId = (int)mapElement.getKey();
	         int requiredSpecifiedIngredient = (int)mapElement.getValue();
	         int lastStock = this.ingredientService.getIngredientDetails(ingredientId).getData().getUnitInStock();
	         int newStock = lastStock - requiredSpecifiedIngredient;
	         this.ingredientService.getIngredientDetails(ingredientId).getData().setUnitInStock(newStock);
	         System.out.println(requiredSpecifiedIngredient+"x"+this.ingredientService.getIngredientDetails(ingredientId).
	        		 																				getData().getIngredientName());
	         
	     }
		 System.out.println("Afiyet olsun.");
	     
	}
	private Coffee findReferenceOfCoffee(Coffee coffee) {
		Coffee coffeeWanted = null;
		for (var c : coffeeDao.getAll()) 
		{
			if(coffee.getId() == c.getId())
			{
				coffeeWanted = c;
			}
		}
		return coffeeWanted;
	}

}
