package pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    SelenideElement buttonLogin = $(byLinkText("Войти"));

    @Step("Нажимаю на кнопку Войти на странице восстановления пароля")
    public LoginPage pressButtonLogin(){
        buttonLogin.click();
        return new LoginPage();
    }
}
