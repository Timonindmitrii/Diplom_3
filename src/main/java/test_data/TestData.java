package test_data;
import org.apache.commons.lang3.RandomStringUtils;

public class TestData {
    public static final String MAIN = "https://stellarburgers.nomoreparties.site";
    public  static final String REGISTER = "https://stellarburgers.nomoreparties.site/register";
    public  static final String LOGIN = "https://stellarburgers.nomoreparties.site/login";
    public static final String FORGOT = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String PERSON = "https://stellarburgers.nomoreparties.site/account/profile";


    public static final String NAME = "Дмитрий";
    public static final String EMAIL ="Dmitry@yandex.ru";
    public static final String  PASSWORD = "q12345";
    public static String randomEmail = RandomStringUtils.randomAlphanumeric(10)+"@yandex.ru";
    public static String randomCorrectPassword = RandomStringUtils.randomAlphanumeric(10);
    public static String randomIncorrectPassword = RandomStringUtils.randomAlphanumeric(3);


}
