package utn.ddsG8.impacto_ambiental.calculos;

public class Medicion {
    // todo: le agregamos la fecha de cuando se cargo?
    private String actividad;
    //todo: creamos una clase tipo consumo donde tenga precargado las unidades?
    private String tipoConsumo;
    private String valor;
    private String periocidad;
    private String periodoDeImputacion;


    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(String tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    public String getPeriodoDeImputacion() {
        return periodoDeImputacion;
    }

    public void setPeriodoDeImputacion(String periodoDeImputacion) {
        this.periodoDeImputacion = periodoDeImputacion;
    }
}
