package cimab.openaq.util;

import cimab.openaq.dto.ruido.ChartGenerico;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ListasChart {

    public List<ChartGenerico> genListaChartGenerico(List<Object[]> listChartEsTramite) {
        List<ChartGenerico> listCharEstTramite = new ArrayList<>();
        for (Object[] objX : listChartEsTramite) {
            ChartGenerico chartGenerico = new ChartGenerico();
            String nombre = (String) objX[0];
            BigInteger valor = (BigInteger) objX[1];
            chartGenerico.setName(nombre);
            chartGenerico.setValue(valor.intValue());
            listCharEstTramite.add(chartGenerico);
        }
        return listCharEstTramite;
    }
}
