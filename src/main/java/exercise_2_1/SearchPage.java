package exercise_2_1;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends MainPage{

    private List<SelenideElement> carNameTitles = $$(By.xpath("//span[@data-ftid='bull_title']"));
    private List<SelenideElement> mileages = $$(By.xpath("//span[contains(text(),' тыс. км')]"));
    private SelenideElement secondPageInPagination = $(By.xpath("//a[@data-ftid='component_pagination-item' and contains(text(),'2')]"));
    private SelenideElement firstPageInPagination = $(By.xpath("//a[@data-ftid='component_pagination-item' and contains(text(),'1')]"));

    @Step("Проверить, что нет перечеркнутого текста на первых двух страницах")
    public SearchPage testTextCarNameTitle() {

        for (SelenideElement element: carNameTitles) {
            element.shouldNotHave(cssValue("text-decoration", "line-through"));
        }

        secondPageInPagination.click();

        for (SelenideElement element: carNameTitles) {
            element.shouldNotHave(cssValue("text-decoration", "line-through"));
        }

        firstPageInPagination.click();

        return this;
    }

    @Step("Проверить, что у всех авто на первых двух страницах есть пробег")
    public SearchPage testMileages() {

        for (SelenideElement element: mileages) {
            element.shouldHave(matchText("тыс. км"));
        }

        secondPageInPagination.click();

        for (SelenideElement element: mileages) {
            element.shouldHave(matchText("тыс. км"));
        }

        return this;
    }

}
