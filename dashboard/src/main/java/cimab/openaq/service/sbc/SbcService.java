package cimab.openaq.service.sbc;


import cimab.openaq.dataTransferObject.Parametro;
import cimab.openaq.dataTransferObject.SensorMedicion;
import cimab.openaq.dto.LatitudLongitud;
import cimab.openaq.dto.Param;
import cimab.openaq.entity.sbc.Sensoresestacion;
import cimab.openaq.entity.sbc.Sensoresvariable;
import cimab.openaq.repository.sbc.SensoresestacionRepository;
import cimab.openaq.repository.sbc.SensoresvariableRepository;
import cimab.openaq.util.ConsultasListas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static cimab.openaq.constantes.ConstantesCimab.*;


@Service
public class SbcService {

    private SensoresvariableRepository cs;
    private SensoresestacionRepository se;

    @Autowired
    public void setCs(SensoresvariableRepository cs) {
        this.cs = cs;
    }

    @Autowired
    public void setSe(SensoresestacionRepository se) {
        this.se = se;
    }


    public List<String> querySensoresPorMarca( int marcaSensor) {
        ConsultasListas cl = new ConsultasListas();
         // List<Parametro> listMarcaSensor = cl.listMarcaSensor();
         // 99999
        List<String> listSensoresMarca = cs.queryMarcaSensores();
        List<Parametro> listMarcaSensor = cl.listMarcaSensor( listSensoresMarca );

        String marcaSensorX = "%%";
        if (marcaSensor > TODOS) {
            marcaSensorX = listMarcaSensor.stream().filter(c -> c.getClave() == marcaSensor).findFirst().get().getValor();
        }

        List<String> listSensoresPorMarca = new ArrayList<>();
        listSensoresPorMarca.add(TODAS);
        listSensoresPorMarca.addAll(cs.querySensoresPorMarca(marcaSensorX));
        return listSensoresPorMarca;
    }

    public List<SensorMedicion> consultaSesorBajoCosto(int marcaSensor,
                                                       String codigoSensor,
                                                       int promedio,
                                                       int variable, String fechaInicial,
                                                       String fechaFinal) {

        List<Parametro> listVariable = new ArrayList<>();
        listVariable.add(new Parametro(0, "Todas"));
        listVariable.add(new Parametro(1, "Humedad"));
        listVariable.add(new Parametro(2, "Temperatura"));
        listVariable.add(new Parametro(3, "PM 1"));
        listVariable.add(new Parametro(4, "PM 10"));
        listVariable.add(new Parametro(5, "PM 25"));

        ConsultasListas cl = new ConsultasListas();
        List<String> listSensoresMarca = cs.queryMarcaSensores();
        List<Parametro> listMarcaSensor = cl.listMarcaSensor( listSensoresMarca );
        //List<Parametro> listMarcaSensor = cl.listMarcaSensor();

        List<Parametro> listPromedio = new ArrayList<>();
        listPromedio.add(new Parametro(TODOS, "Todas"));
        listPromedio.add(new Parametro(PROMEDIO_DIARIO, "Diario"));
        listPromedio.add(new Parametro(PROMEDIO_HORARIO, "Horario"));
        listPromedio.add(new Parametro(PROMEDIO_MENSUAL, "Promedio mensual"));
        listPromedio.add(new Parametro(PROMEDIO_MOVIL_24h, "Promedio móvil 24h"));
        listPromedio.add(new Parametro(PROMEDIO_MOVIL_8h, "Promedio móvil 8h"));


        String marcaSensorX = "%%";
        if (codigoSensor.equals("Todas")) {
            codigoSensor = "%%";
        }

        if (marcaSensor > TODOS) {
            marcaSensorX = listMarcaSensor.stream().filter(c -> c.getClave() == marcaSensor).findFirst().get().getValor();
        }


        List<Object[]> listSensor = new ArrayList<>();
        List<SensorMedicion> listSensorMedicion = new ArrayList<>();



        if (promedio == TODOS) {
            listSensor = cs.consultaSesorBajoCosto(marcaSensorX, codigoSensor, fechaInicial, fechaFinal);
            listSensorMedicion = cl.listaTodos(listSensor);
        }
        if (promedio == PROMEDIO_DIARIO) {
            listSensor = cs.querySBCPromedioDiario(marcaSensorX, codigoSensor, fechaInicial, fechaFinal);
            listSensorMedicion = cl.listaPromedioDiario(listSensor);
        }

        if (promedio == PROMEDIO_HORARIO) {
            listSensor = cs.querySBCPromedioHorario(marcaSensorX, codigoSensor, fechaInicial, fechaFinal);
            listSensorMedicion = cl.listaPromedioHorario(listSensor);
        }

        if (promedio == PROMEDIO_MOVIL_24h) {
            listSensor = cs.querySBCPromedioHorMovil24H(marcaSensorX, codigoSensor, fechaInicial, fechaFinal, MOVIL_24);
            listSensorMedicion = cl.listaPromedioHorMovil(listSensor, MOVIL_24);
        }
        if (promedio == PROMEDIO_MOVIL_8h) {
            listSensor = cs.querySBCPromedioHorMovil24H(marcaSensorX, codigoSensor, fechaInicial, fechaFinal, MOVIL_8);
            listSensorMedicion = cl.listaPromedioHorMovil(listSensor, MOVIL_8);
        }

        if (promedio == PROMEDIO_MENSUAL) {
            listSensor = cs.sBCPromMensualHorMovil24H(marcaSensorX, codigoSensor, fechaInicial, fechaFinal);
            listSensorMedicion = cl.listaMensualHorMovil(listSensor);
        }

        return listSensorMedicion;
    }

    public List<Param> listaMarcasSensores() {
        List<String> listSensoresMarca = cs.queryMarcaSensores();
        ConsultasListas cl = new ConsultasListas();
        return cl.listMarcaSensorParam( listSensoresMarca );

    }

    public List<Sensoresestacion> latlongPoligionoEstaciones() {
        List<String> listSensoresMarca = cs.queryMarcaSensores();
        ConsultasListas cl = new ConsultasListas();
        List<Sensoresestacion> lisSeEstacion = se.consultaSesorBajoCosto();

        return lisSeEstacion;

    }

    public String calidadDatosSBC() {
        String diaFinal = "2022-02-05 23:00";
        String diaInicial = "2022-02-05 00:00";

        for (int i= 1; i<=28; i++) {
            if (i<10) {
                diaFinal = "2022-02-0" + i + " 23:00";
                diaInicial = "2022-02-0" + i + " 00:00";
            } else {
                diaFinal = "2022-02-" + i + " 23:00";
                diaInicial = "2022-02-" + i + " 00:00";
            }


            List<Sensoresvariable> lsv= cs.consultaCalidadAire(diaInicial, diaFinal);
            Float pm10_ = 300.0F;
            Float pm25_ = 300.0F;
            Float pm1_ = 300.0F;
            Float temperatura_ = 5.0F;
            for (Sensoresvariable ls : lsv) {
                Float pm10x = ls.getPm10();
                Float pm25x = ls.getPm25();
                Float pm1x = ls.getPm1();
                Float temperaturax = ls.getTemperatura();

                if ((Math.abs( pm10x - pm10_)) > 300) {
                    ls.setCalidad_pm10(-2);

                    cs.saveAndFlush(ls);
                }
                if ((Math.abs( pm25x - pm25_)) > 300) {
                    ls.setCalidad_pm25(-2);

                    cs.saveAndFlush(ls);
                }
                if ((Math.abs( pm1x - pm1_)) > 300) {
                    ls.setCalidad_pm1(-2);

                    cs.saveAndFlush(ls);
                }
                if ((Math.abs( temperaturax - temperatura_)) > 5) {
                    ls.setCalidad_temperatura(-2);

                    cs.saveAndFlush(ls);
                }


                if (ls.getPm10() > 800) {
                   ls.setCalidad_pm10(-1);

                   cs.saveAndFlush(ls);
                }
                 if (ls.getPm25() > 800) {
                    ls.setCalidad_pm25(-1);

                    cs.saveAndFlush(ls);
                }
                if (ls.getPm1() > 500) {
                    ls.setCalidad_pm1(-1);

                    cs.saveAndFlush(ls);
                }
                //-------------------
                if (ls.getPm10() < 0 ) {
                    ls.setCalidad_pm10(-2);

                    cs.saveAndFlush(ls);
                }
                if (ls.getPm25() < 0) {
                    ls.setCalidad_pm25(-2);

                    cs.saveAndFlush(ls);
                }
                if (ls.getPm1() < 0) {
                    ls.setCalidad_pm1(-2);

                    cs.saveAndFlush(ls);
                }
                //-------------------
                if (ls.getTemperatura() > 35) {
                    ls.setCalidad_temperatura(-1);

                    cs.saveAndFlush(ls);
                }
                if (ls.getTemperatura() < -10) {
                    ls.setCalidad_temperatura(-1);

                    cs.saveAndFlush(ls);
                }
            }
        }

        return "Ejecucion proceso dia hoy";
    }

}
