
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GradeReportPage {
    WebDriver driver;

    public GradeReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
