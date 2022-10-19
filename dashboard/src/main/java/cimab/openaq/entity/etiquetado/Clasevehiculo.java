package cimab.openaq.entity.etiquetado;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * The persistent class for the calificacion database table.
 *
 */
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Clasevehiculo.findAll", query="SELECT c FROM Clasevehiculo c")
@Table(name = "sda_e_clasevehiculo")
public class Clasevehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "ClaseVehiculo",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sda_e_clasevehiculo_idclasevehiculo_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idclasevehiculo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idclasevehiculo;

    @Column(name = "nombre")
    private String nombre;
}
