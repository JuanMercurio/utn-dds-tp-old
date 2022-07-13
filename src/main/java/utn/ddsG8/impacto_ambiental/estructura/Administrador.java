package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.calculos.CalcularHC;
import utn.ddsG8.impacto_ambiental.calculos.FE;
import utn.ddsG8.impacto_ambiental.movilidad.transportes.publico.*;

import java.util.List;

public class Administrador {
    private String usuario;
    private String contrasenia;
    private List<Organizacion> organizaciones;
    private CalcularHC calculador;

    public CalcularHC getCalculador() {
        return calculador;
    }

    public void setCalculador(CalcularHC calculador) {
        this.calculador = calculador;
    }

    public void CrearColectivo(String nombre){
        Colectivo unColectivo = new Colectivo(nombre);

    }
    public void CrearSubte(String nombre){
        Subte unColectivo = new Subte(nombre);

    }
    public void CrearTren(String nombre){
        Tren unColectivo = new Tren(nombre);

    }
    //String nombre, TransportePublico transportePublico, Direccion direccion, double distanciaProxima, double distanciaAnterior, int i
    public void AgregarParadaTransportePublico(String nombre, TransportePublico transportePublico, Direccion direccion,
                                               double distanciaProxima, double distanciaAnterior, int i ){
        // TODO: Ver si se le saca la distancia entre paradas entre el constructor.
        Parada nuevaParada = new Parada(nombre,direccion);
        transportePublico.agregarParada(nuevaParada,distanciaProxima,distanciaAnterior,i);
    }


    // TODO: LEVANTAR ARCHIVO O PONER FIJO CADA FE DE LA TABLA DE LA ENTREGA 2

    public  void ModificarFactirEmision ( String actividad, String tipoConsumo, double factorEmision){
        //MODIFICA solo el FE de una actividad y tipo consumo existente.
        this.calculador.modificarFE(actividad,tipoConsumo,factorEmision);
    }

    public void CargarFE(String actividad, String tipoConsumo, double factorEmision, String unidad){
        FE fe = new FE(actividad,tipoConsumo,unidad,factorEmision);
        this.calculador.cargarFactorEmision(fe);
    }



}
