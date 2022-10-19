package mintrabajo.dashboard.repository;

import mintrabajo.dashboard.entity.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SancionRepository extends JpaRepository<Valor, Long> {

    @Query(value = " SELECT ORGANIGRAMA_PK, ORGANIGRAMA_NOMBRE FROM IVC_ORGANIGRAMA WHERE ORGANIGRAMA_TIPO = 'TER' " +
            " AND ORGANIGRAMA_PK <> 81050 ORDER BY  ORGANIGRAMA_NOMBRE  ",
            nativeQuery = true)
    List<Object[]> listTerritorial();


    @Query(value = " select territorial_reparto, sum(pivc) as pivc, sum (rcc) as rcc, sum(act) as act, sum(PIVCRCC) as pivrcc, " +
            "sum(riesgoslab) as riesgoslab, sum(todas) as todas, sum(inspecciones) as inspecciones " +
            "from " +
            "( " +
            "select p.proceso_pk,p.organigrama_fk, p.territorial_reparto,p.proceso_estado,  " +
            "case  when (o.organigrama_pivc = 'SI' and o.organigrama_rcc <> 'SI' and o.organigrama_act <> 'SI')  THEN 1 ELSE 0 end PIVC,  " +
            "case  when (o.organigrama_pivc <> 'SI' and o.organigrama_rcc = 'SI' and o.organigrama_act <> 'SI')  THEN 1 ELSE 0 end RCC, " +
            "case  when (o.organigrama_pivc <> 'SI' and o.organigrama_rcc <> 'SI' and o.organigrama_act = 'SI')  THEN 1 ELSE 0 end ACT, " +
            "case  when (o.organigrama_pivc = 'SI' and o.organigrama_rcc = 'SI' and o.organigrama_act <> 'SI')  THEN 1 ELSE 0 end PIVCRCC,  " +
            "case when p.proceso_nat_investigacion = 'RIESGOS LABORALES' then 1 else 0 end RIESGOSLAB,  " +
            "case  when (o.organigrama_pivc = 'SI' and o.organigrama_rcc = 'SI' and o.organigrama_act = 'SI' " +
            "and  p.proceso_nat_investigacion = 'RIESGOS LABORALES')  THEN 1 ELSE 0 end TODAS,  " +
            "case when o.organigrama_tipo = 'INS' then 1 else 0 END INSPECCIONES " +
            "from ivc_v_reporte_proceso p, ivc_organigrama o  " +
            "WHERE p.proceso_estado in  ('ACTIVO', 'FINALIZADO') " +
            "AND  p.usuario_fk in (select usuario_pk from ivc_usuario where ivc_usuario.usuario_estado in ('I','A') ) " +
            "AND p.organigrama_fk = o.organigrama_pk  " +
            "AND p.organigrama_fk in (select organigrama_pk from ivc_organigrama where organigrama_pk = 131 or organigrama_fk = 131) " +
            "order by 3  " +
            ")  " +
            "group by territorial_reparto  "     ,
            nativeQuery = true)
    List<Object[]> procesosgrupo();


    @Query(value = "select   " +
            "    sum(ejecutoriadas),   " +
            "    sum(noejecutoriadas),   " +
            "    sum(decode(ejecutoriadas,1, valor, 0)) valor_ejecutoriadas,   " +
            "    sum(decode(noejecutoriadas,1, valor, 0)) valor_no_ejecutoriadas   " +
            "    from   " +
            "        (SELECT                " +
            "            case when ivc_fn_ejecutoriada(P.PROCESO_PK) = 'SI' then 1 else 0 end ejecutoriadas,     " +
            "            case when ivc_fn_ejecutoriada(P.PROCESO_PK) = 'NO' then 1 else 0 end noejecutoriadas,    " +
            "            CASE WHEN (MS.PROCESO_MOTIVO_SANCION_V_UNID = 'PE')     " +
            "                THEN MS.PROCESO_MOTIVO_SANCION_VALOR ELSE MS.PROCESO_MOTIVO_SANCION_VALOR*(SELECT SALARIO_MINIMO_VALOR     " +
            "                    FROM IVC_SALARIO_MINIMO WHERE SALARIO_MINIMO_ANIO = EXTRACT(YEAR FROM MS.PROCESO_MOTIVO_SANCION_INSERT)) END valor      " +
            "        FROM IVC_V_REPORTE_PROCESO P    " +
            "        LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION MS ON P.PROCESO_PK = MS.PROCESO_PK    " +
            "            WHERE                                      " +
            "                 p.ORGANIGRAMA_REP_INI_TERR_FK >= :territorialInicial     " +
            "                AND p.ORGANIGRAMA_REP_INI_TERR_FK <= :territorialFinal    " +
            "                AND MS.MOTIVO_SANCION_FK = 1    " +
            "                AND P.FECHA_REPARTO_ACT  >= to_date( :fechaInicio , 'yyyy/MM/dd')      " +
            "                AND P.FECHA_REPARTO_ACT  <= to_date( :fechaFin , 'yyyy/MM/dd')    " +
            "                AND p.proceso_estado like  ( :estadoProceso ) " +
            "                AND P.PROCESO_NAT_INVESTIGACION like ( :naturaleza ) ) " +
            "                " , nativeQuery = true)
    List<Object[]> eje_lista_plant_consolid(@Param("fechaInicio") String fechaInicio,
                                            @Param("fechaFin") String fechaFin,
                                            @Param("territorialInicial") int territorialInicial,
                                            @Param("territorialFinal") int territorialFinal,
                                            @Param("naturaleza") String naturaleza,
                                            @Param("estadoProceso") String estadoProceso);


    @Query(value = "select  " +
            "      TERRITORIAL_REPARTO,  " +
            "      sum(ejecutoriadas),  " +
            "      sum(noejecutoriadas),  " +
            "      sum(decode(ejecutoriadas,1, valor, 0)) valor_ejecutoriadas,  " +
            "      sum(decode(noejecutoriadas,1, valor, 0)) valor_no_ejecutoriadas  " +
            "  from  " +
            "      (SELECT P.TERRITORIAL_REPARTO, case when ivc_fn_ejecutoriada(P.PROCESO_PK) = 'SI' then 1 else 0 end ejecutoriadas,  " +
            "      case when ivc_fn_ejecutoriada(P.PROCESO_PK) = 'NO' then 1 else 0 end noejecutoriadas,  " +
            "            CASE WHEN (MS.PROCESO_MOTIVO_SANCION_V_UNID = 'PE')   " +
            "                THEN MS.PROCESO_MOTIVO_SANCION_VALOR ELSE MS.PROCESO_MOTIVO_SANCION_VALOR*(SELECT SALARIO_MINIMO_VALOR FROM IVC_SALARIO_MINIMO WHERE SALARIO_MINIMO_ANIO = EXTRACT(YEAR FROM MS.PROCESO_MOTIVO_SANCION_INSERT))END valor    " +
            "            FROM IVC_V_REPORTE_PROCESO P  " +
            "            LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION MS ON P.PROCESO_PK = MS.PROCESO_PK  " +
            "            WHERE     " +
            "                p.ORGANIGRAMA_REP_INI_TERR_FK >= :territorialInicial     " +
            "                AND p.ORGANIGRAMA_REP_INI_TERR_FK <= :territorialFinal    " +
            "                AND MS.MOTIVO_SANCION_FK = 1    " +
            "                AND P.FECHA_REPARTO_ACT  >= to_date( :fechaInicio , 'yyyy/MM/dd')      " +
            "                AND P.FECHA_REPARTO_ACT  <= to_date( :fechaFin , 'yyyy/MM/dd')    " +
            "                AND P.PROCESO_NAT_INVESTIGACION like ( :naturaleza )   " +
            "                AND p.proceso_estado like  ( :estadoProceso )) " +
            "             group by TERRITORIAL_REPARTO order by TERRITORIAL_REPARTO " , nativeQuery = true)
    List<Object[]> eje_lista_plant_sececono_terr_natu(@Param("fechaInicio") String fechaInicio,
                                                      @Param("fechaFin") String fechaFin,
                                                      @Param("territorialInicial") int territorialInicial,
                                                      @Param("territorialFinal") int territorialFinal,
                                                      @Param("naturaleza") String naturaleza,
                                                      @Param("estadoProceso") String estadoProceso);


    @Query(value = "select  " +
            "      TERRITORIAL_REPARTO,  " +
            "      sum(ejecutoriadas),  " +
            "      sum(noejecutoriadas),  " +
            "      sum(decode(ejecutoriadas,1, valor, 0)) valor_ejecutoriadas,  " +
            "      sum(decode(noejecutoriadas,1, valor, 0)) valor_no_ejecutoriadas  " +
            "  from  " +
            "      (SELECT P.TERRITORIAL_REPARTO, case when ivc_fn_ejecutoriada(P.PROCESO_PK) = 'SI' then 1 else 0 end ejecutoriadas,  " +
            "      case when ivc_fn_ejecutoriada(P.PROCESO_PK) = 'NO' then 1 else 0 end noejecutoriadas,  " +
            "            CASE WHEN (MS.PROCESO_MOTIVO_SANCION_V_UNID = 'PE')   " +
            "                THEN MS.PROCESO_MOTIVO_SANCION_VALOR ELSE MS.PROCESO_MOTIVO_SANCION_VALOR*(SELECT SALARIO_MINIMO_VALOR FROM IVC_SALARIO_MINIMO WHERE SALARIO_MINIMO_ANIO = EXTRACT(YEAR FROM MS.PROCESO_MOTIVO_SANCION_INSERT))END valor    " +
            "            FROM IVC_V_REPORTE_PROCESO P  " +
            "            LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION MS ON P.PROCESO_PK = MS.PROCESO_PK  " +
            "            LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO Q ON P.PROCESO_PK = Q.PROCESO_PK      " +
            "            WHERE     " +
            "                p.ORGANIGRAMA_REP_INI_TERR_FK >= :territorialInicial     " +
            "                AND p.ORGANIGRAMA_REP_INI_TERR_FK <= :territorialFinal    " +
            "                AND MS.MOTIVO_SANCION_FK = 1    " +
            "                AND P.FECHA_REPARTO_ACT  >= to_date( :fechaInicio , 'yyyy/MM/dd')      " +
            "                AND P.FECHA_REPARTO_ACT  <= to_date( :fechaFin , 'yyyy/MM/dd')    " +
            "                AND Q.QUERELLADO_SECTOR_CRITICO IN (50,21,51,52,25)    " +
            "                AND P.PROCESO_NAT_INVESTIGACION like ( :naturaleza )   " +
            "                AND p.proceso_estado like  ( :estadoProceso )) " +
            "             group by TERRITORIAL_REPARTO order by TERRITORIAL_REPARTO " , nativeQuery = true)
    List<Object[]>  eje_lista_plant_sececono_prioritario(@Param("fechaInicio") String fechaInicio,
                                                         @Param("fechaFin") String fechaFin,
                                                         @Param("territorialInicial") int territorialInicial,
                                                         @Param("territorialFinal") int territorialFinal,
                                                         @Param("naturaleza") String naturaleza,
                                                         @Param("estadoProceso") String estadoProceso);

    @Query(value = "select      " +
            "            QUERELLADO_SECTOR_CRITICO_NOM,      " +
            "    sum(ejecutoriadas),      " +
            "    sum(noejecutoriadas),      " +
            "    sum(decode(ejecutoriadas,1, valor, 0)) valor_ejecutoriadas,      " +
            "    sum(decode(noejecutoriadas,1, valor, 0)) valor_no_ejecutoriadas      " +
            "    from      " +
            "            (SELECT Q.QUERELLADO_SECTOR_CRITICO_NOM, case when ivc_fn_ejecutoriada(P.PROCESO_PK) = 'SI' then 1 else 0 end ejecutoriadas,        " +
            "      case when ivc_fn_ejecutoriada(P.PROCESO_PK) = 'NO' then 1 else 0 end noejecutoriadas,      " +
            "    CASE WHEN (MS.PROCESO_MOTIVO_SANCION_V_UNID = 'PE')      " +
            "    THEN MS.PROCESO_MOTIVO_SANCION_VALOR ELSE MS.PROCESO_MOTIVO_SANCION_VALOR*(SELECT SALARIO_MINIMO_VALOR FROM IVC_SALARIO_MINIMO WHERE SALARIO_MINIMO_ANIO = EXTRACT(YEAR FROM MS.PROCESO_MOTIVO_SANCION_INSERT))END valor      " +
            "    FROM IVC_V_REPORTE_PROCESO P      " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION MS ON P.PROCESO_PK = MS.PROCESO_PK      " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO Q ON P.PROCESO_PK = Q.PROCESO_PK      " +
            "            WHERE      " +
            "    p.ORGANIGRAMA_REP_INI_TERR_FK >= :territorialInicial      " +
            "    AND p.ORGANIGRAMA_REP_INI_TERR_FK <= :territorialFinal      " +
            "    AND MS.MOTIVO_SANCION_FK = 1      " +
            "    AND P.FECHA_REPARTO_ACT  >= to_date( :fechaInicio , 'yyyy/MM/dd')      " +
            "    AND P.FECHA_REPARTO_ACT  <= to_date( :fechaFin , 'yyyy/MM/dd')      " +
            "    AND P.PROCESO_NAT_INVESTIGACION like ( :naturaleza )      " +
            "    AND p.proceso_estado like  ( :estadoProceso )       " +
            "    AND Q.QUERELLADO_SECTOR_CRITICO IN (50,21,51,52,25))      " +
            "    group by  QUERELLADO_SECTOR_CRITICO_NOM  " , nativeQuery = true)
    List<Object[]> eje_lista_sector_critico(@Param("fechaInicio") String fechaInicio,
                                            @Param("fechaFin") String fechaFin,
                                            @Param("territorialInicial") int territorialInicial,
                                            @Param("territorialFinal") int territorialFinal,
                                            @Param("naturaleza") String naturaleza,
                                            @Param("estadoProceso") String estadoProceso);


}
