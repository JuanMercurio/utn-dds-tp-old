package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

public class Parada {
    private Parada proximaParada;
    private String nombre;
    private Linea linea;

    public int distancia(Parada paradaFinal) {
        return this.distanciaProximaParada() + this.proximaParada.distanciaProximaParada();
    }

    public int distanciaProximaParada() {
       return 0;
    }
}
