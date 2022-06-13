package utn.ddsG8.impacto_ambiental.movilidad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Auto;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Pie;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Parada;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.TransportePublico;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.Tren;
import utn.ddsG8.impacto_ambiental.services.distancia.*;


class TrayectoTest {
    private final String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";
    private final Localidad localidad = new Localidad(3908, "ALDEA BRASILERA", 3101, null);
    private final Direccion inicio = new Direccion("Grupo8", 100, localidad);
    private final Direccion fin = new Direccion("No llegamos con la entrega", 100, localidad);
    private Tramo tramoAuto;
    private Tramo tramoPie;
    private TransportePublico transportePublico;
    private Tramo tramoTren1;
    private Tramo tramoTren2;

    @BeforeEach
    public void iniciarTramos() {
        Auto auto = new Auto(null);
        Pie pie = new Pie();
        this.transportePublico = crearTren();
        this.tramoAuto = new TramoTransportePrivado(auto, inicio, fin, token);
        this.tramoPie = new TramoTransportePrivado(pie, inicio, fin, token);
        tramoTren1 = new TramoTransportePublico(transportePublico, transportePublico.getParadas().get(2), transportePublico.getParadas().get(4));
        tramoTren2 = new TramoTransportePublico(transportePublico, transportePublico.getParadas().get(6), transportePublico.getParadas().get(7));
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
    public void distanciaDeTrayectoPrivadoYPublico() {
        Trayecto trayecto = new Trayecto();
        trayecto.agregarTramos(tramoTren1, tramoAuto, tramoTren2, tramoAuto);
        Assertions.assertTrue(trayecto.getDistancia().valor > 0);
    }

    private TransportePublico crearTren() {
        TransportePublico tren = new Tren("Aguante Pablo");
        for (int i = 0; i <10; i++) {
            Parada parada = new Parada("parada "+i, tren, null, 123, 123, i);
        }
        return tren;
    }
}