package cimab.openaq.entity.ruido;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@NamedQuery(name="Visitas.findAll", query="SELECT c FROM Visitas c")
@Table(name = "Visitas", schema = "sde")
public class Visitas implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "VisitasSq",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sde.visitas_id_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "305"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "objectid")
    private Integer objectid;


    @Column(name = "ano")
    private Integer ano;


    @Column(name = "mes")
    private String mes;

    @Column(name = "latitud")
    private Float latitud;

    @Column(name = "longitud")
    private Float longitud;

    @Column(name = "profesional_encargado")
    private String profesional_encargado;

    @Column(name = "radicado")
    private String radicado;

    @Column(name = "actividad_a_realizar_segun_plan")
    private String actividad_a_realizar_segun_plan;

    @Column(name = "estado_de_la_visita")
    private String estado_de_la_visita;

    @Column(name = "solo_si_la_visita_no_fue_efecti")
    private String solo_si_la_visita_no_fue_efecti;

    @Column(name = "solo_si_la_visita_fue_efectiva_")
    private String solo_si_la_visita_fue_efectiva_;

    @Column(name = "gestion")
    private String gestion;

    @Column(name = "observaciones_al_motivo")
    private String observaciones_al_motivo;

    @Column(name = "numero_de_expediente")
    private String numero_de_expediente;

    @Column(name = "proceso_actuacion_tecnica_o_res")
    private String proceso_actuacion_tecnica_o_res;

    @Column(name = "nombre_comercial")
    private String nombre_comercial;

    @Column(name = "razon_social")
    private String razon_social;

    @Column(name = "codigo_ciiu")
    private String codigo_ciiu;

    @Column(name = "matricula_mercantil")
    private String matricula_mercantil;

    @Column(name = "nit")
    private String nit;

    @Column(name = "representante_legal")
    private String representante_legal;

    @Column(name = "numero")
    private String numero;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion__via_")
    private String direccion__via_;

    @Column(name = "direccion__numero_")
    private Integer direccion__numero_;

    @Column(name = "direccion__letra_")
    private String direccion__letra_;

    @Column(name = "direccion__bis_")
    private String direccion__bis_;

    @Column(name = "direccion__cuadrante_")
    private String direccion__cuadrante_ ;

    @Column(name = "direccion__numero1")
    private Integer direccion__numero1;

    @Column(name = "direccion__letra1")
    private String direccion__letra1;

    @Column(name = "direccion__bis1")
    private String direccion__bis1;

    @Column(name = "direccion__placa_")
    private String direccion__placa_;

    @Column(name = "direccion__cuadrante1")
    private String direccion__cuadrante1;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "tipo_de_predio_generador_de_la_")
    private String tipo_de_predio_generador_de_la_;

    @Column(name = "actividad_especifica")
    private String actividad_especifica;

    @Column(name = "localidad")
    private String localidad ;

    @Column(name = "upz")
    private String upz;

    @Column(name = "cumplimiento_normativo")
    private String cumplimiento_normativo;

    @Column(name = "horario_de_la_visita")
    private String horario_de_la_visita;

    @Column(name = "lequemision_n_db_a_")
    private Float lequemision_n_db_a_;

    @Column(name = "sellamiento_codigo_de_la_polici")
    private String sellamiento_codigo_de_la_polici;

    @Column(name = "valor_para_comparar_con_la_norm")
    private String valor_para_comparar_con_la_norm;

    @Column(name = "visita_programada")
    private Integer visita_programada;

    @Column(name = "area_de_actividad_segun_sinupot")
    private String area_de_actividad_segun_sinupot;

    @Column(name = "observaciones_de_area_de_activi")
    private String observaciones_de_area_de_activi;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "barrio")
    private String barrio;

    @Column(name = "orig_fid")
    private Integer orig_fid;

    @Column(name = "globalid")
    private String globalid ;

    @Column(name = "fechavisita")
    //@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy'T'HH:mm:ss.SSS'Z'", timezone="Europe/Berlin")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm")
    private java.sql.Timestamp fechavisita ;
}