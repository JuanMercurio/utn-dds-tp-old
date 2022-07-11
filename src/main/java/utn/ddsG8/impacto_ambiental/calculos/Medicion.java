package utn.ddsG8.impacto_ambiental.calculos;

public class Medicion {
    private String actividad;
    private String tipoConsumo;
    private String valor;
    private String periocidad;
    private String periodoDeImputacion;
    private int anio;
    private int mes;
    private double valorD;


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
        try{
            this.valorD = Double.parseDouble(valor);

        }catch (NumberFormatException ex) {
            this.valorD = 0;
            ex.printStackTrace();
        }
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
        if(periodoDeImputacion.length() == 4){
            try{
                this.anio = Integer.parseInt(periodoDeImputacion);
                // INDICA QUE ESA MEDICION. ES ANUAL Y NO POR MES.
                this.mes = -1;
            }catch (NumberFormatException ex)
            {
                // no tiene motivo alguno. solo puse 2022.
                this.anio = 2022;
                this.mes = -1;
                ex.printStackTrace();
            }

        }
        else{
            String month,year;
            month = periodoDeImputacion.substring(0,2);
            year = periodoDeImputacion.substring(2,4);
            try{
                this.mes = Integer.parseInt(month);
                this.anio = Integer.parseInt(year);
            }catch (NumberFormatException ex)
            {
                // no tiene motivo alguno. solo puse 2022. y mes enero.
                this.anio = 2022;
                this.mes = 1;
                ex.printStackTrace();
            }

        }
        this.periodoDeImputacion = periodoDeImputacion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getValorD() {
        return valorD;
    }

    public void setValorD(double valorD) {
        this.valorD = valorD;
    }
}
