package cimab.openaq.entity.ruido;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;

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
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Pqrs.findAll", query="SELECT c FROM Pqrs c")
@Table(name = "Pqrs", schema = "sde")
public class Pqrs implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "Pqrs",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "pqrs_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name="objectid")
    private Integer objectid;


  //  @Column(name="año")
  //  private String ano;

    @Column(name="mes")
    private String mes;

    @Column(name="x")
    private String x;

    @Column(name="y")
    private String y;

    @Column(name="radicado")
    private String radicado;

    @Column(name="asunto_de_radicacion")
    private String asunto_de_radicacion;

    @Column(name="direcciones")
    private String direcciones;

    @Column(name="complemento_de_direcciones")
    private String complemento_de_direcciones;

    @Column(name="razon_social_del_establecimient")
    private String razon_social_del_establecimient;

    @Column(name="sector_reportado")
    private String sector_reportado;

    @Column(name="localidad")
    private String localidad;

    @Column(name="causante_del_origen_quejoso")
    private String causante_del_origen_quejoso;

    @Column(name="estado_del_tramite")
    private Integer estado_del_tramite;

    @Column(name="observaciones_generales")
    private String observaciones_generales;

    @Column(name="profesional_asignado_primera_as")
    private String profesional_asignado_primera_as;

    @Column(name="profesional_que_diligencia")
    private String profesional_que_diligencia;

    @Column(name="orig_fid")
    private Integer orig_fid;

    @Column(name="fecha_del_radicado")
    private Timestamp fecha_del_radicado  ;

    @Column(name="fecha_primera_asignacion")
    private Timestamp fecha_primera_asignacion  ;

    @Column(name="fecha_segunda_asignacion")
    private Integer fecha_segunda_asignacion  ;

    @Column(name="profesional_asignado_segunda_as")
    private String profesional_asignado_segunda_as;

    @Column(name="globalid")
    private String globalid;

}