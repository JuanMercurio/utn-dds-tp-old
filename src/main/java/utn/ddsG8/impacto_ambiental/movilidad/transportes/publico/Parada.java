package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

public class Parada {

    private Parada proximaParada;           // esto se podria hacer como una lista de paradas en la linea
    private Parada anteriorParada;          // verificar si es legal. Seria mas facil que esto
    private String nombre;
    private Linea linea;

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
        // TODO: agregar distancia a la proxima parada como un atributo? Cuado se crea
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

}
