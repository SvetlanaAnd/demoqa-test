package ru.sandreeva.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


import java.io.File;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {

        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {


        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("alex@petrov.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2010");
        $(".react-datepicker__day--028:not(.react-datepicker__day--028 react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Mankato Mississippi 96522");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Petrov"), text("alex@petrov.com"), text("Other"),
                text("1234567890"), text("28 June,2010"), text("Maths"), text("Reading"), text("1.png"), text("Mankato Mississippi 96522"),
                text("NCR Delhi"));

    }
}







