package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import com.demoqa.pages.RegistrationFormPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.demoqa.testData.UserData.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormWithTestData {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
    @DisplayName("Форма регистрации")
    @Owner("Тимур Максютов")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void fillFormTest () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу",() -> {
            registrationFormPage.openPage();
        });

        step("Вводим данные", () -> {
            registrationFormPage.setFirstName(firstName)
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
                    .setCity(city);
        } );

        step("Нажимаем кнопку Submit", () -> {
            registrationFormPage.setSubmit();
        });

        step("Проверяем результат", () ->{
            registrationFormPage.checkResultsTableVisible()
                    .checkResultTableData(firstName, lastName, email, gender,
                            number, date, hobby, subject, picture, address, state, city);
        });
    }

}
