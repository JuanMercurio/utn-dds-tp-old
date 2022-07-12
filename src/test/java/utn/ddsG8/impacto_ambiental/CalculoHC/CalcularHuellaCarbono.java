package utn.ddsG8.impacto_ambiental.CalculoHC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.calculos.Medicion;
import utn.ddsG8.impacto_ambiental.estructura.CalcularHC;
import utn.ddsG8.impacto_ambiental.estructura.FactorEmision;
import utn.ddsG8.impacto_ambiental.services.sheets.LectorExcel;

import java.io.IOException;
import java.util.List;

public class CalcularHuellaCarbono {
    @Test
    public void crearFeYBuscar () throws IOException {
        CalcularHC calcular = new CalcularHC();
       /* FactorEmision fe = new FactorEmision("Combustion fija","Gas Natural","m3",2.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustion fija","Diesel","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustion fija","Gasoil ","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustion fija","Kerosene","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustion fija","Fuel Oil","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustion fija","Nafta","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustion fija","Carbon","kg",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustion fija","Carbon de leña","kg",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustion fija","Lena","kg",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustión móvil","Combustible consumido - Gasoil","lts",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustión móvil","Combustible consumido – GNC","lts",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Combustión móvil","Combustible consumido - Nafta","lts",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FactorEmision("Electricidad adquirida y consumida","Electricidad","kwh",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FactorEmision("Logística de productos y residuos","","",3.44);
        calcular.cargarFactorEmision(fe);

        Assertions.assertTrue( calcular.buscarFactorEmision("Combustion fija","Gas Natural") != -1);
        LectorExcel lector = new LectorExcel();
        List<Medicion> mediciones = lector.obtenerDatosActividades("src/main/resources/ejemploDA.xlsx");
        Assertions.assertTrue(calcular.CalcularFEActividades(mediciones) != 0);

        fe = new FactorEmision("Camion","","",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FactorEmision("Auto","","",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FactorEmision("Moto","","",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FactorEmision("Colectivo","","",3.44);
        calcular.cargarFactorEmision(fe);*/


    }

}
