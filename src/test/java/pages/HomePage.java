package pages;

import com.codeborne.selenide.SelenideElement;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import util.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private JsonParser parser = new JsonParser("Available_Examples");

    //do przetestowania klasa parsująca

    private SelenideElement addRemoveSiteBtn = $(By.linkText((String) parser.getMap().get("add_remove_element")));
    private SelenideElement particularSitePageTitle = $(By.className("example"));
    private SelenideElement abTestingBtn = $(By.linkText("A/B Testing"));


    public void clickAbTesting(){
        abTestingBtn.click();
    }

    public void clickAddRemoveElement(){
        addRemoveSiteBtn.click();
    }



    public void enterBasicAuth(){
        open("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }


    public SelenideElement getParticularSitePageTitle(){
        return particularSitePageTitle;
    }


}
