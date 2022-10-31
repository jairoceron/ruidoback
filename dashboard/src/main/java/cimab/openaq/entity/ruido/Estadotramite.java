package cimab.openaq.entity.ruido;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigInteger;
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

/**
 * The persistent class for the calificacion database table.
 *
 */
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Estadotramite.findAll", query="SELECT c FROM Estadotramite c")
public class Estadotramite implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "Estadotramite",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "estadotramite_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

}
