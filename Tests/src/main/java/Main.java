public class Main {

    public static void main(String[] args) {

        // ===========================================
        // CONFIG: Phone Information is needed.
        // ===========================================
        String appActivity = "com.project458.myapplication.MainActivity";
        String appPackage = "com.project458.myapplication";
        String platformVersion = "9 PKQ1.180904.001";
        String platformName = "Android";
        String deviceId = "10ca3119";
        String deviceName = "Redmi";

        Appium.getInstance().initAppium(deviceName, deviceId, platformName,
                platformVersion, appPackage, appActivity);


        // ===========================================
        // TEST 1: Respond to Poll
        // ===========================================
        TestRespondToPoll testRespondToPoll = new TestRespondToPoll();
        testRespondToPoll.testRespondToPoll();

        // ===========================================
        // TEST 2: Test Duplicate Answer
        // ===========================================
        TestDuplicateAnswer testDuplicateAnswer = new TestDuplicateAnswer();
        testDuplicateAnswer.testDuplicateAnswer();

        // ===========================================
        // TEST 3: Wrong Date
        // ===========================================
        TestWrongDate testWrongDate = new TestWrongDate();
        testWrongDate.testWrongDate();

        // ===========================================
        // TEST 4: Wrong City
        // ===========================================
        TestWrongCity testWrongCity = new TestWrongCity();
        testWrongCity.testWrongCity();

        // ===========================================
        // TEST 5: Empty Name and Text
        // ===========================================
        TestEmptyNameAndText testEmptyNameAndText = new TestEmptyNameAndText();
        testEmptyNameAndText.testEmptyNameAndText();

        // ===========================================
        // TEST 6: Test Sql Injection
        // ===========================================
        TestSqlInjection testSqlInjection = new TestSqlInjection();
        testSqlInjection.testSqlInjection();

        // ===========================================
        // TEST 7: View previous answers
        // ===========================================
        TestViewAnswers testViewAnswers = new TestViewAnswers();
        testViewAnswers.testViewAnswers();

        Appium.getDriver().closeApp();
    }

}
