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
        passwordEightWithUpperLettersSpecialLetters = new PasswordValidation("Luxus%Auto");
        passwordEightWithUpperLettersNumbersSpecials = new PasswordValidation("Luxus%Auto6");

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
    void name() {
    }
}