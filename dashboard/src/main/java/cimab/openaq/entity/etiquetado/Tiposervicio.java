package cimab.openaq.entity.etiquetado;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
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
@NamedQuery(name="Tiposervicio.findAll", query="SELECT c FROM Tiposervicio c")
@Table(name = "sda_e_tiposervicio")
public class Tiposervicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "Tiposervicio",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sda_e_tiposervicio_idtiposerv_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idtiposerv")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idtiposerv;

    @Column(name = "nombre")
    private String  nombre;
}
