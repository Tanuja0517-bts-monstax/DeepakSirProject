package batchExecution;

import org.testng.annotations.Test;

public class CreateAccTest {
	@Test(groups = "System Testing")
	public void createAcc() {
		
	}
	
	@Test(groups = "System Testing")
	public void modicyAcc() {
		System.out.println("Executing modicyAcc method");
	}
	
	@Test(groups = "Smoke Testing")
	public void deleteAcc() {
		System.out.println("Executing deleteAcc method");
	}
}
