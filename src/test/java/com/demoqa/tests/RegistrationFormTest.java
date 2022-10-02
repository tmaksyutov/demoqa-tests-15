package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest () {
        open("/automation-practice-form");
        $("#firstName").setValue("Timur");
        $("#lastName").setValue("Maksyutov");
        $("#userEmail").setValue("tmaksyutov@mail.ru");

        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8917456525");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--007").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("English").pressEnter();

        $("#uploadPicture").uploadFromClasspath("2.jpg");

        $("#currentAddress").setValue("Dagestanskaya Street");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Timur Maksyutov"),
            text("tmaksyutov@mail.ru"),
            text("Male"),
            text("8917456525"),
            text("07 September,1994"),
            text("English"),
            text("Sports"),
            text("2.jpg"),
            text("Dagestanskaya Street"),
            text("NCR Delhi"));

    }

}
