package utn.ddsG8.distancia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.services.distancia.*;

import java.io.IOException;
import java.util.List;

public class distanciaTest {
    private String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";

    @Test
    public void uruarioYaExiste() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        UserRespuesta respuesta = api.crearUsuario(new UserCrear("mail@ejemplo.com"));
        Assertions.assertEquals(null, respuesta);
    }

    @Test
    public void retornaPaises() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Pais> paises = api.paises(token, 1);
        Assertions.assertEquals("ARGENTINA", paises.get(0).nombre);
    }

    @Test
    public void retornaProvincias() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Provincia> provincias = api.provincias(token, 1);
        Assertions.assertTrue(provincias.size() > 0);
    }

    @Test
    public void retornaProvinciasDePais() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Provincia> provincias = api.provincias(token, 1, 9);
        Assertions.assertEquals("BUENOS AIRES", provincias.get(0).nombre);
    }

    @Test
    public void retornaMunicipios() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Municipio> municipios = api.municipios(token, 1);
        Assertions.assertTrue(municipios.size() > 0);
    }

    @Test
    public void retornaMunicipiosDeProvincia() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Municipio> municipios = api.municipios(token, 1, 171);
        Assertions.assertEquals("RAWSON ", municipios.get(0).nombre);
    }

    @Test
    public void retornaLocalidades() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Localidad> localidades = api.localidades(token, 1);
        Assertions.assertTrue(localidades.size() > 0);
    }

    @Test
    public void retornaLocalidadesDeMunicipio() throws IOException {
        DistanciaServicio api = DistanciaServicio.getInstancia();
        List<Localidad> localidades = api.localidades(token, 1, 9);
        Assertions.assertEquals("ALDEA BRASILERA ", localidades.get(0).nombre);
    }
}
