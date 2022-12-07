package pom;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    SelenideElement buttonLogin = $(byXpath("//*[.='Войти в аккаунт']"));
    SelenideElement buttonMakeOrder = $(byXpath("//*[.='Оформить заказ']"));
    SelenideElement buttonPersonalAccount = $(byLinkText("Личный Кабинет"));
    SelenideElement textTitle = $(byXpath("//h1"));
    SelenideElement bunsTitle = $(byXpath("//h2[.='Булки']"));
    SelenideElement saucesTitle = $(byXpath("//h2[.='Соусы']"));
    SelenideElement fillingsTitle = $(byXpath("//h2[.='Начинки']"));
    SelenideElement bunsTab = $(byXpath(".//div/span[text()='Булки']"));
    SelenideElement saucesTab = $(byXpath(".//div/span[text()='Соусы']"));
    SelenideElement fillingsTab = $(byXpath(".//div/span[text()='Начинки']"));
    SelenideElement activeTab = $(".tab_tab_type_current__2BEPc");


    @Step("Нажимаю кнопку войти в аккаунт на главной странице")
    public LoginPage pressButtonLogin(){
        buttonLogin.click();
        return new LoginPage();
    }

    @Step("Нажимаю кнопку Личный кабинет")
    public LoginPage pressButtonPersonalAccount(){
        buttonPersonalAccount.click();
        return new LoginPage();
    }

    @Step("Проверяю что кнопка Оформить заказ доступна")
    public void checkEnabledButtonMakeOrder(){
        buttonMakeOrder.shouldBe(enabled);
    }

    @Step("Нажимаю кнопку Личный кабинет на главной странице")
    public PersonalAccountPage pressButtonPersonalAccountWithAuth(){
        buttonPersonalAccount.click();
        return new PersonalAccountPage();
    }

    @Step("Проверяю что видно заголовок Соберите бургер")
    public void checkLogoVisible(){
        textTitle.shouldBe(visible);
    }

    @Step("Выбираю раздел Булки")
    public MainPage chooseBunsTab(){
        boolean isTrue = activeTab.isDisplayed();
        if(isTrue) {

        } else {
        bunsTab.click();}

        return this;
    }

    @Step("Выбираю раздел Coусы")
    public MainPage chooseSaucesTab(){
        saucesTab.click();
        return this;
    }

    @Step("Выбираю раздел Начинки")
    public MainPage chooseFillingsTab(){
        fillingsTab.click();
        return this;
    }

    @Step("Проверяю видимость заголовка Булки")
    public void checkBunsTitle(){
        bunsTitle.shouldBe(visible);
    }

    @Step("Проверяю видимость заголовка Соусы")
    public void checkSaucesTitle(){
        saucesTitle.shouldBe(visible);
    }

    @Step("Проверяю видимость заголовка Начинки")
    public void checkFillingsTitle(){
        fillingsTitle.shouldBe(visible);
    }

}

