package utn.ddsG8.impacto_ambiental.movilidad;

import utn.ddsG8.impacto_ambiental.estructura.Direccion;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.Transporte;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.TransportePublico;

import java.time.LocalDate;

public class Tramo {
    private Direccion direccionInicial;
    private Direccion direccionFinal;
    private LocalDate fecha;
    private Transporte transporte;

    public Tramo(Direccion inicio, Direccion fin, Transporte transporte) {
        this.direccionFinal = fin;
        this.direccionInicial = inicio;
        this.transporte = transporte;
        this.fecha = LocalDate.now();
    }

    public int distancia() {
        return transporte.distancia();
    }
}
