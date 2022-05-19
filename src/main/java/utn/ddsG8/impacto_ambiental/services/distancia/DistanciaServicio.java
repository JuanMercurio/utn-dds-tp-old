package utn.ddsG8.impacto_ambiental.services.distancia;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class DistanciaServicio {
    private static DistanciaServicio instancia = null;
    private static final String URL= "https://ddstpa.com.ar/"; //agregar para obtener de archivo de config
    private final Retrofit retrofit;

    private DistanciaServicio() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static DistanciaServicio getInstancia() {
        if (instancia == null) {
            instancia = new DistanciaServicio();
        }
        return instancia;
    }

    public List<Pais> paises(String token, int offset) throws IOException {
        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<List<Pais>> requestPaises= distanciaAPI.paises(token, offset);
        Response<List<Pais>> responsePaises = requestPaises.execute();
        return responsePaises.body();
    }

    public List<Provincia> provincias(String token, int offset) throws IOException {
        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<List<Provincia>> requestProvincia= distanciaAPI.provincias(token, offset);
        Response<List<Provincia>> responseProvincia = requestProvincia.execute();
        return responseProvincia.body();
    }

    public List<Provincia> provincias(String token, int offset, int pais) throws IOException {
        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<List<Provincia>> requestProvincia= distanciaAPI.provincias(token, offset, pais);
        Response<List<Provincia>> responseProvincia = requestProvincia.execute();
        return responseProvincia.body();
    }


    public List<Localidad> localidades(String token, int offset) throws IOException {
        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<List<Localidad>> requestLocalidad = distanciaAPI.localidades(token, offset);
        Response<List<Localidad>> responseLocalidad = requestLocalidad.execute();
        return responseLocalidad.body();
    }

    public List<Localidad> localidades(String token, int offset, int provincia) throws IOException {
        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<List<Localidad>> requestLocalidad = distanciaAPI.localidades(token, offset, provincia);
        Response<List<Localidad>> responseLocalidad = requestLocalidad.execute();
        return responseLocalidad.body();
    }


    public List<Municipio> municipios(String token, int offset) throws IOException {
        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<List<Municipio>> requestMunicipio = distanciaAPI.municipios(token, offset);
        Response<List<Municipio>> responseMunicipio = requestMunicipio.execute();
        return responseMunicipio.body();
    }

    public List<Municipio> municipios(String token, int offset, int provincia) throws IOException {
        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<List<Municipio>> requestMunicipio = distanciaAPI.municipios(token, offset, provincia);
        Response<List<Municipio>> responseMunicipio = requestMunicipio.execute();
        return responseMunicipio.body();
    }


    public Distancia distancia(String token,
                               int localidadOrigenId,
                               String calleOrigen,
                               String alturaOrigen,
                               int localidadDestinoId,
                               String calleDestino,
                               String alturaDestino)
                               throws IOException {

        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<Distancia> requestDistancia = distanciaAPI.distancia(token, localidadOrigenId, calleOrigen, alturaOrigen,
                                                                  localidadDestinoId, calleDestino, alturaDestino);
        Response<Distancia> responseDistancia = requestDistancia.execute();
        if (responseDistancia.code() != 200) {
            System.out.println(responseDistancia.code() + responseDistancia.message());
        }
        return responseDistancia.body();
    }


    public UserRespuesta crearUsuario(UserCrear user) throws IOException {
        DistanciaAPI distanciaAPI = this.retrofit.create(DistanciaAPI.class);
        Call<UserRespuesta> requestUser = distanciaAPI.user(user);
        Response<UserRespuesta> responseUser = requestUser.execute();
        return responseUser.body();
    }
}
