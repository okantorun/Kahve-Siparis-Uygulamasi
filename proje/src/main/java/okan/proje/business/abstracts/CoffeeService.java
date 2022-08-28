package okan.proje.business.abstracts;

import java.util.List;

import okan.proje.core.utilities.results.DataResult;
import okan.proje.entities.concretes.Coffee;

public interface CoffeeService {
	void order(int id);
	void add(Coffee coffee);
	void delete(Coffee coffee);
	void update(Coffee coffee);
	DataResult<Coffee> getCoffeeDetails(int id);
	DataResult<List<Coffee>> getAll();
}
