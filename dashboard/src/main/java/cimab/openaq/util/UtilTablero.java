package cimab.openaq.util;

import cimab.openaq.entity.rmcab.Variableambiental;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilTablero {

    public List<Variableambiental> cargaDatos(List<Object[]> listObject) {
        List<Variableambiental> listVariableAmb = new ArrayList<>();
        for (Object[] objeto : listObject) {
            Variableambiental va = new Variableambiental();
            va.setFuenteinformacion((String) objeto[0]); // fuenteinformacion,  // 0
            va.setVariable((String) objeto[1]);  //  // variable,   // 1
            va.setLatitud((Double) objeto[2]);  // objeto[2]  // latitud,   //2
            va.setLongitud((Double) objeto[3]); //    objeto[3]  // longitud,  //3
            va.setCodigoestacion((Integer) objeto[4]);  //  codigoestacion // 4,
            va.setNombreestacion((String) objeto[5]);  // nombreestacion // 5,
            Integer anio = (Integer) objeto[6];

            va.setAnioobservacion(anio);     // anioobservacion , //6
            Integer mes = (Integer) objeto[7];
            va.setMesobservacion(mes);  // objeto[7]   // mesobservacion , // 7
            Integer dia = (Integer) objeto[8];
            va.setDiaobservacion(dia); // objeto[8]   // diaobservacion,  //8


            String mes_ = mes.toString();
            String dia_ = dia.toString();
            if (mes_.length() <2 ){
                mes_ = "0"+mes_;
            }
            if (dia_.length() <2 ){
                dia_ = "0" + dia_;
            }

            String myFormat = "yyyyMMdd";
            String value = anio.toString() + mes_ + dia_  ;
            SimpleDateFormat dformat = new SimpleDateFormat("yyyyMMdd");
            try {
                Date date = dformat.parse(value);
                Timestamp ts = new Timestamp(date.getTime());
                va.setFechaobservacion(ts);


                va.setValorobservado((Double) objeto[9]);  // SUM(valorobservado) as suma //9
                listVariableAmb.add(va);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return listVariableAmb;
    }


}
