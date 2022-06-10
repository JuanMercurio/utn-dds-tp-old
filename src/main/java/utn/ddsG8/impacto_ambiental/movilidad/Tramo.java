package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;
import java.time.LocalDate;

public class Tramo {
    private LocalDate fecha;
    private Transporte transporte;
    private Distancia distancia;
    private Direccion DireccionFinal;
    private Direccion DireccionInicial;

    public Tramo(Transporte transporte) {
        this.transporte = transporte;
        this.fecha = LocalDate.now();
        this.distancia = calcularDistancia();
    }

    public Distancia calcularDistancia() {
        try {
            return transporte.calcularDistancia();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: forma elegante de hacer esto
            return null; // un peligro pero bueno
        }
    }

    public Direccion getDireccionFinal() { return DireccionFinal; }
    public void setDireccionFinal(Direccion direccionFinal) { DireccionFinal = direccionFinal; }
    public Direccion getDireccionInicial() { return DireccionInicial; }
    public void setDireccionInicial(Direccion direccionInicial) { DireccionInicial = direccionInicial; }
    public Distancia getDistancia() { return this.distancia; }
}
