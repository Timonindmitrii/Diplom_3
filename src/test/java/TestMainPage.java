import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static test_data.TestData.MAIN;

@DisplayName("Тесты главной страницы")
public class TestMainPage {
    MainPage mainPage;

    @Before
    @DisplayName("Открываю главную страницу без авторизации")
    public void setupMainPage() {
        // DriverSetup.getYandexDriver();
        mainPage = new MainPage();
        open(MAIN);
    }

    @After
    @DisplayName("Закрываю драйвер для следующих тестов")
    public void exitMainPage() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Раздел Булки")
    @Description("Выбираю раздел Булки и проверяю заголовок")
    public void chooseBunsTabTest(){
        mainPage.chooseBunsTab()

                .checkBunsTitle();
    }

    @Test
    @DisplayName("Раздел Начинки")
    @Description("Выбираю раздел Булки и проверяю заголовок")
    public void chooseFillingsTabTest(){
        mainPage.chooseFillingsTab()

                .checkFillingsTitle();
    }

    @Test
    @DisplayName("Раздел Соусы")
    @Description("Выбираю раздел Соусы и проверяю заголовок")
    public void chooseSaucesTabTest(){
        mainPage.chooseSaucesTab()

                .checkSaucesTitle();
    }

}
