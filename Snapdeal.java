package week4day1;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	public static void main(String[] args) throws InterruptedException , IOException {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[@class='catText']")).click();
		
		driver.findElement(By.xpath("//span[@class='linkTest']")).click();
		
		 
		String text = driver.findElement(By.xpath("//div[@class='child-cat-count ']")).getText();
		System.out.println(text);
		
	    driver.findElement(By.xpath("//div[text()='Training Shoes' ]")).click();
	    
	    driver.findElement(By.xpath(" //span[@class='sort-label']")).click();
	    
	    driver.findElement(By.xpath("//li[@class='search-li']")).click();
	    WebElement fromVal = driver.findElement(By.xpath("//input[@name='fromVal']"));
	    fromVal.clear();
	    fromVal.sendKeys("900");
	    WebElement toVal = driver.findElement(By.xpath("//input[@name='toVal']"));
	    toVal.clear();
	    toVal.sendKeys("1200");
	    driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//button[@class='clear-all-filters  btn-theme-secondary btn-line btn']")).click();
	    
	 
	    //filter with Navy
	    driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label")).click();
	    //check all filters
	    String Ctag = driver.findElement(By.xpath("//a[contains(text(),'Navy')]")).getText();
	    System.out.println(Ctag);
	    if(Ctag.contains("Navy")) {
	    	System.out.println("NAVY COLOR");
	    }
	    else {
	    	System.out.println("other colour");
	    }
	    //mousehover on first element
	    
	    WebElement firstshoe= driver.findElement(By.xpath("//p[@class='product-title'][1]"));
	    
	    //QuickView button
	    driver.findElement(By.xpath("//div[@class='clearfix row-disc']")).click();
	    //cost and discount
	    String rupees= driver.findElement(By.xpath("//span[@class='lfloat product-price'][1]")).getText();
	    System.out.println("rupees");
	    String discount= driver.findElement(By.xpath("//div[@class='product-discount'][1]")).getText();
	    System.out.println("discount");
	    //screenshot
	    File ScreenshotAs = driver.getScreenshotAs(OutputType.FILE);
	    File target= new File("./report/img.png");
	    FileUtils.copyFile(ScreenshotAs, target);
	    System.out.println("clicked snapshot");
	    driver.close();
	    driver.quit();
	}
	
}
	   
	    
	    
		
	    
	    
	    
	
	    

	

	



