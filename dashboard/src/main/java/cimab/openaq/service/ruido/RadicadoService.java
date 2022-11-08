package cimab.openaq.service.ruido;

import cimab.openaq.dto.ruido.ChartGenerico;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.ruido.PqrsRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class RadicadoService {
    private PqrsRepository pqr;


    @Autowired
    public void setPqr(PqrsRepository pqr) {
        this.pqr = pqr;
    }

    public Pqrs guardarRadicado(Pqrs pqrs) {
        pqr.save(pqrs);
        return pqrs;
    }

    public Pqrs consultaRadicado(Pqrs pqrs) {
        Pqrs pqrsX = pqr.consultaPorRadicado(pqrs.getRadicado());
        return pqrsX;
    }

public List<ChartGenerico> chartEstadoTramite(ConsultaVisita consultaVisita) {

    List<Object[]> listChartEsTramite = pqr.chartEstadoTramite(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
    List<ChartGenerico> listCharEstTramite = new ArrayList<>();
    for (Object[] objX : listChartEsTramite) {
        ChartGenerico chartGenerico = new ChartGenerico();
        String nombre = (String)objX[0];
        BigInteger valor = (BigInteger)objX[1];
        chartGenerico.setName(nombre);
        chartGenerico.setValue(valor.intValue());
        listCharEstTramite.add(chartGenerico);
    }

    return listCharEstTramite;
}
}
