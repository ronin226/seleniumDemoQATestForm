package demoQAPracticeForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoForm {
    @FindBy(css = "input#firstName")
    public WebElement firstNameField;

    @FindBy(css = "input#lastName")
    public WebElement lastNameField;

    @FindBy(css = "input#userEmail")
    public WebElement emailField;

    @FindBy(css = "[for=\"gender-radio-1\"]")
    public WebElement genderRadioMale;

    @FindBy(css = "[for=\"gender-radio-2\"]")
    public WebElement genderRadioFemale;

    @FindBy(css = "[for=\"gender-radio-3\"]")
    public WebElement genderRadioOther;

    @FindBy(css = ".react-datepicker__month-container")
    public WebElement datepickerBox;

    @FindBy(css = "input#userNumber")
    public WebElement phoneNumberField;

    @FindBy(css = "input#dateOfBirthInput")
    public WebElement DOBField;

    @FindBy(css = "#subjectsContainer input")
    public WebElement subjectsField;

    @FindBy(css ="[for=\"hobbies-checkbox-1\"]")
    public WebElement spotsHobieCheckbox;

    @FindBy(css = "[for=\"hobbies-checkbox-2\"]")
    public WebElement readingHobieCheckbox;

    @FindBy(css = "[for=\"hobbies-checkbox-3\"]")
    public WebElement musicHobieCheckbox;

    @FindBy(css = "input#uploadPicture")
    public WebElement uploadPictureField;

    @FindBy(css = "textarea#currentAddress")
    public WebElement addressField;

    @FindBy(css = "div#state")
    public WebElement selectStateField;

    @FindBy(css = "div#city")
    public WebElement selectCityField;

    @FindBy(css = "button#submit")
    public WebElement submitButton;

    @FindBy(xpath = "//*[contains(text(),\"Thanks for submitting the form\")]")
    public WebElement successForm;

    public DemoForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
