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
@NamedQuery(name="Sensoresestacion.findAll", query="SELECT c FROM Sensoresestacion c")
@Table(name="SENSORES_ESTACION")
public class Sensoresestacion {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "SensoresestacionGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensores_estacion_id_seq"),
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

    @Column(name="estacion_nombre")
    private String estacionnombre;

    @Column(name="latitud")
    private Float latitud;

    @Column(name="longitud")
    private Float longitud;
}
