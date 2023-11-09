package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.Estadotramite;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PqrsRepository extends JpaRepository<Pqrs, Integer> {
    //   rdoEstadoTramite.setId(ESTADO_TRAMITE_PROVISIONAL);
    //   rdoEstadoTramite.setNombre("PROVISIONAL");
    @Query(value = "select p.* from sde.pqrs p " +
            "               where " +
            "               entidad_de_control = 'SI'  " +
            "               and estado_tramite = :ESTADO_TRAMITE_PROVISIONAL  " +
            "               and p.fecha_radicado between :fechaInicial and  :fechaFinal order by p.fecha_radicado desc",
            nativeQuery = true)
    List<Pqrs> listPqrs(java.sql.Timestamp fechaInicial, java.sql.Timestamp fechaFinal, int ESTADO_TRAMITE_PROVISIONAL);




    @Query(value = "select * from sde.pqrs q where q.radicado = :radicado LIMIT 1",
            nativeQuery = true)
    Pqrs consultaPorRadicado(String radicado);

    @Query(value = "select e.nombre , count(1) from " +
            " sde.pqrs p , " +
            " sde.rdo_estado e " +
            " where p.estado_tramite is not null " +
            " and p.fecha_radicado between :fechaInicial and :fechaFinal " +
            " and p.estado_tramite = e.nombre " +
            " group by e.nombre order by count(1) desc",
            nativeQuery = true)
    List<Object[]> chartEstadoTramite(java.sql.Timestamp fechaInicial, java.sql.Timestamp fechaFinal);

    @Query(value = "select CASE " +
            "           WHEN estado_tramite <> 9 " +
            "                 THEN 'OTROS'  " +
            "           WHEN estado_tramite = 9 " +
            "                 THEN 'NO ES COMPETENCIA'   " +
            "       END estadoVnk, count(1)   " +
            "       from sde.pqrs p  " +
            "       where estado_tramite is not null  " +
            "       and p.fecha_radicado between :fechaInicial and :fechaFinal " +
            "      group by estadoVnk",
            nativeQuery = true)
    List<Object[]> chartNoEsCompetencia(java.sql.Timestamp fechaInicial, java.sql.Timestamp fechaFinal);
    /*
    *        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(9);
        rdoEstadoTramite.setNombre("NO ES COMPETENCIA");
        listREsTram.add(rdoEstadoTramite);
    * */

    @Query(value = "select CASE " +
            "           WHEN estado_tramite <> :ESTADO_TRAMITE_PROVISIONAL " +
            "                 THEN 'OTROS'  " +
            "           WHEN estado_tramite = :ESTADO_TRAMITE_PROVISIONAL " +
            "                 THEN 'PROVISIONAL'   " +
            "       END estadoVnk, count(1)   " +
            "       from sde.pqrs p  " +
            "       where estado_tramite is not null  " +
            "       and p.fecha_radicado between :fechaInicial and :fechaFinal " +
            "      group by estadoVnk",
            nativeQuery = true)
    List<Object[]> chartProvisionalET(java.sql.Timestamp fechaInicial, java.sql.Timestamp fechaFinal, int ESTADO_TRAMITE_PROVISIONAL);
            // rdoEstadoTramite.setId(ESTADO_TRAMITE_PROVISIONAL);
        // rdoEstadoTramite.setNombre("PROVISIONAL");
        // listREsTram.add(rdoEstadoTramite);

    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_radicado between :fechaInicial and  :fechaFinal " +
            "   and p.direccion like %:direccion%",
            nativeQuery = true)
    List<Pqrs> pqrsPorDireccion(@Param("fechaInicial") java.sql.Timestamp fechaInicial,
                                      @Param("fechaFinal") java.sql.Timestamp fechaFinal ,
                                      @Param("direccion") String direccion);

    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_radicado between :fechaInicial and  :fechaFinal " +
            "   and p.localidad like %:localidad%",
            nativeQuery = true)
    List<Pqrs> pqrsPorLocalidad(@Param("fechaInicial") java.sql.Timestamp fechaInicial,
                                @Param("fechaFinal") java.sql.Timestamp fechaFinal ,
                                @Param("localidad") String localidad);




    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_radicado between :fechaInicial and  :fechaFinal " +
            "   and p.peticionario like %:peticionario%",
            nativeQuery = true)
    List<Pqrs> consultaPorPeticionario(@Param("fechaInicial") java.sql.Timestamp fechaInicial,
                                @Param("fechaFinal") java.sql.Timestamp fechaFinal ,
                                @Param("peticionario") String peticionario);



    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_radicado between :fechaInicial and  :fechaFinal " +
            "   and estado_tramite = :estadoTramite and observaciones_estado_tramite = :observacionEstadoTramite ",
            nativeQuery = true)
    List<Pqrs> reporteDeAntecedentes(@Param("fechaInicial") java.sql.Timestamp fechaInicial,
                          @Param("fechaFinal") java.sql.Timestamp fechaFinal ,
                          @Param("estadoTramite") int estadoTramite ,
                          @Param("observacionEstadoTramite") String observacionEstadoTramite );



    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_radicado between :fechaInicial and  :fechaFinal " +
            "   and estado_tramite = :estadoTramite and observaciones_estado_tramite = :observacionEstadoTramite " +
            "   and localidad = :localidad  ",
            nativeQuery = true)
    List<Pqrs> visitaConsultaNoEsCompetencia (@Param("fechaInicial") java.sql.Timestamp fechaInicial,
                                             @Param("fechaFinal") java.sql.Timestamp fechaFinal ,
                                             @Param("estadoTramite") int estadoTramite ,
                                             @Param("observacionEstadoTramite") String observacionEstadoTramite,
                                              @Param("localidad") String localidad   );

    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_radicado between :fechaInicial and  :fechaFinal " +
            "   and p.estado_tramite like %:estadoTramite%",
            nativeQuery = true)
    List<Pqrs> consultaPqrsEstramite(@Param("fechaInicial") java.sql.Timestamp fechaInicial,
                                     @Param("fechaFinal") java.sql.Timestamp fechaFinal ,
                                     @Param("estadoTramite") String estadoTramite);

    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_radicado between :fechaInicial and  :fechaFinal " +
            "   and p.estado_tramite = :estadoTramite",
            nativeQuery = true)
    List<Pqrs> consultaPqrsEstramiteVnk(@Param("fechaInicial") java.sql.Timestamp fechaInicial,
                                     @Param("fechaFinal") java.sql.Timestamp fechaFinal ,
                                     @Param("estadoTramite") int estadoTramite);


    @Query(value = "select p.* from sde.pqrs p " +
            "   where p.fecha_radicado between :fechaInicial and  :fechaFinal " +
            "   and entidad_de_control = 'SI'",
            nativeQuery = true)
    List<Pqrs> consultaOrganismoControl(@Param("fechaInicial") Timestamp fechaInicial,
                                     @Param("fechaFinal") Timestamp fechaFinal );


/*
    @Query(value = "select q.* from sde.pqrs q where q.radicado in (select p.radicado from sde.visitas v, " +
            "    sde.pqrs p " +
            "    where v.tipo_predio_generador_emision  like %:tipoPredio% " +
            "    and v.radicado = p.radicado " +
            "    and  p.fecha_radicado between :fechaInicial and :fechaFinal " +
            "   group by p.radicado)",
            nativeQuery = true)
    List<Pqrs> consultaPqrsTipoPredio(@Param("fechaInicial") Date fechaInicial,
                                     @Param("fechaFinal") Date fechaFinal ,
                                     @Param("tipoPredio") String tipoPredio);
*/

    @Query(value = "select q.* from sde.pqrs q where  " +
            " sector_reportado = :tipoPredio and " +
            " q.fecha_radicado between :fechaInicial and :fechaFinal  " +
            "               ",
            nativeQuery = true)
    List<Pqrs> consultaPqrsTipoPredio(@Param("fechaInicial") java.sql.Timestamp fechaInicial,
                                      @Param("fechaFinal") java.sql.Timestamp fechaFinal ,
                                      @Param("tipoPredio") String tipoPredio);
}
