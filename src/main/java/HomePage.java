import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.naming.directory.DirContext;

public class HomePage extends Basepage {
    SearchBox searchBox;
    By cartCountLocator= By.id("cart-items");
    By goToCartLocator=By.id("cart");
    By goToCartCheckoutLocator= new By.ByClassName("button");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        searchBox=new SearchBox(webDriver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount()>0;

    }

    public void goToCart() {
        click(goToCartLocator);
    }

    public void goToCartDetail(){
        click(goToCartCheckoutLocator);
   }
    private  int getCartCount(){
       String count= find(cartCountLocator).getText();
       return Integer.parseInt(count);
    }


}
