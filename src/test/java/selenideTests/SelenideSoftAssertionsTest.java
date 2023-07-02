package selenideTests;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsTest {
    @Test
    public void testSoftAssertionsPageHasJUnit5CodeExample() {
// открыть страницу проекта Selenide на Github
        open("https://github.com/selenide/selenide");
// перейти в раздел Wiki
        $("#wiki-tab").click();
// убедиться, что в списке страниц есть страница SoftAssertions
        $("[class=markdown-body]").shouldHave(Condition.text("Soft assertions"));
// открыть страницу SoftAssertions
        $("a.internal[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
// проверить, что на странице есть пример кода для JUnit5
        $("#wiki-body").shouldHave(Condition.text("JUnit5 extension"));
    }
}