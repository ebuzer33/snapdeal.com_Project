package testNgPages;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.Parent;
import webElements.ElementsPage;
import java.util.Set;

public class Test_1 extends BaseDriver {

    ElementsPage ep =new ElementsPage();

    @Test
    public void test1(){

        getDriver().get("https://www.snapdeal.com");

        String firstUrl=getDriver().getCurrentUrl();

        String mainWindow =getDriver().getWindowHandle();

        ep.sendKeysFunction(ep.getSearchInput(),"watch");
        ep.clickFunction(ep.getSearchBtn());

        String secondUrl=getDriver().getCurrentUrl();

        Assert.assertNotEquals(firstUrl,secondUrl);

        ep.randomClick(ep.getProductList());

        Set<String> windowIds = getDriver().getWindowHandles();

        for (String id:windowIds) {

            if (id.equals(mainWindow))
                continue;

            getDriver().switchTo().window(id);
        }

        ep.clickFunction(ep.getCookies());

        String lastUrl =getDriver().getCurrentUrl();

        Assert.assertNotEquals(secondUrl,lastUrl);

        ep.moveTheMouse(ep.getLeftPanel(), 0,0);
        Parent.waiting(1);
        ep.moveTheMouse(ep.getLeftPanel(),60,60);
        Parent.waiting(1);
        ep.moveTheMouse(ep.getLeftPanel(),80,-80);
        Parent.waiting(1);
        ep.moveTheMouse(ep.getLeftPanel(),-80,-80);
        Parent.waiting(1);
        ep.moveTheMouse(ep.getLeftPanel(),-80,80);
    }
}
