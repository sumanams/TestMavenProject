package helloWorld;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/suman/Downloads/chromedriver/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		Thread.sleep(1000);
		String parentWindowHandle=driver.getWindowHandle();
		
		System.out.println("Parent Window Handle: "+parentWindowHandle);
		driver.findElement(By.id("newWindowsBtn")).click();
		Set<String> windowHandles=driver.getWindowHandles();
		for (String handle: windowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				System.out.println("Child Window Handle: "+handle);
				driver.switchTo().window(handle);
				System.out.println("Child window title: "+driver.getTitle());
				driver.close();
				//System.out.println("After closing --- > Child window title: "+driver.getTitle());
			}
		}
		//driver.close();
	}

}
