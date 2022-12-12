package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.Estadotramite;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
            " and p.fecha_del_radicado between :fechaInicial and :fechaFinal " +
            " and p.estado_del_tramite = e.nombre " +
            " group by e.nombre order by count(1) desc",
            nativeQuery = true)
    List<Object[]> chartEstadoTramite(Date fechaInicial, Date fechaFinal);

    @Query(value = "select CASE " +
            "           WHEN estado_del_tramite <> 'NO ES COMPETENCIA' " +
            "                 THEN 'OTROS'  " +
            "           WHEN estado_del_tramite = 'NO ES COMPETENCIA' " +
            "                 THEN 'NO ES COMPETENCIA'   " +
            "       END estadoVnk, count(1)   " +
            "       from sde.pqrs p  " +
            "       where estado_del_tramite is not null  " +
            "       and p.fecha_del_radicado between :fechaInicial and :fechaFinal " +
            "      group by estadoVnk",
            nativeQuery = true)
    List<Object[]> chartNoEsCompetencia(Date fechaInicial, Date fechaFinal);

    @Query(value = "select CASE " +
            "           WHEN estado_del_tramite <> 'PROVISIONAL' " +
            "                 THEN 'OTROS'  " +
            "           WHEN estado_del_tramite = 'PROVISIONAL' " +
            "                 THEN 'PROVISIONAL'   " +
            "       END estadoVnk, count(1)   " +
            "       from sde.pqrs p  " +
            "       where estado_del_tramite is not null  " +
            "       and p.fecha_del_radicado between :fechaInicial and :fechaFinal " +
            "      group by estadoVnk",
            nativeQuery = true)
    List<Object[]> chartProvisionalET(Date fechaInicial, Date fechaFinal);


    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_del_radicado between :fechaInicial and  :fechaFinal " +
            "   and p.direcciones like %:direccion%",
            nativeQuery = true)
    List<Pqrs> pqrsPorDireccion(@Param("fechaInicial") Date fechaInicial,
                                      @Param("fechaFinal") Date fechaFinal ,
                                      @Param("direccion") String direccion);

    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_del_radicado between :fechaInicial and  :fechaFinal " +
            "   and p.localidad like %:localidad%",
            nativeQuery = true)
    List<Pqrs> pqrsPorLocalidad(@Param("fechaInicial") Date fechaInicial,
                                @Param("fechaFinal") Date fechaFinal ,
                                @Param("localidad") String localidad);




    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_del_radicado between :fechaInicial and  :fechaFinal " +
            "   and p.estado_del_tramite like %:estadoTramite%",
            nativeQuery = true)
    List<Pqrs> consultaPqrsEstramite(@Param("fechaInicial") Date fechaInicial,
                                @Param("fechaFinal") Date fechaFinal ,
                                @Param("estadoTramite") String estadoTramite);




    @Query(value = "select q.* from sde.pqrs q where q.radicado in (select p.radicado from sde.visitas v, " +
            "    sde.pqrs p " +
            "    where v.tipo_de_predio_generador_de_la_  like %:tipoPredio% " +
            "    and v.radicado = p.radicado " +
            "    and  p.fecha_del_radicado between :fechaInicial and :fechaFinal " +
            "   group by p.radicado)",
            nativeQuery = true)
    List<Pqrs> consultaPqrsTipoPredio(@Param("fechaInicial") Date fechaInicial,
                                     @Param("fechaFinal") Date fechaFinal ,
                                     @Param("tipoPredio") String tipoPredio);



}
