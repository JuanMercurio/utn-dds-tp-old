package persistence;

import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.db.EntityManagerHelper;
import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.Auto;
import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.Bicicleta;
import utn.ddsG8.impacto_ambiental.model.services.distancia.*;

import java.util.ArrayList;
import java.util.List;

public class EntityManagerTest {
    private static final String token = "Bearer E8iN6xBPXQsUI+M72MfPdVhM/o3axkzywqKZjjOyhe0=";
    private static List<Pais> paises;
    private static List<Provincia> provincias;
    private static List<Municipio> municipios;
    private static List<Localidad> localidades;


    public void getLocations() {
        // TODO: Este test es muy lento, hay que usar mockito
        paises = DistanciaServicio.getInstancia().paises(token, 1);
        provincias = DistanciaServicio.getInstancia().provincias(token, 1);
        municipios = new ArrayList<Municipio>();
        localidades = new ArrayList<Localidad>();
        for (Provincia p : provincias) {
            List municipiosProvicia = DistanciaServicio.getInstancia().municipios(token, 1, p.id);
            municipios.addAll(municipiosProvicia);
        }
        for (Municipio m : municipios) {
            List localidadesMunicipio = DistanciaServicio.getInstancia().localidades(token, 1, m.id);
            localidades.addAll(localidadesMunicipio);
        }
    }


    @Test
    public void persistirLocations() {

        getLocations();
        EntityManagerHelper.beginTransaction();
        paises.forEach(p -> EntityManagerHelper.getEntityManager().persist(p));
        EntityManagerHelper.commit();
        EntityManagerHelper.beginTransaction();
        provincias.forEach(p -> EntityManagerHelper.getEntityManager().persist(p));
        EntityManagerHelper.commit();
        EntityManagerHelper.beginTransaction();
        municipios.forEach(m -> EntityManagerHelper.getEntityManager().persist(m));
        EntityManagerHelper.commit();
        EntityManagerHelper.beginTransaction();
        localidades.forEach(l -> EntityManagerHelper.getEntityManager().persist(l));
        EntityManagerHelper.commit();
    }

    @Test
    public void movilidad() {
        Auto auto = new Auto(null);
        Bicicleta bici = new  Bicicleta();

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(auto);
        EntityManagerHelper.getEntityManager().persist(bici);
        EntityManagerHelper.commit();
    }
}
