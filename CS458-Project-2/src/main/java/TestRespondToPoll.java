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
        // FRAGMENT CREDENTIAL
        // =================================
        MobileElement etNameSurname = (MobileElement) Appium.getDriver().findElement(By.id("etNameSurname"));
        MobileElement etBirthDate = (MobileElement) Appium.getDriver().findElement(By.id("etBirthDate"));
        MobileElement etCity = (MobileElement) Appium.getDriver().findElement(By.id("etCity"));
        MobileElement radioButtonFemale = (MobileElement) Appium.getDriver().findElement(By.id("radioButtonFemale"));
        MobileElement btnProceed = (MobileElement) Appium.getDriver().findElement(By.id("btnProceed"));
        etNameSurname.setValue("Fatih Sevban Uyanik");
        etBirthDate.setValue("09.08.2019");
        etCity.setValue("Ankara");
        radioButtonFemale.click();
        btnProceed.click();
        Appium.sleep(2000);

        // =================================
        // FRAGMENT POLL
        // =================================
        MobileElement etPoll = (MobileElement) Appium.getDriver().findElement(By.id("editTextTextMultiLine"));
        MobileElement btnSend = (MobileElement) Appium.getDriver().findElement(By.id("btnSend"));
        etPoll.setValue("Geberiyorum artık. Dışarı çıkasım var !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        btnSend.click();
    }

}
