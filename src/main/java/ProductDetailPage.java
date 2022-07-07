import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends Basepage {
    By addToCartButtonLocator= By.id("button-cart");
    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }
    public void addToCart() {
        click(addToCartButtonLocator);
    }


}
