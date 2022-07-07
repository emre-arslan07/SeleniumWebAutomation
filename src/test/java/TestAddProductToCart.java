import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestAddProductToCart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    @Test
    @Order(1)
    public void searchProduct() throws FileNotFoundException {
        homePage=new HomePage(webDriver);
        productsPage=new ProductsPage(webDriver);

        homePage.searchBox().search(readFile());
        Assertions.assertTrue(productsPage.isOnProductPage(),"You are not at product page!!!");
    }
        public String readFile() throws FileNotFoundException {
            Scanner sc = new Scanner(new File("C:\\Users\\ASUS\\IdeaProjects\\SeleniumWebAutomation\\word.csv"));
            String word="";
            while (sc.hasNext()) {
                word=sc.next();
            }
        return word;
        }
    @Test
    @Order(2)
    public  void selectProduct(){
        productDetailPage=new ProductDetailPage(webDriver);
            productsPage.selectProduct(3);
            Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),"You are not at product detail page!!!");
    }

    @Test
   @Order(3)
    public  void addProductToChart(){
            productDetailPage.addToCart();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
            Assertions.assertTrue(homePage.isProductCountUp(),"Product count didn't increase!!!");
    }

    @Test
    @Order(4)
    public  void goToCart(){
        cartPage=new CartPage(webDriver);
        homePage.goToCart();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
        Assertions.assertTrue(cartPage.checkIfProductAdded(),"Product couldn't add to car!!!");

    }

    @Test
    @Order(5)
    public  void goToCartDetail(){
        homePage.goToCartDetail();
//        Assertions.assertTrue(cartPage.checkIfProductAdded(),"Product couldn't add to car!!!");


    }

    @Test
    @Order(6)
    public  void clearQuantity(){
        cartPage.clearQuantity();
    }
    @Test
    @Order(7)
    public void increaseCount(){
        cartPage.increaseQuantity(Integer.toString(2));
    }

    @Test
    @Order(8)
    public void refreshCount(){
        cartPage.refresh();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
    }

    @Test
    @Order(9)
    public  void deleteFromCart(){
        cartPage.deleteItem();
    }
}
