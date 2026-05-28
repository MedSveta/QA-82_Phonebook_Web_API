package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ContactsPage extends BasePage{
    public ContactsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory
                (driver, 10), this);
    }

    @FindBy(xpath = "//a[@href='/add']")
    WebElement btnAdd;
    @FindBy(xpath = "//button[text()='Sign Out']")
    WebElement btnSignOut;


    public boolean validateTextInBtnAdd(){
        return isTextInElementPresent(btnAdd, "ADD");
    }

    public boolean isBtnSignOutDisplayed(){
        return btnSignOut.isDisplayed();
    }
}
