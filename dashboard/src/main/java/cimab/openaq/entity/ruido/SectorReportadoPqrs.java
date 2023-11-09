package cimab.openaq.entity.ruido;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="SectorReportadoPqrs.findAll", query="SELECT c FROM SectorReportadoPqrs c")
@Table(name = "Rdo_visita", schema = "sde")
public class SectorReportadoPqrs {


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
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    // Id int4 NOT NULL,
    // sector_reportado text NOT NULL
    @Column(name = "sector_reportado")
    private String sector_reportado;

}
