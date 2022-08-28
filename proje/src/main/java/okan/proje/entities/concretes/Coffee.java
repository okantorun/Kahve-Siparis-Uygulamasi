package okan.proje.entities.concretes;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coffee {
	private int id;
	private String coffeeName;
	private double unitPrice;
	Map<Integer, Integer> ingredientsOfCoffee;
}

