package cimab.openaq.util;

import cimab.openaq.dataTransferObject.Parametro;
import cimab.openaq.dataTransferObject.SensorMedicion;
import cimab.openaq.dto.Param;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static cimab.openaq.constantes.ConstantesCimab.TODAS;
import static cimab.openaq.constantes.ConstantesCimab.TODOS;

public class ConsultasListas {

    public List<SensorMedicion> listaTodos(List<Object[]> listSensor) {
        List<SensorMedicion> listSensorMedicion = new ArrayList<>();
        for (Object[] objSensor : listSensor) {
            SensorMedicion sensorMedicion = new SensorMedicion();
            String yearMedicion = (String) objSensor[0];  //   0  yearMedicion,   " +
            sensorMedicion.setYearMedicion(Integer.parseInt(yearMedicion));
            String mesMedicion = (String) objSensor[1]; //   1  mesMedicion,  " +
            sensorMedicion.setMesMedicion(Integer.parseInt(mesMedicion));
            String diaMedicion = (String) objSensor[2];  //   2  diaMedicion,  " +
            sensorMedicion.setDiaMedicion(Integer.parseInt(diaMedicion));
            String horaMedicion = (String) objSensor[3];  //   3  horaMedicion,  " +
            sensorMedicion.setHoraMedicion(Integer.parseInt(horaMedicion));
            String minutMedicion = (String) objSensor[4];  //   4  minutoMedicion,  " +
            sensorMedicion.setMinutMedicion(Integer.parseInt(minutMedicion));
            Timestamp fechaCreacion = (Timestamp) objSensor[5];  //   5  sv.date_created,
            sensorMedicion.setFechaCreacion(fechaCreacion);
            String marcaSensorXX = (String) objSensor[6];  //   6  sv.sensor_marca,
            sensorMedicion.setMarcaSensor(marcaSensorXX);
            String codigoSensor = (String) objSensor[7];  //   7  sv.sensor_codigo,   " +
            sensorMedicion.setCodigoSensor(codigoSensor);
            Double humedad = (Double) objSensor[8];  //   8 hum_s,
            sensorMedicion.setHumedad(humedad);
            Double temperatura = (Double) objSensor[9];  //   9 tmp_s,
            sensorMedicion.setTemperatura(temperatura);
            Double pm1 = (Double) objSensor[10]; //   10 pm1,
            sensorMedicion.setPm1(pm1);
            Double pm10 = (Double) objSensor[11]; //   11 sv.pm10 ,
            sensorMedicion.setPm10(pm10);
            Double pm25 = (Double) objSensor[12]; //   12 sv.pm25,
            sensorMedicion.setPm25(pm25);
            Integer idEstacion = (Integer) objSensor[13]; //   13 sv.estacion_id
            sensorMedicion.setIdEstacion(idEstacion);
            Double latitud = (Double) objSensor[14]; //   13 sv.estacion_id
            sensorMedicion.setLatitud(latitud);
            Double longitud = (Double) objSensor[15]; //   13 sv.estacion_id
            sensorMedicion.setLongitud(longitud);


            listSensorMedicion.add(sensorMedicion);
        }


        return listSensorMedicion;
    }

    public List<SensorMedicion> listaPromedioDiario(List<Object[]> listSensor) {
        List<SensorMedicion> listSensorMedicion = new ArrayList<>();
        for (Object[] objSensor : listSensor) {
            SensorMedicion sensorMedicion = new SensorMedicion();
            String yearMedicion = (String) objSensor[0];  //   0  yearMedicion,   " +
            sensorMedicion.setYearMedicion(Integer.parseInt(yearMedicion));
            String mesMedicion = (String) objSensor[1]; //   1  mesMedicion,  " +
            sensorMedicion.setMesMedicion(Integer.parseInt(mesMedicion));
            String diaMedicion = (String) objSensor[2];  //   2  diaMedicion,  " +
            sensorMedicion.setDiaMedicion(Integer.parseInt(diaMedicion));

            String marcaSensor = (String) objSensor[3];  //   3  codigoSensor,  " +
            sensorMedicion.setMarcaSensor(marcaSensor);

            String codigoSensor = (String) objSensor[4];  //   4  codigoSensor,  " +
            sensorMedicion.setCodigoSensor(codigoSensor);

            Double humedad = (Double) objSensor[5];  //   5 hum_s,
            sensorMedicion.setHumedad(humedad);
            Double temperatura = (Double) objSensor[6];  //   6 tmp_s,
            sensorMedicion.setTemperatura(temperatura);
            Double pm1 = (Double) objSensor[7]; //   7 pm1,
            sensorMedicion.setPm1(pm1);
            Double pm10 = (Double) objSensor[8]; //   8 sv.pm10 ,
            sensorMedicion.setPm10(pm10);
            Double pm25 = (Double) objSensor[9]; //   9 sv.pm25,
            sensorMedicion.setPm25(pm25);

            Double latitud = (Double) objSensor[10]; //   13 sv.estacion_id
            sensorMedicion.setLatitud(latitud);
            Double longitud = (Double) objSensor[11]; //   13 sv.estacion_id
            sensorMedicion.setLongitud(longitud);

            listSensorMedicion.add(sensorMedicion);
        }


        return listSensorMedicion;
    }

    public List<SensorMedicion> listaPromedioHorMovil(List<Object[]> listSensor, Integer horaMovil) {
        List<SensorMedicion> listSensorMedicion = new ArrayList<>();
        for (Object[] objSensor : listSensor) {
            SensorMedicion sensorMedicion = new SensorMedicion();
            String yearMedicion = (String) objSensor[0];  //   0  yearMedicion,   " +
            sensorMedicion.setYearMedicion(Integer.parseInt(yearMedicion));
            String mesMedicion = (String) objSensor[1]; //   1  mesMedicion,  " +
            sensorMedicion.setMesMedicion(Integer.parseInt(mesMedicion));
            String diaMedicion = (String) objSensor[2];  //   2  diaMedicion,  " +
            sensorMedicion.setDiaMedicion(Integer.parseInt(diaMedicion));

            String horaMedicion = (String) objSensor[3];  //   3  diaMedicion,  " +
            sensorMedicion.setHoraMedicion(Integer.parseInt(horaMedicion));

            String marcaSensor = (String) objSensor[4];  //   4  marcaSensor,  " +
            sensorMedicion.setMarcaSensor(marcaSensor);
            String codigoSensor = (String) objSensor[5];  //   5  codigoSensor,  " +
            sensorMedicion.setCodigoSensor(codigoSensor);

            Double humedad = (Double) objSensor[6];  //   8 hum_s,
            sensorMedicion.setHumedad(humedad);
            Double temperatura = (Double) objSensor[7];  //   9 tmp_s,
            sensorMedicion.setTemperatura(temperatura);
            Double pm1 = (Double) objSensor[8]; //   10 pm1,
            sensorMedicion.setPm1(pm1);
            Double pm1Movil = (Double) objSensor[9]; //   11 pm1Movil ,
            sensorMedicion.setPm1Movil(pm1Movil);
            Double pm10 = (Double) objSensor[10]; //   11 sv.pm10 ,
            Double pm10Movil = (Double) objSensor[11];
            sensorMedicion.setPm10Movil(pm10Movil);
            sensorMedicion.setPm10(pm10);
            Double pm25 = (Double) objSensor[12]; //   12 sv.pm25,
            Double pm25Movil = (Double) objSensor[13]; //   12 sv.pm25,
            sensorMedicion.setPm25Movil(pm25Movil);
            sensorMedicion.setPm25(pm25);

            Double latitud = (Double) objSensor[14]; //   13 sv.estacion_id
            sensorMedicion.setLatitud(latitud);
            Double longitud = (Double) objSensor[15]; //   13 sv.estacion_id
            sensorMedicion.setLongitud(longitud);
            sensorMedicion.setHoraMovil(horaMovil);

            listSensorMedicion.add(sensorMedicion);
        }


        return listSensorMedicion;
    }

    public List<SensorMedicion> listaMensualHorMovil(List<Object[]> listSensor) {
        List<SensorMedicion> listSensorMedicion = new ArrayList<>();
        for (Object[] objSensor : listSensor) {
            SensorMedicion sensorMedicion = new SensorMedicion();
            String yearMedicion = (String) objSensor[0];  //   0  yearMedicion,   " +
            sensorMedicion.setYearMedicion(Integer.parseInt(yearMedicion));
            String mesMedicion = (String) objSensor[1]; //   1  mesMedicion,  " +
            sensorMedicion.setMesMedicion(Integer.parseInt(mesMedicion));

            String marcaSensor = (String) objSensor[2];  //   4  marcaSensor,  " +
            sensorMedicion.setMarcaSensor(marcaSensor);
            String codigoSensor = (String) objSensor[3];  //   5  codigoSensor,  " +
            sensorMedicion.setCodigoSensor(codigoSensor);

            Double humedad = (Double) objSensor[4];  //   8 hum_s,
            sensorMedicion.setHumedad(humedad);
            Double temperatura = (Double) objSensor[5];  //   9 tmp_s,
            sensorMedicion.setTemperatura(temperatura);
            Double pm1 = (Double) objSensor[6]; //   10 pm1,
            sensorMedicion.setPm1(pm1);
            Double pm10 = (Double) objSensor[7]; //   11 sv.pm10 ,
            sensorMedicion.setPm10(pm10);
            Double pm25 = (Double) objSensor[8]; //   12 sv.pm25,
            sensorMedicion.setPm25(pm25);
            Double latitud = (Double) objSensor[9]; //   13 sv.estacion_id
            sensorMedicion.setLatitud(latitud);
            Double longitud = (Double) objSensor[10]; //   13 sv.estacion_id
            sensorMedicion.setLongitud(longitud);
            listSensorMedicion.add(sensorMedicion);
        }


        return listSensorMedicion;
    }


    public List<SensorMedicion> listaPromedioHorario(List<Object[]> listSensor) {
        List<SensorMedicion> listSensorMedicion = new ArrayList<>();
        for (Object[] objSensor : listSensor) {
            SensorMedicion sensorMedicion = new SensorMedicion();
            String yearMedicion = (String) objSensor[0];  //   0  yearMedicion,   " +
            sensorMedicion.setYearMedicion(Integer.parseInt(yearMedicion));
            String mesMedicion = (String) objSensor[1]; //   1  mesMedicion,  " +
            sensorMedicion.setMesMedicion(Integer.parseInt(mesMedicion));
            String diaMedicion = (String) objSensor[2];  //   2  diaMedicion,  " +
            sensorMedicion.setDiaMedicion(Integer.parseInt(diaMedicion));

            String horaMedicion = (String) objSensor[3];  //   2  diaMedicion,  " +
            sensorMedicion.setHoraMedicion(Integer.parseInt(horaMedicion));

            String marcaSensor = (String) objSensor[4];  //   2  diaMedicion,  " +
            sensorMedicion.setMarcaSensor(marcaSensor);
            String codigoSensor = (String) objSensor[5];  //   2  diaMedicion,  " +
            sensorMedicion.setCodigoSensor(codigoSensor);

            Double humedad = (Double) objSensor[6];  //   8 hum_s,
            sensorMedicion.setHumedad(humedad);
            Double temperatura = (Double) objSensor[7];  //   9 tmp_s,
            sensorMedicion.setTemperatura(temperatura);
            Double pm1 = (Double) objSensor[8]; //   10 pm1,
            sensorMedicion.setPm1(pm1);
            Double pm10 = (Double) objSensor[9]; //   11 sv.pm10 ,
            sensorMedicion.setPm10(pm10);
            Double pm25 = (Double) objSensor[10]; //   12 sv.pm25,
            sensorMedicion.setPm25(pm25);

            Double latitud = (Double) objSensor[11]; //   13 sv.estacion_id
            sensorMedicion.setLatitud(latitud);
            Double longitud = (Double) objSensor[12]; //   13 sv.estacion_id
            sensorMedicion.setLongitud(longitud);

            listSensorMedicion.add(sensorMedicion);
        }


        return listSensorMedicion;
    }
/*
    public  List<Parametro> listMarcaSensor() {
        List<Parametro> listMarcaSensor = new ArrayList<>();
        listMarcaSensor.add(new Parametro(TODOS, "Todas"));
        listMarcaSensor.add(new Parametro(1, "Canairo"));
        listMarcaSensor.add(new Parametro(2, "Clarity"));
        listMarcaSensor.add(new Parametro(3, "Davis"));
        listMarcaSensor.add(new Parametro(4, "PurpleAir"));
        listMarcaSensor.add(new Parametro(5, "TsiLink"));
        listMarcaSensor.add(new Parametro(6, "UCentral"));
        listMarcaSensor.add(new Parametro(7, "UradMonitor"));
        return listMarcaSensor;
    }

 */
    public  List<Parametro> listMarcaSensor(List<String> listaDb) {
        List<Parametro> listMarcaSensor = new ArrayList<>();
        listMarcaSensor.add(new Parametro(TODOS, "Todas"));
        int claveMarca = 1;
        for (String marca : listaDb) {
            System.out.println(" MARCA ... " + marca);
            listMarcaSensor.add(new Parametro(claveMarca, marca));
            claveMarca++;
        }
        System.out.println(" listado de marcas ::: ... " + listMarcaSensor);
        return listMarcaSensor;
    }

    public  List<Param> listMarcaSensorParam(List<String> listaDb) {
        List<Param> listMarcaSensor = new ArrayList<>();
        Param paramX = new Param();
        paramX.setId(TODOS);
        paramX.setValue(TODAS);
        paramX.setIdAlt(TODOS);
        listMarcaSensor.add(paramX);
        int claveMarca = 1;
        for (String marca : listaDb) {
            System.out.println(" MARCA ... " + marca);
            Param paramD = new Param();
            paramD.setId(claveMarca);
            paramD.setValue(marca);
            paramD.setIdAlt(claveMarca);
            listMarcaSensor.add(paramD);
            claveMarca++;
        }
        System.out.println(" listado de marcas ::: ... " + listMarcaSensor);
        return listMarcaSensor;
    }
}
