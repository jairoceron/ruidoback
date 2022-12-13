package cimab.openaq.service.ruido;

import cimab.openaq.dto.ruido.ChartGenerico;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.ruido.PqrsRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import cimab.openaq.util.ListasChart;
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

    public List<ChartGenerico> chartNoEsCompetencia(ConsultaVisita consultaVisita) {
        List<Object[]> listChartEsTramite = pqr.chartNoEsCompetencia(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
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

    public List<ChartGenerico> chartProvisionalET(ConsultaVisita consultaVisita) {
        List<Object[]> listChartEsTramite = pqr.chartProvisionalET(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
        ListasChart listaChart = new ListasChart();
        return listaChart.genListaChartGenerico(listChartEsTramite);
    }

    public List<Pqrs> consultaOrganismoDeControl(ConsultaVisita consultaVisita) {

        return pqr.consultaOrganismoControl(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
    }

}
