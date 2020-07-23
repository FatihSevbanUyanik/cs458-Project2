import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TestWrongDate {

    public void testWrongDate() {
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
        MobileElement btnBack = (MobileElement) Appium.getDriver().findElement(By.id("btnBack"));

        etNameSurname.click();
        etNameSurname.setValue("Steve Jobs");
        Appium.getDriver().hideKeyboard();

        etBirthDate.click();
        etBirthDate.setValue("Wrong Date");
        Appium.getDriver().hideKeyboard();

        etCity.click();
        etCity.setValue("Antalya");
        Appium.getDriver().hideKeyboard();

        radioButtonMale.click();

        etText.click();
        etText.setValue("Due to Corona, I would like to play kolbastı in my tomb.");
        Appium.getDriver().hideKeyboard();

        Appium.sleep(3000);
        btnBack.click();
        Appium.sleep(1000);
    }

}
