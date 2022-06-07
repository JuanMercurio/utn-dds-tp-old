package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.TransportePublico;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;

import java.io.IOException;
import java.time.LocalDate;

public class Tramo {
    private Direccion direccionInicial;
    private Direccion direccionFinal;
    private LocalDate fecha;
    private Transporte transporte;

    public Tramo(Transporte transporte) {
        this.transporte = transporte;
        this.fecha = LocalDate.now();
    }

    public Distancia distancia(String token) throws IOException {
        return transporte.distancia(token);
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