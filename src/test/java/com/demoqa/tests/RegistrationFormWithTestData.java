package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.demoqa.testData.UserData.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormWithTestData extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @DisplayName("Форма регистрации")
    @Owner("Тимур Максютов")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void fillFormTest () {

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
