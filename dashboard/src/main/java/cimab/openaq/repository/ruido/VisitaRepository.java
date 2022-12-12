package cimab.openaq.repository.ruido;
import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.entity.ruido.RdoVisita;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.entity.sbc.Sensoresestacion;
import cimab.openaq.entity.sbc.Sensoresvariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Repository
public interface  VisitaRepository  extends JpaRepository<Visitas, Long> {



    @Query(value = "select profesional_encargado from sde.visitas group by profesional_encargado ",
            nativeQuery = true)
    List<String> listFuncionariosRuido();

    @Query(value = "select * from sde.visitas where radicado = :idRadicado order by id desc",
            nativeQuery = true)
    List<Visitas> listVisitasPorRadicado(String idRadicado);

    @Query(value = "select * from sde.visitas where radicado = :idRadicado and profesional_encargado = :profesional_encargado and fechavisita is not null and fechavisita = :fechavisita ",
            nativeQuery = true)
    Visitas consultaSiYa_existe(String idRadicado, String profesional_encargado, java.sql.Timestamp fechavisita);

    @Query(value = "select * from sde.visitas v, " +
            "   sde.rdo_profesional rp where " +
            "   rp.username = :profesional and " +
            "   v.profesional_encargado = rp.nombre " +
            "    order by fechavisita desc ",
            nativeQuery = true)
    List<Visitas> visitasPorProfesional(String profesional);

    @Query(value = "select v.* from sde.visitas v " +
            "   where v.fechavisita between :fechaInicial and  :fechaFinal " +
            "   and direccion like %:direccion%",
            nativeQuery = true)
    List<Visitas> visitasPorDireccion(@Param("fechaInicial") Date fechaInicial,
                                      @Param("fechaFinal") Date fechaFinal ,
                                      @Param("direccion") String direccion);


    @Query(value = "select v.tipo_de_predio_generador_de_la_ from sde.visitas v  " +
            "where " +
            "    v.fechavisita between :fechaInicial and :fechaFinal " +
            "    group by v.tipo_de_predio_generador_de_la_  " +
            "    order by v.tipo_de_predio_generador_de_la_",
            nativeQuery = true)
    List<String> visitasPorTipoPredio(@Param("fechaInicial") Date fechaInicial,
                                      @Param("fechaFinal") Date fechaFinal );

    @Query(value = "select v.cumplimiento_normativo, count(1) " +
            "  from " +
            "  sde.visitas v " +
            "   where " +
            "  v.tipo_de_predio_generador_de_la_ = :tipoPredio " +
            "  and v.fechavisita between :fechaInicial and :fechaFinal " +
            "  group by v.cumplimiento_normativo order by v.cumplimiento_normativo ",
            nativeQuery = true)
    List<Object[]> visitasCategoriasPorTipoPredio(@Param("fechaInicial") Date fechaInicial,
                                      @Param("fechaFinal") Date fechaFinal,
                                      @Param("tipoPredio") String tipoPredio);

}
