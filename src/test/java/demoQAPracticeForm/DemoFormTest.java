package demoQAPracticeForm;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class DemoFormTest {
    private WebDriver driver;
    private DemoForm demoForm;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");

        demoForm = new DemoForm(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("$('#fixedban').remove()");
        js.executeScript("$('footer').remove()");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void submitTest() {

        assertTrue(demoForm.firstNameField.isDisplayed());
        demoForm.firstNameField.sendKeys(DemoFormTestData.firstName);
        demoForm.lastNameField.sendKeys(DemoFormTestData.lastName);
        demoForm.emailField.sendKeys(DemoFormTestData.userEmail);
        demoForm.genderRadioFemale.click();
        demoForm.phoneNumberField.sendKeys(DemoFormTestData.userNumber);
        demoForm.DOBField.click();
        demoForm.datepickerBox.isDisplayed();
        demoForm.DOBField.sendKeys("placeholder", Keys.chord(Keys.COMMAND, "a"),DemoFormTestData.dateOfBirth, Keys.RETURN);
        demoForm.subjectsField.sendKeys(DemoFormTestData.subject);
        demoForm.subjectsField.sendKeys(Keys.RETURN);
        demoForm.readingHobieCheckbox.click();
        File uploadFile = new File("src/test/resources/pictures/img.png");
//        demoForm.uploadPictureField.sendKeys(uploadFile.getAbsolutePath());
//        driver.findElement(By.id("file-submit")).click();
        demoForm.addressField.sendKeys(DemoFormTestData.currentAddress);
        demoForm.selectStateField.click();
        driver.findElement(By.xpath ("//*[contains(text(),"+DemoFormTestData.state+")]")).click();
        demoForm.submitButton.click();
        demoForm.successForm.isDisplayed();


    }

}
