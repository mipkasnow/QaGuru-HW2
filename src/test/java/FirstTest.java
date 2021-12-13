import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeEach
    void openForm(){
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void checkForm(){

        $("#firstName").setValue("Mikhail");
        $("#lastName").setValue("Loginov");
        $("#userEmail").setValue("random@mail.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");


        $("#dateOfBirthInput").click();
        $("[class*='month-select']").selectOptionByValue("2");
        $("[class*='year-select']").selectOptionByValue("1993");
        $("[class*='datepicker__day--016']").click();
        $("#subjectsInput").setValue("Math").pressEnter();

        ElementsCollection hobbies = $$("[for*='hobbies-checkbox']");
        int count = hobbies.size();
        for (int i = 0; i < count; i++) {
            hobbies.get(i).click();
        }

        File file = new File("src/test/resources/qa-guru.txt");
        $("input[id='uploadPicture']").uploadFile(file);

        $("[placeholder='Current Address']").setValue("Saint-Pee");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(byText("Thanks for submitting the form")).should(appear);
        $(".modal-content").should(appear);


    }

}