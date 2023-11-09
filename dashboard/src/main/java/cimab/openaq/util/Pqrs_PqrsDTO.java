package cimab.openaq.util;

import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.PqrsDTO;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static cimab.openaq.constantes.Constantes.*;

public class Pqrs_PqrsDTO {

    public PqrsDTO conviertePqrsPqrsDTO(Pqrs pqrs) {
        PqrsDTO pqrsDTO = new PqrsDTO();

        pqrsDTO.setObjectid(pqrs.getObjectid());
        pqrsDTO.setRadicado(pqrs.getRadicado() );   // varchar(50) NULL,
        pqrsDTO.setFecha_radicado(pqrs.getFecha_radicado() );   // timestamp NULL,

        String asuntoS = pqrs.getAsunto_radicacion();
        if (asuntoS != null) {
            if (asuntoS.length() > 29) {
                asuntoS = asuntoS.substring(0, 30);
            }
        }

        pqrsDTO.setAsunto_radicacion(asuntoS );  // varchar(200) NULL,

        String razonS = pqrs.getRazon_social_establecimiento();
        if (razonS != null) {
            if (razonS.length() > 29) {
                razonS = razonS.substring(0, 30);
            }
        }

        pqrsDTO.setRazon_social_establecimiento(razonS);  // varchar(200) NULL,
        pqrsDTO.setSector_reportado(pqrs.getSector_reportado() ); // varchar(50) NULL,
        pqrsDTO.setEntidad_de_control(pqrs.getEntidad_de_control() );  // varchar(50) NULL,
        pqrsDTO.setPeticionario(pqrs.getPeticionario() ); // varchar(200) NULL,
        pqrsDTO.setEstado_tramite(pqrs.getEstado_tramite() ); // int2 NULL,
        pqrsDTO.setObservaciones_estado_tramite(pqrs.getObservaciones_estado_tramite() ); // varchar(50) NULL,
        pqrsDTO.setObservaciones_generales(pqrs.getObservaciones_generales() ); // varchar(256) NULL,
        pqrsDTO.setProfesional_1ra_asignacion(pqrs.getProfesional_1ra_asignacion() ); // varchar(50) NULL,
        pqrsDTO.setFecha_1ra_asignacion(pqrs.getFecha_1ra_asignacion() ); // timestamp NULL,
        pqrsDTO.setProfesional_2da_asignacion(pqrs.getProfesional_2da_asignacion() ); // varchar(50) NULL,
        pqrsDTO.setFecha_2da_asignacion(pqrs.getFecha_2da_asignacion() ); // timestamp NULL,
        pqrsDTO.setProfesional_diligencia(pqrs.getProfesional_diligencia() ); // varchar(50) NULL,
        pqrsDTO.setX(pqrs.getX() ); // numeric(38, 8) NULL,
        pqrsDTO.setY(pqrs.getY() ); // numeric(38, 8) NULL,
        pqrsDTO.setDireccion(pqrs.getDireccion() ); // varchar(255) NULL,
        pqrsDTO.setComplemento_direccion(pqrs.getComplemento_direccion() ); // varchar(255) NULL,
        pqrsDTO.setLocalidad(pqrs.getLocalidad() ); // varchar(255) NULL,

        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_ANTECEDENTES_TECNICOS) {
            pqrsDTO.setEstadoTramiteStr(ANTECEDENTES_TECNICOS);
        }
        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_ANTECEDENTES_TECNICOS_Y_JURIDICOS) {
            pqrsDTO.setEstadoTramiteStr(ANTECEDENTES_TECNICOS_Y_JURIDICOS);
        }
        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_EVALUACION_DE_ESTUDIO_DE_RUIDO) {
            pqrsDTO.setEstadoTramiteStr(EVALUACION_DE_ESTUDIO_DE_RUIDO);
        }
        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL) {
            pqrsDTO.setEstadoTramiteStr(NORMATIVIDAD_AMBIENTAL);
        }
        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_NO_ES_COMPETENCIA) {
            pqrsDTO.setEstadoTramiteStr(NO_ES_COMPETENCIA);
        }
        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_PENDIENTE) {
            pqrsDTO.setEstadoTramiteStr(PENDIENTE);
        }
        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_PROVISIONAL) {
            pqrsDTO.setEstadoTramiteStr(PROVISIONAL);
        }
        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_SELLO_SEGURO) {
            pqrsDTO.setEstadoTramiteStr(SELLO_SEGURO);
        }
        if (pqrs.getEstado_tramite().intValue() == ESTADO_TRAMITE_TRAMITADO) {
            pqrsDTO.setEstadoTramiteStr(TRAMITADO);
        }

        // pqrsDTO.setDiasDeVencido( );
        // pqrsDTO.setBanderaVencimiento(pqrs.get );

        return pqrsDTO;
    }
}
