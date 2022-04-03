import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TestCalcul {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenin\\Documents\\chromedriver_win32_selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @FindBy(xpath = "//input[@aria-label=\"Найти\"]")
    private WebElement searchInput;

    @FindBy(id = "cwos")
    private WebElement result;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/span")
    private WebElement example;

    //1
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[1]/div/div")
    private WebElement b1;
    //*
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[3]/td[4]/div/div")
    private WebElement bm;
    //2
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[2]/div/div")
    private WebElement b2;
    //-
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[4]/div/div")
    private WebElement bmin;
    //3
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[4]/td[3]/div/div")
    private WebElement b3;
    //+
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[4]/div/div")
    private WebElement bp;
    //=
    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/div[3]/div/table[2]/tbody/tr[5]/td[3]/div/div")
    private WebElement be;

    public void setInput(String strSearchInput) {
        searchInput.sendKeys(strSearchInput, Keys.RETURN);
    }

    public void waitCatpcha() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void task1() {
        b1.click();
        bm.click();
        b2.click();
        bmin.click();
        b3.click();
        bp.click();
        b1.click();
        be.click();
    }

    @Test
    public void testCalc() {
        driver.get("http://google.com");
        setInput("калькулятор");
//        как обходить гугл каптчу я не знаю
        waitCatpcha();
//        1 * 2 - 3 + 1
        task1();

        Assert.assertEquals("ok", result.getAttribute("textContent"), "0");
        Assert.assertEquals("ok", example.getAttribute("textContent"), "1 × 2 - 3 + 1 =");

    }
}
