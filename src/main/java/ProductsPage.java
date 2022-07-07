import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends Basepage{
    By productLocator= new By.ByCssSelector("a.pr-img-link");
    By productNameLocator=new By.ByClassName("name");
    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(productLocator);
    }

    public void selectProduct(int i) {
            getAllProduct().get(i).click();
    }

    private List<WebElement> getAllProduct(){
        return findAll(productLocator);
    }
}
