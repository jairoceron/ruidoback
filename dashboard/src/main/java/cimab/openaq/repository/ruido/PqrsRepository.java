package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.Estadotramite;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PqrsRepository extends JpaRepository<Pqrs, Integer> {

    @Query(value = "select p.* from sde.visitas v, " +
            "    sde.pqrs p " +
            "    where v.radicado = p.radicado ",
            nativeQuery = true)
    List<Pqrs> listPqrs();

    @Query(value = "select * from sde.pqrs q where q.radicado = :radicado ",
            nativeQuery = true)
    Pqrs consultaPorRadicado(String radicado);
}
