package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="RdoEstadoTramite.findAll", query="SELECT c FROM RdoEstadoTramite c")
@Table(name = "rdo_estado_tramite", schema = "sde")
public class RdoEstadoTramite {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "rdoEstadoTramite",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.rdo_estado_idestado_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "9"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

}
