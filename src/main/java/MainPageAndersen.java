
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageAndersen {
    WebDriver driver;
    LoginPageAndersen lpa;
    @FindBy(xpath = "/html/head/title")
    private WebElement mainTitle;
    @FindBy(xpath = "//i[@title='Переключить меню сообщений']")
    private WebElement messageMenu;
    @FindBy(xpath = "//strong[text()='Алина Фаттахова']")
    private WebElement alinaFattakhova;
    @FindBy(xpath = "//span[@class='text-truncate'][contains(text(),'Автоматизация на JAVA для начинающих')]")
    private WebElement aqaCourse;
    @FindBy(xpath = "//span[@class='text m-l-0'][contains(text(),'Оценки')]")
    private WebElement grades;
    @FindBy(xpath = "//a[@title='Обзорный отчет']")
    private WebElement report;
    @FindBy(xpath = "//span[contains(text(),'Календарь')]")
    private WebElement calendar;
    @FindBy(xpath = "//a[@title='ДЗ к лекции 14. - надо сдать']")
    private WebElement toPass;
    @FindBy(xpath = "//a[@id='action-menu-toggle-1']")
    private WebElement userMenu;
    @FindBy(xpath = "//div[@id='action-menu-1-menu']/a[7]")
    private WebElement exit;

    public MainPageAndersen(WebDriver driver) {
        this.driver = driver;
        lpa = new LoginPageAndersen(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPageAndersen sendMessage() {
        this.messageMenu.click();
        this.alinaFattakhova.click();
        return this;
    }

    public CoursePageAndersen goToAutomationCourse() {
        this.aqaCourse.click();
        return new CoursePageAndersen(driver);

    }

    public GradeReportPage checkGrades() {
        this.goToAutomationCourse();
        this.grades.click();
        this.report.click();
        return new GradeReportPage(driver);
    }
    public LoginPageAndersen exitUser(){
        this.userMenu.click();
        this.exit.click();
        return new LoginPageAndersen(driver);
    }
    public LoginPageAndersen exitGrades(){
        this.checkGrades();
        this.userMenu.click();
        this.exit.click();
        return new LoginPageAndersen(driver);

    }

    public CalendarPage checkDate() {
        this.goToAutomationCourse();
        this.calendar.click();
        this.toPass.click();
        return new CalendarPage(driver);
    }
}
