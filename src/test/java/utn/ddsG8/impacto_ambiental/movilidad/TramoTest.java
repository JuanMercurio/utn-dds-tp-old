package utn.ddsG8.impacto_ambiental.movilidad;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Moto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Pie;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.combustibles.Combustible;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.combustibles.Nafta;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Auto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Parada;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.TransportePublico;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Tren;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.Localidad;

class TramoTest {
    private final String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";
    private final Localidad localidad = new Localidad(3908, "ALDEA BRASILERA", 3101, null);
    private final Direccion inicioDireccion = new Direccion("Grupo8", 100, localidad);
    private final Direccion finDireccion = new Direccion("No llegamos con la entrega", 100, localidad);

    @Test
    public void autoDistancia() {
        Combustible combustible = new Nafta();
        Auto auto = new Auto(combustible);
        Tramo tramo = new TramoTransportePrivado(auto, inicioDireccion, finDireccion, token);
        Distancia distanciaTramo= tramo.getDistancia();
//        System.out.println(distanciaTramo.valor + distanciaTramo.unidad);
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void motoDistancia() {
        Combustible combustible = new Nafta();
        Moto moto = new Moto(combustible);
        Tramo tramo = new TramoTransportePrivado(moto, inicioDireccion, finDireccion, token);
        Distancia distanciaTramo= tramo.getDistancia();
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void pieDistancia() {
        Pie pie = new Pie();
        Tramo tramo = new TramoTransportePrivado(pie, inicioDireccion, finDireccion, token);
        Distancia distanciaTramo= tramo.getDistancia();
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void TranportePublicoDistancia() {
        TransportePublico tren = crearTren();
        Tramo tramo = new TramoTransportePublico(tren, tren.getParadas().get(0), tren.getParadas().get(5));
        Distancia distanciaTramo= tramo.getDistancia();
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    private TransportePublico crearTren() {
        TransportePublico tren = new Tren("Subte 123");
        for (int i = 0; i <10; i++) {
            Parada parada = new Parada("parada "+i, tren, null, 123, 123, i);
        }
        return tren;
    }


}