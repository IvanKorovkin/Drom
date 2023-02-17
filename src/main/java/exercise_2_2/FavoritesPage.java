package exercise_2_2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class FavoritesPage extends CarCardPage{

    private SelenideElement carName = $(By.xpath("//a[@data-role='bulletin-link']"));

    @Step("Проверка, что в Избранное добавлена верная машина")
    public void checkCarName() {
        carName.shouldBe(Condition.enabled);
    }

}
