import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SetupClass {
    public WebDriver driver;

    public SetupClass(WebDriver driver) {

        this.driver = driver;
    }

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            driver.get("https://learn.andersenlab.com/login/index.php");
            Thread.sleep(10000);

            LoginPageAndersen lpa = PageFactory.initElements(driver, LoginPageAndersen.class);
            MainPageAndersen mpa = lpa.login("spiritusdentatus", "237534096Gaz!~");
            mpa.sendMessage();
            mpa.exitUser();
            mpa.checkGrades();
            mpa.exitGrades();
            mpa.checkDate();


        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            driver.quit();
        }
    }
}

