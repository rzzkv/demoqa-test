package regForm;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegFormTest {

    @Test
    void regFormTest(){

        String firstName = "Jakhongir";
        String lastName = "Razzakov";
        String userMail = "kgb@jovan.ru";
        String userNumber = "4999886645";
        String gender = "Male";
        String month  = "April";
        String year = "2000";
        String nameFile = "Img.jpg";
        String currentAddress = "Mustakillik st. 52/17";

        open("https://demoqa.com/automation-practice-form");
        $("h5").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userMail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        $(".react-datepicker__day.react-datepicker__day--016").click();

        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $x("//label[text()='Reading']").click();

        File file = new File("src/test/resources/" +nameFile);
        $("#uploadPicture").uploadFile(file);
        $("#uploadPicture").shouldHave(value(nameFile));

        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();

        // hide overlay banners
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".btn-primary").click();

        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userMail), text("Male"), text(userNumber),
                text("16 April,2000"), text("Economics"), text("Computer Science"), text("Reading"), text(nameFile), text(currentAddress),
                text("Rajasthan Jaipur"));



    }
}
