package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ScreenShotWithCurrentDate {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Ehab Alking\\Desktop\\QA\\myWebDriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		Date currentDate = new Date();
		String newCurrent = currentDate.toString().replace(":", "-");
		driver.get("http://127.0.0.1:5500/Automation_Test_Screenshot/index.html");

		TakesScreenshot src = ((TakesScreenshot) driver);
		File srcFile = src.getScreenshotAs((OutputType.FILE));
		File dest = new File("./myPicture/"+newCurrent+".png");
		FileUtils.copyFile(srcFile, dest);

	}

}
