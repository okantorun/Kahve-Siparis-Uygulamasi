package okan.proje.entities.concretes;

import lombok.Data;

@Data
public class Ingredient {
	private int id;
	private String ingredientName;
	private int unitInStock;
	public Ingredient(int id, String ingredientName, int unitInStock) {
		super();
		this.id = id;
		this.ingredientName = ingredientName;
		this.unitInStock = unitInStock;
	}
}

