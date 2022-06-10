package utn.ddsG8.impacto_ambiental.movilidad.transportes.publico;

public class Tren extends TransportePublico {

    public Tren(Linea linea, Parada paradaInicio, Parada ParadaFin) {
        this.paradaInicio = paradaInicio;
        this.paradaFin = paradaFin;
        this.linea = linea;

    }
}
