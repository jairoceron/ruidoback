package mintrabajo.dashboard.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mintrabajo.dashboard.entity.Valor;

@Repository
public interface ProcesosGrupoRepository extends JpaRepository<Valor, Long> {
	
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
            "AND p.organigrama_pk = o.organigrama_pk  " +
            "AND p.organigrama_pk in (select organigrama_pk from ivc_organigrama where organigrama_fk not in (1, 81050))\n " 
            + "AND p.fecha_reparto_act BETWEEN :fecha_desde and :fecha_hasta\n"
            + "order by 3  " +
            ")  " +
            "group by territorial_reparto  "     ,
            nativeQuery = true)
    List<Object[]> procesosgrupo(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to  );
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
            "AND p.organigrama_pk = o.organigrama_pk  " +
            "AND p.organigrama_pk in (select organigrama_pk from ivc_organigrama where (organigrama_pk = :organigrama_pk or organigrama_fk = :organigrama_pk)  AND organigrama_fk not in (1, 81050))\n " 
            + "AND p.fecha_reparto_act BETWEEN :fecha_desde and :fecha_hasta\n"
            + "order by 3  " +
            ")  " +
            "group by territorial_reparto  "     ,
            nativeQuery = true)
    List<Object[]> procesosgrupo(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to, @Param("organigrama_pk") Long idDt);
}
