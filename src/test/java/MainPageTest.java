

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class MainPageTest {

    private static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://learn.andersenlab.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void logoPresence() {
        boolean logo = driver.findElement(By.xpath("//img[@title='Andersen Moodle']")).isDisplayed();
        Assert.assertEquals(logo, true);
    }

    @Test
    public void loginInput() {
        driver.findElement(By.xpath("//input[@id='username']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("spiritusdentatus");
        Assert.assertFalse("Логин не был введён", driver.findElement(By.xpath("//input[@id='username']")).getAttribute("value").isEmpty());
        Assert.assertEquals("Ошибка при вводе логина", "spiritusdentatus", driver.findElement(By.xpath("//input[@id='username']")).getAttribute("value"));
        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("237534096Gaz!~");
        Assert.assertFalse("Пароль не был введён", driver.findElement(By.xpath("//input[@id='password']")).getAttribute("value").isEmpty());
        Assert.assertEquals("Ошибка при вводе пароля", "237534096Gaz!~", driver.findElement(By.xpath("//input[@id='password']")).getAttribute("value"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.getTitle(), "Личный кабинет");

    }
    @After
    public void tearDown() {

        driver.quit();
    }
    }

