package cimab.openaq.entity.ruido;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class PqrsDTO {

    Integer objectid;
    String radicado;   // varchar(50) NULL,
    Timestamp fecha_radicado;   // timestamp NULL,
    String asunto_radicacion;  // varchar(200) NULL,
    String razon_social_establecimiento;  // varchar(200) NULL,
    String sector_reportado; // varchar(50) NULL,
    String entidad_de_control;  // varchar(50) NULL,
    String peticionario; // varchar(200) NULL,
    Integer estado_tramite; // int2 NULL,
    String observaciones_estado_tramite; // varchar(50) NULL,
    String observaciones_generales; // varchar(256) NULL,
    String profesional_1ra_asignacion; // varchar(50) NULL,
    Timestamp fecha_1ra_asignacion; // timestamp NULL,
    String profesional_2da_asignacion; // varchar(50) NULL,
    Timestamp fecha_2da_asignacion; // timestamp NULL,
    String profesional_diligencia; // varchar(50) NULL,
    BigDecimal x; // numeric(38, 8) NULL,
    BigDecimal y; // numeric(38, 8) NULL,
    String direccion; // varchar(255) NULL,
    String complemento_direccion; // varchar(255) NULL,
    String localidad; // varchar(255) NULL,
    long diasDeVencido;
    String banderaVencimiento;  // Vencido=ROJO (Fecha vencida)
    String estadoTramiteStr;
    // ------------------------------ DATOS DE LA VISITA :::::
    Timestamp fechaVisita;
    String estadoVisita;
    String cantidad_de_reprogramaciones;
    String horario;


    // Próximo a vencer= AMARILLO (1 semana antes de vencer)
    // https://docs.google.com/document/d/13zwX0RXtXTBNGZJrTIzb3EoEBuX-u2rc/edit


}
