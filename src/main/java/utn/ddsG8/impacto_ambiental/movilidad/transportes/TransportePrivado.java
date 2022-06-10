package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.DistanciaServicio;

import java.io.IOException;

public abstract class TransportePrivado implements Transporte {
    protected Direccion inicio;
    protected Direccion fin;
    protected String token;

    @Override
    public void calcularHC() {

    }

    @Override
    public Distancia calcularDistancia() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        return api.distancia(this.token, inicio, fin);
    }

    public Distancia getDistanciaTramo() {
        return null;
    }

}
