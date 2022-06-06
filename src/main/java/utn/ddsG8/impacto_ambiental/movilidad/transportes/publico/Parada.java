package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

public class Parada {
    private Parada proximaParada;
    private Parada anteriorParada;
    private String nombre;
    private Linea linea;

    public Parada() {

    }

    public int distanciaAParada(Parada paradaFinal) {
        return this.nombre == paradaFinal.nombre ?
               0 : this.distanciaProximaParada() + this.proximaParada.distanciaAParada(paradaFinal);
    }

    public int distanciaProximaParada() {
        // TODO: agregar distancia a la proxima parada como un atributo? Cuado se crea
       return 0;
    }
}
