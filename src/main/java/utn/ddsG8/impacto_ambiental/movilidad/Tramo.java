package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;
import java.time.LocalDate;

public class Tramo {
    private LocalDate fecha;
    private Transporte transporte;
    // una solucion al tema de la orgs podria ser agregar organizacion por tramo

    public Tramo(Transporte transporte) {
        this.transporte = transporte;
        this.fecha = LocalDate.now();
    }

    public Distancia distancia(String token) {
        try {
            return transporte.distancia(token);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // un peligro pero bueno
        }
    }
}
