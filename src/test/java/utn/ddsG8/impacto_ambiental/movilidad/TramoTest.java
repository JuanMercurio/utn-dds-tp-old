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
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.Localidad;

class TramoTest {
    private final String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";
    private final Localidad localidad = new Localidad(3908, "ALDEA BRASILERA", 3101, null);
    private final Direccion inicio = new Direccion("Grupo8", 100, localidad);
    private final Direccion fin = new Direccion("No llegamos con la entrega", 100, localidad);

    @Test
    public void autoDistancia() {
        Combustible combustible = new Nafta();
        Auto auto = new Auto(inicio, fin, combustible);
        Tramo tramo = new Tramo(auto);
        Distancia distanciaTramo= tramo.calcularDistancia(token);
//        System.out.println(distanciaTramo.valor + distanciaTramo.unidad);
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void motoDistancia() {
        Combustible combustible = new Nafta();
        Moto moto = new Moto(inicio, fin, combustible);
        Tramo tramo = new Tramo(moto);
        Distancia distanciaTramo= tramo.calcularDistancia(token);
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void pieDistancia() {
        Pie pie = new Pie(inicio, fin);
        Tramo tramo = new Tramo(pie);
        Distancia distanciaTramo= tramo.calcularDistancia(token);
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }

    @Test
    public void biciDistancia() {
        Bicicleta bici = new Bicicleta(inicio, fin);
        Tramo tramo = new Tramo(bici);
        Distancia distanciaTramo= tramo.calcularDistancia(token);
        Assertions.assertTrue(distanciaTramo.valor > 0);
    }
}