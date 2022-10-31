package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="RdoVisita.findAll", query="SELECT c FROM RdoVisita c")
@Table(name = "Rdo_visita", schema = "sde")
public class RdoVisita {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "rdoVisitaSq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.rdo_visita_idvisita_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvisita")
    private Integer idvisita;

    @Column(name = "profesional")
    private String profesional;

    @Column(name = "radicado")
    private String radicado;

    @Column(name = "fechavisita")
    private Timestamp fechavisita;

    @Column(name = "estadovisita")
    private String estadovisita;

    @Column(name = "numeroexpediente")
    private Integer numeroexpediente;

    @Column(name = "horariovisita")
    private String horariovisita;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "latitud")
    private Float latitud;

    @Column(name = "longitud")
    private Float longitud;



}
