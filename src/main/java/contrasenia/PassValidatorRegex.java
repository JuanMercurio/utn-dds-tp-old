package contrasenia;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.regex.Pattern;

public class PassValidatorRegex extends PassValidator{

    public PassValidatorRegex(String archivoContrasenias, Integer cantMinCaracteres, Integer cantMinLower, Integer cantMinNum, Integer cantMinUpper) throws FileNotFoundException {
        super(archivoContrasenias, cantMinCaracteres, cantMinLower, cantMinNum, cantMinUpper);
    }

    public boolean cumpleRestricciones(String pass){

        String regexNum   = crearRegex(".*[0-9]", cantMinNum);
        String regexUpper = crearRegex(".*[A-Z]", cantMinNum);
        String regexLower = crearRegex(".*[a-z]", cantMinNum);


        return Pattern.matches(regexUpper, pass) &&
               Pattern.matches(regexLower, pass) &&
               Pattern.matches(regexNum, pass) &&
               pass.length() >= cantMinCaracteres;

    }

    private String crearRegex(String s, int n){
        return  String.join("", Collections.nCopies(n, s)) + ".*";
    }

}
