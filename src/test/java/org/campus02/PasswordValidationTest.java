package org.campus02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {

    PasswordValidation passwordSmallerEight;
    PasswordValidation passwordEightwithNothing;
    PasswordValidation passwordEightwithUpperLetters;
    PasswordValidation passwordEightWithUpperLettersNumbers;
    PasswordValidation passwordEightWithUpperLettersSpecialLetters;
    PasswordValidation passwordEightWithUpperLettersNumbersSpecials;
    @BeforeEach
    void setUp() {
        passwordSmallerEight = new PasswordValidation("auto");
        passwordEightwithNothing = new PasswordValidation("luxusauto");
        passwordEightwithUpperLetters = new PasswordValidation("LuxusAuto");
        passwordEightWithUpperLettersNumbers = new PasswordValidation("LuxusAuto4");
        passwordEightWithUpperLettersSpecialLetters = new PasswordValidation("Luxus%AuTo");
        passwordEightWithUpperLettersNumbersSpecials = new PasswordValidation("Luxus%7Auto!6");

    }

    @Test
    @DisplayName("Test für Konstruktor")
    void KonstruktorTest() {
        String expected = "LuxusAuto4";

        Assertions.assertEquals(expected,passwordEightWithUpperLettersNumbers.getPassword());
    }

    @Test
    @DisplayName("Test für Länge des Passworts > 8")
    void validateLengthTest() {
        boolean expectedUnder8 = false;
        Assertions.assertEquals(expectedUnder8, passwordSmallerEight.validateLength());

        boolean expectedOver8 = true;
        Assertions.assertEquals(expectedOver8, passwordEightWithUpperLettersNumbersSpecials.validateLength());

    }

    @Test
    @DisplayName("Test ob Passwort Grossbuchstaben enthält")
    void countUpperCaseLetter() {
        int expectedNull = 0;
        Assertions.assertEquals(expectedNull, passwordSmallerEight.countUpperCaseLetters());

        int expected2= 2;
        Assertions.assertEquals(expected2, passwordEightwithUpperLetters.countUpperCaseLetters());

        int expected3 = 3;
        Assertions.assertEquals(expected3,passwordEightWithUpperLettersSpecialLetters.countUpperCaseLetters());
    }

    @Test
    void countSpecialSign() {
        int expected0 = 0;
        Assertions.assertEquals(expected0, passwordEightwithUpperLetters.countSpecialSign());

        int expected1 = 1;
        Assertions.assertEquals(expected1, passwordEightWithUpperLettersSpecialLetters.countSpecialSign());

        int expected2 = 2;
        Assertions.assertEquals(expected2, passwordEightWithUpperLettersNumbersSpecials.countSpecialSign());
    }

}