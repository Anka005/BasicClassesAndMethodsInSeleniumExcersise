import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class FileUploadTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("C:/testfile.txt");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedFiles.getText(), "testfile.txt");

      //  sleep(3000);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}


