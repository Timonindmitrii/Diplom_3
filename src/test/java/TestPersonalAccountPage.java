import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static test_data.TestData.*;

@DisplayName("Тесты страницы личного кабинета")
public class TestPersonalAccountPage {

    MainPage mainPage;
    LoginPage loginPage;
    PersonalAccountPage personalAccountPage;

    @Before
    @DisplayName("Логинюсь под учетной записью")
    public void setupAccount(){
        // DriverSetup.getYandexDriver();
        mainPage = new MainPage();
        open(MAIN);
        mainPage.pressButtonLogin()
                .enterEmail(EMAIL)
                .enterPassword(PASSWORD)
                .pressButtonLogin();

    }

    @After
    @DisplayName("Закрываю драйвер для следующих тестов")
    public void exitAccount(){
        closeWebDriver();
    }


    @Test
    @DisplayName("Открытие личного кабинета")
    @Description("Проверяю открытие личного кабинета и доступности кнопки Выхода")
    public void openPersonalAccountPositiveTest(){
        mainPage.pressButtonPersonalAccountWithAuth()

                .checkButtonExitEnabled();
    }

    @Test
    @DisplayName("Переход на главную по кнопке Конструктор")
    @Description("Проверяю переход на главную страницу после нажатия на кнопку Конструктор")
    public void openMainPagePressConstructorPositiveTest(){
        mainPage.pressButtonPersonalAccountWithAuth()
                .pressButtonConstructor()

                .checkLogoVisible();
    }

    @Test
    @DisplayName("Переход на главную по нажатию на лого")
    @Description("Проверяю переход на главную страницу после нажатия на кнопку логотипа")
    public void openMainPagePressLogoPositiveTest(){
        mainPage.pressButtonPersonalAccountWithAuth()
                .pressLogo()

                .checkLogoVisible();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверяю переход на страницу Логина после нажатия на кнопку Выхода")
    public void openLoginPagePressButtonExitPositiveTest(){
        mainPage.pressButtonPersonalAccountWithAuth()
                .pressButtonExit()

                .checkVisibleButtonLogin();
    }


}
