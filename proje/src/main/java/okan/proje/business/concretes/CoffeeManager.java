package okan.proje.business.concretes;

import java.util.List;

import okan.proje.business.abstracts.CoffeeService;
import okan.proje.dataAccess.abstracts.CoffeeDao;
import okan.proje.entities.concretes.Coffee;

public class CoffeeManager implements CoffeeService {
	
	private CoffeeDao coffeeDao;
	public CoffeeManager(CoffeeDao coffeeDao) {
		super();
		this.coffeeDao = coffeeDao;
	}

	@Override
	public void order(Coffee coffee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Coffee coffee) {
		
		this.coffeeDao.add(coffee);
	}

	@Override
	public void delete(Coffee coffee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Coffee coffee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Coffee getCoffeeDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coffee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
