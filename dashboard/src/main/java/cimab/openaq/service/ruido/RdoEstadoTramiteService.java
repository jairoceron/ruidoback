package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.ObserEstTramite;
import cimab.openaq.entity.ruido.RdoEstadoTramite;
import cimab.openaq.repository.ruido.RdoEstadoRepository;
import cimab.openaq.repository.ruido.RdoEstadoTramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static cimab.openaq.constantes.Constantes.*;

@Service
public class RdoEstadoTramiteService {


    private RdoEstadoTramiteRepository ar;

    @Autowired
    public void setAr(RdoEstadoTramiteRepository ar) {
        this.ar = ar;
    }

    List<RdoEstadoTramite> listREsTram = new ArrayList<>();
    List<ObserEstTramite> listObsEstTram = new ArrayList<>();

    public List<RdoEstadoTramite> consultaEstado() {

        return inicializarLista();


        // return ar.listEstadoTramitePqr();
    }

    public List<RdoEstadoTramite> inicializarLista() {

        listREsTram = new ArrayList<>();
        RdoEstadoTramite rdoEstadoTramite = new RdoEstadoTramite();

        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS);
        rdoEstadoTramite.setNombre(ANTECEDENTES_TECNICOS);
        listREsTram.add(rdoEstadoTramite);

        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS_Y_JURIDICOS);
        rdoEstadoTramite.setNombre(ANTECEDENTES_TECNICOS_Y_JURIDICOS);
        listREsTram.add(rdoEstadoTramite);

        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_EVALUACION_DE_ESTUDIO_DE_RUIDO);
        rdoEstadoTramite.setNombre(EVALUACION_DE_ESTUDIO_DE_RUIDO);
        listREsTram.add(rdoEstadoTramite);




        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);
        rdoEstadoTramite.setNombre(NORMATIVIDAD_AMBIENTAL);
        listREsTram.add(rdoEstadoTramite);

        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);
        rdoEstadoTramite.setNombre(NO_ES_COMPETENCIA);
        listREsTram.add(rdoEstadoTramite);



        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_PENDIENTE);
        rdoEstadoTramite.setNombre(PENDIENTE);
        listREsTram.add(rdoEstadoTramite);

        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_PROVISIONAL);
        rdoEstadoTramite.setNombre(PROVISIONAL);
        listREsTram.add(rdoEstadoTramite);

        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_SELLO_SEGURO);
        rdoEstadoTramite.setNombre(SELLO_SEGURO);
        listREsTram.add(rdoEstadoTramite);

        rdoEstadoTramite = new RdoEstadoTramite();
        rdoEstadoTramite.setId(ESTADO_TRAMITE_TRAMITADO);
        rdoEstadoTramite.setNombre(TRAMITADO);
        listREsTram.add(rdoEstadoTramite);

        return listREsTram;


    }

    public int retornaIdEstadoTramite(String nombre) {
        inicializarLista();
        System.out.println("nombre ---->  " + nombre);
        RdoEstadoTramite rdoEstadoTramite = listREsTram.stream().filter(c -> c.getNombre().equals(nombre)).findFirst().get();
        return rdoEstadoTramite.getId();
    }


    public List<ObserEstTramite> listObservacionEstadoTramiteX(int idEstadoTramite) {
        listObservacionEstadoTramite();
        return filtraObservacion_porEstadoTramite(idEstadoTramite);
    }

    public List<ObserEstTramite> listObservacionEstadoTramite() {
        listObsEstTram = new ArrayList<>();
        ObserEstTramite obserEstTramite = new ObserEstTramite();

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS);	obserEstTramite.setObservacion("I.A.E");
        listObsEstTram.add(obserEstTramite);


       // obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS);	obserEstTramite.setObservacion("NULL");
       // listObsEstTram.add(obserEstTramite);


        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS);	obserEstTramite.setObservacion("NO SUPERA");
        listObsEstTram.add(obserEstTramite);


        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS);	obserEstTramite.setObservacion("CTE NO CUMPLE CON ART. 21, RES. 0627 / 2009");
        listObsEstTram.add(obserEstTramite);


        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS);	obserEstTramite.setObservacion("CONCEPTO TECNICO SIN SEGUIMIENTO AL REQUERIMIENTO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS_Y_JURIDICOS);	obserEstTramite.setObservacion("SUPERA");
        listObsEstTram.add(obserEstTramite);

      //  obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS_Y_JURIDICOS);	obserEstTramite.setObservacion("NULL");
      //  listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_ANTECEDENTES_TECNICOS_Y_JURIDICOS);	obserEstTramite.setObservacion("ARCHIVO DE EXPEDIENTE");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_EVALUACION_DE_ESTUDIO_DE_RUIDO);	obserEstTramite.setObservacion("DESFAVORABLE");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_EVALUACION_DE_ESTUDIO_DE_RUIDO);	obserEstTramite.setObservacion("PARA SUBSANAR");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_EVALUACION_DE_ESTUDIO_DE_RUIDO);	obserEstTramite.setObservacion("FAVORABLE");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_EVALUACION_DE_ESTUDIO_DE_RUIDO);	obserEstTramite.setObservacion("INFORMATIVO/NO REQUIERE RESPUESTA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_EVALUACION_DE_ESTUDIO_DE_RUIDO);	obserEstTramite.setObservacion("INFORMATIVO / NO REQUIERE RESPUESTA");
        listObsEstTram.add(obserEstTramite);

        // obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("NULL");
        // listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("TRAMITES ASOCIADOS CON EVENTOS SUGA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("MESA DE TRABAJO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("LABCIMAB");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("RED DE RUIDO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("ACCIONES POPULARES");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("TRAMITE JURIDICO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("INFORMATIVO / NO REQUIERE RESPUESTA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("NORMATIVIDAD AMBIENTAL");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("NO SE EMITEN CERTIFICADOS");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NORMATIVIDAD_AMBIENTAL);	obserEstTramite.setObservacion("INVESTIGACION UNIVERSITARIA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("CARGA Y DESCARGA DE MERCANCIA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("VIBRACION");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("CONDICIONES DE LEGALIDAD");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("AEROPUERTO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("JURISDICCION DE LA CAR");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("CONSTRUCCION");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("NO ES COMPETENCIA DE RUIDO");
        listObsEstTram.add(obserEstTramite);

        // obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("NULL");
        // listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("PERIFONEO COMERCIAL");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("PROPIEDAD HORIZONTAL");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("ALTOPARLANTES");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("AFECTADO Y GENERADOR UBICADOS EN EL MISMO PREDIO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("TRAMITE RELACIONADO CON ANTENAS");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("ESPACIO PUBLICO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("FUENTES MOVILES");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("CONVIVENCIA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_NO_ES_COMPETENCIA);	obserEstTramite.setObservacion("INMISION");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PENDIENTE);	obserEstTramite.setObservacion("PRESUNTO CESE DE LA AFECTACION");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PENDIENTE);	obserEstTramite.setObservacion("REPARTO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PENDIENTE);	obserEstTramite.setObservacion("PENDIENTE ACTUALIZAR");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PENDIENTE);	obserEstTramite.setObservacion("CRONOGRAMA DE EVENTOS");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PENDIENTE);	obserEstTramite.setObservacion("REQUERIMIENTO POR CONVIVENCIA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PENDIENTE);	obserEstTramite.setObservacion("SE SOLICITA AMPLIACION DE LA INFORMACION");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("PROVISIONAL EN ZONA CRITICA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("REITERACION DE PROVISIONAL");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("PROVISIONAL PARA LEVANTAMIENTO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("PARA INVENTARIO DE ESTABLECIMIENTOS");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("PROVISIONAL, EMERGENCIA SANITARIA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("PROVISIONAL POR PERIODO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("PROVISIONAL CON RETRASO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("PROVISIONAL CON RANGO DE FECHA");
        listObsEstTram.add(obserEstTramite);

       // obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_PROVISIONAL);	obserEstTramite.setObservacion("NULL");
       // listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_SELLO_SEGURO);	obserEstTramite.setObservacion("PARA SUBSANAR");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_SELLO_SEGURO);	obserEstTramite.setObservacion("FAVORABLE");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_SELLO_SEGURO);	obserEstTramite.setObservacion("EN REVISION");
        listObsEstTram.add(obserEstTramite);

      //  obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("NULL");
      //  listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("VISITA EFECTIVA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("TRAMITE JURIDICO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("SOLICITUD DE COPIAS");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("SIN VIABILIDAD TECNICA PARA MEDIR");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("TRASLADO POR USO DE SUELO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("PREDIO SIN ANTECEDENTES");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("FINALIZADO SE RESPONDIO CON OTRO RADICADO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("INFORMATIVO / NO REQUIERE RESPUESTA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("OPERATIVO");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("ACTIVIDAD NO PERMITIDA POR EMERGENCIA SANITARIA");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("CESE DE LA AFECTACION");
        listObsEstTram.add(obserEstTramite);

        obserEstTramite = new ObserEstTramite(); obserEstTramite.setId(ESTADO_TRAMITE_TRAMITADO);	obserEstTramite.setObservacion("SE ENVIA COPIA DE RESPUESTA A PETICIONARIOS");
        listObsEstTram.add(obserEstTramite);

        return listObsEstTram;

    }


    public List<ObserEstTramite> filtraObservacion_porEstadoTramite(int estadoTramite) {
        return listObsEstTram.stream().filter(c -> c.getId() == estadoTramite).collect(Collectors.toList());
    }
}