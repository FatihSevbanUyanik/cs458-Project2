import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class TestSqlInjection {

    public void testSqlInjection() {
        // =================================
        // FRAGMENT ENTER
        // =================================
        Appium.sleep(2000);
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

        etNameSurname.click();
        etNameSurname.setValue("Enes Merdane");
        Appium.getDriver().hideKeyboard();

        etBirthDate.click();
        etBirthDate.setValue("02.02.1996");
        Appium.getDriver().hideKeyboard();

        etCity.click();
        etCity.setValue("Trabzon");
        Appium.getDriver().hideKeyboard();

        etText.click();
        etText.setValue("SELECT * FROM Users WHERE Id = 8R7pF2z3g6efCYolrj9d");
        Appium.getDriver().hideKeyboard();

        radioButtonMale.click();

        btnSend.click();
        Appium.sleep(5000);
    }

}
