package utn.ddsG8.impacto_ambiental;

import utn.ddsG8.impacto_ambiental.Notificaciones.Contacto;
import utn.ddsG8.impacto_ambiental.Notificaciones.Whatsapp;
import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.calculos.FE;
import utn.ddsG8.impacto_ambiental.calculos.Medicion;
import utn.ddsG8.impacto_ambiental.estructura.*;
import utn.ddsG8.impacto_ambiental.services.distancia.*;
import utn.ddsG8.impacto_ambiental.services.distancia.Pais;
import utn.ddsG8.impacto_ambiental.services.distancia.Provincia;
import utn.ddsG8.impacto_ambiental.services.sheets.LectorExcel;

import java.io.IOException;
import java.util.List;
import java.util.Timer;

public class impactoAmbiental {
    private static final String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";
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
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Pais> paises = api.paises(token, 1);
        List<Provincia> provincias = api.provincias(token, 1);


        Miembro unMiembro = new Miembro("Matias","Carasi", TipoDoc.DNI, "42998217");
        Pais unPais = new Pais();
        Provincia unaProvincia = new Provincia(9, "Buenos Aires", unPais);
        Municipio unMunicipio = new Municipio(2, "General Pueyrredon", unaProvincia);
        Localidad unaLocalidad = new Localidad(1,"Mar del Plata",3546, unMunicipio);
        Direccion direccionOrg = new Direccion("medrano", 1234, unaLocalidad);
        Organizacion unaOrganizacion = new Organizacion("Escuela", OrgTipo.ONG, Clasificacion.Ministerio, direccionOrg);
        Sector unSector = new Sector("Desarrollo", unaOrganizacion);
        Sector otroSector = new Sector("Direccion", unaOrganizacion);

        Contacto contacto = new Contacto("jana@gmail.com","123456789","Jana");
        unaOrganizacion.agregarContacto(contacto);
        Contacto contactoJuan = new Contacto("juan@gmail.com","123456789","Juan");
        unaOrganizacion.agregarContacto(contactoJuan);
        admin.AgregarOrganizacion(unaOrganizacion);
        admin.EnviarNotificaciones();




    }

}

