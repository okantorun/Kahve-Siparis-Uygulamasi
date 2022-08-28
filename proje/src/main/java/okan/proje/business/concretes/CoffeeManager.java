package okan.proje.business.concretes;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okan.proje.business.abstracts.CoffeeService;
import okan.proje.business.abstracts.IngredientService;
import okan.proje.dataAccess.abstracts.CoffeeDao;
import okan.proje.entities.concretes.Coffee;

public class CoffeeManager implements CoffeeService {
	
	private CoffeeDao coffeeDao;
	private IngredientService ingredientService;
	
	public CoffeeManager(CoffeeDao coffeeDao,IngredientService ingredientService) {
		super();
		this.coffeeDao = coffeeDao;
		this.ingredientService = ingredientService;
	}

	@Override
	public void order(int id) {
		
		Coffee coffeeOrdered = findReferenceOfCoffee(new Coffee(id, null, 0, null));
		if(!controlOfIngredientStock(coffeeOrdered)) {
			System.out.println("İstediğiniz ürün için gerekli olan malzemeler yetersizdir.Lütfen başka ürün seçiniz.");
			return;
		}
		takeIngredientsOutOfStock(coffeeOrdered);
		this.coffeeDao.order(coffeeOrdered);
	}

	@Override
	public void add(Coffee coffee) {
		
		this.coffeeDao.add(coffee);
	}

	@Override
	public void delete(Coffee coffee) {
		this.coffeeDao.delete(coffee);
		
	}

	@Override
	public void update(Coffee coffee) {
		this.coffeeDao.update(coffee);
		
	}

	@Override
	public Coffee getCoffeeDetails(int id) {
		
		return this.getCoffeeDetails(id);
	}

	@Override
	public List<Coffee> getAll() {

		return this.coffeeDao.getAll();
	}
	
	private boolean controlOfIngredientStock(Coffee coffee) {
		 Map<Integer, Integer> hm	= coffee.getIngredientsOfCoffee();
		
		 Iterator hmIterator = hm.entrySet().iterator();
		 while (hmIterator.hasNext()) {		 
			 
	         Map.Entry mapElement
	             = (Map.Entry)hmIterator.next();       
	         
	         int ingredientId = (int)mapElement.getKey();
	         int requiredSpecifiedIngredient = (int)mapElement.getValue();
	         int stockOfRequiredIngredient = this.ingredientService.getIngredientDetails(ingredientId).getUnitInStock();
	         if(stockOfRequiredIngredient < requiredSpecifiedIngredient) {
	        	 return false;
	         }
	     }
	     
		 return true;
	}
	
	private void takeIngredientsOutOfStock(Coffee coffee) {
		Map<Integer, Integer> hm	= coffee.getIngredientsOfCoffee();
		
		 Iterator hmIterator = hm.entrySet().iterator();
		 while (hmIterator.hasNext()) {		 
			 
	         Map.Entry mapElement
	             = (Map.Entry)hmIterator.next();       
	         
	         int ingredientId = (int)mapElement.getKey();
	         int requiredSpecifiedIngredient = (int)mapElement.getValue();
	         int lastStock = this.ingredientService.getIngredientDetails(ingredientId).getUnitInStock();
	         int newStock = lastStock - requiredSpecifiedIngredient;
	         this.ingredientService.getIngredientDetails(ingredientId).setUnitInStock(newStock);
	         System.out.println(requiredSpecifiedIngredient+"x"+this.ingredientService.getIngredientDetails(ingredientId).getIngredientName());
	         
	     }
	     
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
