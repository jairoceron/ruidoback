package mintrabajo.dashboard.repository;

import mintrabajo.dashboard.entity.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  DtRepository  extends JpaRepository<Valor, Long> {


    @Query(value = " SELECT PROCESO_ESTADO,  count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO = 'TERRITORIAL DE BOGOTA' " +
            " and flujo_pk = :flujo_pk " +
            " GROUP BY PROCESO_ESTADO " ,
            nativeQuery = true)
    List<Object[]> activosFinalizadosBogota (@Param("flujo_pk") Integer flujo_pk  );


    @Query(value = "  SELECT PROCESO_ESTADO, count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO = :dirTerrit " +
            " and flujo_pk = :idFlujoPk AND  " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (to_date(:fechaCorte,'yyyy/mm/dd') )  AND " +
            "             IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (to_date(:fechaCorte,'yyyy/mm/dd') + 30) " +
            " GROUP BY PROCESO_ESTADO  " ,
            nativeQuery = true)
    List<Object[]> activosEstadoPrDTerr(@Param("dirTerrit") String dirTerrit, @Param("idFlujoPk") Integer idFlujoPk, @Param("fechaCorte") String fechaCorte );

    @Query(value = "  SELECT PROCESO_ESTADO, count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO <> 'TERRITORIAL TESTING' " +
            " and TERRITORIAL_REPARTO <> 'TERRITORIAL DE BOGOTA' " +
            " and flujo_pk = :idFlujoPk AND  " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (to_date(:fechaCorte,'yyyy/mm/dd') )  AND " +
            "             IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (to_date(:fechaCorte,'yyyy/mm/dd') + 30) " +
            " GROUP BY PROCESO_ESTADO  " ,
            nativeQuery = true)
    List<Object[]> activosEstadoPrDTerrOtras(@Param("idFlujoPk") Integer idFlujoPk, @Param("fechaCorte") String fechaCorte );


    @Query(value = " SELECT PROCESO_ESTADO,  count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO <> 'TERRITORIAL DE BOGOTA' " +
            " and flujo_pk = :flujo_pk " +
            " GROUP BY PROCESO_ESTADO " ,
            nativeQuery = true)
    List<Object[]> activosFinalizadosOtraDt (@Param("flujo_pk") Integer flujo_pk  );

    @Query(value = " SELECT  PROCESO_NAT_INVESTIGACION, count(1) FROM IVC_V_REPORTE_PROCESO  WHERE TERRITORIAL_REPARTO = 'TERRITORIAL DE BOGOTA' " +
            " and flujo_pk = :flujo_pk " +
            " GROUP BY PROCESO_NAT_INVESTIGACION " ,
            nativeQuery = true)
    List<Object[]> naturalezaBogota (@Param("flujo_pk") Integer flujo_pk );

    @Query(value = " SELECT  PROCESO_NAT_INVESTIGACION, count(1) FROM IVC_V_REPORTE_PROCESO  WHERE TERRITORIAL_REPARTO = :dirTerrit " +
            " and flujo_pk = :idFlujoPk AND  " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (to_date(:fechaCorte,'yyyy/mm/dd') )  AND " +
            "             IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (to_date(:fechaCorte,'yyyy/mm/dd') + 30) " +
            " GROUP BY PROCESO_NAT_INVESTIGACION " ,
            nativeQuery = true)
    List<Object[]> naturalezaBogotaGen (@Param("dirTerrit") String dirTerrit, @Param("idFlujoPk") Integer idFlujoPk, @Param("fechaCorte") String fechaCorte);

    @Query(value = " SELECT  PROCESO_NAT_INVESTIGACION, count(1) FROM IVC_V_REPORTE_PROCESO  WHERE TERRITORIAL_REPARTO <> 'TERRITORIAL DE BOGOTA' " +
            " and TERRITORIAL_REPARTO <> 'TERRITORIAL TESTING' " +
            " and flujo_pk = :idFlujoPk AND  " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (to_date(:fechaCorte,'yyyy/mm/dd') )  AND " +
            "             IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (to_date(:fechaCorte,'yyyy/mm/dd') + 30) " +
            " GROUP BY PROCESO_NAT_INVESTIGACION " ,
            nativeQuery = true)
    List<Object[]> naturalezaOtrasDtGen ( @Param("idFlujoPk") Integer idFlujoPk, @Param("fechaCorte") String fechaCorte);


    @Query(value = " SELECT  PROCESO_NAT_INVESTIGACION, count(1) FROM IVC_V_REPORTE_PROCESO  WHERE TERRITORIAL_REPARTO <> 'TERRITORIAL DE BOGOTA' " +
            " and flujo_pk = :flujo_pk " +
            " GROUP BY PROCESO_NAT_INVESTIGACION " ,
            nativeQuery = true)
    List<Object[]> naturalezaOtraDt (@Param("flujo_pk") Integer flujo_pk );

    @Query(value = " SELECT  count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO  IN ('TERRITORIAL DE ANTIOQUIA', " +
            " 'TERRITORIAL DE ATLANTICO', 'TERRITORIAL DE BOGOTA', " +
            " 'TERRITORIAL DE BOLIVAR','TERRITORIAL DE CESAR','TERRITORIAL DE MAGDALENA','TERRITORIAL DE NORTE  DE  SANTANDER', " +
            " 'TERRITORIAL DE SANTANDER','TERRITORIAL DE VALLE DEL CAUCA')  and flujo_pk = :flujo_pk  " ,
            nativeQuery = true)
    Integer grupoIVC (@Param("flujo_pk") Integer flujo_pk  );

    @Query(value = " SELECT  count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO  IN ('TERRITORIAL DE ANTIOQUIA', " +
            " 'TERRITORIAL DE ATLANTICO', 'TERRITORIAL DE BOGOTA', " +
            " 'TERRITORIAL DE BOLIVAR','TERRITORIAL DE CESAR','TERRITORIAL DE MAGDALENA','TERRITORIAL DE NORTE  DE  SANTANDER', " +
            " 'TERRITORIAL DE SANTANDER','TERRITORIAL DE VALLE DEL CAUCA')  and flujo_pk = :idFlujoPk  AND  " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (to_date(:fechaCorte,'yyyy/mm/dd') )  AND " +
            "             IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (to_date(:fechaCorte,'yyyy/mm/dd') + 30) "  ,
            nativeQuery = true)
    Integer grupoIVCGen ( @Param("idFlujoPk") Integer idFlujoPk, @Param("fechaCorte") String fechaCorte);

    @Query(value = " SELECT  count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO  IN ('TERRITORIAL DE BOYACA', 'TERRITORIAL DE CALDAS', " +
            " 'TERRITORIAL DE CAUCA', 'TERRITORIAL DE CHOCO', 'TERRITORIAL DE CORDOBA', 'TERRITORIAL DE CUNDINAMARCA', 'TERRITORIAL DE LA GUAJIRA'," +
            " 'TERRITORIAL DE HUILA', 'TERRITORIAL DE META', 'TERRITORIAL DE NARIÑO', 'TERRITORIAL DE QUINDIO'," +
            " 'TERRITORIAL DE RISARALDA', 'TERRITORIAL DE TOLIMA', 'TERRITORIAL DE ARAUCA', 'TERRITORIAL DE CAQUETA'," +
            " 'TERRITORIAL DE CASANARE', 'TERRITORIAL DE PUTUMAYO', 'TERRITORIAL DE SUCRE', 'OFICINA ESPECIAL DE BUENAVENTURA')  and flujo_pk = :flujo_pk " ,
            nativeQuery = true)
    Integer grupoIVC_RCC (@Param("flujo_pk") Integer flujo_pk  );


    @Query(value = " SELECT  count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO  IN ('TERRITORIAL DE BOYACA', 'TERRITORIAL DE CALDAS', " +
            " 'TERRITORIAL DE CAUCA', 'TERRITORIAL DE CHOCO', 'TERRITORIAL DE CORDOBA', 'TERRITORIAL DE CUNDINAMARCA', 'TERRITORIAL DE LA GUAJIRA'," +
            " 'TERRITORIAL DE HUILA', 'TERRITORIAL DE META', 'TERRITORIAL DE NARIÑO', 'TERRITORIAL DE QUINDIO'," +
            " 'TERRITORIAL DE RISARALDA', 'TERRITORIAL DE TOLIMA', 'TERRITORIAL DE ARAUCA', 'TERRITORIAL DE CAQUETA'," +
            " 'TERRITORIAL DE CASANARE', 'TERRITORIAL DE PUTUMAYO', 'TERRITORIAL DE SUCRE', 'OFICINA ESPECIAL DE BUENAVENTURA')  and flujo_pk = :idFlujoPk " +
            " AND  " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (to_date(:fechaCorte,'yyyy/mm/dd') )  AND " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (to_date(:fechaCorte,'yyyy/mm/dd') + 30) "  ,
            nativeQuery = true)
    Integer grupoIVC_RCCGen ( @Param("idFlujoPk") Integer idFlujoPk, @Param("fechaCorte") String fechaCorte  );

    @Query(value = " SELECT  count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO = 'TERRITORIAL DE BOGOTA' " +
            " and flujo_pk = :flujo_pk AND  IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (SYSDATE )  AND " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (SYSDATE + :numDias) ",
            nativeQuery = true)
    Integer porVencerNumDias (@Param("flujo_pk") Integer flujo_pk, @Param("numDias") Integer numDias   );

    @Query(value = " SELECT  count(1) FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO <> 'TERRITORIAL DE BOGOTA' " +
            " and flujo_pk = :flujo_pk AND  IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (SYSDATE )  AND " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (SYSDATE + :numDias) ",
            nativeQuery = true)
    Integer porVencerNumDiasOtraDt (@Param("flujo_pk") Integer flujo_pk, @Param("numDias") Integer numDias   );


    @Query(value = "SELECT PROCESO_PK, TERRITORIAL_REPARTO, PROCESO_NAT_INVESTIGACION, QUERELLADOS, QUERELLANTES, ORGANIGRAMA_NOMBRE_REPARTO  FROM IVC_V_REPORTE_PROCESO WHERE TERRITORIAL_REPARTO <> 'TERRITORIAL TESTING' " +
            " and TERRITORIAL_REPARTO <> 'TERRITORIAL DE BOGOTA'  " +
            " and flujo_pk = :idFlujoPk AND  " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (to_date(:fechaCorte,'yyyy/mm/dd') )  AND " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (to_date(:fechaCorte,'yyyy/mm/dd') + 90) " ,
            nativeQuery = true)
    List<Object[]> descargaExcelOtraDt ( @Param("idFlujoPk") Integer idFlujoPk, @Param("fechaCorte") String fechaCorte  );

    @Query(value = "SELECT PROCESO_PK, TERRITORIAL_REPARTO, PROCESO_NAT_INVESTIGACION, QUERELLADOS, QUERELLANTES, ORGANIGRAMA_NOMBRE_REPARTO " +
            " FROM IVC_V_REPORTE_PROCESO WHERE  " +
            " TERRITORIAL_REPARTO = 'TERRITORIAL DE BOGOTA'  " +
            " and flujo_pk = :idFlujoPk AND  " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION >= (to_date(:fechaCorte,'yyyy/mm/dd') )  AND " +
            " IVC_V_REPORTE_PROCESO.PROCESO_FECHA_PRESCRIPCION <= (to_date(:fechaCorte,'yyyy/mm/dd') + 90) " ,
            nativeQuery = true)
    List<Object[]> descargaExcelBogota ( @Param("idFlujoPk") Integer idFlujoPk, @Param("fechaCorte") String fechaCorte  );

}
