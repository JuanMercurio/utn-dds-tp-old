package utn.ddsG8.impacto_ambiental;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.calculos.FE;
import utn.ddsG8.impacto_ambiental.calculos.Medicion;
import utn.ddsG8.impacto_ambiental.estructura.Administrador;
import utn.ddsG8.impacto_ambiental.estructura.Organizacion;
import utn.ddsG8.impacto_ambiental.services.sheets.LectorExcel;

import java.io.IOException;
import java.util.List;

public class impactoAmbiental {
    public static CalcularHC CrearFes(){
        CalcularHC calcular = new CalcularHC();
        FE fe = new FE("Combustion fija","Gas Natural","m3",2.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustion fija","Diesel","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustion fija","Gasoil ","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustion fija","Kerosene","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustion fija","Fuel Oil","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustion fija","Nafta","lt",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustion fija","Carbon","kg",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustion fija","Carbon de leña","kg",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustion fija","Lena","kg",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustión móvil","Combustible consumido - Gasoil","lts",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustión móvil","Combustible consumido – GNC","lts",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Combustión móvil","Combustible consumido - Nafta","lts",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FE("Electricidad adquirida y consumida","Electricidad","kwh",3.44);
        calcular.cargarFactorEmision(fe);
        fe = new FE("Logística de productos y residuos","","",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FE("Camion","","",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FE("Auto","","",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FE("Moto","","",3.44);
        calcular.cargarFactorEmision(fe);

        fe = new FE("Colectivo","","",3.44);
        calcular.cargarFactorEmision(fe);
        return calcular;
    }
    public static void main(String[] args) throws IOException {
        System.out.println("  A\nI M\nM B\nP I\nA E\nC N\nT T\nO A\n  L\n");

        Administrador admin = new Administrador();
        admin.setCalculador(CrearFes());


    }

}

