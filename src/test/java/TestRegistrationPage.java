import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.LoginPage;
import pom.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static test_data.TestData.*;

@DisplayName("Тесты страницы регистрации")
public class TestRegistrationPage {
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @Before
    @Step ("Открываю ссылку на странице регистрации")
    public void setupRegistrationPage(){
        // DriverSetup.getYandexDriver();
        registrationPage = new RegistrationPage();
        loginPage = new LoginPage();
        open(REGISTER);
    }

    @After
    @DisplayName("Закрываю драйвер для следующих тестов")
    public void closeDriver(){
        closeWebDriver();
    }

    @Test
    @DisplayName("Регестрирую пользователя с корректными данными")
    @Description("Ввожу рандомные данные почты и пароля с корректной длинной полей")
    public void registrationUserPositiveTest(){
        registrationPage.enterName(NAME)
                        .enterEmail(randomEmail)
                        .enterPassword(randomCorrectPassword)
                        .pressButtonRegistration();

        loginPage.checkVisibleButtonLogin();
    }

    @Test
    @DisplayName("Регестриурю пользователя с некорректным паролем")
    @Description("Ввожу рандомные данные почты и пароля, а пароль некорректной длинны")
    public void registrationUserNegativeTest(){
        registrationPage.enterName(NAME)
                        .enterEmail(randomEmail)
                        .enterPassword(randomIncorrectPassword)
                        .pressButtonRegistration()

                        .checkErrorMessage();
    }

}
