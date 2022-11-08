package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.Estadotramite;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PqrsRepository extends JpaRepository<Pqrs, Integer> {

    @Query(value = "select p.* from sde.visitas v, " +
            "    sde.pqrs p " +
            "    where v.radicado = p.radicado and v.fechavisita between :fechaInicial and  :fechaFinal ",
            nativeQuery = true)
    List<Pqrs> listPqrs(Date fechaInicial, Date fechaFinal);

    @Query(value = "select * from sde.pqrs q where q.radicado = :radicado ",
            nativeQuery = true)
    Pqrs consultaPorRadicado(String radicado);

    @Query(value = "select e.nombre , count(1) from " +
            " sde.pqrs p , " +
            " sde.rdo_estado e " +
            " where p.estado_del_tramite is not null " +
            " and p.fecharadicado between :fechaInicial and :fechaFinal " +
            " and p.estado_del_tramite = e.idestado " +
            " group by e.nombre order by count(1) desc",
            nativeQuery = true)
    List<Object[]> chartEstadoTramite(Date fechaInicial, Date fechaFinal);

}
