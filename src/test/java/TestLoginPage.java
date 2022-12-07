
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.ForgotPasswordPage;
import pom.LoginPage;
import pom.MainPage;
import pom.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static test_data.TestData.*;

@DisplayName("Тесты страницы логина")

public class TestLoginPage {
    RegistrationPage registrationPage;
    LoginPage loginPage;
    MainPage mainPage;
    ForgotPasswordPage forgotPasswordPage;


    @Before
    public void setupLogin(){
       // DriverSetup.getYandexDriver();
        mainPage = new MainPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        forgotPasswordPage = new ForgotPasswordPage();

    }

    @After
    @DisplayName("Закрываю драйвер для следующих тестов")
    public void exit(){
        closeWebDriver();
    }



    @Test
    @DisplayName("Логинюсь через кнопку Войти в аккаунт")
    @Description("Залогинюсь через кнопку Войти в аккаунт на главной странице")
    public void loginWithMainPagePositiveTest(){
        open(MAIN);
        mainPage.pressButtonLogin()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .pressButtonLogin()

                .checkEnabledButtonMakeOrder();

    }

    @Test
    @DisplayName("Логинюсь через кнопку Личный кабинет")
    @Description("Нажимаю кнопку Личный кабинет на главной странице и логинюсь на форме")
    public void loginWithMainPageButtonPersonAccountPositiveTest(){
        open(MAIN);
        mainPage.pressButtonPersonalAccount()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .pressButtonLogin()

                .checkEnabledButtonMakeOrder();

    }

    @Test
    @DisplayName("Логинюсь с формы регистрации")
    @Description("Залогинюсь через кнопку Войти в аккаунт на странице восстановления пароля")
    public void loginWitRegistrationPagePositiveTest(){
        open(REGISTER);
        registrationPage.pressButtonLogin()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .pressButtonLogin()

                .checkEnabledButtonMakeOrder();

    }

    @Test
    @DisplayName("Логинюсь с формы восстановления пароля ")
    @Description("Залогинюсь через кнопку Войти в аккаунт на странице восстановления пароля")
    public void loginWithForgotPagePositiveTest(){
        open(FORGOT);
        forgotPasswordPage.pressButtonLogin()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .pressButtonLogin()

                .checkEnabledButtonMakeOrder();

    }




}
