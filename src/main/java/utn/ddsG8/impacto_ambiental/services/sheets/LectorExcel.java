package utn.ddsG8.impacto_ambiental.services.sheets;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utn.ddsG8.impacto_ambiental.calculos.Medicion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LectorExcel {

    public List<Medicion> obtenerDatosActividades(String path) throws IOException {

        List<Medicion> mediciones = new ArrayList<Medicion>();
        FileInputStream file = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            Medicion medicion = new Medicion();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

            }

        }
            file.close();

        return mediciones;
    }

}
