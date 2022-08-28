package okan.proje.business.abstracts;

import java.util.List;

import okan.proje.entities.concretes.Coffee;

public interface CoffeeService {
	void order(int id);
	void add(Coffee coffee);
	void delete(Coffee coffee);
	void update(Coffee coffee);
	Coffee getCoffeeDetails(int id);
	List<Coffee> getAll();
}
