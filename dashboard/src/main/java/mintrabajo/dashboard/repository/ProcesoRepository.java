package mintrabajo.dashboard.repository;

import mintrabajo.dashboard.entity.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcesoRepository extends JpaRepository<Valor, Long> {


    @Query(value = "SELECT IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO TERRITORIAL_REPARTO , IVC_V_REPORTE_PROCESO.PROCESO_ESTADO,  " +
            "    SUM(IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_VALOR),  " +
            "    count(1) AS numero_procesos  " +
            "    FROM  " +
            "    IVC_V_REPORTE_PROCESO  " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK  " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION ON	IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_PK  " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLADO.PROCESO_PK  " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_QUERELLANTE ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLANTE.PROCESO_PK  " +
            "    WHERE FLUJO_PROCESO_FECHAINICIO >=  ADD_Months(Sysdate, :numMeses)  " +
            "    GROUP BY IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO, IVC_V_REPORTE_PROCESO.PROCESO_ESTADO,  " +
            "    IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_VALOR  " +
            "    ORDER BY IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO   " ,
            nativeQuery = true)
    List<Object[]> totalSancionDt (@Param("numMeses") Integer numMeses );  // numMeses -4 :ejemplo

    @Query(value = "SELECT IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO TERRITORIAL_REPARTO ,  " +
            "    SUM(IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_VALOR), " +
            "    count(1) AS numero_procesos  " +
            "    FROM  " +
            "    IVC_V_REPORTE_PROCESO  " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK  " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_PK  " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLADO.PROCESO_PK  " +
            "    LEFT OUTER JOIN IVC_V_REPORTE_QUERELLANTE ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLANTE.PROCESO_PK  " +
            "    WHERE FLUJO_PROCESO_FECHAINICIO >=  ADD_Months(Sysdate, :numMeses) " +
            "    AND IVC_V_REPORTE_PROCESO.flujo_pk = :idFlujoPk  " +
            "    AND IVC_V_REPORTE_PROCESO.PROCESO_ESTADO = :estado  " +
            "    GROUP BY IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO,  " +
            "    IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_VALOR " +
            "    ORDER BY IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO " ,
            nativeQuery = true)
    List<Object[]> estProcesoDt(@Param("idFlujoPk") Integer idFlujoPk, @Param("estado") String estado, @Param("numMeses") Integer numMeses);


    @Query(value = "select p.PROCESO_NUMERO_RADICACION, " +
            "    DECODE(p.PROCESO_ORIGEN_ACTUACION,'P','PERSONAL','O','DE OFICIO','A','ANONIMO') PROCESO_ORIGEN_ACTUACION, " +
            "    p.PROCESO_FECHA_RADICACION from ivc_proceso p where p.PROCESO_PK = :idProceso" ,
            nativeQuery = true)
    List<Object[]> calificacionGenSample (@Param("idProceso") Integer idProceso  );




    @Query(value = "SELECT IVC_V_REPORTE_PROCESO.PROCESO_PK PROCESO_PK, " +
            "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_INFRA CONDUCTA_SANCION_INFRA, " +
            "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_MAT_DES CONDUCTA_SANCION_MAT_DES, " +
            "IVC_V_REPORTE_PROCESO.GRUPO_REPARTO GRUPO_REPARTO,IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO TERRITORIAL_REPARTO, " +
            "IVC_V_REPORTE_PROCESO.PROCESO_MES_PRESCRIPCION PROCESO_MES_PRESCRIPCION,IVC_V_REPORTE_PROCESO.FECHA_REPARTO_ACT FECHA_REPARTO_ACT,IVC_V_REPORTE_PROCESO.PROCESO_NUMERO_RADICACION  " +
            "PROCESO_NUMERO_RADICACION,IVC_V_REPORTE_PROCESO.PROCESO_ORIGEN_ACTUACION PROCESO_ORIGEN_ACTUACION,IVC_V_REPORTE_PROCESO.PROCESO_FECHA_RADICACION PROCESO_FECHA_RADICACION,  " +
            "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_HECHOS PROCESO_FECHA_HECHOS,IVC_V_REPORTE_PROCESO.PROCESO_FECHA_HECHOS_FIN PROCESO_FECHA_HECHOS_FIN,IVC_V_REPORTE_PROCESO.PROCESO_ESTADO  " +
            "PROCESO_ESTADO,IVC_V_REPORTE_PROCESO.PROCESO_NAT_INVESTIGACION PROCESO_NAT_INVESTIGACION,IVC_V_REPORTE_PROCESO.PERFIL_NOMBRE PERFIL_NOMBRE,IVC_V_REPORTE_PROCESO.ACTIVIDAD_NOMBRE  " +
            "ACTIVIDAD_NOMBRE,IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION PROCESO_FECHA_PRESCRIPCION,IVC_V_REPORTE_PROCESO.USUARIO_NOMBRE USUARIO_NOMBRE,IVC_V_REPORTE_QUERELLANTE.TERCERO_NOMBRES " +
            "QUERELLANTE_NOMBRE,IVC_V_REPORTE_QUERELLANTE.TERCERO_NUMERO_IDENTIFICACION QUERELLANTE_NUMERO_IDE,IVC_V_REPORTE_QUERELLANTE.TIPO_IDENTIFICACION QUERELLANTE_TIPO_ID,  " +
            "IVC_V_REPORTE_QUERELLADO.QUERELLADO_TIPO_IDENT QUERELLADO_TIPO_IDENT,IVC_V_REPORTE_QUERELLADO.QUERELLADO_NUMERO_IDENT QUERELLADO_NUMERO_IDENT,IVC_V_REPORTE_QUERELLADO.QUERELLADO_NOMBRES  " +
            "QUERELLADO_NOMBRES,IVC_V_REPORTE_MOTIVO_SANCION.MOTIVO_SANCION_NOMBRE MOTIVO_SANCION_NOMBRE,IVC_V_REPORTE_MOTIVO_SANCION.CRITERIO_GRAD_SANCION_CRITERIO CRITERIO_GRAD_SANCION_CRITERIO,  " +
            "IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_EJ PROCESO_MOTIVO_SANCION_EJ,IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_INS PROCESO_MOTIVO_SANCION_INS,  " +
            "IVC_V_REPORTE_PROCESO.USERNAME USERNAME,IVC_V_REPORTE_PROCESO.IDENTIFICACION IDENTIFICACION, IVC_V_REPORTE_PROCESO.USUARIO_ESTADO USUARIO_ESTADO,  " +
            "IVC_V_REPORTE_PROCESO.PROCESO_FLUJO_NOMBRE PROCESO_FLUJO_NOMBRE  " +
            ",  IVC_V_REPORTE_PROCESO.flujo_proceso_fechainicio, IVC_V_REPORTE_PROCESO.flujo_proceso_fechafinpro, IVC_V_REPORTE_QUERELLADO.QUERELLADO_SECTOR_CRITICO_NOM, IVC_V_REPORTE_QUERELLADO.QUERELLADO_CIIU_DESCRIPCION  " +
            "LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK " +
            "LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION ON  " +
            "IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_PK " +
            "LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLADO.PROCESO_PK " +
            "LEFT OUTER JOIN IVC_V_REPORTE_QUERELLANTE ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLANTE.PROCESO_PK " +
            " where IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= ADD_Months(Sysdate, -1)  ",
            nativeQuery = true)
    List<Object[]> consSancion ( );

    @Query(value = "SELECT IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO TERRITORIAL_REPARTO , IVC_V_REPORTE_PROCESO.PROCESO_ESTADO, " +
            " IVC_V_REPORTE_QUERELLADO.QUERELLADO_SECTOR_CRITICO, SUM(IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_VALOR), " +
            " count(1) AS numero_procesos " +
            " FROM " +
            " IVC_V_REPORTE_PROCESO " +
            " LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK " +
            " LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION ON	IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_PK " +
            " LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLADO.PROCESO_PK " +
            " LEFT OUTER JOIN IVC_V_REPORTE_QUERELLANTE ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLANTE.PROCESO_PK " +
            " WHERE FLUJO_PROCESO_FECHAINICIO >=  ADD_Months(Sysdate, -4)  " +
            " GROUP BY IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO, IVC_V_REPORTE_PROCESO.PROCESO_ESTADO, " +
            " IVC_V_REPORTE_QUERELLADO.QUERELLADO_SECTOR_CRITICO, IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_VALOR " +
            " ORDER BY IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO ",
            nativeQuery = true)
    List<Object[]>  totalesSancion ( );


    @Query(value = "SELECT IVC_V_REPORTE_PROCESO.PROCESO_PK PROCESO_PK, " +
            "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_INFRA CONDUCTA_SANCION_INFRA, " +
            "IVC_V_REPORTE_CONDUCTA_SANCION.CONDUCTA_SANCION_MAT_DES CONDUCTA_SANCION_MAT_DES, " +
            "IVC_V_REPORTE_PROCESO.GRUPO_REPARTO GRUPO_REPARTO,IVC_V_REPORTE_PROCESO.TERRITORIAL_REPARTO TERRITORIAL_REPARTO, " +
            "IVC_V_REPORTE_PROCESO.PROCESO_MES_PRESCRIPCION PROCESO_MES_PRESCRIPCION,IVC_V_REPORTE_PROCESO.FECHA_REPARTO_ACT FECHA_REPARTO_ACT,IVC_V_REPORTE_PROCESO.PROCESO_NUMERO_RADICACION  " +
            "PROCESO_NUMERO_RADICACION,IVC_V_REPORTE_PROCESO.PROCESO_ORIGEN_ACTUACION PROCESO_ORIGEN_ACTUACION,IVC_V_REPORTE_PROCESO.PROCESO_FECHA_RADICACION PROCESO_FECHA_RADICACION,  " +
            "IVC_V_REPORTE_PROCESO.PROCESO_FECHA_HECHOS PROCESO_FECHA_HECHOS,IVC_V_REPORTE_PROCESO.PROCESO_FECHA_HECHOS_FIN PROCESO_FECHA_HECHOS_FIN,IVC_V_REPORTE_PROCESO.PROCESO_ESTADO  " +
            "PROCESO_ESTADO,IVC_V_REPORTE_PROCESO.PROCESO_NAT_INVESTIGACION PROCESO_NAT_INVESTIGACION,IVC_V_REPORTE_PROCESO.PERFIL_NOMBRE PERFIL_NOMBRE,IVC_V_REPORTE_PROCESO.ACTIVIDAD_NOMBRE  " +
            "ACTIVIDAD_NOMBRE,IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION PROCESO_FECHA_PRESCRIPCION,IVC_V_REPORTE_PROCESO.USUARIO_NOMBRE USUARIO_NOMBRE,IVC_V_REPORTE_QUERELLANTE.TERCERO_NOMBRES " +
            "QUERELLANTE_NOMBRE,IVC_V_REPORTE_QUERELLANTE.TERCERO_NUMERO_IDENTIFICACION QUERELLANTE_NUMERO_IDE,IVC_V_REPORTE_QUERELLANTE.TIPO_IDENTIFICACION QUERELLANTE_TIPO_ID,  " +
            "IVC_V_REPORTE_QUERELLADO.QUERELLADO_TIPO_IDENT QUERELLADO_TIPO_IDENT,IVC_V_REPORTE_QUERELLADO.QUERELLADO_NUMERO_IDENT QUERELLADO_NUMERO_IDENT,IVC_V_REPORTE_QUERELLADO.QUERELLADO_NOMBRES  " +
            "QUERELLADO_NOMBRES,IVC_V_REPORTE_MOTIVO_SANCION.MOTIVO_SANCION_NOMBRE MOTIVO_SANCION_NOMBRE,IVC_V_REPORTE_MOTIVO_SANCION.CRITERIO_GRAD_SANCION_CRITERIO CRITERIO_GRAD_SANCION_CRITERIO,  " +
            "IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_EJ PROCESO_MOTIVO_SANCION_EJ,IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_MOTIVO_SANCION_INS PROCESO_MOTIVO_SANCION_INS,  " +
            "IVC_V_REPORTE_PROCESO.USERNAME USERNAME,IVC_V_REPORTE_PROCESO.IDENTIFICACION IDENTIFICACION, IVC_V_REPORTE_PROCESO.USUARIO_ESTADO USUARIO_ESTADO,  " +
            "IVC_V_REPORTE_PROCESO.PROCESO_FLUJO_NOMBRE PROCESO_FLUJO_NOMBRE  " +
            ",  IVC_V_REPORTE_PROCESO.flujo_proceso_fechainicio, IVC_V_REPORTE_PROCESO.flujo_proceso_fechafinpro, IVC_V_REPORTE_QUERELLADO.QUERELLADO_SECTOR_CRITICO_NOM, IVC_V_REPORTE_QUERELLADO.QUERELLADO_CIIU_DESCRIPCION  " +
            "FROM IVC_V_REPORTE_PROCESO " +
            "LEFT OUTER JOIN IVC_V_REPORTE_CONDUCTA_SANCION ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_CONDUCTA_SANCION.PROCESO_PK " +
            "LEFT OUTER JOIN IVC_V_REPORTE_MOTIVO_SANCION ON  " +
            "IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_MOTIVO_SANCION.PROCESO_PK " +
            "LEFT OUTER JOIN IVC_V_REPORTE_QUERELLADO ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLADO.PROCESO_PK " +
            "LEFT OUTER JOIN IVC_V_REPORTE_QUERELLANTE ON IVC_V_REPORTE_PROCESO.PROCESO_PK = IVC_V_REPORTE_QUERELLANTE.PROCESO_PK " +
            " where IVC_V_REPORTE_PROCESO.FECHA_REPARTO_ACT >= ADD_Months(Sysdate, -6)  ",
            nativeQuery = true)
    List<Object[]> fechaReparto ( );
    
    
    








}