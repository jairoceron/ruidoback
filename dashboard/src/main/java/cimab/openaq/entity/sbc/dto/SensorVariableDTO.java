package cimab.openaq.entity.sbc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
public class SensorVariableDTO {

    private Timestamp medicionfecha;
    private String sensorcodigo;
    private String sensormarca;
    private Float humedad;
    private Float temperatura;
    private Float pm1;
    private Float pm10;
    private Float pm25;


}
