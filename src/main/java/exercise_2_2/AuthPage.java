package exercise_2_2;

import com.codeborne.selenide.SelenideElement;
import exercise_2_1.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthPage {

    private String login = "testDrom123";
    private String password = "test123456789";

    private SelenideElement inputLogin = $(By.xpath("//input[@name='sign']"));
    private SelenideElement inputPassword = $(By.xpath("//input[@name='password']"));
    private SelenideElement entranceButton = $(By.xpath("//button[@type='submit']"));

    @Step("Ввести логин")
    public AuthPage enterLogin() {
        inputLogin.sendKeys(login);

        return this;
    }

    @Step("Ввести пароль")
    public AuthPage enterPassword() {
        inputPassword.sendKeys(password);

        return this;
    }

    @Step("Кликнуть на кнопку \"Войти\"")
    public MainPage entranceButtonClick() {
        entranceButton.click();

        return page(MainPage.class);
    }

}
