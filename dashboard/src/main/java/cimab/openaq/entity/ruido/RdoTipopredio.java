package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="RdoTipopredio.findAll", query="SELECT c FROM RdoTipopredio c")
@Table(name = "rdo_tipopredio", schema = "sde")
public class RdoTipopredio {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "rdoTipopredioSq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.rdo_tipopredio_idtipopredio_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "9"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idtipopredio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipopredio;

    @Column(name = "nombre")
    private String nombre;
}
