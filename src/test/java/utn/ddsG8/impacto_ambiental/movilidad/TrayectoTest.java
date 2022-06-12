package utn.ddsG8.impacto_ambiental.movilidad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.estructura.Miembro;
import utn.ddsG8.impacto_ambiental.estructura.TipoDoc;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Auto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Pie;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Colectivo;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Linea;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Parada;
import utn.ddsG8.impacto_ambiental.services.distancia.*;

import java.io.IOException;
import java.util.List;


class TrayectoTest {
    private final String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";
    private final Localidad localidad = new Localidad(3908, "ALDEA BRASILERA", 3101, null);
    private final Direccion inicio = new Direccion("Grupo8", 100, localidad);
    private final Direccion fin = new Direccion("No llegamos con la entrega", 100, localidad);
    private Tramo tramoAuto;
    private Tramo tramoPie;

    @BeforeEach
    public void iniciarTramos() {
        Auto auto = new Auto(token, inicio, fin, null);
        Pie pie = new Pie(token, inicio, fin);
        this.tramoAuto = new Tramo(auto);
        this.tramoPie = new Tramo(pie);
    }

    @Test
    public void autoYPieTest() {
        Trayecto trayecto = new Trayecto();
        trayecto.agregarTramos(tramoAuto, tramoPie, tramoAuto, tramoPie);
        Distancia distancia = trayecto.getDistancia();
        Assertions.assertTrue(distancia.valor > 0);
    }

    @Test
    public void distanciaDeTramoSegunIndiceTest() {
        Trayecto trayecto = new Trayecto();
        trayecto.agregarTramos(tramoAuto, tramoPie, tramoAuto, tramoPie);
        Distancia distancia = trayecto.getDistanciaDeTramo(2);
        Assertions.assertTrue(distancia.valor > 0);
    }

    @Test
    public void CrearProvincia () throws IOException {
        // a jana le quedo por la mitad.
        Trayecto unTrayecto = new Trayecto();

        // creo un pais:
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Pais> paises = api.paises(token, 1);
        List<Provincia> provincias = api.provincias(token, 1);
        List<Municipio> municipios = api.municipios(token, 1);


        Miembro miembroJana = new Miembro("jana","rozenberg", TipoDoc.DNI,"12345678");
        Miembro miembroMati = new Miembro("Mati","Carasi", TipoDoc.DNI,"12345678");
        Localidad unaLocalidad = new Localidad(3908,"ALDEA BREASILERA",3101,null);

        Direccion dirParada1 = new Direccion("avellaneda",300,unaLocalidad);


        Linea linea19 = new Linea("Linea 19");

//        Parada parada1 = new Parada("primer parada",linea19);
//        Parada parada2 = new Parada("segunda parada",linea19);
//        Parada parada3 = new Parada("tercer parada",linea19);
//        parada1.AgregarParadaAnteriorYProxima(parada2,null);
//        parada2.AgregarParadaAnteriorYProxima(parada3,parada1);
//        parada2.AgregarParadaAnteriorYProxima(null,parada2);
//
//        parada1.setDireccion(dirParada1);
//        parada2.setDireccion(dirParada1);
//        parada3.setDireccion(dirParada1);
//        Colectivo colectivo19 = new Colectivo(linea19,parada1,parada3);

        //TransportePublico unaTransportePublico = new TransportePublico();


        //Tramo tramito


    }
}