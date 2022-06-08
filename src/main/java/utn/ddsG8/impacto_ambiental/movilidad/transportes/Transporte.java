package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;

public interface Transporte {

    public void calcularHC();
    public Distancia calcularDistancia(String token) throws IOException;
    public Distancia getDistanciaTramo();
}
