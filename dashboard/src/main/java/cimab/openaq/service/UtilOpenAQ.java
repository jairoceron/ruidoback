package cimab.openaq.service;

import cimab.openaq.model.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.math.BigInteger;
import java.rmi.RemoteException;

import java.time.*;
import java.time.LocalDate;
import java.util.*;

public class UtilOpenAQ {

    public String retornaFechaValida(String datefrom) {

        String datefromX = datefrom.replaceAll("-","");


        if (datefromX.length() == 8) {
            return datefromX;
        }



        String[] rayas = datefrom.split("-");


        if (rayas.length == 3) {
            String anio = rayas[0];

            String mes = rayas[1];
            if (mes.length() < 2) {
                mes = "0" + mes;
            }
            String dia = rayas[2];
            if (dia.length() < 2) {
                dia = "0" + dia;
            }
            datefromX = anio + mes + dia;

        }

        return datefromX;

    }

    public JsonArray consultaWebService(BigInteger fini  , BigInteger hora  ) {

        JsonArray jsonObject = null;
        try {
            WsrmcabStub serviceCAB = new WsrmcabStub();
            WsrmcabStub.GetDataHorario gdO = new WsrmcabStub.GetDataHorario();
            WsrmcabStub.GetDataHorarioE gdE = new WsrmcabStub.GetDataHorarioE();
            gdO.setFechaInicio(fini);

            gdO.setHora(hora);
            gdO.setJson(true);

            gdE.setGetDataHorario(gdO);




            WsrmcabStub.GetDataHorarioResponseE gdhre = serviceCAB.getDataHorario(gdE);
            String json = gdhre.getGetDataHorarioResponse().get_return();


            jsonObject = new JsonParser().parse(json).getAsJsonArray();

        } catch (org.apache.axis2.AxisFault af) {
           af.printStackTrace();
        }
        catch (RemoteException re) {
            re.printStackTrace();
        }
        // System.out.println(jsonObject);
        return jsonObject;
    }

    public List<OpenAqFormat> leerJson(JsonArray jsonObject  ) {


        List<JsonSDA> ltJsonSDA = new ArrayList<JsonSDA>();


        for (int i = 0; i < jsonObject.size(); i++) {
            JsonObject obj = jsonObject.get(i).getAsJsonObject();



            //obj.get
            JsonElement jsonEle = obj.get("stanombre");

            JsonElement stanombre = obj.get("stanombre");

            JsonElement stadireccion = obj.get("stadireccion");
            JsonElement stacode = obj.get("stacode");

            JsonElement latitudXXX = obj.get("stalatitud");
            JsonElement stalongitud = null;
            JsonElement stalatitud = null;

            // latitude":-74.16627777777778

            if ((latitudXXX.getAsDouble() > -75.0) && (latitudXXX.getAsDouble() < -73)) {
                stalongitud =    obj.get("stalatitud");
                stalatitud =  obj.get("stalongitud");
            } else {
                stalongitud = obj.get("stalongitud");
                stalatitud =    obj.get("stalatitud");
            }


            // JsonElement stalatitud =   obj.get("stalongitud");
            JsonElement variable = obj.get("variable");
            JsonElement moncode = obj.get("moncode");
            JsonElement unidad = obj.get("unidad");
            JsonElement fechainicio = obj.get("fechainicio");
            JsonElement fechafin = obj.get("fechafin");

            JsonElement fechamodificacion = obj.get("fechamodificacion");
            JsonElement concentracion = obj.get("concentracion");
            JsonElement msflcode = obj.get("msflcode");
            JsonElement monMonitorstate = obj.get("monMonitorstate");
            JsonElement staActive = obj.get("staActive");
            JsonElement tp = obj.get("tp");
            JsonElement fn = obj.get("fn");
            JsonElement h24 = obj.get("h24");



            JsonSDA jsonSDA = new JsonSDA();
            jsonSDA.setStanombre(stanombre.getAsString());
            jsonSDA.setStadireccion(stadireccion.getAsString());
            jsonSDA.setStacode(stacode.getAsString());
            jsonSDA.setStalongitud(stalongitud.getAsString());
            jsonSDA.setStalatitud(stalatitud.getAsString());
            jsonSDA.setVariable(variable.getAsString());
            jsonSDA.setMoncode(moncode.getAsString());
            jsonSDA.setUnidad(unidad.getAsString());
            jsonSDA.setFechainicio(fechainicio.getAsString());
            jsonSDA.setFechafin(fechafin.getAsString());
            jsonSDA.setFechamodificacion(fechamodificacion.getAsString());
            jsonSDA.setConcentracion(concentracion.getAsString());
            jsonSDA.setMsflcode(msflcode.getAsString());
            jsonSDA.setMonMonitorstate(monMonitorstate.getAsString());
            jsonSDA.setStaActive(staActive.getAsString());
            jsonSDA.setTp(tp.getAsString());
            jsonSDA.setFn(fn.getAsString());
            jsonSDA.setH24(h24.getAsString());

            ltJsonSDA.add(jsonSDA);


        }

        List<OpenAqFormat> ltOpenAqFormat = listaOpenAqFormat(ltJsonSDA);

        return ltOpenAqFormat;
    }


    private List<OpenAqFormat> listaOpenAqFormat(List<JsonSDA> ltJsonSDA) {
        // función que hace la transformación
        List<OpenAqFormat> ltOpenAqFormat = new ArrayList<OpenAqFormat>();

        for (int i=0; i<ltJsonSDA.size(); i++) {
            JsonSDA jsonSDA = ltJsonSDA.get(i);
            OpenAqFormat openAq = new OpenAqFormat();

            // pm25, pm10, co, bc, so2, no2, o3
            // pm25  PM2.5

            openAq.setLocation(jsonSDA.getStanombre());
            openAq.setCity("Bogota");
            openAq.setCountry("Colombia");
            openAq.setValue(new Double(jsonSDA.getConcentracion()));
            openAq.setUnit(jsonSDA.getUnidad());

            DateUtcLocal datULoc = new DateUtcLocal();
            String local = agregarTyZ();
            String utc = retornaUTC(local);

            datULoc.setLocal(local);
            datULoc.setUtc(utc);

            openAq.setDate(datULoc);
            openAq.setSourceName(jsonSDA.getStanombre());
            openAq.setSourceType("government");
            openAq.setMobile(false);
            Location location = new Location();
            location.setLatitude(new Double(jsonSDA.getStalatitud()));
            location.setLongitude(new Double(jsonSDA.getStalongitud()));
            openAq.setCoordinates(location);
            Attribution attribution = new Attribution();
            attribution.setName("Secretaria Distrital de Ambiente");
            attribution.setUrl("http://www.ambientebogota.gov.co/");
            openAq.setAttribution(attribution);
            AveragingPeriod averaginPeriod = new AveragingPeriod();
            averaginPeriod.setUnit("hours");
            averaginPeriod.setValue(1);

            openAq.setAveragingPeriod(averaginPeriod);

            if (mapeaParametroWebService(jsonSDA.getVariable(), openAq)) {
                // solo envia los parametros validos ::: pm25, pm10, co, bc, so2, no2, o3
                // https://github.com/openaq/openaq-data-format
                ltOpenAqFormat.add(openAq);

            }

        }

        return ltOpenAqFormat;
    }


    private boolean mapeaParametroWebService(String paramWebService, OpenAqFormat openAq) {

        boolean retorno = false;
            switch (paramWebService) {
                case "PM2.5":
                    openAq.setParameter("pm25");
                    retorno = true;
                    break;
                case "PM10":
                    openAq.setParameter("pm10");
                    retorno = true;
                    break;
                case "CO":
                    openAq.setParameter("co");
                    retorno = true;
                    break;
               // case "BC":
               //     openAq.setParameter("bc");
               //     retorno = true;
               //     break;
                case "SO2":
                    openAq.setParameter("so2");
                    retorno = true;
                    break;
                case "NO2":
                    openAq.setParameter("no2");
                    retorno = true;
                    break;
               // case "O3 API":
               //     openAq.setParameter("o3");  // ozono
               //     retorno = true;
               //     break;

                case "OZONO":
                    openAq.setParameter("o3");  // ozono
                         retorno = true;
                         break;

            }

            return retorno;
    }


    private String agregarTyZ() {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        //    LocalDateTime dateTime = LocalDateTime.of(date, time);
        //  System.out.println(dateTime);   // 2020-04-27T13:01:29.750616

        ZoneId zoneId = ZoneId.of("America/Bogota");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);
        //  System.out.println(zonedDateTime);

        String cad = zonedDateTime.toString();
        cad = cad.substring(0,19)+ "-05:00";
        /*
        int boi = cad.indexOf("[America/Bogota");
        if (boi>0) {
            cad = cad.substring(0,boi);
        }
*/
        return cad;


    }

    private String retornaUTC(String localX)  {
        Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate

        // String strDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"; // El formato de fecha está especificado
        // SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto

        ZonedDateTime nowUTC = ZonedDateTime.now(ZoneOffset.UTC);
        String local = nowUTC.toString();
        local = local.substring(0,19)+ "Z";
        //  System.out.println("dm.     " + nowUTC.toString());
        //  System.out.println("dm.>>>> " + local);

        //  return objSDF.format(objDate);

        // ZoneId zoneId = ZoneId.of("America/Bogota");
        //  ZoneId zoneId = ZoneId.of("UTC-5");
        //ZonedDateTime dateTime = ZonedDateTime.of(objDate, zoneId);
        //  LocalDateTime now = LocalDateTime.now();
/*
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zoneId);

        //  System.out.println(zonedDateTime);

        String cad = zonedDateTime.toString();
        int boi = cad.indexOf("[America/Bogota");
        if (boi>0) {
            cad = cad.substring(0,boi);
        } */
        return local;


    }



}
