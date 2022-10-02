package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.demoqa.testData.UserData.*;

public class RegistrationFormWithTestData {
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
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setDate(day, month, year)
                .setHobbies(hobby)
                .setSubjects(subject)
                .setUploadPicture(path)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResultTableData(firstName, lastName, email, gender,
                        number, date, hobby, subject, picture, address, state, city);

    }

}
