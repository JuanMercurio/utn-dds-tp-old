package persistence;

import org.junit.jupiter.api.Test;
import utn.ddsG8.impacto_ambiental.db.EntityManagerHelper;
import utn.ddsG8.impacto_ambiental.model.estructura.*;
import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.Auto;
import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.publico.Colectivo;
import utn.ddsG8.impacto_ambiental.model.movilidad.transportes.publico.Subte;
import utn.ddsG8.impacto_ambiental.model.services.distancia.*;

import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
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

//    Comento este test porque no usa mockito y tarda como 1 min en correr
//    @Test
    public void persistirMovilidad() {
        Auto auto = new Auto(null);
        Subte subte = new Subte(null);
        Colectivo colectivo = new Colectivo(null);

        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.getEntityManager().persist(auto);
        EntityManagerHelper.getEntityManager().persist(subte);
        EntityManagerHelper.getEntityManager().persist(colectivo);

        EntityManagerHelper.commit();

    }

    @Test
    public void persistirEstructura() {

        Direccion direccion = new Direccion("ejemplo_calle", new Integer(123) , null);
        Organizacion org = new Organizacion(
                "ejemplo razonSocial",
                OrgTipo.Empresa,
                Clasificacion.Empresa_del_Sector_Primario,
                direccion);
        Sector s = new Sector("soy un sector", org);

        Miembro m1 = new Miembro( "aprobame",  "pablo", TipoDoc.DNI, "12341234");
        Miembro m2 = new Miembro( "aprobame",  "pablo", TipoDoc.DNI, "12341234");

        m1.unirseAOrg(org, s);

        org.aceptarTodosLosMiembros();

        m2.unirseAOrg(org, s);

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(org);
        EntityManagerHelper.commit();
    }

    @Test
    public void encontrarProvincias() {
        String queryString = "FROM Provincia";
        Query query = EntityManagerHelper.createQuery(queryString);
        List<Provincia> provincias = query.getResultList();
        provincias.forEach(p -> System.out.println(p.nombre));
    }

}
