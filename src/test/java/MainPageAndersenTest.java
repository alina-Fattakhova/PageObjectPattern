
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MainPageAndersenTest {

    private static WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://learn.andersenlab.com/");
    }

    @Test
    public void loginFormTest() {
        LoginPageAndersen lpa1 = new LoginPageAndersen(driver);
        MainPageAndersen mp1 = new MainPageAndersen(driver);
        lpa1.inputUsername("spiritusdentatus").inputPassword("237534096Gaz!~");
        Assert.assertFalse("Логин не был введён", driver.findElement(By.name("username")).getAttribute("value").isEmpty());
        Assert.assertEquals("Ошибка при вводе логина", "spiritusdentatus", driver.findElement(By.name("username")).getAttribute("value"));
        Assert.assertFalse("Пароль не был введён", driver.findElement(By.name("password")).getAttribute("value").isEmpty());
        Assert.assertEquals("Ошибка при вводе пароля", "237534096Gaz!~", driver.findElement(By.name("password")).getAttribute("value"));
        lpa1.clickEnter();
        Assert.assertEquals("Личный кабинет", driver.getTitle());
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}



