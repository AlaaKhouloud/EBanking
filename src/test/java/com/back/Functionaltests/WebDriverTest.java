package com.back.Functionaltests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
 
@ActiveProfiles( profiles={"test"})
public class WebDriverTest extends FunctionalTest {

	@Test(priority=1)
	public void seeVirement() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='virement']")).click();
		System.out.println("click link de virement");
	}
	
	@Test(priority=2)
	public void AddVirement() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='add']")).click();
		System.out.println("click link d'ajout de virement");
		
		System.out.println("Remplissage du formulaire");
		
		Select monrib = new Select(driver.findElement(By.xpath("//*[@id='monrib']")));
		monrib.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id='ribto']")).sendKeys("XXXXIIIKKKOOO"); 
		driver.findElement(By.xpath("//*[@id='montant']")).sendKeys("53"); 
		System.out.println("Fin du remplissage du formulaire");
		test.log(LogStatus.PASS , "filled form virement");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ok']")).click();
		test.log(LogStatus.WARNING , "click ajout virement");
		System.out.println("add virement click");
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void seeRecharge() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='recharge']")).click();
		System.out.println("click link de recharge");
	}
	
	@Test(priority=4)
	public void AddRecharge() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='add']")).click();
		System.out.println("click link d'ajout de recharge");
		
		System.out.println("Remplissage du formulaire");
		Select monrib = new Select(driver.findElement(By.xpath("//*[@id='monrib']")));
		monrib.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id='tel']")).sendKeys("0652148936");
		Select montant = new Select(driver.findElement(By.xpath("//*[@id='montant']"))); 
		montant.selectByIndex(1);
		System.out.println("Fin du remplissage du formulaire");
		test.log(LogStatus.PASS , "fill to add recharge");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ok']")).click();
		test.log(LogStatus.WARNING , "click ajout recharge");
		System.out.println("add recharge click");
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void déconnexion() throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='deconnexion']")).click();
		System.out.println("click link to logout");
	}
}
