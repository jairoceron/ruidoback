package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="RdoProfesional.findAll", query="SELECT c FROM RdoProfesional c")
@Table(name = "Rdo_Profesional", schema = "sde")
public class RdoProfesional {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "rdoProfesionalSq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.rdo_profesional_idprofesional_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "9"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idprofesional")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesional;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "username")
    private String username;
}
