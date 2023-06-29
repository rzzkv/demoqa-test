package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest{
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){
        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Jakhongir Razzakov");
        $("#userEmail").setValue("rzzkv@gmail.com");
        $("#currentAddress").setValue("address 1");
        $("#permanentAddress").setValue("address 2");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text("Jakhongir Razzakov"));
        $("#output").$("#email").shouldHave(text("rzzkv@gmail.com"));
        $("#output #currentAddress").shouldHave(text("address 1"));
        $("#output #permanentAddress").shouldHave(text("address 2"));
    }
}
