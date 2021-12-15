package webElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;
import utils.Parent;
import java.util.List;

public class ElementsPage extends Parent {

    public ElementsPage(){
        PageFactory.initElements(BaseDriver.getDriver(),this);
    }

    @FindBy(id = "inputValEnter")
    WebElement searchInput;

    @FindBy(css = "button[class=\"searchformButton col-xs-4 rippleGrey\"]")
    WebElement searchBtn;

    @FindBy(css = "#products>section>div")
    List<WebElement> productList;

    @FindBy(css = "#bx-slider-left-image-panel")
    WebElement leftPanel;

    @FindBy(id = "adroll_allow_all")
    WebElement cookies;

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public WebElement getLeftPanel() {
        return leftPanel;
    }

    public WebElement getCookies() {
        return cookies;
    }
}
