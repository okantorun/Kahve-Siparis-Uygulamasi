package okan.proje.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import okan.proje.entities.abstracts.Entity;

@Data
@AllArgsConstructor
public class Ingredient implements Entity {
	private int id;
	private String ingredientName;
	private int unitInStock;
}

