package cimab.openaq.entity.sbc;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the calificacion database table.
 *
 */
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Sensoresvariable.findAll", query="SELECT c FROM Sensoresvariable c")
@Table(name="SENSORES_VARIABLE")
public class Sensoresvariable implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "SensoresvariableGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensores_variable_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="date_created")
    private Timestamp datecreated;

    @Column(name="date_updated")
    private Timestamp dateupdated;

    @Column(name="medicion_fecha")
    private Timestamp medicionfecha;

    @Column(name="sensor_codigo")
    private String sensorcodigo;

    @Column(name="sensor_marca")
    private String sensormarca;

    @Column(name="hum_s")
    private Float humedad;

    @Column(name="tmp_s")
    private Float temperatura;

    @Column(name="pm1")
    private Float pm1;

    @Column(name="pm10")
    private Float pm10;

    @Column(name="pm25")
    private Float pm25;

   // @Column(name="estacion_id")
   // private Integer estacionid;

    @Column(name="calidad_pm10")
    private Integer calidad_pm10;

    @Column(name="calidad_pm1")
    private Integer calidad_pm1;

    @Column(name="calidad_pm25")
    private Integer calidad_pm25;

    @Column(name="calidad_temperatura")
    private Integer calidad_temperatura;

    @Column(name="calidad_humedadrelativa")
    private Integer calidad_humedadrelativa;


}
