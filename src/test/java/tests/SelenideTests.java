package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Owner("Elizarkov Artem")
@Feature("Issue в репозитории")
@DisplayName("Тесты на проверку назвнаия Issue в репозитории")
public class SelenideTests extends TestBase {

    private String expectedIssueTitle = "Issue for Autotest";
    private final TestSteps testSteps = new TestSteps();

    @Story("Автотест на проверку Issue на чистом Selenide и Listener")
    @DisplayName("Проверка, что название Issue соответствует Issue for Autotest")
    @Link(value = "Repository page", url = "https://github.com/qa-guru/qa_guru_14_10")
    @Test
    void checkIssueTitleUsingListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/qa-guru/qa_guru_14_10");
        $("[data-content='Issues']").click();
        $("#issue_2_link").shouldHave(text(expectedIssueTitle));
    }

    @Story("Автотест на проверку Issue на используя Selenide и Lambda")
    @DisplayName("Проверка, что название Issue соответствует Issue for Autotest")
    @Link(value = "Repository page", url = "https://github.com/qa-guru/qa_guru_14_10")
    @Test
    void checkIssueTitleUsingLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу репозитория", () -> {
            open("/qa-guru/qa_guru_14_10");
        });

        step("Перейти на вкладку Issues", () -> {
            $("[data-content='Issues']").click();
        });

        step("Проверить, что текст Issue совпадает с " + expectedIssueTitle, () -> {
            $("#issue_2_link").shouldHave(text(expectedIssueTitle));
        });
    }

    @Story("Автотест на проверку Issue используя Selenide и аннотацию @Step")
    @DisplayName("Проверка, что название Issue соответствует Issue for Autotest")
    @Link(value = "Repository page", url = "https://github.com/qa-guru/qa_guru_14_10")
    @Test
    void checkIssueTitleUsingStepAnnotation() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        testSteps
                .openRepoPage()
                .openIssuesTab()
                .checkIssueTitle(expectedIssueTitle);
    }


}
