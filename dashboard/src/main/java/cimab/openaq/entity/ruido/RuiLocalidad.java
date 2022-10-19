package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="RuiLocalidad.findAll", query="SELECT c FROM RuiLocalidad c")
@Table(name = "RuiLocalidad", schema = "sde")
public class RuiLocalidad implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "ruiLocalidadSq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.rdo_localidad_idlocalidad_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idlocalidad")
    private Integer idLocalidad;

    @Column(name = "nombre")
    private String nombre;

}
