import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class CheckBoxesTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
    }

    @Test
    public void checkboxesTest() throws InterruptedException {
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

        assertFalse(firstCheckbox.isSelected());
        assertTrue(secondCheckbox.isSelected());

     //   sleep(2000);

        firstCheckbox.click();
        secondCheckbox.click();

        assertTrue(firstCheckbox.isSelected());
        assertFalse(secondCheckbox.isSelected());

     //   sleep(2000);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
