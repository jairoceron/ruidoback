package cimab.openaq.service;


import cimab.openaq.model.OpenAqFormat;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.google.gson.JsonArray;


@Service
public class OpenAQService {

    public void operacion(String datefrom, String dateto, String parameter) {

        String datefromDefault = "20201609";
        UtilOpenAQ utilOpenAQ = new UtilOpenAQ();
        if (datefrom != null) {
            if (datefrom.length() > 4) {
                datefromDefault = utilOpenAQ.retornaFechaValida(datefrom);
            }
        }
        BigInteger fini = new BigInteger(datefromDefault);
        BigInteger hora = new BigInteger("7");

        for (int i=1; i<=24; i++) {
            hora = new BigInteger(String.valueOf(i));

            JsonArray jsonObject = utilOpenAQ.consultaWebService(fini, hora);

        }

    }
    public void latest(String city,  String parameter) {


        String datefromDefault = "20201609";
        UtilOpenAQ utilOpenAQ = new UtilOpenAQ();

        BigInteger fini = new BigInteger(datefromDefault);
        BigInteger hora = new BigInteger("7");

        for (int i=1; i<=1; i++) {  // deberìa ir hasta 24 horas
            hora = new BigInteger(String.valueOf(i));

            JsonArray jsonObject = utilOpenAQ.consultaWebService(fini, hora);
            // utilOpenAQ.leerJson(jsonObject, parameter);
        }
    }

    public List<OpenAqFormat> openAq() {

        UtilOpenAQ utilOpenAQ = new UtilOpenAQ();
        // se arregla para la fecha actual

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        String ultimoDia = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String horaX = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());


        String datefromDefault = ultimoDia;         // "20201008";  // fecha actual  // octubre 8 de 2020
        BigInteger fini = new BigInteger(datefromDefault);

        // hora = new BigInteger(String.valueOf(hora));
        BigInteger hora = new BigInteger(String.valueOf(horaX));

        JsonArray jsonObject = utilOpenAQ.consultaWebService(fini, hora);
        List<OpenAqFormat> ltOpenAqFormat = utilOpenAQ.leerJson(jsonObject);

        return ltOpenAqFormat;

        }


}





