package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="RuiSector.findAll", query="SELECT c FROM RuiSector c")
@Table(name = "RDO_SECTOR", schema = "sde")

public class RuiSector implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "ruiSectoSq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.rdo_sector_idsector_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idsector")
    private Integer idSector;

    @Column(name = "nombre")
    private String nombre;

}
