package okan.proje.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
	private int id;
	private String ingredientName;
	private int unitInStock;
}

