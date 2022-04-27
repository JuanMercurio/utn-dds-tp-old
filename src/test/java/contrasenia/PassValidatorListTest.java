package contrasenia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class PassValidatorListTest {

    // TODO: mejorar tests

    @Test
    public void listTest() throws FileNotFoundException {
        String contrasenias_path = "src/main/resources/badPasswords.txt";
        PassValidatorList list = new PassValidatorList(contrasenias_path, 8, 1, 1, 1);


        Assertions.assertTrue(list.validarPass("Bien1234"));

        Assertions.assertFalse(list.validarPass("Password1"));
        Assertions.assertFalse(list.validarPass("malacontrasenia1234"));
        Assertions.assertFalse(list.validarPass("Mala123"));
        Assertions.assertFalse(list.validarPass("11111111"));
        Assertions.assertFalse(list.validarPass("aaaaaaaa"));
        Assertions.assertFalse(list.validarPass("AAAAAAAA"));
    }

    @Test
    public void regexTest() throws FileNotFoundException {
        String contrasenias_path = "src/main/resources/badPasswords.txt";
        PassValidatorRegex regex  = new PassValidatorRegex(contrasenias_path, 8, 1, 1, 1);
        Assertions.assertTrue(regex.validarPass("Bien1234"));

        Assertions.assertFalse(regex.validarPass("Password1"));
        Assertions.assertFalse(regex.validarPass("malacontrasenia1234"));
        Assertions.assertFalse(regex.validarPass("Mala123"));
        Assertions.assertFalse(regex.validarPass("11111111"));
        Assertions.assertFalse(regex.validarPass("aaaaaaaa"));
        Assertions.assertFalse(regex.validarPass("AAAAAAAA"));
    }

    @Test
    public void brutoTest() throws FileNotFoundException {
        String contrasenias_path = "src/main/resources/badPasswords.txt";
        PassValidatorBruto bruto = new PassValidatorBruto(contrasenias_path, 8, 1, 1, 1);
        Assertions.assertTrue(bruto.validarPass("Bien1234"));
        Assertions.assertFalse(bruto.validarPass("Password1"));
        Assertions.assertFalse(bruto.validarPass("malacontrasenia1234"));
        Assertions.assertFalse(bruto.validarPass("Mala123"));
        Assertions.assertFalse(bruto.validarPass("11111111"));
        Assertions.assertFalse(bruto.validarPass("aaaaaaaa"));
        Assertions.assertFalse((bruto.validarPass("AAAAAAAA")));
    }

}
