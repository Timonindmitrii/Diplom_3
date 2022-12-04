package pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {


    SelenideElement fieldName = $(byXpath(".//fieldset[1]//input"));
    SelenideElement fieldEmail = $(byXpath(".//fieldset[2]//input"));
    SelenideElement fieldPassword = $(byXpath("//input[@name = 'Пароль']"));
    SelenideElement buttonRegistration = $(byXpath("//button[text() = 'Зарегистрироваться']"));
    SelenideElement errorText = $(".input__error");
    SelenideElement buttonLogin = $(byLinkText("Войти"));


    @Step("Ввожу данные в поле Имя")
    public RegistrationPage enterName(String name){
        fieldName.setValue(name);
        return this;
    }

    @Step("Ввожу данные в поле Email")
    public RegistrationPage enterEmail(String email){
        fieldEmail.setValue(email);
        return this;
    }

    @Step("Ввожу данные в поле Пароль")
    public RegistrationPage enterPassword(String password){
        fieldPassword.setValue(password);
        return this;
    }

    @Step("Нажимаю кнопку Зарегистрироваться")
    public RegistrationPage pressButtonRegistration(){
        buttonRegistration.click();
    return this;
    }

    @Step("Проверяю отображение текста ошибки о вводе неправильного пароля")
    public void checkErrorMessage(){
        errorText.shouldBe(visible);
    }

    @Step("Нажимаю на кнопку Войти на форме регистрации")
    public LoginPage pressButtonLogin(){
        buttonLogin.click();
        return new LoginPage();
    }
}
