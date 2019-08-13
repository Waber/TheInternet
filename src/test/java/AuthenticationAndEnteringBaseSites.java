import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import pages.AddRemovePage;
import pages.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners({ScreenShooter.class})
public class AuthenticationAndEnteringBaseSites {

    HomePage homePage = new HomePage();
    AddRemovePage addRemovePage;

    @BeforeClass
    public void setUp(){
     //   ScreenShooter.captureSuccessfulTests = true;
        WebDriverRunner.getWebDriver().manage().window().maximize();//dopiero takie ustawienie pozwala maksymalizować okno przeglądarki
    }

    @BeforeTest
    public void enterHomePage(){
        open("https://the-internet.herokuapp.com/");
    }

    @Test(enabled = false)
    public void shouldEnterAbTesting(){
        homePage.clickAbTesting();
        homePage.getParticularSitePageTitle().shouldHave(text("A/B Test Control"));
    }


    @Test(enabled = false)
    public void shouldEnterBaseAuthSite(){
        homePage.enterBasicAuth();
        homePage.getParticularSitePageTitle().shouldHave(text("Congratulations! You must have the proper credentials."));
    }

    @Test
    public void addRemoveElementSiteTest(){
        addRemovePage = new AddRemovePage();
        homePage.clickAddRemoveElement();
        for (int i = 0; i < 5; i++){
            addRemovePage.clickAddElement();
        }

        assertThat(addRemovePage.deleteElementsQuantity()).isEqualTo(5);

        addRemovePage.clickDeleElement();

        assertThat(addRemovePage.deleteElementsQuantity()).isEqualTo(4);
    }

}
