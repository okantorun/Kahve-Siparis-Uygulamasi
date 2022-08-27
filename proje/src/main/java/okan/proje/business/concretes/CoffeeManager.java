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
	public void order(Coffee coffee) {
	 
		if(!controlOfIngredientStock(coffee)) {
			System.out.println("İstediğiniz ürün için gerekli olan malzemeler yetersizdir.Lütfen başka ürün seçiniz.");
		}
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
	         if(stockOfRequiredIngredient < requiredSpecifiedIngredient) 
	        	 return false;
	     }
	     
		 return true;
	}

}
