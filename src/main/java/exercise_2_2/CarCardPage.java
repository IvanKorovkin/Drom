package exercise_2_2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CarCardPage {

    private SelenideElement favoritesButton = $(By.xpath("//div[@class='css-1b2zlcs']"));
    private SelenideElement favoritesHeader = $(By.xpath("(//a[@href='https://my.drom.ru/personal/bookmark'])[2]"));
    private SelenideElement carName = $(By.xpath("//a[@data-ga-stats-name='sidebar_model_name']"));

    @Step("Добавить в Избранное")
    public CarCardPage addFavorites() {
        favoritesButton.click();

        return this;
    }

    @Step("Перейти в Избранное")
    public FavoritesPage followToFavorites() {
        try {
            favoritesHeader.click();
        } catch (Exception e) {
            favoritesHeader.shouldBe(Condition.enabled);
            favoritesHeader.click();
        }

        return page(FavoritesPage.class);
    }

    public String getCarName() {
        String name = carName.getText();

        return name;
    }

}
