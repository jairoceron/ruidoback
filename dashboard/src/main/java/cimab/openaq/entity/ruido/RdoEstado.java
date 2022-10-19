package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="RdoEstado.findAll", query="SELECT c FROM RdoAsunto c")
@Table(name = "Rdo_Estado", schema = "sde")
public class RdoEstado  implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "rdoEstadoSq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.rdo_estado_idestado_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "9"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idestado")
    private Integer idAsunto;

    @Column(name = "nombre")
    private String nombre;

}
