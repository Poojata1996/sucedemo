package testpkage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import base.Baseclass;
import pagepkage.Saucedemopage;
import utility.Excelutilis;



public class Saucedemotest extends Baseclass{
	@Test
	public void verifyLoginWithValidCred() throws InterruptedException
	{
		Saucedemopage p1=new Saucedemopage(driver);
		String xl="C:\\Users\\USER\\Desktop\\Luminar\\Data";
		String Sheet="Sheet2";
		int rowCount=Excelutilis.getRowCount(xl, Sheet);
		for(int i=1;i<=rowCount;i++)
		{
	
			String Username=Excelutilis.getCellValues(xl, Sheet, i, 0);
			System.out.println("username----"+Username);
			
			String Password=Excelutilis.getCellValues(xl, Sheet, i, 1);
			System.out.println("password----"+Password);
			
			
			p1.setvalues(Username, Password);
			p1.login();
			
			driver.navigate().refresh();
		}
			Thread.sleep(30);
			p1.Products();
			Thread.sleep(30);
			p1.cart();
			Thread.sleep(30);
			p1.checkoutclick();
			Thread.sleep(30);
			p1.details("Emily", "Thomas", "685509");
			Thread.sleep(30);
			p1.logout();
//			
			//driver.navigate().back();
			
			
		}
	}