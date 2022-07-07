import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends Basepage {

    By productNameLocator= new By.ByClassName("alt");
//    By productCountLocator=new By.ByClassName("quantity");
    By productCountLocator=new By.ByCssSelector("input[name=quantity]");
    By refreshButtonLocator=new By.ByCssSelector("i.fa.fa-refresh.green-icon");
    By deleteButtonLocator=new By.ByCssSelector("i.fa.fa-times.red-icon");


    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size()>0;
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }



    public  void clearQuantity(){
        WebElement quantity=webDriver.findElement(new By.ByName("quantity"));
        quantity.clear();
    }
    public  void increaseQuantity(String i){

        type(productCountLocator,i);
    }

    public  void refresh(){
        click(refreshButtonLocator);
    }

    public void deleteItem(){
        click(deleteButtonLocator);
    }


}
