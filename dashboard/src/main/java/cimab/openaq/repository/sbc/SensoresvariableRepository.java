package cimab.openaq.repository.sbc;

import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.entity.sbc.Sensoresvariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SensoresvariableRepository extends JpaRepository< Sensoresvariable , Long> {
    
    @Query(value = "select to_char(sv.medicion_fecha,'YYYY') as yearMedicion,     " +
       "       to_char(sv.medicion_fecha,'MM') as mesMedicion,    " +
       "       to_char(sv.medicion_fecha,'DD') as diaMedicion,    " +
       "       to_char(sv.medicion_fecha,'HH24') as horaMedicion,    " +
       "       to_char(sv.medicion_fecha,'MI') as minutoMedicion,    " +
       "       sv.medicion_fecha, sv.sensor_marca,  sv.sensor_codigo,     " +
       "       hum_s, tmp_s, pm1, sv.pm10 , sv.pm25, sv.estacion_id, " +
       "       se.latitud , se.longitud  " +
       "   from sensores_variable sv , sensores_estacion se     " +
       "   where sv.estacion_id = se.id and     " +
       "   cast(sv.medicion_fecha as date) between to_date(:fechaInicial, 'DD/MM/YYYY')   " +
       "   and to_date(:fechaFinal, 'DD/MM/YYYY') and     " +
       "      sensor_marca like :marcaSensor  " +
       "     and sv.sensor_codigo like :sensorCodigo", nativeQuery = true)
    List<Object[]> consultaSesorBajoCosto(@Param("marcaSensor") String marcaSensor,
                                          @Param("sensorCodigo") String sensorCodigo,
                                          @Param("fechaInicial") String fechaInicial,
                                          @Param("fechaFinal") String fechaFinal);

    @Query(value = "select to_char(sv.medicion_fecha,'YYYY') as yearMedicion,     " +
       "       to_char(sv.medicion_fecha,'MM') as mesMedicion,    " +
       "       to_char(sv.medicion_fecha,'DD') as diaMedicion,    " +
       "       sv.sensor_marca as marcaSensor,    " +
       "       sv.sensor_codigo as codigoSensor,   " +
       "       avg(hum_s) as humedad, avg(tmp_s) as temperatura,    " +
       "       avg(pm1) as pm1_, avg(sv.pm10) as pm10_ , avg(sv.pm25) as pm25_, " +
       "       se.latitud , se.longitud  " +
       "   from sensores_variable sv , sensores_estacion se    " +
       "   where sv.estacion_id = se.id and     " +
       "   cast(sv.medicion_fecha as date)  between to_date(:fechaInicial, 'DD/MM/YYYY') and to_date(:fechaFinal, 'DD/MM/YYYY') and     " +
       "      sensor_marca like :marcaSensor   " +
       "      and sv.sensor_codigo like :sensorCodigo  " +
       "      group by to_char(sv.medicion_fecha,'YYYY'), to_char(sv.medicion_fecha,'MM'),to_char(sv.medicion_fecha,'DD') , " +
       "      sv.sensor_marca ,sv.sensor_codigo,se.latitud , se.longitud", nativeQuery = true)
    List<Object[]> querySBCPromedioDiario(@Param("marcaSensor") String marcaSensor,
                                          @Param("sensorCodigo") String sensorCodigo,
                                          @Param("fechaInicial") String fechaInicial, @Param("fechaFinal") String fechaFinal);

    @Query(value = "select to_char(sv.medicion_fecha,'YYYY') as yearMedicion, " +
       "       to_char(sv.medicion_fecha,'MM') as mesMedicion, " +
       "       to_char(sv.medicion_fecha,'DD') as diaMedicion,         " +
       "       to_char(sv.medicion_fecha,'HH24') as horarioMed,    " +
       "       sv.sensor_marca as marcaSensor,    " +
       "       sv.sensor_codigo as codigoSensor,   " +
       "       avg(hum_s) as humedad, avg(tmp_s) as temperatura,    " +
       "       avg(pm1) as pm1_, avg(sv.pm10) as pm10_ , avg(sv.pm25) as pm25_, " +
       "       se.latitud , se.longitud  " +
       "   from sensores_variable sv , sensores_estacion se  " +
       "   where sv.estacion_id = se.id and  " +
       "   cast(sv.medicion_fecha as date)  between to_date(:fechaInicial, 'DD/MM/YYYY') and to_date(:fechaFinal, 'DD/MM/YYYY') and  " +
       "      sensor_marca like :marcaSensor   " +
       "            and sv.sensor_codigo like :sensorCodigo   " +
       "      group by to_char(sv.medicion_fecha,'YYYY'), to_char(sv.medicion_fecha,'MM'),to_char(sv.medicion_fecha,'DD'), to_char(sv.medicion_fecha,'HH24'),     " +
       "        sv.sensor_marca ,sv.sensor_codigo, se.latitud , se.longitud    " +
       "      order by to_char(sv.medicion_fecha,'YYYY') ,  " +
       "       to_char(sv.medicion_fecha,'MM') , " +
       "       to_char(sv.medicion_fecha,'DD') ,         " +
       "       to_char(sv.medicion_fecha,'HH24') , sv.sensor_marca ,sv.sensor_codigo", nativeQuery = true)
    List<Object[]> querySBCPromedioHorario(@Param("marcaSensor") String marcaSensor,
                                           @Param("sensorCodigo") String sensorCodigo,
                                           @Param("fechaInicial") String fechaInicial,
                                           @Param("fechaFinal") String fechaFinal);

    @Query(value = "select yearMedicion, mesMedicion, diaMedicion, horarioMed,   " +
            "    marcaSensor, codigoSensor, humedad, temperatura,   " +
            "    pm1_,   " +
            "    avg(pm1_) over(order by yearMedicion, mesMedicion, diaMedicion, horarioMed rows between :horaMovil preceding and current ROW) as pm1Movil,   " +
            "    pm10_,   " +
            "    avg(pm10_) over(order by yearMedicion, mesMedicion, diaMedicion, horarioMed rows between :horaMovil preceding and current ROW) as pm10Movil,   " +
            "    pm25_,   " +
            "    avg(pm25_) over(order by yearMedicion, mesMedicion, diaMedicion, horarioMed rows between :horaMovil preceding and current ROW)  as pm25Movil,   " +
            "       latvnk , lonvnk   " +
            "from (    " +
            "select to_char(sv.medicion_fecha,'YYYY') as yearMedicion,         " +
            "       to_char(sv.medicion_fecha,'MM') as mesMedicion,        " +
            "       to_char(sv.medicion_fecha,'DD') as diaMedicion,                " +
            "       to_char(sv.medicion_fecha,'HH24') as horarioMed,      " +
            "       sv.sensor_marca as marcaSensor,      " +
            "       sv.sensor_codigo as codigoSensor,     " +
            "       avg(hum_s) as humedad, avg(tmp_s) as temperatura,      " +
            "       avg(pm1) as pm1_, avg(sv.pm10) as pm10_ , avg(sv.pm25) as pm25_,   " +
            "       se.latitud as latvnk , se.longitud as lonvnk    " +
            "   from sensores_variable sv , sensores_estacion se         " +
            "   where sv.estacion_id = se.id and         " +
            "      cast(sv.medicion_fecha as date)  between to_date(:fechaInicial, 'DD/MM/YYYY') and to_date(:fechaFinal, 'DD/MM/YYYY') and         " +
            "      sensor_marca like :marcaSensor     " +
            "            and sv.sensor_codigo like :sensorCodigo     " +
            "      group by to_char(sv.medicion_fecha,'YYYY'), to_char(sv.medicion_fecha,'MM'),to_char(sv.medicion_fecha,'DD'), to_char(sv.medicion_fecha,'HH24'),       " +
            "        sv.sensor_marca ,sv.sensor_codigo, se.latitud , se.longitud      " +
            "      order by to_char(sv.medicion_fecha,'YYYY') ,         " +
            "       to_char(sv.medicion_fecha,'MM') ,        " +
            "       to_char(sv.medicion_fecha,'DD') ,                " +
            "       to_char(sv.medicion_fecha,'HH24') , sv.sensor_marca ,sv.sensor_codigo) as paso1", nativeQuery = true)
    List<Object[]> querySBCPromedioHorMovil24H(@Param("marcaSensor") String marcaSensor,
                                           @Param("sensorCodigo") String sensorCodigo,
                                           @Param("fechaInicial") String fechaInicial,
                                           @Param("fechaFinal") String fechaFinal,
                                           @Param("horaMovil") int horaMovil);


    @Query(value = "select to_char(sv.medicion_fecha,'YYYY') as yearMedicion,  " +
            "       to_char(sv.medicion_fecha,'MM') as mesMedicion,     " +
            "       sv.sensor_marca as marcaSensor,   " +
            "       sv.sensor_codigo as codigoSensor,  " +
            "       avg(hum_s) as humedad, avg(tmp_s) as temperatura,   " +
            "       avg(pm1) as pm1_, avg(sv.pm10) as pm10_ , avg(sv.pm25) as pm25_,   " +
            "       se.latitud as latvnk , se.longitud as lonvnk " +
            "   from sensores_variable sv , sensores_estacion se  " +
            "   where sv.estacion_id = se.id and  " +
            "      cast(sv.medicion_fecha as date)  between to_date(:fechaInicial, 'DD/MM/YYYY') and to_date(:fechaFinal, 'DD/MM/YYYY') and  " +
            "      sensor_marca like :marcaSensor  " +
            "            and sv.sensor_codigo like :sensorCodigo  " +
            "      group by to_char(sv.medicion_fecha,'YYYY'), to_char(sv.medicion_fecha,'MM'),    " +
            "        sv.sensor_marca ,sv.sensor_codigo, se.latitud , se.longitud   " +
            "      order by to_char(sv.medicion_fecha,'YYYY') ,  " +
            "       to_char(sv.medicion_fecha,'MM') ,  sv.sensor_marca ,sv.sensor_codigo", nativeQuery = true)
    List<Object[]> sBCPromMensualHorMovil24H(@Param("marcaSensor") String marcaSensor,
                                               @Param("sensorCodigo") String sensorCodigo,
                                               @Param("fechaInicial") String fechaInicial,
                                               @Param("fechaFinal") String fechaFinal);

    @Query(value = "select sv.sensor_codigo    " +
       "from sensores_variable sv  " +
       "where sv.sensor_marca like :marcaSensor  " +
       "group by sensor_codigo", nativeQuery = true)
    List<String> querySensoresPorMarca(@Param("marcaSensor") String marcaSensor);

    @Query(value = "select sensor_marca from sensores_variable sv group by sensor_marca order by sensor_marca",
            nativeQuery = true)
    List<String> queryMarcaSensores() ;


    @Query(value = "select * from sensores_variable where sensor_codigo = '428950' and " +
            " medicion_fecha <= to_timestamp( :diaFinal,'yyyy-mm-dd HH24:mi') and " +
    " medicion_fecha >= to_timestamp( :diaInicial,'yyyy-mm-dd HH24:mi') order by medicion_fecha",
    nativeQuery = true)
    List<Sensoresvariable> consultaCalidadAire(String diaInicial, String diaFinal) ;


}
