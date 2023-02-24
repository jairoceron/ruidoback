package cimab.openaq.service.rmcab;

import cimab.openaq.entity.rmcab.Sbccalidad;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.rmcab.SbccalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SbccalidadService {

    private  SbccalidadRepository cs;

    @Autowired
    public void setCs(SbccalidadRepository cs) {
        this.cs = cs;
    }

    public List<Sbccalidad> consultaSbccalidad(ConsultaVisita consultaVisita) {
        return cs.listSbccalidad();
    }

    public List<Sbccalidad> calidadPM1(ConsultaVisita consultaVisita) {
        Sbccalidad sbccalidad = cs.listSbccalidadPM1();
        return null;
    }


}
