package exercise_2_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import exercise_2_2.AuthPage;
import exercise_2_2.CarCardPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static String baseURL = "https://auto.drom.ru/";

    private SelenideElement authButton = $(By.xpath("//a[@class='css-1h9spzo e1k6fwrt0']"));
    private SelenideElement carCard = $(By.xpath("(//a[@class='css-ynn6sc e1gtllnn0'])[2]"));
    private SelenideElement carsMarkInput = $(By.xpath("//input[@placeholder='Марка']"));
    private SelenideElement carsModelInput = $(By.xpath("//input[@placeholder='Модель']"));
    private SelenideElement fuelInput = $(By.xpath("//button[.='Топливо']"));
    private SelenideElement saleCheckBox = $(By.xpath("//label[@for='sales__filter_unsold']"));
    private SelenideElement advancedSearchButton = $(By.xpath("//span[.='Расширенный поиск']"));
    private SelenideElement mileageInput = $(By.xpath("//input[@placeholder='от, км']"));
    private SelenideElement yearInput = $(By.xpath("//button[.='Год от']"));
    private SelenideElement showButton = $(By.xpath("//div[.='Показать']"));

    public static String getBaseURL() {
        return baseURL;
    }

    @Step("Перейти на главную страницу")
    public MainPage openMainPage() {
        open(baseURL);

        return page(MainPage.class);
    }

    @Step("Кликнуть на кнопку \"Вход и регистрация\"")
    public AuthPage authButtonClick() {
        authButton.click();

        return page(AuthPage.class);
    }

    @Step("Кликнуть на первое объявление")
    public CarCardPage carCardClick() {
        carCard.click();

        return page(CarCardPage.class);
    }

    @Step("Выбрать в фильте марку Тойота")
    public MainPage chooseMark(String mark) {
        carsMarkInput.scrollIntoView(true);
        carsMarkInput.click();
        $(By.xpath("//div[@role='option' and contains(text(),'Toyota') ]")).click();

        return page(MainPage.class);
    }

    @Step("Выбрать в фильте модель Harrier")
    public MainPage chooseModel(String model) {
        carsModelInput.shouldBe(Condition.enabled);
        carsModelInput.click();
        carsModelInput.sendKeys(model);
        $(By.xpath("//div[@role='option' and contains(text(),'Harrier') ]")).click();

        return page(MainPage.class);
    }

    @Step("Выбрать гибрид")
    public MainPage chooseFuel() {
        fuelInput.shouldBe(Condition.enabled);
        fuelInput.click();
        $(By.xpath("//div[@role='option' and contains(text(),'Гибрид') ]")).click();

        return page(MainPage.class);
    }

    @Step("Активировать чек-бокс Непроданные")
    public MainPage chooseSaleCheckBox() {
        saleCheckBox.shouldBe(Condition.enabled);
        saleCheckBox.click();

        return page(MainPage.class);
    }

    @Step("Установить пробег")
    public MainPage chooseMileageOneKm(String mileage) {
        advancedSearchButton.click();
        mileageInput.sendKeys(mileage);

        return page(MainPage.class);
    }

    @Step("Установить 2007 год")
    public MainPage chooseYear() {
        yearInput.click();
        $(By.xpath("//div[@role='option' and contains(text(),'2007')]")).click();

        return page(MainPage.class);
    }

    @Step("Кликнуть кнопку Показать")
    public SearchPage clickShowButton() {
        showButton.click();

        return page(SearchPage.class);
    }

}
