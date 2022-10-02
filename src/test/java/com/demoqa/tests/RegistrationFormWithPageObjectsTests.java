package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest () {
        registrationFormPage.openPage()
                .setFirstName("Timur")
                .setLastName("Maksyutov")
                .setEmail("tmaksyutov@mail.ru")
                .setGender("Male")
                .setNumber("8917456525")
                .setBirthDate("07", "September", "1994")
                .setHobbies("Sports")
                .setSubjects("English")
                .setUploadPicture("2.jpg")
                .setAddress("Dagestanskaya Street")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name","Timur Maksyutov")
                .checkResult("Student Email","tmaksyutov@mail.ru")
                .checkResult("Gender","Male")
                .checkResult("Mobile","8917456525")
                .checkResult("Date of Birth","07 September,1994")
                .checkResult("Subjects","English")
                .checkResult("Hobbies","Sports")
                .checkResult("Picture","2.jpg")
                .checkResult("Address","Dagestanskaya Street")
                .checkResult("State and City","NCR Delhi");

    }

}
