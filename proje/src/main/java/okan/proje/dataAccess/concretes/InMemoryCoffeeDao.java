package okan.proje.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import okan.proje.dataAccess.abstracts.CoffeeDao;
import okan.proje.entities.concretes.Coffee;
import okan.proje.entities.concretes.Ingredient;

public class InMemoryCoffeeDao implements CoffeeDao {
	
	private List<Coffee> coffees;
	
	public InMemoryCoffeeDao() {
		this.coffees = new ArrayList<Coffee>(
				Arrays.asList(new Coffee(1,"Espresso",17,Map.of(1,1)),
							  new Coffee(2,"Double Espresso",22,Map.of(1,2)),
							  new Coffee(3,"Cappuccino",22,Map.of(1,1,2,4)),
							  new Coffee(4,"Caffe Latte",22,Map.of(1,1,3,2,4,2)),
							  new Coffee(5,"Mocha",23,Map.of(1,1,3,2,4,1)),
							  new Coffee(6,"Americano",20,Map.of(1,1,3,1,4,1,5,2)),
							  new Coffee(7,"Hot Water",4,Map.of(2,5)))
		);
	}

	@Override
	public void order(Coffee coffee) {
		
	}

	@Override
	public void add(Coffee coffee) {
		this.coffees.add(coffee);
		
	}

	@Override
	public void delete(Coffee coffee) {
		Coffee coffeeDelete = findReferenceOfCoffee(coffee);
		
		this.coffees.remove(coffeeDelete);
		
	}

	@Override
	public void update(Coffee coffee) {
		Coffee coffeeUpdate = findReferenceOfCoffee(coffee);
		
		coffeeUpdate.setCoffeeName(coffee.getCoffeeName());
		coffeeUpdate.setIngredientsOfCoffee(coffee.getIngredientsOfCoffee());
		coffeeUpdate.setUnitPrice(coffee.getUnitPrice());
	}

	@Override
	public Coffee getCoffeeDetails(int id) {
		Coffee coffeeDetails = findReferenceOfCoffee(new Coffee(id, null, 0, null));
		return coffeeDetails ;
	}

	@Override
	public List<Coffee> getAll() {
		return this.coffees;
	}
	
	private Coffee findReferenceOfCoffee(Coffee coffee) {
		Coffee coffeeWanted = null;
		for (var c : this.coffees) 
		{
			if(coffee.getId() == c.getId())
			{
				coffeeWanted = c;
			}
		}
		return coffeeWanted;
	}

}
