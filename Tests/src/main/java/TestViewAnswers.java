import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TestViewAnswers {

    public void testViewAnswers() {

        // =================================
        // FRAGMENT ENTER
        // =================================
        MobileElement btnViewAnswers = (MobileElement) Appium.getDriver().findElement(By.id("btnViewAnswers"));
        btnViewAnswers.click();
        Appium.sleep(10000);

        // =================================
        // FRAGMENT ANSWERS
        // =================================
        MobileElement btnBack = (MobileElement) Appium.getDriver().findElement(By.id("btnBack"));
        btnBack.click();
        Appium.sleep(2000);
    }

}
