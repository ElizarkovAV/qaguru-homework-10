package tests;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSteps {

    @Step("Открыть страницу репозитория")
    public TestSteps openRepoPage() {
        open("/qa-guru/qa_guru_14_10");
        return this;
    }

    @Step("Перейти на вкладку Issues")
    public TestSteps openIssuesTab() {
        $("[data-content='Issues']").click();
        return this;
    }

    @Step("Проверить, что название Issue совпадает с ожидаемым")
    public TestSteps checkIssueTitle(String expTitle) {
        $("#issue_2_link").shouldHave(text(expTitle));
        return this;
    }

}
