package okan.proje.dataAccess.abstracts;

import java.util.List;

import okan.proje.entities.concretes.Coffee;

public interface CoffeeDao {
	
	void order(Coffee coffee);
	void add(Coffee coffee);
	void delete(Coffee coffee);
	void update(Coffee coffee);
	Coffee getCoffeeDetails(int id);
	List<Coffee> getAll();
}
