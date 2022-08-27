package okan.proje.dataAccess.concretes;

import java.util.List;

import okan.proje.dataAccess.abstracts.CoffeeDao;
import okan.proje.entities.concretes.Coffee;

public class InMemoryCoffeeDao implements CoffeeDao {

	@Override
	public void order(Coffee coffee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Coffee coffee) {
		System.out.println("Eklendi " + coffee.getCoffeeName());
		
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
