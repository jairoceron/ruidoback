package cimab.openaq.dataTransferObject;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SensorMedicion {
    Integer yearMedicion ;
    Integer mesMedicion ;
    Integer diaMedicion ;
    Integer horaMedicion ;
    Integer minutMedicion ;
    Timestamp fechaCreacion ;
    String marcaSensor ;
    String codigoSensor ;
    Double humedad ;
    Double temperatura ;
    Double pm1 ;
    Double pm10 ;
    Double pm25 ;
    Integer idEstacion ;
    Double latitud ;
    Double longitud ;

    Double pm1Movil ;
    Double pm10Movil ;
    Double pm25Movil ;
    Integer horaMovil;  // puede ser 24 o 8

}
