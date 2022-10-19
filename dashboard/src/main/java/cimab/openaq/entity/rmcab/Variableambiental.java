package cimab.openaq.entity.rmcab;

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
@NamedQuery(name="Variableambiental.findAll", query="SELECT c FROM Variableambiental c")
public class Variableambiental implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "variAmbientalGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "variableambiental_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="variable")
    private String variable;

    @Column(name="codigoestacion")
    private Integer codigoestacion;

    @Column(name="latitud")
    private Double latitud;

    @Column(name="longitud")
    private Double longitud;

    @Column(name="nombreestacion")
    private String nombreestacion;

    @Column(name="fechaobservacion")
    private Timestamp fechaobservacion;

    @Column(name="mesobservacion")
    private Integer mesobservacion;

    @Column(name="diaobservacion")
    private Integer diaobservacion;

    @Column(name="anioobservacion")
    private Integer anioobservacion;

    @Column(name="departamento")
    private String departamento;

    @Column(name="municipio")
    private String municipio;

    @Column(name="valorobservado")
    private Double valorobservado;

    @Column(name="fuenteinformacion")
    private String fuenteinformacion;


}
