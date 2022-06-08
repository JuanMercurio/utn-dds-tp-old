package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;
import java.time.LocalDate;

public class Tramo {
    private LocalDate fecha;
    private Transporte transporte;
    private Direccion DireccionFinal;
    private Direccion DireccionInicial;
    // una solucion al tema de la orgs podria ser agregar organizacion por tramo

    public Direccion getDireccionFinal() {
        return DireccionFinal;
    }

    public void setDireccionFinal(Direccion direccionFinal) {
        DireccionFinal = direccionFinal;
    }

    public Direccion getDireccionInicial() {
        return DireccionInicial;
    }

    public void setDireccionInicial(Direccion direccionInicial) {
        DireccionInicial = direccionInicial;
    }

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
