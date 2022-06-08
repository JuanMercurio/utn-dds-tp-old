package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.DistanciaServicio;

import java.io.IOException;

public class TransportePrivado implements Transporte {
    protected Direccion inicio;
    protected Direccion fin;

    @Override
    public void calcularHC() {

    }

    @Override
    public Distancia distancia(String token) throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        return api.distancia(token, inicio, fin);
    }

}
