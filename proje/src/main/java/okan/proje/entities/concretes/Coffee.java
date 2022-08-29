package okan.proje.entities.concretes;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import okan.proje.entities.abstracts.Entity;

@Data
@AllArgsConstructor
public class Coffee implements Entity {
	private int id;
	private String coffeeName;
	private double unitPrice;
	Map<Integer, Integer> ingredientsOfCoffee;
}

