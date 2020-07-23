import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TestRespondToPoll {

    public void testRespondToPoll() {
        // =================================
        // FRAGMENT ENTER
        // =================================
        MobileElement btnAttendPoll = (MobileElement) Appium.getDriver().findElement(By.id("btnAttendPoll"));
        btnAttendPoll.click();
        Appium.sleep(2000);

        // =================================
        // FRAGMENT POLL
        // =================================
        MobileElement etNameSurname = (MobileElement) Appium.getDriver().findElement(By.id("etNameSurname"));
        MobileElement etBirthDate = (MobileElement) Appium.getDriver().findElement(By.id("etBirthDate"));
        MobileElement etCity = (MobileElement) Appium.getDriver().findElement(By.id("etCity"));
        MobileElement etText = (MobileElement) Appium.getDriver().findElement(By.id("etText"));
        MobileElement radioButtonMale = (MobileElement) Appium.getDriver().findElement(By.id("radioButtonMale"));
        MobileElement radioButtonFemale = (MobileElement) Appium.getDriver().findElement(By.id("radioButtonFemale"));
        MobileElement btnSend = (MobileElement) Appium.getDriver().findElement(By.id("btnProceed"));

        etNameSurname.setValue("Steve Jobs");
        etBirthDate.setValue("09.08.2019");
        etCity.setValue("Trabzon");
        etText.setValue("Due to Corona, I would like to play kolbastı in my tomb.");
        radioButtonMale.click();

        btnSend.click();
        Appium.sleep(3000);
    }

}
