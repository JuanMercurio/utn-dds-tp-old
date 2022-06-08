package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;

public class Parada {

    private Parada proximaParada;
    private Parada anteriorParada;
    private Direccion direccion;
    private String nombre;
    private Linea linea;
    private double distanciaProximaParada;
    private double distanciaAnteriorParada;

    public Parada(String nombre, Linea linea, Parada proxima, Parada anterior) {
        this.nombre = nombre;
        this.linea = linea;
        this.proximaParada = proxima;
        this.anteriorParada = anterior;
    }

    // not safe
    public int distanciaAParada(Parada paradaFinal) {
        return this.nombre == paradaFinal.nombre ?
               0 : this.distanciaProximaParada() + this.proximaParada.distanciaAParada(paradaFinal);
    }

    public int distanciaProximaParada() {

        // todo llamar a la API
       return 0;
    }

   public void nuevaParada(Parada parada) {
        parada.setProximaParada(this.proximaParada);
        parada.setAnteriorParada(this);
        this.proximaParada = parada;
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
