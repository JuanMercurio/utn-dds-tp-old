package utn.ddsG8.impacto_ambiental.estructura;

import utn.ddsG8.impacto_ambiental.calculos.Medicion;

import java.util.ArrayList;
import java.util.List;
// clase singleton. se instancia una sola vez.
public class CalcularHC {
    private float K;
    private List<FactorEmision> factoresDeEmision;

    public CalcularHC(){
        factoresDeEmision = new ArrayList<>();
        this.K = 2;
    }
    // TODO: CALCULAR HUELAL DE CARBONO DEL EXCEL
    // TODO: CALCULAR HUELLAD E CARBONO DE LOGISTICA.
    // DE DONDE SALE EL fe?
    public void cargarFactorEmision (FactorEmision fe){
        this.factoresDeEmision.add(fe);

    }

    public void modificarFE (String actividad, String tipoConsumo, float valorEmision){
        for (FactorEmision fe: factoresDeEmision) {
            if(fe.getActividad() == actividad && fe.getTipoConsumo() == tipoConsumo){
                fe.setValorFactEmision(valorEmision);
            }
        }

    }
    // si lo encuentra lo devuelve. si no devuelve -1.
    public double buscarFactorEmision ( String actividad, String tipoConsumo){
        for (FactorEmision fe: factoresDeEmision) {
            if(fe.getActividad().contains(actividad) && fe.getTipoConsumo().contains(tipoConsumo)){
                return fe.getValorFactEmision();
            }
        }
        return -1;
    }
    //todo CalcularFEMensual
    public double CalcularFEMensual (Organizacion organizacion, int anio, int mes){

        return 1;
    }
    //todo CalcularFEAnual
    public double CalcularFEAnual (Organizacion organizacion, int anio){

        return 1;
    }

    public double CalcularFEActividades (List<Medicion> mediciones){
        double medicionAcum = 0;
        double distMedia = 0,pesoTotal = 0;
        double fe;
        for (Medicion med: mediciones) {
            if( med.getActividad().contains("Logística")){
                /*if (med.getTipoConsumo().contains("Distancia media")){
                    distMedia = med.getValorD();
                }
                else if(med.getTipoConsumo().contains("Distancia media")){
                    pesoTotal = med.getValorD();
                }
                if( distMedia != 0 && pesoTotal != 0){
                    distMedia = 0; pesoTotal = 0;
                    //todo: suponemos que tiene su factor de emision.
                    fe = buscarFactorEmision("Logística de productos y residuos","");
                    if( fe != -1 ) {
                        medicionAcum += fe*distMedia*pesoTotal*K;
                    }
                }*/

            }
            else{
                fe = buscarFactorEmision(med.getActividad(),med.getTipoConsumo());
                if( fe != -1 ){
                    medicionAcum += fe * med.getValorD();
                }
            }

        }
        return medicionAcum;
    }
}
