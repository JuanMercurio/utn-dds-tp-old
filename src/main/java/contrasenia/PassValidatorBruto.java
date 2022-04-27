package contrasenia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PassValidatorBruto extends PassValidator{

    public PassValidatorBruto(String archivoContrasenias, Integer cantMinCaracteres, Integer cantMinLower, Integer cantMinNum, Integer cantMinUpper) throws FileNotFoundException {
        super(archivoContrasenias, cantMinCaracteres, cantMinLower, cantMinNum, cantMinUpper);
    }
    public boolean cumpleRestricciones(String pass){
        int uppers = 0;
        int numeros = 0;
        int lowers = 0;

        for (int i=0; i < pass.length(); i++) {
            if (Character.isUpperCase(pass.charAt(i))) {
                uppers++;
            }
            if (Character.isDigit(pass.charAt(i))) {
                numeros++;
            }
            if (Character.isLowerCase(pass.charAt(i))){
                lowers++;
            }
        }

        boolean cumpleLength    =  pass.length() >= this.cantMinCaracteres ;
        boolean cumpleCantUpper = uppers >= this.cantMinUpper;
        boolean cumpleCantLower = lowers >= this.cantMinLower;
        boolean cumpleCantNum   = numeros >= this.cantMinNum;
        return cumpleLength && cumpleCantLower && cumpleCantNum && cumpleCantUpper;
    }
}
