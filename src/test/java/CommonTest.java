import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import exercise_2_1.MainPage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CommonTest {

    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 70000;
        //Configuration.headless = true;
    }

    @Order(2)
    @Test
    @DisplayName("Задание 2.2")
    public void testEx2_2() {
        new MainPage()
                .openMainPage()
                .authButtonClick()
                .enterLogin()
                .enterPassword()
                .entranceButtonClick()
                .carCardClick()
                .addFavorites()
                .followToFavorites()
                .checkCarName();
    }

    @Order(1)
    @Test
    @DisplayName("Задание 2.1")
    public void testEx2_1() {
        new MainPage()
                .openMainPage()
                .chooseMark("Toyota")
                .chooseModel("Harrier")
                .chooseFuel()
                .chooseSaleCheckBox()
                .chooseMileageOneKm("1")
                .chooseYear()
                .clickShowButton()
                .testTextCarNameTitle()
                .testMileages();
    }

    @AfterEach
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }

}
