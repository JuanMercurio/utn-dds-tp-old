package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;
import java.time.LocalDate;

public class Tramo {
    private LocalDate fecha;
    private Transporte transporte;
    private Distancia distancia;            // cuando se crea el tramo se deberia calcular la distancia y guardar aca
                                            // esto es porque es aleatoria la distancia
    private Direccion DireccionFinal;
    private Direccion DireccionInicial;

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

    public Distancia calcularDistancia(String token) {
        try {
            return transporte.calcularDistancia(token);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // un peligro pero bueno
        }
    }

    public Distancia getDistancia() {
        return this.distancia;
    }

    public void setDistancia(String token) {
        this.distancia = this.calcularDistancia(token);
    }


}
