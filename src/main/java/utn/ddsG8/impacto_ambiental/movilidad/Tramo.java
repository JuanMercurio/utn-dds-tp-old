package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;
import java.time.LocalDate;

public class Tramo {
    private Direccion direccionInicial;
    private Direccion direccionFinal;
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

    public Direccion getDireccionInicial() {
        return direccionInicial;
    }

    public void setDireccionInicial(Direccion direccionInicial) {
        this.direccionInicial = direccionInicial;
    }

    public Direccion getDireccionFinal() {
        return direccionFinal;
    }

    public void setDireccionFinal(Direccion direccionFinal) {
        this.direccionFinal = direccionFinal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
}