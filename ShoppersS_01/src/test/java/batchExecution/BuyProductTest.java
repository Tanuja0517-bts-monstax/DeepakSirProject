package batchExecution;

import org.testng.annotations.Test;

public class BuyProductTest {
	@Test(groups = "Smoke Testing")
	public void addToCart() {
		System.out.println("Executing addToCart method");
	}
	
	@Test(groups = "Smoke Testing")
	public void buyProd() {
		System.out.println("Executing buyProd method");
	}
	
	@Test(groups = "System Testing")
	public void deleteProd() {
		System.out.println("Executing deleteProd method");
	}
}
