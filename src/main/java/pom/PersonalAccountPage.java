package pom;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {

    SelenideElement buttonExit = $(byXpath(".//button[text()='Выход']"));
    SelenideElement buttonConstructor = $(byLinkText("Конструктор"));
    SelenideElement logo = $(".AppHeader_header__logo__2D0X2");

    @Step("Проверяю доступность кнопки Выход в личном кабинете")
    public void checkButtonExitEnabled(){
        buttonExit.shouldBe(enabled);
    }

    @Step("Нажимаю на кнопку Выход")
    public LoginPage pressButtonExit(){
        buttonExit.click();
        return new LoginPage();
    }

    @Step("Нажимаю на кнопку Конструктор из Личного кабинета")
    public MainPage pressButtonConstructor() {
        buttonConstructor.click();
        return new MainPage();
    }

    @Step("Нажимаю на Лого из Личного кабинета")
    public MainPage pressLogo() {
        logo.click();
        return new MainPage();
    }

}
