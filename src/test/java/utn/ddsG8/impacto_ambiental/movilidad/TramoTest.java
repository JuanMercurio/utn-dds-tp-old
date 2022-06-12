package utn.ddsG8.impacto_ambiental.movilidad;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Bicicleta;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Moto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Pie;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.combustibles.Combustible;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.combustibles.Nafta;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Auto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Linea;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Parada;
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
        Auto auto = new Auto(token, inicioDireccion, finDireccion, combustible);
        Tramo tramo = new Tramo(auto);
        Distancia distanciaTramo= tramo.getDistancia();
//        System.out.println(distanciaTramo.valor + distanciaTramo.unidad);
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void motoDistancia() {
        Combustible combustible = new Nafta();
        Moto moto = new Moto(token, inicioDireccion, finDireccion, combustible);
        Tramo tramo = new Tramo(moto);
        Distancia distanciaTramo= tramo.getDistancia();
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void pieDistancia() {
        Pie pie = new Pie(token, inicioDireccion, finDireccion);
        Tramo tramo = new Tramo(pie);
        Distancia distanciaTramo= tramo.getDistancia();
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void biciDistancia() {
        Bicicleta bici = new Bicicleta(token, inicioDireccion, finDireccion);
        Tramo tramo = new Tramo(bici);
        Distancia distanciaTramo = tramo.getDistancia();
        Assertions.assertTrue(distanciaTramo.valor > 0);

    }
//
//    @Test
//    public void trenDistancia() {
//        Parada paradaInicio = new Parada("Viva el grupo 8", null);
//        Parada paradaFin = new Parada("Este test no pasa ni en pedo", null);
//        Tren tren = new Tren(null, paradaInicio, paradaFin);
//        Tramo tramo = new Tramo(tren);
//        Distancia distanciaTramo= tramo.getDistancia();
//        Assertions.assertTrue(distanciaTramo.valor > 0);
//    }

    private void crearLineaSubte() {
        Linea linea = new Linea("linea");

        for (int i = 0; i <10; i++) {
//            Parada parada = new Parada("parada", i);

        }

    }


}