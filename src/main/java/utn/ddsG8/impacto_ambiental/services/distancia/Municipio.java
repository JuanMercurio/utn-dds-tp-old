package utn.ddsG8.impacto_ambiental.services.distancia;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;

public class Municipio {
    public int id;
    public String nombre;
    public Provincia provincia;
    public Retrofit retrofit;
}
