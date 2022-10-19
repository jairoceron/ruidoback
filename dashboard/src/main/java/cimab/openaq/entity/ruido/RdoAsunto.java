package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="RdoAsunto.findAll", query="SELECT c FROM RdoAsunto c")
@Table(name = "Rdo_Asunto", schema = "sde")
public class RdoAsunto implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "rdoAsuntoSq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.rdo_asunto_idasunto_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idasunto")
    private Integer idAsunto;

    @Column(name = "nombre")
    private String nombre;

}
