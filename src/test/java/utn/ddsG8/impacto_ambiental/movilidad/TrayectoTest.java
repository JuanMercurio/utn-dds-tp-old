package utn.ddsG8.impacto_ambiental.movilidad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Auto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Pie;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.Localidad;


class TrayectoTest {
    private final String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";
    private final Localidad localidad = new Localidad(3908, "ALDEA BRASILERA", 3101, null);
    private final Direccion inicio = new Direccion("Grupo8", 100, localidad);
    private final Direccion fin = new Direccion("No llegamos con la entrega", 100, localidad);
    private Tramo tramoAuto;
    private Tramo tramoPie;

    @BeforeEach
    public void inicarTramos() {
        Auto auto = new Auto(inicio, fin, null);
        Pie pie = new Pie(inicio, fin);
        this.tramoAuto = new Tramo(auto);
        this.tramoPie = new Tramo(pie);
        tramoAuto.setDistancia(token);
        tramoPie.setDistancia(token);
    }

    @Test
    public void multiplesTrayectosAutoTest() {
        Trayecto trayecto = new Trayecto();
        trayecto.agregarTramos(tramoAuto, tramoPie, tramoAuto, tramoPie);
        float distInt = trayecto.distanciaTest();
        Distancia distancia = trayecto.distancia();
        System.out.println(distInt);
        Assertions.assertTrue(distInt > 0);
    }
}