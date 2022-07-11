package utn.ddsG8.impacto_ambiental.estructura;

import org.omg.CORBA.PRIVATE_MEMBER;

public class FactorEmision {
    private String actividad;
    private String TipoConsumo;
    private String unidad;
    // PARA TODOS LAS LOGISTICAS SON EL MISMO VALOR DE EMISION.
    private double valorFactEmision;

    public FactorEmision(String actividad, String tipoConsumo, String unidad, double valorFactEmision) {
        this.actividad = actividad;
        TipoConsumo = tipoConsumo;
        this.unidad = unidad;
        this.valorFactEmision = valorFactEmision;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTipoConsumo() {
        return TipoConsumo;
    }

    public void setTipoConsumo(String tipoConsumo) {
        TipoConsumo = tipoConsumo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getValorFactEmision() {
        return valorFactEmision;
    }

    public void setValorFactEmision(double valorFactEmision) {
        this.valorFactEmision = valorFactEmision;
    }
}
