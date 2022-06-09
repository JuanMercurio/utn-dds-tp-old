package utn.ddsG8.services.sheets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.calculos.Medicion;
import utn.ddsG8.impacto_ambiental.services.sheets.LectorExcel;

import java.awt.font.FontRenderContext;
import java.io.IOException;
import java.util.List;

public class LectorExcelTest {

    @Test
    public void obtieneDatos() throws IOException {
        LectorExcel lector = new LectorExcel();
        List<Medicion> mediciones = lector.obtenerDatosActividades("src/main/resources/ejemploDA.xlsx");
        for (Medicion unaMedicion: mediciones) {
            System.out.println("Actividad"+unaMedicion.getActividad()+", TipoMedicion:"+unaMedicion.getTipoConsumo()
            +"Fecha: "+unaMedicion.getPeriodoDeImputacion());
        }
        Assertions.assertTrue(mediciones.size() > 0);
    }
}
