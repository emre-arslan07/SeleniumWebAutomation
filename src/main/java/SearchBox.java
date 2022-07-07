import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends Basepage {

    By searchBoxLocator = new By.ByCssSelector("input#search-input");
    By submitButtonLocator=new By.ByCssSelector("span.common-sprite.button-search");
    public SearchBox(WebDriver webDriver) {
        super(webDriver);
    }

    public void search(String text) {
        type(searchBoxLocator,text);
        click(submitButtonLocator);
    }
}
