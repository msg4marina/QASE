import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    String user, password;

    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = PropertyReader.getProperty("QASE_URL","qase.url");
        user = System.getenv().getOrDefault("QASE_USER", PropertyReader.getProperty("qase.user"));
        password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));

        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.headless = Boolean.getBoolean(PropertyReader.getProperty("headledd"));
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        /*ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--disable-popup-blocking");
       Configuration.browserCapabilities = new ChromeOptions();*/
    }

    @AfterClass(alwaysRun = true)
    public void tearDown( ) {
        getWebDriver().quit();
    }
}


