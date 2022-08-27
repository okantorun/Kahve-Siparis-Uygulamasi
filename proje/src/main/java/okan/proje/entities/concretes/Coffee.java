package okan.proje.entities.concretes;

import java.util.Map;

import lombok.Data;

@Data
public class Coffee {
	
	private int id;
	private String coffeeName;
	private double unitPrice;
	Map<Integer, Integer> ingredientsOfCoffee;
	public Coffee(int id, String coffeeName, double unitPrice, Map<Integer, Integer> ingredientsOfCoffee) {
		super();
		this.id = id;
		this.coffeeName = coffeeName;
		this.unitPrice = unitPrice;
		this.ingredientsOfCoffee = ingredientsOfCoffee;
	}
}

