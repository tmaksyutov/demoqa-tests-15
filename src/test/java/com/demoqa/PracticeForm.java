package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1720x1440";
    }


    @Test
    void fillFormTest () {
        open("/automation-practice-form");
        $("#firstName").setValue("Timur");
        $("#lastName").setValue("Maksyutov");
        $("#userEmail").setValue("tmaksyutov@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("89174565252");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--007").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("Russia");
        $("#uploadPicture").uploadFile(new File("src/test/resources/IntelliJIDEA_ReferenceCard"));


    }

}
