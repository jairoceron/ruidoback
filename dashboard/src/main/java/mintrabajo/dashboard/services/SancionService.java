package mintrabajo.dashboard.services;

import mintrabajo.dashboard.model.*;
import mintrabajo.dashboard.model.dto.DateDTO;
import mintrabajo.dashboard.model.dto.ParametrosDTO;
import mintrabajo.dashboard.model.dto.ValoresDTO;
import mintrabajo.dashboard.repository.ProcesoRepository;
import mintrabajo.dashboard.repository.SancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SancionService {

    int ACTUAL = 0;   // actual
    int SEMANAL = 1;   // semanal
    int TRIMESTRAL = 2;   // 2 // cuatromeses
    int MENSUAL = 3;   /// = 3 mensual
    int SEMESTRAL = 4;   //= 4 bianual
    int ANUAL = 5;   //anual
    static final String Todas = "Todas";
    static final int TODAS_TERRITORIALES = 999999;

    static final String plant_consolid = "plant_consolid";
    static final String plant_sececono = "plant_sececono";
    static final String plant_interlab = "plant_interlab_sectorprior";
    static final String plant_sectprio = "plant_interlab_territorial";
    static final String plant_materia_criterio = "plant_materia_criterio";


    private SancionRepository sr;

    @Autowired
    public void setDr(SancionRepository sr) {
        this.sr = sr;
    }


    private DashboardService ds;

    @Autowired
    public void setDs(DashboardService ds) {
        this.ds = ds;
    }

    List<TotSancTerr> lEjeyNoEje = new ArrayList<>();
    List<TotSancActEcono> lEjeyNoEjeActEcono = new ArrayList<>();

    public List<ValoresDTO> listaTerritorial() {

        List<Object[]> listaTerrito = sr.listTerritorial();
        return cargaLista(listaTerrito);
    }

    public List<ValoresDTO> cargaLista(List<Object[]> listaTerrito) {
        List<ValoresDTO> listVDto = new ArrayList<>();
        for (int i = 0; i < listaTerrito.size(); i++) {
            Object[] obj = listaTerrito.get(i);
            ValoresDTO vDto = new ValoresDTO();
            BigDecimal primaryKey = (BigDecimal) obj[0];
            String nombre = (String) obj[1];
            vDto.setName(nombre);
            vDto.setValue(primaryKey.intValue());
            listVDto.add(vDto);
        }
        return listVDto;
    }

    private List<String[]> leerRangosFechas(List<DateDTO> ldate) {
        List listRanFech = new ArrayList();

        for (int a = ldate.size() - 1; a >= 0; a--) {
            DateDTO dateDto = ldate.get(a);

            java.util.Date fechaInicial = dateDto.getFrom();
            java.util.Date fechaFinal = dateDto.getTo();
            String fechaI = fechaConFormatoX(fechaInicial);
            String fechaF = fechaConFormatoX(fechaFinal);


            String[] ll = {fechaI, fechaF};
            listRanFech.add(ll);
        }
        return listRanFech;
    }


    private String fechaConFormatoX(Date fechaX) {
        String patronFecha = "yyyy/MM/dd";
        SimpleDateFormat dateFor = new SimpleDateFormat(patronFecha);
        return dateFor.format(fechaX);
    }

    private String labelPeriodicidadX(int periodicidad) {
        String labelPeriodicidad = "";
        if (periodicidad == ACTUAL) {
            labelPeriodicidad = "ACTUAL";
        }
        if (periodicidad == SEMANAL) {
            labelPeriodicidad = "SEMANAL";
        }

        if (periodicidad == TRIMESTRAL) {
            labelPeriodicidad = "TRIMESTRAL";
        }
        if (periodicidad == MENSUAL) {
            labelPeriodicidad = "MENSUAL";
        }
        if (periodicidad == SEMESTRAL) {
            labelPeriodicidad = "SEMESTRAL";
        }
        if (periodicidad == ANUAL) {
            labelPeriodicidad = "ANUAL";
        }
        return labelPeriodicidad;
    }

    private List<String[]> arregloFlechas(int periodicidad) {

        ParametrosDTO parametrosDTO = ds.generarParametrosDashboard();
        List<String[]> listRgFechas = null;
        String labelPeriodicidad = "";

        if (periodicidad == ACTUAL) {

            List<DateDTO> ldate = parametrosDTO.getActDate();
            listRgFechas = leerRangosFechas(ldate);
            labelPeriodicidad = "ACTUAL";
        }
        if (periodicidad == SEMANAL) {

            List<DateDTO> ldate = parametrosDTO.getWeekly();
            listRgFechas = leerRangosFechas(ldate);
            labelPeriodicidad = "SEMANAL";
        }

        if (periodicidad == TRIMESTRAL) {
            List<DateDTO> ldate = parametrosDTO.getQuarterly();
            listRgFechas = leerRangosFechas(ldate);
            labelPeriodicidad = "TRIMESTRAL";
        }
        if (periodicidad == MENSUAL) {
            List<DateDTO> ldate = parametrosDTO.getMonthly();
            listRgFechas = leerRangosFechas(ldate);
            labelPeriodicidad = "MENSUAL";
        }
        if (periodicidad == SEMESTRAL) {
            List<DateDTO> ldate = parametrosDTO.getBiannual();
            listRgFechas = leerRangosFechas(ldate);
            labelPeriodicidad = "SEMESTRAL";
        }
        if (periodicidad == ANUAL) {
            List<DateDTO> ldate = parametrosDTO.getYearly();
            listRgFechas = leerRangosFechas(ldate);
            labelPeriodicidad = "ANUAL";
        }
        return listRgFechas;
    }


    public List<ProcesosGrupo> procesosgrupo() {
        List<Object[]> listaProceGr = sr.procesosgrupo();
        return cargarProcesoGrupo(listaProceGr);


        // return null;
    }

    private List<ProcesosGrupo> cargarProcesoGrupo(List<Object[]> listaProceGr) {
        List<ProcesosGrupo> lg = new ArrayList<>();
        for (int m = 0; m < listaProceGr.size(); m++) {
            Object[] obj = listaProceGr.get(m);
            ProcesosGrupo procesosGrupo = new ProcesosGrupo();
            procesosGrupo.setTerritorial_reparto((String) obj[0]);
            procesosGrupo.setPivc(((BigDecimal) obj[1]).longValue());
            procesosGrupo.setRcc(((BigDecimal) obj[2]).longValue());
            procesosGrupo.setAct(((BigDecimal) obj[3]).longValue());
            procesosGrupo.setPivrcc(((BigDecimal) obj[4]).longValue());
            procesosGrupo.setRiesgoslab(((BigDecimal) obj[5]).longValue());
            procesosGrupo.setTodas(((BigDecimal) obj[6]).longValue());
            procesosGrupo.setInspecciones(((BigDecimal) obj[7]).longValue());
            lg.add(procesosGrupo);
        }

        return lg;
    }


    public List<SancionSectorEcono> cargaListaEjecutoriadoTot(List<Object[]> listaEjecuto, String label, String rangoFecha, int indicadorPeriodo) {
        List<SancionSectorEcono> listEjec = new ArrayList<SancionSectorEcono>();
        for (int i = 0; i < listaEjecuto.size(); i++) {
            Object[] obj = listaEjecuto.get(i);
            SancionSectorEcono sancionConsolidado = new SancionSectorEcono();
            BigDecimal numProcesosEje = (BigDecimal) obj[0];
            BigDecimal numProcesosNoEje = (BigDecimal) obj[1];
            BigDecimal sumaSancionEje = (BigDecimal) obj[2];
            BigDecimal sumaSancionNoEje = (BigDecimal) obj[3];

            sancionConsolidado.setLabel(label);
            sancionConsolidado.setRangoFecha(rangoFecha);
            sancionConsolidado.setIndicadorPeriodo(indicadorPeriodo);

            sancionConsolidado.setNumProcesosEjecu(numProcesosEje);
            sancionConsolidado.setTotalSancionEjecu(sumaSancionEje);
            sancionConsolidado.setNumProcesosNoEjecu(numProcesosNoEje);
            sancionConsolidado.setTotalSancionNoEjecu(sumaSancionNoEje);

            listEjec.add(sancionConsolidado);
        }

        return listEjec;
    }

    public List<SancionSectorEcono> cargaListaEjecuLabelTot(List<Object[]> listaEjecuto, String label, String rangoFecha, int indicadorPeriodo) {
        List<SancionSectorEcono> listEjec = new ArrayList<SancionSectorEcono>();
        for (int i = 0; i < listaEjecuto.size(); i++) {
            Object[] obj = listaEjecuto.get(i);
            SancionSectorEcono sancionConsolidado = new SancionSectorEcono();
            String labActivEcono = (String) obj[0];
            BigDecimal numProcesosEje = (BigDecimal) obj[1];
            BigDecimal numProcesosNoEje = (BigDecimal) obj[2];
            BigDecimal sumaSancionEje = (BigDecimal) obj[3];
            BigDecimal sumaSancionNoEje = (BigDecimal) obj[4];
            sancionConsolidado.setLabel(labActivEcono);
            sancionConsolidado.setRangoFecha(rangoFecha);
            sancionConsolidado.setIndicadorPeriodo(indicadorPeriodo);

            sancionConsolidado.setNumProcesosEjecu(numProcesosEje);
            sancionConsolidado.setNumProcesosNoEjecu(numProcesosNoEje);
            sancionConsolidado.setTotalSancionEjecu(sumaSancionEje);
            sancionConsolidado.setTotalSancionNoEjecu(sumaSancionNoEje);

            listEjec.add(sancionConsolidado);
        }

        return listEjec;
    }

    public List<SancionSectorEcono> consultaGeneral(int periodicidad, int parametro_territorial, String naturaleza, String estadoProceso, String plantilla) {
        List<String[]> arregFechas = arregloFlechas(periodicidad);

        List<SancionSectorEcono> listaEjecuT = new ArrayList<SancionSectorEcono>();
        String label = "............. ";
        for (int i = 0; i < arregFechas.size(); i++) {


            String[] lasFechas = arregFechas.get(i);
            String rangoFecha = lasFechas[0] + " a " + lasFechas[1];

            List<Object[]> listaObjEje = new ArrayList<>();
            List<SancionSectorEcono> listaEjePar = new ArrayList<SancionSectorEcono>();

            if (parametro_territorial == TODAS_TERRITORIALES && naturaleza.equals(Todas) && estadoProceso.equals(Todas)) {
                // 1)	1	1	1

                int territorial_inicial = 0;
                int territorial_final = TODAS_TERRITORIALES;
                String naturalezaX = "%%";
                String estadoProcesoX = "%%";


                listaEjePar = ejecutarPlantilla(lasFechas[0], lasFechas[1],
                        territorial_inicial, territorial_final, naturalezaX, estadoProcesoX, plantilla, label,
                        rangoFecha, i);


            }
            if (parametro_territorial == TODAS_TERRITORIALES && naturaleza.equals(Todas) && !estadoProceso.equals(Todas)) {
                // 2)	1	1	0

                int territorial_inicial = 0;
                int territorial_final = TODAS_TERRITORIALES;
                String naturalezaX = "%%";
                String estadoProcesoX = estadoProceso;

                listaEjePar = ejecutarPlantilla(lasFechas[0], lasFechas[1],
                        territorial_inicial, territorial_final, naturalezaX, estadoProcesoX, plantilla, label,
                        rangoFecha, i);

            }
            if (parametro_territorial == TODAS_TERRITORIALES && !naturaleza.equals(Todas) && estadoProceso.equals(Todas)) {
                //  3)	1	0	1

                int territorial_inicial = 0;
                int territorial_final = TODAS_TERRITORIALES;
                String naturalezaX = naturaleza;
                String estadoProcesoX = "%%";

                listaEjePar = ejecutarPlantilla(lasFechas[0], lasFechas[1],
                        territorial_inicial, territorial_final, naturalezaX, estadoProcesoX, plantilla, label,
                        rangoFecha, i);
            }
            if (parametro_territorial == TODAS_TERRITORIALES && !naturaleza.equals(Todas) && !estadoProceso.equals(Todas)) {
                // 4)	1	0	0

                int territorial_inicial = 0;
                int territorial_final = TODAS_TERRITORIALES;
                String naturalezaX = naturaleza;
                String estadoProcesoX = estadoProceso;

                listaEjePar = ejecutarPlantilla(lasFechas[0], lasFechas[1],
                        territorial_inicial, territorial_final, naturalezaX, estadoProcesoX, plantilla, label,
                        rangoFecha, i);
            }
            if (parametro_territorial != TODAS_TERRITORIALES && naturaleza.equals(Todas) && estadoProceso.equals(Todas)) {
                // 5)	0	1	1

                int territorial_inicial = parametro_territorial;
                int territorial_final = parametro_territorial;
                String naturalezaX = "%%";
                String estadoProcesoX = "%%";

                listaEjePar = ejecutarPlantilla(lasFechas[0], lasFechas[1],
                        territorial_inicial, territorial_final, naturalezaX, estadoProcesoX, plantilla, label,
                        rangoFecha, i);
            }

            if (parametro_territorial != TODAS_TERRITORIALES && naturaleza.equals(Todas) && !estadoProceso.equals(Todas)) {

                // 6	0	1	0

                int territorial_inicial = parametro_territorial;
                int territorial_final = parametro_territorial;
                String naturalezaX = "%%";
                String estadoProcesoX = estadoProceso;

                listaEjePar = ejecutarPlantilla(lasFechas[0], lasFechas[1],
                        territorial_inicial, territorial_final, naturalezaX, estadoProcesoX, plantilla, label,
                        rangoFecha, i);
            }
            if (parametro_territorial != TODAS_TERRITORIALES && !naturaleza.equals(Todas) && estadoProceso.equals(Todas)) {
                // 7	0	0	1
                int territorial_inicial = parametro_territorial;
                int territorial_final = parametro_territorial;
                String naturalezaX = naturaleza;
                String estadoProcesoX = "%%";

                listaEjePar = ejecutarPlantilla(lasFechas[0], lasFechas[1],
                        territorial_inicial, territorial_final, naturalezaX, estadoProcesoX, plantilla, label,
                        rangoFecha, i);
            }

            if (parametro_territorial != TODAS_TERRITORIALES && !naturaleza.equals(Todas) && !estadoProceso.equals(Todas)) {
                // 8)	0	0	0

                int territorial_inicial = parametro_territorial;
                int territorial_final = parametro_territorial;
                String naturalezaX = naturaleza;
                String estadoProcesoX = "%%";

                listaEjePar = ejecutarPlantilla(lasFechas[0], lasFechas[1],
                        territorial_inicial, territorial_final, naturalezaX, estadoProcesoX, plantilla, label,
                        rangoFecha, i);
            }

            listaEjecuT.addAll(listaEjePar);

        }
        return listaEjecuT;

    }

    private List<SancionSectorEcono> ejecutarPlantilla(String fechaInicial, String fechaFinal, int territorial_inicial,
                                                       int territorial_final, String naturalezaX, String estadoProcesoX,
                                                       String plantilla, String label,
                                                       String rangoFecha, int i) {


        List<Object[]> listaObjEje = new ArrayList<>();
        List<SancionSectorEcono> listaEjecu = new ArrayList<SancionSectorEcono>();

        if (plantilla.equals(plant_consolid)) {
            listaObjEje = sr.eje_lista_plant_consolid(fechaInicial, fechaFinal,
                    territorial_inicial, territorial_final, naturalezaX, estadoProcesoX);

            listaEjecu = cargaListaEjecutoriadoTot(listaObjEje, label, rangoFecha, i);
        }

        if (plantilla.equals(plant_sececono)) {
            listaObjEje = sr.eje_lista_plant_sececono_terr_natu(fechaInicial, fechaFinal,
                    territorial_inicial, territorial_final, naturalezaX, estadoProcesoX);

            listaEjecu = cargaListaEjecuLabelTot(listaObjEje, label, rangoFecha, i);
        }

        if (plantilla.equals(plant_interlab)) {
            listaObjEje = sr.eje_lista_sector_critico(fechaInicial, fechaFinal,
                    territorial_inicial, territorial_final, naturalezaX, estadoProcesoX);

            listaEjecu = cargaListaEjecuLabelTot(listaObjEje, label, rangoFecha, i);
        }

        if (plantilla.equals(plant_sectprio)) {
            listaObjEje = sr.eje_lista_plant_sececono_prioritario(fechaInicial, fechaFinal,
                    territorial_inicial, territorial_final, naturalezaX, estadoProcesoX);

            listaEjecu = cargaListaEjecuLabelTot(listaObjEje, label, rangoFecha, i);
        }

        if (plantilla.equals(plant_materia_criterio)) {
            listaObjEje = sr.eje_lista_plant_sececono_terr_natu(fechaInicial, fechaFinal,
                    territorial_inicial, territorial_final, naturalezaX, estadoProcesoX);

            listaEjecu = cargaListaEjecuLabelTot(listaObjEje, label, rangoFecha, i);
        }
        return listaEjecu;
    }

}
