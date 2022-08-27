package okan.proje;

import java.util.HashMap;
import java.util.Map;

import okan.proje.business.abstracts.CoffeeService;
import okan.proje.business.concretes.CoffeeManager;
import okan.proje.dataAccess.concretes.InMemoryCoffeeDao;
import okan.proje.entities.concretes.Coffee;

public class Main {

	public static void main(String[] args) {
		
		CoffeeService coffeeService = new CoffeeManager(new InMemoryCoffeeDao());
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(1, 2);
		hm.put(2, 3);
		Coffee coffee = new Coffee(1,"Espresso",17,hm);
		coffeeService.add(coffee);

	}

}
