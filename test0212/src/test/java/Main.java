import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class Main {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public static void beforeClass() {
        String path=String.format("%s/driver/chromedriver.exe",System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver",path);
    }

    @Before
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //driver.manage().window().maximize();//увеличивает окно браузера
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));//ожидание подгрузки для каждого элемента
    }



    @Test
    public void testHillelAuto() throws InterruptedException { //throws InterruptedException используется для задержки потока Thread.sleep(2000);

        driver.get("https://guest:welcome2qauto@qauto.forstudy.space/");

        //1. Создать пользователя
        driver.findElement(By.xpath("//button[@class='hero-descriptor_btn btn btn-primary']")).click();
        driver.findElement(By.id("signupName")).sendKeys("Helen");
        driver.findElement(By.id("signupLastName")).sendKeys("Kuts");
        driver.findElement(By.id("signupEmail")).sendKeys("rt689141y@yu.tu");
        driver.findElement(By.id("signupPassword")).sendKeys("!12345Qq");
        driver.findElement(By.id("signupRepeatPassword")).sendKeys("!12345Qq");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);

        //2. Добавить ему автомобиль
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        Select selectBrand = new Select(driver.findElement(By.id("addCarBrand")));
        selectBrand.selectByIndex(1);           // выбирает option = Two по значению
        Select selectModel = new Select(driver.findElement(By.id("addCarModel")));
        selectModel.selectByIndex(2);
        Thread.sleep(2000);
        driver.findElement(By.id("addCarMileage")).sendKeys("0");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Add\"]"))).click();

        //3. Добавить ему два расхода
        String[] expenseOne={"1","10","11"};
        String[] expenseTwo={"2","20","21"};

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='car_add-expense btn btn-success']"))).click();
        driver.findElement(By.xpath("//input[@id='addExpenseMileage']")).clear();
        driver.findElement(By.xpath("//input[@id='addExpenseMileage']")).sendKeys(expenseOne[0]);
        driver.findElement(By.xpath("//input[@id='addExpenseLiters']")).sendKeys(expenseOne[1]);
        driver.findElement(By.xpath("//input[@id='addExpenseTotalCost']")).sendKeys(expenseOne[2]);
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add an expense']"))).click();
        driver.findElement(By.xpath("//input[@id='addExpenseMileage']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='addExpenseMileage']")).sendKeys(expenseTwo[0]);
        driver.findElement(By.xpath("//input[@id='addExpenseLiters']")).sendKeys(expenseTwo[1]);
        driver.findElement(By.xpath("//input[@id='addExpenseTotalCost']")).sendKeys(expenseTwo[2]);
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();

        //4. Проверить что расходы добавились
        String expectedExpenseOne=expenseOne[0]+" "+expenseOne[1]+"L"+" "+expenseOne[2]+".00 USD";
        String expectedExpenseTwo=expenseTwo[0]+" "+expenseTwo[1]+"L"+" "+expenseTwo[2]+".00 USD";

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tbody")));

        List <WebElement> elements=driver.findElements(By.xpath("//td"));
        String actualExpenseOne=elements.get(6).getText()+" "+elements.get(7).getText()+" "+elements.get(8).getText();
        String actualExpenseTwo=elements.get(1).getText()+" "+elements.get(2).getText()+" "+elements.get(3).getText();
        Assert.assertEquals("Wrong expense one", expectedExpenseOne, actualExpenseOne);
        Assert.assertEquals("Wrong expense two", expectedExpenseTwo, actualExpenseTwo);

        //5. Удалить пользователя
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='userNavDropdown']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@routerlink='/panel/settings']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger-bg']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-danger']"))).click();

    }


    @After
    public void after() {
        driver.quit(); //закроет окно браузера после выполнения теста

    }


}
