package cimab.openaq.entity.ruido;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

// import com.vividsolutions.jts.geom.Point ;
// import org.locationtech.jts.geom.Coordinate;
// import org.locationtech.jts.geom.GeometryFactory;
// import org.locationtech.jts.geom.Point;
// import org.locationtech.jts.geom.Point;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
// import org.locationtech.jts.geom.Point;
// import org.locationtech.jts.geom.PrecisionModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the calificacion database table.
 *
 */

/**
 * The persistent class for the calificacion database table.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@NamedQuery(name="Pqrs.findAll", query="SELECT c FROM Pqrs c")
@Table(name = "Pqrs", schema = "sde")
// @Table(name = "Pqrs", schema = "public")
public class Pqrs implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "Pqrs",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "pqrs_objectid_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name="objectid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer objectid;


    @Column(name="radicado")
    String radicado;   // varchar(50) NULL,

    @Column(name="fecha_radicado")
    Timestamp fecha_radicado;   // timestamp NULL,

    @Column(name="asunto_radicacion")
    String asunto_radicacion;  // varchar(200) NULL,


    @Column(name="razon_social_establecimiento")
    String razon_social_establecimiento;  // varchar(200) NULL,


    @Column(name="sector_reportado")
    String sector_reportado; // varchar(50) NULL,


    @Column(name="entidad_de_control")
    String entidad_de_control;  // varchar(50) NULL,

    @Column(name="peticionario")
    String peticionario; // varchar(200) NULL,

    @Column(name="estado_tramite")
    Integer estado_tramite; // int2 NULL,

    @Column(name="observaciones_estado_tramite")
    String observaciones_estado_tramite; // varchar(50) NULL,

    @Column(name="observaciones_generales")
    String observaciones_generales; // varchar(256) NULL,

    @Column(name="profesional_1ra_asignacion")
    String profesional_1ra_asignacion; // varchar(50) NULL,

    @Column(name="fecha_1ra_asignacion")
    Timestamp fecha_1ra_asignacion; // timestamp NULL,


    @Column(name="profesional_2da_asignacion")
    String profesional_2da_asignacion; // varchar(50) NULL,

    @Column(name="fecha_2da_asignacion")
    Timestamp fecha_2da_asignacion; // timestamp NULL,

    @Column(name="profesional_diligencia")
    String profesional_diligencia; // varchar(50) NULL,

    @Column(name="x")
    BigDecimal x; // numeric(38, 8) NULL,

    @Column(name="y")
    BigDecimal y; // numeric(38, 8) NULL,

    @Column(name="direccion")
    String direccion; // varchar(255) NULL,

    @Column(name="complemento_direccion")
    String complemento_direccion; // varchar(255) NULL,

    @Column(name="localidad")
    String localidad; // varchar(255) NULL,



}