package cimab.openaq.entity.ruido;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
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
    @Column(name = "objectid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer objectid;

    @Column(name = "fecha_hora")
    Timestamp fecha_hora; //  timestamp NOT NULL,

    @Column(name = "profesional_encargado_visita")
    String profesional_encargado_visita; //  varchar(50) NOT NULL,

    @Column(name = "radicado_atendido")
    String radicado_atendido; //  varchar(300) NULL,

    @Column(name = "actividad_segun_plan_trabajo")
    String actividad_segun_plan_trabajo; //  varchar(255) NOT NULL,

    @Column(name = "estado_visita")
    String estado_visita; //  varchar(255) NOT NULL,

    @Column(name = "visi_no_efectiva_motivo_repro")
    String visi_no_efectiva_motivo_repro; //  varchar(410) NOT NULL,


    @Column(name = "periodo_reprogramar_visita")
    String periodo_reprogramar_visita; //  varchar(50) NULL,


    @Column(name = "periodo_desde")
    Timestamp periodo_desde; //  timestamp NULL,


    @Column(name = "perido_hasta")
    Timestamp perido_hasta; //  timestamp NULL,


    @Column(name = "efectiva_cerrar_caso_motivo")
    String efectiva_cerrar_caso_motivo; //  varchar(130) NULL,


    @Column(name = "numero_expediente")
    String numero_expediente; //  varchar(50) NULL,


    @Column(name = "id_visita_ivc_forest")
    String id_visita_ivc_forest; //  varchar(50) NULL,


    @Column(name = "tipo_predio_generador_emision")
    String tipo_predio_generador_emision; //  varchar(50) NOT NULL,


    @Column(name = "matricula_mercantil_rues")
    String matricula_mercantil_rues; //  varchar(250) NULL,


    @Column(name = "nit_rues")
    String nit_rues; //  varchar(50) NULL,


    @Column(name = "nombre_comercial")
    String nombre_comercial; //  varchar(50) NULL,

    @Column(name = "razon_social_rues")
    String razon_social_rues; //  varchar(50) NULL,

    @Column(name = "representante_legal_propetario_")
    String representante_legal_propetario_; //  varchar(50) NULL,

    @Column(name = "tipo_de_documeto")
    String tipo_de_documeto; //  varchar(50) NOT NULL,

    @Column(name = "id_representante_legal_propetar")
    String id_representante_legal_propetar; //  varchar(50) NULL,

    @Column(name = "telefono")
    String telefono; //  varchar(50) NULL,


    @Column(name = "codigo_ciiu")
    Integer codigo_ciiu; //  int2 NULL,

    @Column(name = "direccion_via")
    String direccion_via; //  varchar(50) NOT NULL,


    @Column(name = "direccion_numero")
    Integer direccion_numero; //  int2 NOT NULL,


    @Column(name = "direccion_letra")
    String direccion_letra; //  varchar(50) NULL,


    @Column(name = "direccion_bis")
    String direccion_bis; //  varchar(50) NULL,

    @Column(name = "direccion_letra_2")
    String direccion_letra_2; //  varchar(50) NULL,


    @Column(name = "direccion_bis_2")
    String direccion_bis_2; //  varchar(50) NULL,


    @Column(name = "direccion_cuadrante")
    String direccion_cuadrante; //  varchar(50) NULL,


    @Column(name = "direccion_numero_2")
    Integer direccion_numero_2; //  int2 NOT NULL,


    @Column(name = "direccion_letra_3")
    String direccion_letra_3; //  varchar(50) NULL,


    @Column(name = "direccion_bis_3")
    String direccion_bis_3; //  varchar(50) NULL,


    @Column(name = "direccion_placa")
    Integer direccion_placa; //  int2 NOT NULL,


    @Column(name = "direccion_cuadrante_2")
    String direccion_cuadrante_2; //  varchar(50) NULL,


    @Column(name = "complemento_direccion")
    String complemento_direccion; //  varchar(50) NULL,


    @Column(name = "direccion_completa")
    String direccion_completa; //  varchar(50) NOT NULL,


    @Column(name = "x")
    BigDecimal x; //  numeric(38, 8) NULL,


    @Column(name = "y")
    BigDecimal y; //  numeric(38, 8) NULL,


    @Column(name = "localidad")
    Integer localidad; //  int2 NOT NULL,


    @Column(name = "upz")
    String upz; //  varchar(50) NOT NULL,


    @Column(name = "upl")
    String upl; //  varchar(50) NOT NULL,


    @Column(name = "cumplimiento_normativo")
    String cumplimiento_normativo; //  varchar(50) NULL,


    @Column(name = "leqemision_dba")
    BigDecimal leqemision_dba; //  numeric(38, 8) NULL,


    @Column(name = "valor_en_db_res_0627_2006")
    String valor_en_db_res_0627_2006; //  varchar(50) NULL,


    @Column(name = "area_de_activ_sinupot_dec_1")
    String area_de_activ_sinupot_dec_1; //  varchar(50) NOT NULL,


    @Column(name = "area_de_activ_pot_dec_555_2")
    String area_de_activ_pot_dec_555_2; //  varchar(255) NOT NULL,


    @Column(name = "visita_reprogramada_tiene_antec")
    String visita_reprogramada_tiene_antec; //  varchar(50) NULL,


    @Column(name = "cantidad_de_reprogramaciones")
    String cantidad_de_reprogramaciones; //  varchar(50) NULL,


    @Column(name = "numero_proceso_forest")
    BigDecimal numero_proceso_forest; //  numeric(38, 8) NOT NULL,


    @Column(name = "horario")
    String horario; //  varchar(255) NOT NULL,


    @Column(name = "actividad_principal")
    String actividad_principal; //  varchar(255) NULL,


    @Column(name = "shape")
    String shape; //  sde.st_point NULL,


    @Column(name = "created_user")
    String created_user; //  varchar(255) NULL,


    @Column(name = "created_date")
    Timestamp created_date; //  timestamp NULL,


    @Column(name = "last_edited_user")
    String last_edited_user; //  varchar(255) NULL,


    @Column(name = "last_edited_date")
    Timestamp last_edited_date; // timestamp NULL



}