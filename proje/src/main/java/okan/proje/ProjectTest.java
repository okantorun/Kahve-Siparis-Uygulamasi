package okan.proje;

import static org.junit.Assert.*; 

import java.util.Map;
import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import okan.proje.business.abstracts.CoffeeService;
import okan.proje.business.abstracts.IngredientService;
import okan.proje.business.concretes.CoffeeManager;
import okan.proje.business.concretes.IngredientManager;
import okan.proje.dataAccess.concretes.InMemoryCoffeeDao;
import okan.proje.dataAccess.concretes.InMemoryIngredientDao;
import okan.proje.entities.concretes.Coffee;
import okan.proje.entities.concretes.Ingredient;

import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectTest {
	IngredientService ingredientService = new IngredientManager(new InMemoryIngredientDao());
	CoffeeService coffeeService = new CoffeeManager(new InMemoryCoffeeDao(),ingredientService);
	int coffeeNumber;
	
	
	@Test
	public void aTestGetAllIngredients() {
		
		System.out.println("Malzemelerin listesi:");
		for (var ingredient : ingredientService.getAll().getData()) {
			System.out.println(ingredient);
		}
		System.out.println("----------");
		
	}
	
	@Test
	public void bTestGetAllCoffees() {
		
		for (var coffee : coffeeService.getAll().getData()) {
			System.out.println(coffee.getId()+"."+coffee.getCoffeeName()+"("+coffee.getUnitPrice()+")");
		}
		System.out.println("Lütfen içmek istediğiniz kahvenin numarasını giriniz:");
		System.out.println("4");
		
	}
	
	@Test
	public void cTestOrderAndGetAllCurrentIngredients() {
		System.out.println("----------------");
		coffeeService.order(4);
		testGetAllCurrentIngredients();
		testGetAllCoffees();
		testOrder2();
		updateIngredient();
		currentIngredient();
		testGetAllCoffees();
		testOrder2();
		currentIngredient();
		addNewIngredient();
		testGetAllCurrentIngredients();
		addNewCoffee();
		testGetAllCoffees();
		testOrder3();
		testGetAllCurrentIngredients();
		deleteCoffee();
		testGetAllCoffees();
		updateCoffee();
		testGetAllCoffees();
		testOrder4();
		
	}
	
	public void testGetAllCurrentIngredients() {
		System.out.println("----------");
		System.out.println("Malzemelerin güncel listesi:");
		for (var ingredient : ingredientService.getAll().getData()) {
			System.out.println(ingredient);
		}
	}
	
	public void testGetAllCoffees() {
		System.out.println("-------------");
		for (var coffee : coffeeService.getAll().getData()) {
			System.out.println(coffee.getId()+"."+coffee.getCoffeeName()+"("+coffee.getUnitPrice()+")");
		}
		System.out.println("Lütfen içmek istediğiniz kahvenin numarasını giriniz:");
	
	}
	
	public void testOrder2() {
		System.out.println("1");
		System.out.println("----------------");
		coffeeService.order(1);
	}
	
	public void testOrder3() {
		System.out.println("8");
		System.out.println("----------------");
		coffeeService.order(8);
	}
	
	public void testOrder4() {
		System.out.println("4");
		System.out.println("----------------");
		coffeeService.order(4);
	}
	
	public void updateIngredient() {
		System.out.println("----------------");
		System.out.println("Malzeme stok adedi güncellendi.");
		ingredientService.update(new Ingredient(1, "Espresso", 5));
	}
	public void currentIngredient() {
		System.out.println("----------------");
		System.out.println(ingredientService.getIngredientDetails(1).getData());
		
	}
	public void addNewIngredient() {
		System.out.println("----------------");
		System.out.println("Sisteme yeni malzeme eklendi");
		ingredientService.add(new Ingredient(6, "White Chocolate", 10));
	}
	
	public void addNewCoffee() {
		System.out.println("----------------");
		System.out.println("Sisteme yeni kahve eklendi");
		coffeeService.add(new Coffee(8, "White Chocolate Mocha", 30, Map.of(1,1,3,3,4,2,6,4) ));
	}
	
	public void deleteCoffee() {
		System.out.println("----------------");
		System.out.println("Sistemden 8 numaralı kahve silindi");
		coffeeService.delete(new Coffee(8, "White Chocolate Mocha", 30, Map.of(1,1,3,3,4,2,6,4)));
	}
	
	public void updateCoffee() {
		System.out.println("----------------");
		System.out.println("4 numaralı kahvenin malzemeleri güncellendi");
		coffeeService.update(new Coffee(4, "Cappuccino", 22, Map.of(1,2,4,3)));
	}
	
	public void testAdding3() {
		for (var coffee : coffeeService.getAll().getData()) {
			System.out.println(coffee.getId()+"."+coffee.getCoffeeName()+"("+coffee.getUnitPrice()+")");
		}
	}
}
