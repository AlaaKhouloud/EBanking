package com.back.Functionaltests;

import org.openqa.selenium.By;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;
 
@ActiveProfiles( profiles={"test"})
public class WebDriverTest extends FunctionalTest {

	/*@Test(priority=1)
	public void linkText() {
		driver.findElement(By.linkText("Images")).click();
		System.out.println("click img hyperlink");
	}
	
	@Test(priority=2)
	public void cleark() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.name("q")).clear();
		System.out.println("clear search");
	}*/
}
