package okan.proje.business.abstracts;

import java.util.List;

import okan.proje.core.utilities.results.DataResult;
import okan.proje.core.utilities.results.Result;
import okan.proje.entities.concretes.Coffee;

public interface CoffeeService {
	Result order(int id);
	Result add(Coffee coffee);
	Result delete(Coffee coffee);
	Result update(Coffee coffee);
	DataResult<Coffee> getCoffeeDetails(int id);
	DataResult<List<Coffee>> getAll();
}
