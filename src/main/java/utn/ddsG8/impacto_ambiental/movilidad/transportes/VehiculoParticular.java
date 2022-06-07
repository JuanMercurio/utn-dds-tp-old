package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.DistanciaServicio;

import java.io.IOException;

public abstract class VehiculoParticular implements Transporte {
    private Direccion inicio;
    private Direccion fin;

    @Override
    public Distancia distancia(String token) throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        return api.distancia(token, inicio, fin);
    }
}
