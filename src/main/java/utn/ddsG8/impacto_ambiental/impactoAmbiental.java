package utn.ddsG8.impacto_ambiental;

import utn.ddsG8.impacto_ambiental.calculos.Medicion;
import utn.ddsG8.impacto_ambiental.services.sheets.LectorExcel;

import java.io.IOException;
import java.util.List;

public class impactoAmbiental {
    public static void main(String[] args) throws IOException {
        System.out.println("  A\nI M\nM B\nP I\nA E\nC N\nT T\nO A\n  L\n");
        LectorExcel lector = new LectorExcel();
        List<Medicion> mediciones = lector.obtenerDatosActividades("src/main/resources/ejemploDA.xlsx");
        //TODO: la medicion pertenece a una organizacion o le hacemos a la organizacion una lsita de mediciones?

    }
}

