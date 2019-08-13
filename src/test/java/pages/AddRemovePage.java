package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddRemovePage {

    private SelenideElement addElementBtn = $(By.cssSelector("#content > div > button"));
    private ElementsCollection deleteElementBtn = $$(By.className("added-manually"));

    public void clickAddElement(){
        addElementBtn.click();
    }

    public int deleteElementsQuantity(){
        return deleteElementBtn.size();
    }

    public void clickDeleElement(){
        deleteElementBtn.get(deleteElementsQuantity() - 1).click();
    }
}
