
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CoursePageAndersen {
    WebDriver driver;

    public CoursePageAndersen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
