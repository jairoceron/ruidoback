package mintrabajo.dashboard.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mintrabajo.dashboard.entity.Valor;

@Repository
public interface DashboardRepository extends JpaRepository<Valor, Long> {
	@Query(value = "SELECT IVC_V_REPORTE_PROCESO.PROCESO_PK ID_EXPEDIENTE, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_NUMERO_RADICACION NUMERO_RADICACION,\n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_ORIGEN_ACTUACION ORIGEN_ACTUACION, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_ESTADO ESTADO_PROCESO,\n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_NAT_INVESTIGACION NATURALEZA_INVESTIGACION, \n"
			+ "IVC_V_REPORTE_PROCESO.QUERELLANTES RESUMEN_QUERELLANTES, \n"
			+ "IVC_V_REPORTE_PROCESO.QUERELLADOS RESUMEN_QUERELLADOS, \n"
			+ "IVC_V_REPORTE_PROCESO.CADENA_ESTADO_ACTIVIDAD ESTADO_ACTIVIDAD, \n"
			+ "IVC_V_REPORTE_PROCESO.PERFIL_NOMBRE PERFIL_ACTIVO,\n"
			+ "IVC_V_REPORTE_PROCESO.ACTIVIDAD_NOMBRE ACTIVIDAD_ACTUAL,\n"
			+ "IVC_V_REPORTE_PROCESO.ETAPA_NOMBRE ETAPA_ACTUAL, \n"
			+ "IVC_V_REPORTE_PROCESO.ETAPA_DESCRIPCION ETAPA_ACTUAL_DESC, \n"
			+ "IVC_V_REPORTE_PROCESO.FLUJO_NOMBRE FLUJO_ACTUAL,\n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FLUJO_NOMBRE CADENA_FLUJO, \n"
			+ "IVC_V_REPORTE_PROCESO.ORGANIGRAMA_NOMBRE_RADICACION ORGANIGRAMA_RADICADO, \n"
			+ "IVC_V_REPORTE_PROCESO.GRUPO_REPARTO GRUPO_REPARTO_INICIAL, \n"
			+ "IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO TERRITORIAL_REPARTO_INICIAL, \n"
			+ "IVC_V_REPORTE_PROCESO.USUARIO_NOMBRE USUARIO_REPARTO, \n"
			+ "IVC_V_REPORTE_PROCESO.ORGANIGRAMA_NOMBRE_REPARTO ORGANIGRAMA_NOMBRE_REPARTO,\n"
			+ "IVC_V_REPORTE_PROCESO.USERNAME USUARIO_DIRECTORIO_ACTIVO, \n"
			+ "IVC_V_REPORTE_PROCESO.USUARIO_ESTADO USUARIO_ESTADO, \n"
			+ "IVC_V_REPORTE_QUERELLADO.QUERELLADO_CIIU_DESCRIPCION CIUU_QUERELLADO, \n"
			+ "IVC_V_REPORTE_QUERELLADO.QUERELLADO_CIIU_CODIGO CIIU_CODIGO_QUERELLADO,\n"
			+ "IVC_V_REPORTE_QUERELLADO.QUERELLADO_SECTOR_CRITICO_NOM SECTOR_CRITICO_QUERELLADO, \n"
			+ "IVC_V_REPORTE_QUERELLADO.QUERELLADO_SECTOR_CRITICO_DESC SECTOR_CRITICO_DESC_QUERELLADO, \n"
			+ "IVC_V_REPORTE_RECURSO.PROCESO_RECURSO_TIPO TIPO_RECURSO,\n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_RADICACION FECHA_RADICACION, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_HECHOS FECHA_HECHOS, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_HECHOS_FIN FECHA_HECHOS_FIN, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION FECHA_PRESCIPCION,\n"
			+ "IVC_V_REPORTE_PROCESO.FECHA_PREAIGNACION FECHA_PREASIGNACION_REPARTO,\n"
			+ "IVC_V_REPORTE_PROCESO.FECHA_REPARTO_ACT FECHA_REPARTO,\n"
			+ "IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_VALOR VALOR_SANCION,\n"
			+ "IVC_V_REPORTE_MOTIVO_SANCION.MOTIVO_SANCION_TIPO TIPO_DECISION,\n"
			+ "IVC_V_REPORTE_MOTIVO_SANCION.CRITERIO_GRAD_SANCION_CRITERIO CRITERIO_GRADUACION_SANCION,\n"
			+ "IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_EJ EJECUTANTE,\n"
			+ "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_INFRA INFRACCION,\n"
			+ "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_TI_INFRA TIPO_INFRACCION,\n"
			+ "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_TI_SANCION TIPO_SANCION,\n"
			+ "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_MAT_DES MATERIA_CONDUCTA, \n"
			+ "IVC_V_REPORTE_PROCESO.FLUJO_PK \n"
			+ "FROM IVC_V_REPORTE_PROCESO  LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK\n"
			+ "LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_PK\n"
			+ "LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLADO.PROCESO_PK\n"
			+ "LEFT OUTER JOIN IVC_V_REPORTE_RECURSO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_RECURSO.PROCESO_PK  \n"
			+ "LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK = IVC_V_REPORTE_PROCESO.PROCESO_PK AND IVC_V_REPORTE_RECURSO.PROCESO_QUERELLADO_PK  = IVC_V_REPORTE_QUERELLADO.PROCESO_QUERELLADO_PK  ", nativeQuery = true)
	List<Object[]> insumoDashBoard();

	@Query(value = "SELECT IVC_V_REPORTE_PROCESO.PROCESO_PK ID_EXPEDIENTE, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_NUMERO_RADICACION NUMERO_RADICACION,\n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_ORIGEN_ACTUACION ORIGEN_ACTUACION, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_ESTADO ESTADO_PROCESO,\n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_NAT_INVESTIGACION NATURALEZA_INVESTIGACION, \n"
			+ "IVC_V_REPORTE_PROCESO.QUERELLANTES RESUMEN_QUERELLANTES, \n"
			+ "IVC_V_REPORTE_PROCESO.QUERELLADOS RESUMEN_QUERELLADOS, \n"
			+ "IVC_V_REPORTE_PROCESO.CADENA_ESTADO_ACTIVIDAD ESTADO_ACTIVIDAD, \n"
			+ "IVC_V_REPORTE_PROCESO.PERFIL_NOMBRE PERFIL_ACTIVO,\n"
			+ "IVC_V_REPORTE_PROCESO.ACTIVIDAD_NOMBRE ACTIVIDAD_ACTUAL,\n"
			+ "IVC_V_REPORTE_PROCESO.ETAPA_NOMBRE ETAPA_ACTUAL, \n"
			+ "IVC_V_REPORTE_PROCESO.ETAPA_DESCRIPCION ETAPA_ACTUAL_DESC, \n"
			+ "IVC_V_REPORTE_PROCESO.FLUJO_NOMBRE FLUJO_ACTUAL,\n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FLUJO_NOMBRE CADENA_FLUJO, \n"
			+ "IVC_V_REPORTE_PROCESO.ORGANIGRAMA_NOMBRE_RADICACION ORGANIGRAMA_RADICADO, \n"
			+ "IVC_V_REPORTE_PROCESO.GRUPO_REPARTO GRUPO_REPARTO_INICIAL, \n"
			+ "IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO TERRITORIAL_REPARTO_INICIAL, \n"
			+ "IVC_V_REPORTE_PROCESO.USUARIO_NOMBRE USUARIO_REPARTO, \n"
			+ "IVC_V_REPORTE_PROCESO.ORGANIGRAMA_NOMBRE_REPARTO ORGANIGRAMA_NOMBRE_REPARTO,\n"
			+ "IVC_V_REPORTE_PROCESO.USERNAME USUARIO_DIRECTORIO_ACTIVO, \n"
			+ "IVC_V_REPORTE_PROCESO.USUARIO_ESTADO USUARIO_ESTADO, \n"
			+ "IVC_V_REPORTE_QUERELLADO.QUERELLADO_CIIU_DESCRIPCION CIUU_QUERELLADO, \n"
			+ "IVC_V_REPORTE_QUERELLADO.QUERELLADO_CIIU_CODIGO CIIU_CODIGO_QUERELLADO,\n"
			+ "IVC_V_REPORTE_QUERELLADO.QUERELLADO_SECTOR_CRITICO_NOM SECTOR_CRITICO_QUERELLADO, \n"
			+ "IVC_V_REPORTE_QUERELLADO.QUERELLADO_SECTOR_CRITICO_DESC SECTOR_CRITICO_DESC_QUERELLADO, \n"
			+ "IVC_V_REPORTE_RECURSO.PROCESO_RECURSO_TIPO TIPO_RECURSO,\n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_RADICACION FECHA_RADICACION, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_HECHOS FECHA_HECHOS, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_HECHOS_FIN FECHA_HECHOS_FIN, \n"
			+ "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION FECHA_PRESCIPCION,\n"
			+ "IVC_V_REPORTE_PROCESO.FECHA_PREAIGNACION FECHA_PREASIGNACION_REPARTO,\n"
			+ "IVC_V_REPORTE_PROCESO.FECHA_REPARTO_ACT FECHA_REPARTO,\n"
			+ "IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_VALOR VALOR_SANCION,\n"
			+ "IVC_V_REPORTE_MOTIVO_SANCION.MOTIVO_SANCION_TIPO TIPO_DECISION,\n"
			+ "IVC_V_REPORTE_MOTIVO_SANCION.CRITERIO_GRAD_SANCION_CRITERIO CRITERIO_GRADUACION_SANCION,\n"
			+ "IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_EJ EJECUTANTE,\n"
			+ "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_INFRA INFRACCION,\n"
			+ "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_TI_INFRA TIPO_INFRACCION,\n"
			+ "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_TI_SANCION TIPO_SANCION,\n"
			+ "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_MAT_DES MATERIA_CONDUCTA, \n"
			+ "IVC_V_REPORTE_PROCESO.FLUJO_PK \n"
			+ "FROM IVC_V_REPORTE_PROCESO  LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK\n"
			+ "LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_PK\n"
			+ "LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLADO.PROCESO_PK\n"
			+ "LEFT OUTER JOIN IVC_V_REPORTE_RECURSO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_RECURSO.PROCESO_PK  \n"
			+ "LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK = IVC_V_REPORTE_PROCESO.PROCESO_PK AND IVC_V_REPORTE_RECURSO.PROCESO_QUERELLADO_PK  = IVC_V_REPORTE_QUERELLADO.PROCESO_QUERELLADO_PK \n "
			+ " WHERE IVC_V_REPORTE_PROCESO.organigrama_pk in (select organigrama_pk from ivc_organigrama where (organigrama_pk = :organigrama_pk or organigrama_fk = :organigrama_pk) AND organigrama_fk not in (1, 81050))\n", nativeQuery = true)
	List<Object[]> insumoDashBoard(@Param("organigrama_pk") Long idDt);

	@Query(value = "SELECT count(proceso_pk) from IVC_V_REPORTE_PROCESO WHERE PROCESO_ESTADO = :estado AND organigrama_pk  in (select organigrama_pk from ivc_organigrama where organigrama_fk not in (1, 81050))", nativeQuery = true)
	List<Object[]> dashboardEstado(@Param("estado") String estado);

	@Query(value = "select count(proceso_pk) from IVC_V_REPORTE_PROCESO where PROCESO_NAT_INVESTIGACION  = :investigacion AND organigrama_pk  in (select organigrama_pk from ivc_organigrama where organigrama_fk not in (1, 81050)) ", nativeQuery = true)
	List<Object[]> dashboarDespacho(@Param("investigacion") String estado);

	@Query(value = "select count(proceso_pk) from IVC_V_REPORTE_PROCESO where PROCESO_NAT_INVESTIGACION  = :investigacion AND organigrama_pk  in (select organigrama_pk from ivc_organigrama where organigrama_pivc = :pivc and organigrama_RCC = :rcc AND organigrama_fk not in (1, 81050))", nativeQuery = true)
	List<Object[]> dashboardOrganigrama(@Param("investigacion") String estado, @Param("pivc") String pivc,
			@Param("rcc") String rcc);

	@Query(value = "select count(proceso_pk) from IVC_V_REPORTE_PROCESO where PROCESO_FECHA_PRESCRIPCION >= SYSDATE AND PROCESO_ESTADO <> 'FINALIZADO' AND organigrama_pk  in (select organigrama_pk from ivc_organigrama where organigrama_fk not in (1, 81050))", nativeQuery = true)
	List<Object[]> dashboardExpedientesConCaducidad();

	@Query(value = "select count(proceso_pk) from IVC_V_REPORTE_PROCESO where PROCESO_FECHA_PRESCRIPCION between (SYSDATE+:desde) AND (SYSDATE+:hasta)  AND PROCESO_ESTADO <> 'FINALIZADO'  AND organigrama_pk  in (select organigrama_pk from ivc_organigrama where organigrama_fk not in (1, 81050))", nativeQuery = true)
	List<Object[]> dashboardExpedientesConCaducidad(@Param("desde") Integer desde, @Param("hasta") Integer hasta);

	@Query(value = "SELECT count(proceso_pk) from IVC_V_REPORTE_PROCESO WHERE PROCESO_ESTADO = :estado AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where (organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk) AND organigrama_fk not in (1, 81050) )", nativeQuery = true)
	List<Object[]> dashboardEstado(@Param("estado") String estado, @Param("organigrama_pk") Long idDt);

	@Query(value = "select count(proceso_pk) from IVC_V_REPORTE_PROCESO where PROCESO_NAT_INVESTIGACION  = :investigacion AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where (organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk) AND organigrama_fk not in (1, 81050) ) ", nativeQuery = true)
	List<Object[]> dashboarDespacho(@Param("investigacion") String estado, @Param("organigrama_pk") Long idDt);

	@Query(value = "select count(proceso_pk) from IVC_V_REPORTE_PROCESO where PROCESO_NAT_INVESTIGACION  = :investigacion AND organigrama_pk  in (select organigrama_pk from ivc_organigrama where organigrama_pivc = :pivc and organigrama_RCC = :rcc AND organigrama_fk not in (1, 81050) AND ( organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk))", nativeQuery = true)
	List<Object[]> dashboardOrganigrama(@Param("investigacion") String estado, @Param("pivc") String pivc,
			@Param("rcc") String rcc, @Param("organigrama_pk") Long idDt);

	@Query(value = "select count(proceso_pk) from IVC_V_REPORTE_PROCESO where PROCESO_FECHA_PRESCRIPCION >= SYSDATE AND PROCESO_ESTADO <> 'FINALIZADO' AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where (organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk)  AND organigrama_fk not in (1, 81050) )", nativeQuery = true)
	List<Object[]> dashboardExpedientesConCaducidad(@Param("organigrama_pk") Long idDt);

	@Query(value = "select count(proceso_pk) from IVC_V_REPORTE_PROCESO where PROCESO_FECHA_PRESCRIPCION between (SYSDATE+:desde) AND (SYSDATE+:hasta)  AND PROCESO_ESTADO <> 'FINALIZADO' AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where (organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk)  AND organigrama_fk not in (1, 81050) ) ", nativeQuery = true)
	List<Object[]> dashboardExpedientesConCaducidad(@Param("desde") Integer desde, @Param("hasta") Integer hasta,
			@Param("organigrama_pk") Long idDt);

	@Query(value = "select organigrama_pk, organigrama_nombre from ivc_organigrama where organigrama_tipo in ('TER') and organigrama_fk not in (1, 81050) order by 2", nativeQuery = true)
	List<Object[]> traerDTs();
	
	@Query(value = "select sector_critico_tlc_pk, sector_critico_tlc_nombre from ivc_sector_critico_tlc where sector_critico_tlc_pk in (50, 51, 21, 52, 25) order by 2", nativeQuery = true)
	List<Object[]> traerSectoresCriticos();

	@Query(value = "select ciiu_pk,ciiu_codigo||' '||ciiu_descripcion\n"
			+ "from ivc_ciiu\n"
			+ "where ciiu_fk is null\n"
			+ "and ciiu_pk <= 21", nativeQuery = true)
	List<Object[]> traerCiiu();
	@Query(value = "select motivo_sancion_pk, motivo_sancion_nombre ABSOLUTORIO\n"
			+ "from ivc_motivo_sancion \n"
			+ "where motivo_sancion_pk in (7, 8, 9, 10, 11, 12, 14, 21)", nativeQuery = true)
	List<Object[]> traerAbsolutorios();
	@Query(value = "select motivo_sancion_pk, motivo_sancion_nombre, MOTIVO_SANCION_TIPO \n"
			+ "from ivc_motivo_sancion \n", nativeQuery = true)
	List<Object[]> traerSancionatorios();
	@Query(value = "select conducta_sancion_materia_pk, conducta_sancion_materia_nom\n"
			+ "from ivc_conducta_sancion_materia order by 2", nativeQuery = true)
	List<Object[]> traerMaterias();
	@Query(value = "select conducta_sancion_pk, conducta_sancion_infra,  csm.conducta_sancion_materia_pk  from ivc_conducta_sancion cs \n"
			+ "join ivc_conducta_sancion_materia csm on cs.CONDUCTA_SANCION_MATERIA_FK = csm.conducta_sancion_materia_pk order by 2", nativeQuery = true)
	List<Object[]> traerInfracciones();
	@Query(value = "select entidad_dest_sancion_entidad id, entidad_dest_sancion_entidad val \n"
			+ "from ivc_entidad_destino_sancion order by 2", nativeQuery = true)
	List<Object[]> traerEjecutantes();
	// TOPTEN
	// Visitas reactivas

	// Inculyente
	@Query(value = "select count(pq.tercero_pk),  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO nombre\n"
			+ "from ivc_proceso_querellado pq join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n"
			+ "WHERE pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta "
			+ "AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk AND organigrama_fk not in (1, 81050)))\n"
			+ "group by pq.tercero_pk,  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO \n"
			+ "ORDER BY count(pq.tercero_pk) desc FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarVisitasReactivasIncluyentes(@Param("organigrama_pk") Long idDt,
			@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// Excluyente
	@Query(value = "select count(pq.tercero_pk),  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO nombre\n"
			+ "from ivc_proceso_querellado pq join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n"
			+ "WHERE pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta "
			+ "AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk <> :organigrama_pk and organigrama_pk <> :organigrama_pk AND organigrama_fk not in (1, 81050)))\n"
			+ "group by pq.tercero_pk,  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO \n"
			+ "ORDER BY count(pq.tercero_pk) desc FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarVisitasReactivasExcluyentes(@Param("organigrama_pk") Long idDt,
			@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	@Query(value = "select count(pq.tercero_pk),  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO nombre\n"
			+ "from ivc_proceso_querellado pq join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n"
			+ "WHERE pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta "
			+ "AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050)))\n"
			+ "group by pq.tercero_pk,  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO \n"
			+ "ORDER BY count(pq.tercero_pk) desc FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarVisitasReactivasIncluyentes(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// Excluyente
	@Query(value = "select count(pq.tercero_pk),  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO nombre\n"
			+ "from ivc_proceso_querellado pq join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n"
			+ "WHERE pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta "
			+ "AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050)))\n"
			+ "group by pq.tercero_pk,  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO \n"
			+ "ORDER BY count(pq.tercero_pk) desc FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarVisitasReactivasExcluyentes(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// QUERELLADOS
	@Query(value = "select count(fi.proceso_querellado_fk), t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO  from ivc_fechas_inspeccion fi\n"
			+ "join ivc_proceso_querellado pq on fi.proceso_querellado_fk = pq.proceso_querellado_pk \n"
			+ "join ivc_proceso_flujo_documento pdf on fi.proceso_flujo_documento_pk = pdf.proceso_flujo_documento_pk\n"
			+ "join ivc_proceso_flujo pf on pdf.proceso_flujo_fk = pf.proceso_flujo_pk\n"
			+ "join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n" + "where pf.flujo_proceso_estado not in ('AT')\n"
			+ "AND pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk AND organigrama_fk not in (1, 81050)))\n"
			+ "group by t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO ORDER BY  count(fi.proceso_querellado_fk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarQuerelladosIncluyentes(@Param("organigrama_pk") Long idDt, @Param("fecha_desde") Date from,
			@Param("fecha_hasta") Date to);

	// excluyentes
	@Query(value = "select count(fi.proceso_querellado_fk), t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO  from ivc_fechas_inspeccion fi\n"
			+ "join ivc_proceso_querellado pq on fi.proceso_querellado_fk = pq.proceso_querellado_pk \n"
			+ "join ivc_proceso_flujo_documento pdf on fi.proceso_flujo_documento_pk = pdf.proceso_flujo_documento_pk\n"
			+ "join ivc_proceso_flujo pf on pdf.proceso_flujo_fk = pf.proceso_flujo_pk\n"
			+ "join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n" + "where pf.flujo_proceso_estado not in ('AT')\n"
			+ "AND pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk <> :organigrama_pk AND organigrama_pk <> :organigrama_pk AND organigrama_fk not in (1, 81050)))\n"
			+ "group by t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO ORDER BY  count(fi.proceso_querellado_fk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarQuerelladosExcluyentes(@Param("organigrama_pk") Long idDt, @Param("fecha_desde") Date from,
			@Param("fecha_hasta") Date to);

	@Query(value = "select count(fi.proceso_querellado_fk), t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO  from ivc_fechas_inspeccion fi\n"
			+ "join ivc_proceso_querellado pq on fi.proceso_querellado_fk = pq.proceso_querellado_pk \n"
			+ "join ivc_proceso_flujo_documento pdf on fi.proceso_flujo_documento_pk = pdf.proceso_flujo_documento_pk\n"
			+ "join ivc_proceso_flujo pf on pdf.proceso_flujo_fk = pf.proceso_flujo_pk\n"
			+ "join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n" + "where pf.flujo_proceso_estado not in ('AT')\n"
			+ "AND pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050)))\n"
			+ "group by t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO ORDER BY  count(fi.proceso_querellado_fk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarQuerelladosIncluyentes(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// excluyentes
	@Query(value = "select count(fi.proceso_querellado_fk), t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO  from ivc_fechas_inspeccion fi\n"
			+ "join ivc_proceso_querellado pq on fi.proceso_querellado_fk = pq.proceso_querellado_pk \n"
			+ "join ivc_proceso_flujo_documento pdf on fi.proceso_flujo_documento_pk = pdf.proceso_flujo_documento_pk\n"
			+ "join ivc_proceso_flujo pf on pdf.proceso_flujo_fk = pf.proceso_flujo_pk\n"
			+ "join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n" + "where pf.flujo_proceso_estado not in ('AT')\n"
			+ "AND pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050)))\n"
			+ "group by t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO ORDER BY  count(fi.proceso_querellado_fk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarQuerelladosExcluyentes(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// QURELLANTES
	@Query(value = "select count(pq.tercero_pk), t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO \n"
			+ "from ivc_proceso_querellante pq \n" + "join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n"
			+ "WHERE pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk AND organigrama_fk not in (1, 81050)))\n"
			+ "group by pq.tercero_pk,  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO ORDER BY count(pq.tercero_pk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarQuerellantesIncluyentes(@Param("organigrama_pk") Long idDt, @Param("fecha_desde") Date from,
			@Param("fecha_hasta") Date to);

	// excluyentes
	@Query(value = "select count(pq.tercero_pk),  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO \n"
			+ "from ivc_proceso_querellante pq \n" + "join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n"
			+ "WHERE pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk <> :organigrama_pk AND organigrama_pk <> :organigrama_pk AND organigrama_fk not in (1, 81050)))\n"
			+ "group by pq.tercero_pk,  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO ORDER BY count(pq.tercero_pk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarQuerellantesExcluyentes(@Param("organigrama_pk") Long idDt, @Param("fecha_desde") Date from,
			@Param("fecha_hasta") Date to);

	@Query(value = "select count(pq.tercero_pk), t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO \n"
			+ "from ivc_proceso_querellante pq \n" + "join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n"
			+ "WHERE pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050)))\n"
			+ "group by pq.tercero_pk,  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO ORDER BY count(pq.tercero_pk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarQuerellantesIncluyentes(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// excluyentes
	@Query(value = "select count(pq.tercero_pk),  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO \n"
			+ "from ivc_proceso_querellante pq \n" + "join ivc_tercero t on pq.tercero_pk = t.tercero_pk\n"
			+ "WHERE pq.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050)))\n"
			+ "group by pq.tercero_pk,  t.TERCERO_NOMBRES ||' ' ||t.TERCERO_PRIMER_APELLIDO ||' '||t.TERCERO_SEGUNDO_APELLIDO ORDER BY count(pq.tercero_pk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarQuerellantesExcluyentes(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// INCIDENCIAS
	@Query(value = "select count(it.incidencia_tipo_pk), it.incidencia_tipo_nombre from ivc_incidencia_proceso ip\n"
			+ "join ivc_proceso p on ip.proceso_fk = p.proceso_pk\n"
			+ "join ivc_incidencia_tipo it on p.incidencia_tipo_fk = it.incidencia_tipo_pk\n"
			+ "WHERE p.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk AND organigrama_fk not in (1, 81050)))\n"
			+ "group by it.incidencia_tipo_nombre ORDER BY count(it.incidencia_tipo_pk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarIncidenciasIncluyentes(@Param("organigrama_pk") Long idDt, @Param("fecha_desde") Date from,
			@Param("fecha_hasta") Date to);

	// excluyentes
	@Query(value = "select count(it.incidencia_tipo_pk), it.incidencia_tipo_nombre from ivc_incidencia_proceso ip\n"
			+ "join ivc_proceso p on ip.proceso_fk = p.proceso_pk\n"
			+ "join ivc_incidencia_tipo it on p.incidencia_tipo_fk = it.incidencia_tipo_pk\n"
			+ "WHERE p.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk <> :organigrama_pk AND organigrama_pk <> :organigrama_pk AND organigrama_fk not in (1, 81050)))\n"
			+ "group by it.incidencia_tipo_nombre ORDER BY count(it.incidencia_tipo_pk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarIncidenciasExcluyentes(@Param("organigrama_pk") Long idDt, @Param("fecha_desde") Date from,
			@Param("fecha_hasta") Date to);

	@Query(value = "select count(it.incidencia_tipo_pk), it.incidencia_tipo_nombre from ivc_incidencia_proceso ip\n"
			+ "join ivc_proceso p on ip.proceso_fk = p.proceso_pk\n"
			+ "join ivc_incidencia_tipo it on p.incidencia_tipo_fk = it.incidencia_tipo_pk\n"
			+ "WHERE p.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050)))\n"
			+ "group by it.incidencia_tipo_nombre ORDER BY count(it.incidencia_tipo_pk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarIncidenciasIncluyentes(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// excluyentes
	@Query(value = "select count(it.incidencia_tipo_pk), it.incidencia_tipo_nombre from ivc_incidencia_proceso ip\n"
			+ "join ivc_proceso p on ip.proceso_fk = p.proceso_pk\n"
			+ "join ivc_incidencia_tipo it on p.incidencia_tipo_fk = it.incidencia_tipo_pk\n"
			+ "WHERE p.proceso_pk in (select proceso_pk from ivc_proceso WHERE proceso_fecha_radicacion between :fecha_desde and :fecha_hasta AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050)))\n"
			+ "group by it.incidencia_tipo_nombre ORDER BY count(it.incidencia_tipo_pk) DESC FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
	List<Object[]> consultarIncidenciasExcluyentes(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// HU 11
	@Query(value = "SELECT * \n"
			+ "FROM (SELECT ir.USUARIO_FK, iu.USUARIO_USERNAME, ir.usuario_nombre , PROCESO_NAT_INVESTIGACION, ir.TERRITORIAL_REPARTO, ir.PROCESO_ESTADO, ir.PROCESO_FECHA_RADICACION \n"
			+ "        FROM IVC_V_REPORTE_PROCESO ir, IVC_ORGANIGAMA_USUARIO iou , ivc_usuario iu\n"
			+ "       WHERE ir.USUARIO_FK = iou.USUARIO_FK AND iu.USUARIO_PK = iou.USUARIO_FK  \n"
			+ " AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050))\n"
			+ "         ) PIVOT (COUNT(1) FOR PROCESO_ESTADO IN ('ACTIVO','FINALIZADO')) order by 5,3", nativeQuery = true)
	List<Object[]> consultarExpedientesPorUsuarioSinFiltro();

	// Con filtro de estado usuario

	@Query(value = "SELECT * \n"
			+ "FROM (SELECT ir.USUARIO_FK, iu.USUARIO_USERNAME, ir.usuario_nombre , PROCESO_NAT_INVESTIGACION, ir.TERRITORIAL_REPARTO, ir.PROCESO_ESTADO, ir.PROCESO_FECHA_RADICACION \n"
			+ "        FROM IVC_V_REPORTE_PROCESO ir, IVC_ORGANIGAMA_USUARIO iou , ivc_usuario iu\n"
			+ "       WHERE ir.USUARIO_FK = iou.USUARIO_FK AND iu.USUARIO_PK = iou.USUARIO_FK  \n"
			+ " AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050))\n"
			+ "       AND iu.usuario_estado = :usuario_estado\n"
			+ "         ) PIVOT (COUNT(1) FOR PROCESO_ESTADO IN ('ACTIVO','FINALIZADO')) order by 5,3", nativeQuery = true)
	List<Object[]> consultarExpedientesPorUsuarioConFiltroEstadoUsuario(@Param("usuario_estado") String usuario_estado);

	// Con fuiltro organigrama

	@Query(value = "SELECT * \n"
			+ "FROM (SELECT ir.USUARIO_FK, iu.USUARIO_USERNAME, ir.usuario_nombre , PROCESO_NAT_INVESTIGACION, ir.TERRITORIAL_REPARTO, ir.PROCESO_ESTADO, ir.PROCESO_FECHA_RADICACION \n"
			+ "        FROM IVC_V_REPORTE_PROCESO ir, IVC_ORGANIGAMA_USUARIO iou , ivc_usuario iu\n"
			+ "       WHERE ir.USUARIO_FK = iou.USUARIO_FK AND iu.USUARIO_PK = iou.USUARIO_FK  \n"
			+ "         AND  ir.organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk AND organigrama_fk not in (1, 81050))\n"
			+ "         ) PIVOT (COUNT(1) FOR PROCESO_ESTADO IN ('ACTIVO','FINALIZADO')) order by 5,3", nativeQuery = true)
	List<Object[]> consultarExpedientesPorUsuarioConFiltroOrganigrama(@Param("organigrama_pk") Long idDt);

	// Con todos los filtros

	@Query(value = "SELECT * \n"
			+ "FROM (SELECT ir.USUARIO_FK, iu.USUARIO_USERNAME, ir.usuario_nombre , PROCESO_NAT_INVESTIGACION, ir.TERRITORIAL_REPARTO, ir.PROCESO_ESTADO, ir.PROCESO_FECHA_RADICACION \n"
			+ "        FROM IVC_V_REPORTE_PROCESO ir, IVC_ORGANIGAMA_USUARIO iou , ivc_usuario iu\n"
			+ "       WHERE ir.USUARIO_FK = iou.USUARIO_FK AND iu.USUARIO_PK = iou.USUARIO_FK  \n"
			+ "      AND  ir.organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk AND organigrama_fk not in (1, 81050))\n"
			+ "      AND iu.usuario_estado = :usuario_estado\n"
			+ "         ) PIVOT (COUNT(1) FOR PROCESO_ESTADO IN ('ACTIVO','FINALIZADO')) order by 5,3", nativeQuery = true)
	List<Object[]> consultarExpedientesPorUsuarioConFiltros(@Param("organigrama_pk") Long idDt,
			@Param("usuario_estado") String usuario_estado);

	// HU12
	@Query(value = "SELECT * FROM (SELECT  ir.TERRITORIAL_REPARTO, ir.PROCESO_ESTADO \n"
			+ "    FROM IVC_V_REPORTE_PROCESO ir \n"
			+ " WHERE organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050))\n"

			+ "     )  PIVOT (COUNT(1) FOR PROCESO_ESTADO IN ('ACTIVO','FINALIZADO')) ORDER BY 1", nativeQuery = true)
	List<Object[]> consultarExpedientesDtsSinFiltro();

	// Con filtro estado usario

	@Query(value = "SELECT * FROM (SELECT  ir.TERRITORIAL_REPARTO, ir.PROCESO_ESTADO \n"
			+ "    FROM IVC_V_REPORTE_PROCESO ir \n"
			+ "   WHERE  ir.usuario_fk in ( select usuario_pk from ivc_usuario where usuario_estado = :usuario_estado )\n"
			+ " AND organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk not in (1, 81050))\n"
			+ "     )  PIVOT (COUNT(1) FOR PROCESO_ESTADO IN ('ACTIVO','FINALIZADO')) ORDER BY 1", nativeQuery = true)
	List<Object[]> consultarExpedientesDtsConFiltroEstadoUsuario(@Param("usuario_estado") String usuario_estado);

//Con filtro estado organigrama

	@Query(value = "SELECT * FROM (SELECT  ir.TERRITORIAL_REPARTO, ir.PROCESO_ESTADO \n"
			+ "    FROM IVC_V_REPORTE_PROCESO ir \n"
			+ "    WHERE  ir.organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk AND organigrama_fk not in (1, 81050))\n"
			+ "     )  PIVOT (COUNT(1) FOR PROCESO_ESTADO IN ('ACTIVO','FINALIZADO')) ORDER BY 1", nativeQuery = true)
	List<Object[]> consultarExpedientesDtsConFiltroOrganigrama(@Param("organigrama_pk") Long idDt);
//Con todos los filtros

	@Query(value = "SELECT * FROM (SELECT  ir.TERRITORIAL_REPARTO, ir.PROCESO_ESTADO \n"
			+ "    FROM IVC_V_REPORTE_PROCESO ir \n"
			+ "    WHERE  ir.organigrama_pk in (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk AND organigrama_fk not in (1, 81050))\n"
			+ "     AND ir.usuario_fk in ( select usuario_pk from ivc_usuario where usuario_estado = :usuario_estado )\n"
			+ "     )  PIVOT (COUNT(1) FOR PROCESO_ESTADO IN ('ACTIVO','FINALIZADO')) ORDER BY 1", nativeQuery = true)
	List<Object[]> consultarExpedientesDtsConFiltros(@Param("organigrama_pk") Long idDt,
			@Param("usuario_estado") String usuario_estado);

	// HU 6

	// Inculyente
	@Query(value = "SELECT count(1), PROCESO_ESTADO  \n" + "FROM IVC_V_REPORTE_PROCESO \n"
			+ "WHERE ORGANIGRAMA_PK IN (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk)\n"
			+ "and flujo_pk in (select flujo_pk from ivc_flujo where flujo_pk = 15735 or flujo_fk = 15735)    \n"
			+ "AND PROCESO_FECHA_PRESCRIPCION between :fecha_desde and :fecha_hasta\n"
			+ "AND PROCESO_FECHA_PRESCRIPCION is not null\n" + "GROUP BY PROCESO_ESTADO", nativeQuery = true)
	List<Object[]> consultarFuncionPreventivaIncluyentes(@Param("organigrama_pk") Long idDt,
			@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// Excluyente
	@Query(value = "SELECT count(1), PROCESO_ESTADO \n" + "FROM IVC_V_REPORTE_PROCESO \n"
			+ "WHERE ORGANIGRAMA_PK IN (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk <> :organigrama_pk >ND organigrama_pk <> :organigrama_pk)\n"
			+ "and flujo_pk in (select flujo_pk from ivc_flujo where flujo_pk = 15735 or flujo_fk = 15735) \n"
			+ "AND PROCESO_FECHA_PRESCRIPCION between :fecha_desde and :fecha_hasta \n"
			+ "AND PROCESO_FECHA_PRESCRIPCION is not null \n" + "GROUP BY PROCESO_ESTADO", nativeQuery = true)
	List<Object[]> consultarFuncionPreventivaExcluyentes(@Param("organigrama_pk") Long idDt,
			@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

	// HU 9
	@Query(value = "SELECT p.territorial_reparto ,p.proceso_pk, p.proceso_estado, p.proceso_decision_1ra, p.proceso_decision_2da,\n"
			+ "MS.MOTIVO_SANCION_TIPO, MS.CRITERIO_GRAD_SANCION_CRITERIO, MS.PROCESO_MOTIVO_SANCION_VALOR, ms.proceso_motivo_sancion_v_unid,\n"
			+ "q.querellado_numero_ident, q.querellado_nombres,  \n" + "s.conducta_sancion_infra, \n"
			+ "qr.tercero_numero_identificacion, qr.tercero_nombres\n" + "FROM IVC_V_REPORTE_PROCESO P\n"
			+ "LEFT JOIN IVC_V_REPORTE_CONDUCTA_SANCION S ON P.PROCESO_PK = S.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_MOTIVO_SANCION MS ON	P.PROCESO_PK = MS.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_QUERELLADO Q ON P.PROCESO_PK = Q.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_QUERELLANTE QR ON P.PROCESO_PK = QR.PROCESO_PK\n"
			+ "WHERE P.FLUJO_PK in (select flujo_pk from ivc_flujo where flujo_pk =:flujo_pk or flujo_fk =:flujo_pk)    \n"
			+ "AND P.ORGANIGRAMA_PK IN (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk)\n"
			+ "AND p.proceso_pk like :proceso\n"
			+ "AND lower(q.querellado_nombres) like lower(:querellado)\n"
			+ "AND lower(qr.tercero_nombres) like lower(:querellante)\n"
			+ "AND q.querellado_numero_ident like :idQuerellado\n"
			+ "AND qr.tercero_numero_identificacion like :idQuerellante\n"
			+ "AND p.proceso_pk like :numeroRadicado", nativeQuery = true)
	List<Object[]> consultarProcesoConIdDt(@Param("organigrama_pk") Long idDt, @Param("flujo_pk") Long flujoPk,
			@Param("idQuerellado") String idQuerellado, @Param("idQuerellante") String idQuerellante,
			@Param("numeroRadicado") String numeroRadicado,@Param("querellante") String querellante,@Param("querellado") String querellado,@Param("proceso") String proceso);

	@Query(value = "SELECT p.territorial_reparto ,p.proceso_pk, p.proceso_estado, p.proceso_decision_1ra, p.proceso_decision_2da,\n"
			+ "MS.MOTIVO_SANCION_TIPO, MS.CRITERIO_GRAD_SANCION_CRITERIO, MS.PROCESO_MOTIVO_SANCION_VALOR, ms.proceso_motivo_sancion_v_unid,\n"
			+ "q.querellado_numero_ident, q.querellado_nombres,  \n" + "s.conducta_sancion_infra, \n"
			+ "qr.tercero_numero_identificacion, qr.tercero_nombres\n" + "FROM IVC_V_REPORTE_PROCESO P\n"
			+ "LEFT JOIN IVC_V_REPORTE_CONDUCTA_SANCION S ON P.PROCESO_PK = S.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_MOTIVO_SANCION MS ON	P.PROCESO_PK = MS.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_QUERELLADO Q ON P.PROCESO_PK = Q.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_QUERELLANTE QR ON P.PROCESO_PK = QR.PROCESO_PK\n"
			+ "WHERE P.ORGANIGRAMA_PK IN (select organigrama_pk from IVC_ORGANIGRAMA where organigrama_fk = :organigrama_pk or organigrama_pk = :organigrama_pk)\n"
			+ "AND p.proceso_pk like :proceso\n"
			+ "AND lower(q.querellado_nombres) like lower(:querellado)\n"
			+ "AND lower(qr.tercero_nombres) like lower(:querellante)\n"
			+ "AND q.querellado_numero_ident like :idQuerellado\n"
			+ "AND qr.tercero_numero_identificacion like :idQuerellante\n"
			+ "AND p.proceso_pk like :numeroRadicado", nativeQuery = true)
	List<Object[]> consultarProcesoConIdDt(@Param("organigrama_pk") Long idDt,
			@Param("idQuerellado") String idQuerellado, @Param("idQuerellante") String idQuerellante,
			@Param("numeroRadicado") String numeroRadicado,@Param("querellante") String querellante,@Param("querellado") String querellado,@Param("proceso") String proceso);

	@Query(value = "SELECT p.territorial_reparto ,p.proceso_pk, p.proceso_estado, p.proceso_decision_1ra, p.proceso_decision_2da,\n"
			+ "MS.MOTIVO_SANCION_TIPO, MS.CRITERIO_GRAD_SANCION_CRITERIO, MS.PROCESO_MOTIVO_SANCION_VALOR, ms.proceso_motivo_sancion_v_unid,\n"
			+ "q.querellado_numero_ident, q.querellado_nombres,  \n" + "s.conducta_sancion_infra, \n"
			+ "qr.tercero_numero_identificacion, qr.tercero_nombres\n" + "FROM IVC_V_REPORTE_PROCESO P\n"
			+ "LEFT JOIN IVC_V_REPORTE_CONDUCTA_SANCION S ON P.PROCESO_PK = S.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_MOTIVO_SANCION MS ON	P.PROCESO_PK = MS.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_QUERELLADO Q ON P.PROCESO_PK = Q.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_QUERELLANTE QR ON P.PROCESO_PK = QR.PROCESO_PK\n"
			+ "WHERE P.FLUJO_PK in (select flujo_pk from ivc_flujo where flujo_pk =:flujo_pk or flujo_fk =:flujo_pk)    \n"
			+ "AND p.proceso_pk like :proceso\n"
			+ "AND lower(q.querellado_nombres) like lower(:querellado)\n"
			+ "AND lower(qr.tercero_nombres) like lower(:querellante)\n"
			+ "AND q.querellado_numero_ident like :idQuerellado\n"
			+ "AND qr.tercero_numero_identificacion like :idQuerellante\n"
			+ "AND p.proceso_pk like :numeroRadicado", nativeQuery = true)
	List<Object[]> consultarProcesoSinIdDt(@Param("flujo_pk") Long flujoPk, @Param("idQuerellado") String idQuerellado,
			@Param("idQuerellante") String idQuerellante, @Param("numeroRadicado") String numeroRadicado,@Param("querellante") String querellante,@Param("querellado") String querellado,@Param("proceso") String proceso);

	@Query(value = "SELECT p.territorial_reparto ,p.proceso_pk, p.proceso_estado, p.proceso_decision_1ra, p.proceso_decision_2da,\n"
			+ "MS.MOTIVO_SANCION_TIPO, MS.CRITERIO_GRAD_SANCION_CRITERIO, MS.PROCESO_MOTIVO_SANCION_VALOR, ms.proceso_motivo_sancion_v_unid,\n"
			+ "q.querellado_numero_ident, q.querellado_nombres,  \n" + "s.conducta_sancion_infra, \n"
			+ "qr.tercero_numero_identificacion, qr.tercero_nombres\n" + "FROM IVC_V_REPORTE_PROCESO P\n"
			+ "LEFT JOIN IVC_V_REPORTE_CONDUCTA_SANCION S ON P.PROCESO_PK = S.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_MOTIVO_SANCION MS ON	P.PROCESO_PK = MS.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_QUERELLADO Q ON P.PROCESO_PK = Q.PROCESO_PK \n"
			+ "LEFT JOIN IVC_V_REPORTE_QUERELLANTE QR ON P.PROCESO_PK = QR.PROCESO_PK\n"
			+ "WHERE q.querellado_numero_ident like :idQuerellado\n"
			+ "AND p.proceso_pk like :proceso\n"
			+ "AND lower(q.querellado_nombres) like lower(:querellado)\n"
			+ "AND lower(qr.tercero_nombres) like lower(:querellante)\n"
			+ "AND qr.tercero_numero_identificacion like :idQuerellante\n"
			+ "AND p.proceso_pk like :numeroRadicado", nativeQuery = true)
	List<Object[]> consultarProcesoSinIdDt(@Param("idQuerellado") String idQuerellado,
			@Param("idQuerellante") String idQuerellante, @Param("numeroRadicado") String numeroRadicado,@Param("querellante") String querellante,@Param("querellado") String querellado,@Param("proceso") String proceso);

	// HU 14

	// Inculyente
	@Query(value = "SELECT COUNT(TERRITORIAL_REPARTO),  TERRITORIAL_REPARTO \n" + "FROM IVC_V_REPORTE_PROCESO\n"
			+ "WHERE FECHA_REPARTO_ACT BETWEEN :fecha_desde and :fecha_hasta \n"
			+ "AND organigrama_rep_ini_terr_fk in (select organigrama_pk from ivc_organigrama where organigrama_pk = :organigrama_pk or organigrama_pk = :organigrama_pk)\n"
			+ "GROUP BY  TERRITORIAL_REPARTO\n" + "ORDER BY TERRITORIAL_REPARTO", nativeQuery = true)
	List<Object[]> consultarIndicadorProcesosPorDt(@Param("organigrama_pk") Long idDt, @Param("fecha_desde") Date from,
			@Param("fecha_hasta") Date to);

	// Excluyente
	@Query(value = "SELECT COUNT(TERRITORIAL_REPARTO), TERRITORIAL_REPARTO \n" + "FROM IVC_V_REPORTE_PROCESO\n"
			+ "WHERE FECHA_REPARTO_ACT BETWEEN :fecha_desde and :fecha_hasta \n" + "GROUP BY  TERRITORIAL_REPARTO\n"
			+ "ORDER BY TERRITORIAL_REPARTO", nativeQuery = true)
	List<Object[]> consultarIndicadorProcesos(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to);

//HU 15

	// Inculyente
	@Query(value = "select TERRITORIAL_REPARTO, sum(ACTIVOS), sum(FINALIZADOS), sum(activos + finalizados), sum(primer_mes), sum(segundo_mes), sum(tercer_mes), sum(primer_mes+segundo_mes+tercer_mes),\n"
			+ "case when sum(activos + finalizados) = 0 then 0 else round(((sum(primer_mes+segundo_mes+tercer_mes)/sum(activos + finalizados))*100),2) end avanzadas\n"
			+ "from\n" + "(SELECT p.proceso_pk, p.TERRITORIAL_REPARTO, \n"
			+ "case when p.PROCESO_ESTADO = 'ACTIVO' then 1 else 0 end ACTIVOS,\n"
			+ "case when p.PROCESO_ESTADO = 'FINALIZADO' then 1 else 0 end FINALIZADOS,\n" + "case when \n"
			+ "(select count(*) from ivc_proceso_reparto pr where pr.proceso_fk = p.proceso_pk and EXTRACT(MONTH FROM pr.proceso_reparto_fechaini)||'/'||EXTRACT(year FROM pr.proceso_reparto_fechaini)  = EXTRACT(MONTH FROM to_date(:fecha))||'/'||EXTRACT(year FROM to_date(:fecha))   ) > 1\n"
			+ "then 1 else 0 end primer_mes,\n" + "case when \n"
			+ "(select count(*) from ivc_proceso_reparto pr where pr.proceso_fk = p.proceso_pk and EXTRACT(MONTH FROM pr.proceso_reparto_fechaini)||'/'||EXTRACT(year FROM pr.proceso_reparto_fechaini)  = EXTRACT(MONTH FROM to_date(:fecha))+1 ||'/'||EXTRACT(year FROM to_date(:fecha))   ) > 1\n"
			+ "then 1 else 0 end segundo_mes,\n" + "case when \n"
			+ "(select count(*) from ivc_proceso_reparto pr where pr.proceso_fk = p.proceso_pk and EXTRACT(MONTH FROM pr.proceso_reparto_fechaini)||'/'||EXTRACT(year FROM pr.proceso_reparto_fechaini)  = EXTRACT(MONTH FROM to_date(:fecha))+2||'/'||EXTRACT(year FROM to_date(:fecha))   ) > 1\n"
			+ "then 1 else 0 end tercer_mes\n" + "FROM IVC_V_REPORTE_PROCESO p\n"
			+ "WHERE p.FECHA_REPARTO_ACT BETWEEN :fecha_desde and :fecha_hasta \n"
			+ "AND p.ORGANIGRAMA_REP_INI_TERR_FK in (select organigrama_pk from ivc_organigrama where organigrama_pk = :organigrama_pk or organigrama_pk = :organigrama_pk)\n"
			+ "ORDER BY p.TERRITORIAL_REPARTO)\n" + "group by TERRITORIAL_REPARTO", nativeQuery = true)
	List<Object[]> consultarIndicadorProcesalPorDt(@Param("organigrama_pk") Long idDt, @Param("fecha_desde") Date from,
			@Param("fecha_hasta") Date to, @Param("fecha") String fecha);

	// Excluyente
	@Query(value = "select TERRITORIAL_REPARTO, sum(ACTIVOS), sum(FINALIZADOS), sum(activos + finalizados), sum(primer_mes), sum(segundo_mes), sum(tercer_mes), sum(primer_mes+segundo_mes+tercer_mes),\n"
			+ "case when sum(activos + finalizados) = 0 then 0 else round(((sum(primer_mes+segundo_mes+tercer_mes)/sum(activos + finalizados))*100),2) end avanzadas\n"
			+ "from\n" + "(SELECT p.proceso_pk, p.TERRITORIAL_REPARTO, \n"
			+ "case when p.PROCESO_ESTADO = 'ACTIVO' then 1 else 0 end ACTIVOS,\n"
			+ "case when p.PROCESO_ESTADO = 'FINALIZADO' then 1 else 0 end FINALIZADOS,\n" + "case when \n"
			+ "(select count(*) from ivc_proceso_reparto pr where pr.proceso_fk = p.proceso_pk and EXTRACT(MONTH FROM pr.proceso_reparto_fechaini)||'/'||EXTRACT(year FROM pr.proceso_reparto_fechaini)  = EXTRACT(MONTH FROM to_date(:fecha))||'/'||EXTRACT(year FROM to_date(:fecha))   ) > 1\n"
			+ "then 1 else 0 end primer_mes,\n" + "case when \n"
			+ "(select count(*) from ivc_proceso_reparto pr where pr.proceso_fk = p.proceso_pk and EXTRACT(MONTH FROM pr.proceso_reparto_fechaini)||'/'||EXTRACT(year FROM pr.proceso_reparto_fechaini)  = EXTRACT(MONTH FROM to_date(:fecha))+1 ||'/'||EXTRACT(year FROM to_date(:fecha))   ) > 1\n"
			+ "then 1 else 0 end segundo_mes,\n" + "case when \n"
			+ "(select count(*) from ivc_proceso_reparto pr where pr.proceso_fk = p.proceso_pk and EXTRACT(MONTH FROM pr.proceso_reparto_fechaini)||'/'||EXTRACT(year FROM pr.proceso_reparto_fechaini)  = EXTRACT(MONTH FROM to_date(:fecha))+2||'/'||EXTRACT(year FROM to_date(:fecha))   ) > 1\n"
			+ "then 1 else 0 end tercer_mes\n" + "FROM IVC_V_REPORTE_PROCESO p\n"
			+ "WHERE p.FECHA_REPARTO_ACT BETWEEN :fecha_desde and :fecha_hasta \n" + "ORDER BY p.TERRITORIAL_REPARTO)\n"
			+ "group by TERRITORIAL_REPARTO", nativeQuery = true)
	List<Object[]> consultarIndicadorProcesal(@Param("fecha_desde") Date from, @Param("fecha_hasta") Date to,
			@Param("fecha") String fecha);

}
