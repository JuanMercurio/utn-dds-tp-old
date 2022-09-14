package persistence;

import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.db.EntityManagerHelper;
import utn.ddsG8.impacto_ambiental.model.services.distancia.*;

import java.util.List;

public class EntityManagerTest {
    public final String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";

    @Test
    public void persistirEstructuras() {

//        Pais pais = new Pais(1, "nombre de pais");
//        Provincia provincia = new Provincia(9, "nombre de provincia", pais);
//        Municipio municipio = new Municipio(1, "nombre de municipio",provincia);
//        Localidad localidad = new Localidad(1, "nombre de localidad", 1234, municipio);

        List<Pais> paises = DistanciaServicio.getInstancia().paises(token, 1);
        List<Provincia> provincias = DistanciaServicio.getInstancia().provincias(token, 1);
//        List<Municipio> municipios = DistanciaServicio.getInstancia().municipios(token, 1);
//        List<Localidad> localidades = DistanciaServicio.getInstancia().localidades(token, 1);

        EntityManagerHelper.beginTransaction();

        paises.forEach(p -> EntityManagerHelper.persist(p));
//        provincias.forEach(p -> EntityManagerHelper.getEntityManager().persist(p));
//        municipios.forEach(m -> EntityManagerHelper.persist(m));
//        localidades.forEach(l -> EntityManagerHelper.persist(l));
        // TODO verificar cascadas y demas para poder persistir lo que queda

        EntityManagerHelper.commit();


    }
}
