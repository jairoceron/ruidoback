package cimab.openaq.entity.etiquetado;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
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
@NamedQuery(name="Cilindrada.findAll", query="SELECT c FROM Cilindrada c")
@Table(name = "sda_e_cilindrada")
public class Cilindrada implements Serializable {

    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "Cilindrada",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sda_e_cilindrada_idcilindrada_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idcilindrada")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idcilindrada;

    @Column(name = "idclasevehiculo")
    private Integer idclasevehiculo;

    @Column(name = "nombre")
    private String nombre;
}
