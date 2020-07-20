public class TestCalculator {

    public static void main(String[] args) {

        // =========================================== //
        // CONFIG                                      //
        // =========================================== //
        String appActivity = "com.project458.myapplication.MainActivity";
        String appPackage = "com.project458.myapplication";
        String platformVersion = "9 PKQ1.180904.001";
        String platformName = "Android";
        String deviceId = "10ca3119";
        String deviceName = "Redmi";

        Appium.getInstance().initAppium(deviceName, deviceId, platformName,
                platformVersion, appPackage, appActivity);

        TestRespondToPoll testRespondToPoll = new TestRespondToPoll();
        testRespondToPoll.testRespondToPoll();

    }

}
