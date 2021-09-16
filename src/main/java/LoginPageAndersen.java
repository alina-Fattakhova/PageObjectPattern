import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAndersen {
    private WebDriver driver;

    @FindBy(xpath = "/html/head/title")
    private WebElement title;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement enterButton;


    public LoginPageAndersen(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LoginPageAndersen inputUsername(String userName) {
        username.sendKeys(userName);
        return this;
    }

    public LoginPageAndersen inputPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public MainPageAndersen clickEnter() {
        this.enterButton.click();
        return new MainPageAndersen(driver);
    }


    public MainPageAndersen login(String userName, String password) {
        this.inputUsername(userName);
        this.inputPassword(password);
        this. clickEnter();
        return new MainPageAndersen(driver);

    }

    public MainPageAndersen getTitle() {
        this.title.click();
        return new MainPageAndersen(driver);
    }

    boolean atPage() {
        if(driver.getTitle().equals("Автоматизация на JAVA для начинающих: Личные данные: Алина Фатахова")) {
            return true;
        }else{
            return false;
        }
    }
}
