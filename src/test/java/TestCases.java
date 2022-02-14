import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases{

    protected static WebDriver driver;
    public static final String URL="https://www.enuygun.com";
    static MainPage mainPage;
    @BeforeAll
    public static void openWindow(){
        System.out.println("BeforeAll()");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        mainPage=new MainPage(driver);
    }

    @Test
    @Order(1)
    public void setRoute(){
        System.out.println("TESTCASE: SetRoute");
        mainPage.setFrom("Elazig");
        mainPage.setTo("Istanbul");
    }

    @Test
    @Order(2)
    public void setDates(){
        System.out.println("TESTCASE: SetDates");
        mainPage.setDepartOn("Salı","1","Mart","2022");
	    mainPage.setReturnOn("Salı","8","Mart","2022");
    }

    @Test
    @Order(3)
    public void enableTransitFilter(){
        System.out.println("TESTCASE: EnableTransitFilter");
	mainPage.enableTransitFilter();
    }

    @Test
    @Order(4)
    public void setPassengerCountAndClass(){
        System.out.println("TESTCASE: SetPassengerCountAndTıcketClass");
        MainPage mainPage=new MainPage(driver);
	    mainPage.setPassengerCountAndClass(1,"1","1");
    }

    @Test
    @Order(5)
    public void clickOnSearchButton(){
        System.out.println("TESTCASE: ClickOnrSearchButtonAndCheck");
       	mainPage.clickOnSearchButton();
    }

    @AfterAll
    public static void closeWindow(){
        driver.quit();
    }

}
