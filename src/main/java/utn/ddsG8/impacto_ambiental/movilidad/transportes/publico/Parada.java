package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.services.distancia.Distancia;
import utn.ddsG8.impacto_ambiental.services.distancia.DistanciaServicio;

import java.io.IOException;

public class Parada {

    private Parada proximaParada;
    private Parada anteriorParada;
    private Direccion direccion;
    private String nombre;
    private Linea linea;
    // lo agrega el administrador
    private double distanciaProximaParada;
    private double distanciaAnteriorParada;

    public Parada(String nombre, Linea linea, Direccion direccion, double distanciaProxima, double distanciaAnterior, int i) {
        this.nombre = nombre;
        this.linea = linea;
        this.direccion = direccion;
        this.distanciaProximaParada = distanciaProxima;
        this.distanciaAnteriorParada = distanciaAnterior;
        linea.agregarParada(this, distanciaProxima, distanciaAnterior, i);
    }

    public void setProximaParada(Parada proxima, double distancia){
        this.proximaParada = proxima;
        this.distanciaProximaParada = distancia;
    }
    public void setAnteriorParada(Parada anterior, double distancia){
        this.anteriorParada = anterior;
        this.distanciaAnteriorParada = distancia;
    }






   // ya no tiene mucho sentido
    public void AgregarParadaAnteriorYProxima(Parada proxima,Parada anterior){
        this.proximaParada = proxima;
        this.anteriorParada = anterior;
    }


    // not safe
    //todo checkear con los nuevos cambios.
    public double distanciaAParada(Parada paradaFinal) {
        return this.nombre == paradaFinal.nombre ?
               0 : this.distanciaProximaParada + this.proximaParada.distanciaAParada(paradaFinal);
    }
    public void nuevaParada(Parada parada) {
        parada.setProximaParada(this.proximaParada);
        parada.setAnteriorParada(this);
        this.proximaParada = parada;
    }

    // getters y setters genericos.
      public double getDistanciaProximaParada() {
        return distanciaProximaParada;
    }

    public void setDistanciaProximaParada(double distanciaProximaParada) {
        this.distanciaProximaParada = distanciaProximaParada;
    }

    public double getDistanciaAnteriorParada() {
        return distanciaAnteriorParada;
    }

    public void setDistanciaAnteriorParada(double distanciaAnteriorParada) {
        this.distanciaAnteriorParada = distanciaAnteriorParada;
    }

    public Parada getProximaParada() {
        return this.proximaParada;
    }

    public Parada getAnteriorParada() {
        return anteriorParada;
    }

    public void setAnteriorParada(Parada anteriorParada) {
        this.anteriorParada = anteriorParada;
    }

    public void setProximaParada(Parada parada) {
        this.proximaParada = parada;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
