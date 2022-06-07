package utn.ddsG8.impacto_ambiental.movilidad.transportes;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;

public interface Transporte {
    public void calcularHC();
    public Distancia distancia(String token) throws IOException;
}
