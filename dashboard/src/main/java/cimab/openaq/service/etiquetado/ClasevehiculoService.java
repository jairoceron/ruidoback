package cimab.openaq.service.etiquetado;

import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.repository.etiquetado.ClasevehiculoRepository;
import cimab.openaq.repository.ruido.EstadotramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;


import cimab.openaq.entity.ruido.Estadotramite;
import cimab.openaq.repository.ruido.EstadotramiteRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import cimab.openaq.dataTransferObject.Parametro;
import cimab.openaq.dataTransferObject.SensorMedicion;
import cimab.openaq.dto.LatitudLongitud;
import cimab.openaq.dto.Param;
import cimab.openaq.entity.sbc.Sensoresestacion;
import cimab.openaq.repository.ruido.VisitaRepository;
import cimab.openaq.repository.sbc.SensoresestacionRepository;
import cimab.openaq.repository.sbc.SensoresvariableRepository;
import cimab.openaq.util.ConsultasListas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static cimab.openaq.constantes.ConstantesCimab.*;


@Service
public class ClasevehiculoService {

    private ClasevehiculoRepository vr;

    @Autowired
    public void setVr(ClasevehiculoRepository vr) {
        this.vr = vr;
    }

    public List<Clasevehiculo> listClaseVehiculos() {
        return vr.listClaseVehiculo();
    }


}
