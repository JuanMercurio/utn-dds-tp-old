package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

public class ServicioContratado implements Transporte{
    @Override
    public void crearTramo(Direccion inicio, Direccion fin) {

    }

    @Override
    public void calcularHC() {

    }

    @Override
    public Distancia distancia(String token) {
        return null;
    }
}
