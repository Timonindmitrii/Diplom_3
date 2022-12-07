package pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement buttonLogin = $(".button_button__33qZ0");
    SelenideElement fieldEmail = $(byXpath(".//fieldset[1]//input"));
    SelenideElement fieldPassword = $(byXpath("//input[@name = 'Пароль']"));



    @Step("Проверяю видимость кнопки Войти на форме Логина")
    public void checkVisibleButtonLogin(){
        buttonLogin.shouldBe(visible);
    }

    @Step("Нажимаю кнопку Войти на странице Логина")
    public MainPage pressButtonLogin(){
        buttonLogin.click();
        return new MainPage();
    }

    @Step("Ввожу данные в поле Email")
    public LoginPage enterEmail(String email){
        fieldEmail.setValue(email);
        return this;
    }

    @Step("Ввожу данные в поле Пароль")
    public LoginPage enterPassword(String password){
        fieldPassword.setValue(password);
        return this;
    }


}
