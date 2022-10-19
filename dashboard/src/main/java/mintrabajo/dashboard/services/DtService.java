package mintrabajo.dashboard.services;

import mintrabajo.dashboard.model.*;
import mintrabajo.dashboard.repository.DtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DtService {


    private DtRepository dr;

    @Autowired
    public void setDr(DtRepository dr) {
        this.dr = dr;
    }

    private void  consultaXEtapaProcesalOtraDT(DashboardX dashboard, EtapaProcesal etapaProcesal) {


        dashboard.setDirTerritorial("OTRAS DT");

        dashboard.setEtapaProcesal(etapaProcesal.getNombreEtapa());  //  AP AVERIGUACIÓN PRELIMINAR 3218
        // 3218 : flujo_pk tabla : IVC_FLUJO  ::: 3218  AVERIGUACIÓN PRELIMINAR

        // 3218 : Averiguación Preliminar



        List<Object[]> listActBogota =  dr.activosFinalizadosOtraDt(etapaProcesal.getIdEtapaPro());
        Estado estadoAcFin = new Estado();
        int total = 0;
        for (int i=0; i<listActBogota.size(); i++) {
            Object[] objEstado = listActBogota.get(i);
            String estActFina = (String)objEstado[0];
            BigDecimal totEst = (BigDecimal)objEstado[1];
            if (estActFina.equals("ACTIVO")) {
                estadoAcFin.setActivos(totEst.intValue());
                total = total + totEst.intValue();
            }
            if (estActFina.equals("FINALIZADO")) {
                estadoAcFin.setFinalizados(totEst.intValue());
                total = total + totEst.intValue();
            }
        }
        estadoAcFin.setTotal(total);
        dashboard.setEstado(estadoAcFin);

        //------- inicia naturaleza
        List<Object[]> listNatuBogota =  dr.naturalezaOtraDt(etapaProcesal.getIdEtapaPro());
        Naturaleza naturaleza = new Naturaleza();
        int totalNat = 0;
        for (int i=0; i<listNatuBogota.size(); i++) {
            Object[] objEstado = listNatuBogota.get(i);
            String natural = (String)objEstado[0];
            BigDecimal totNatu = (BigDecimal)objEstado[1];
            if (natural.equals("NORMAS LABORALES")) {
                naturaleza.setNormLabor(totNatu.intValue());
                totalNat = totalNat +totNatu.intValue();
            }
            if (natural.equals("RIESGOS LABORALES")) {
                naturaleza.setRiesLabor(totNatu.intValue());
                totalNat = totalNat + totNatu.intValue();
            }
        }
        dashboard.setNaturaleza(naturaleza);

        // ------ termina naturaleza

        // ------ INICIA GRUPO IVC
        int grupoIvc = dr.grupoIVC(etapaProcesal.getIdEtapaPro());
        int grupoIvc_RCC = dr.grupoIVC_RCC(etapaProcesal.getIdEtapaPro());
        Grupo grupo = new Grupo();
        grupo.setIvc(grupoIvc);
        grupo.setRcc(grupoIvc_RCC);
        grupo.setDespacho(0);
        dashboard.setGrupo(grupo);

        // ------ FIN GRUPO IVC

        // inicia vencimiento 7 30 y 90 dias.
        int venci7Dias = dr.porVencerNumDiasOtraDt(etapaProcesal.getIdEtapaPro(),7);
        int venci30Dias = dr.porVencerNumDiasOtraDt(etapaProcesal.getIdEtapaPro(),30);
        int venci90Dias = dr.porVencerNumDiasOtraDt(etapaProcesal.getIdEtapaPro(),90);
        Expvencer expvencer = new Expvencer();

        expvencer.setUnasemana(venci7Dias);
        expvencer.setTresmeses(venci90Dias);
        expvencer.setUnmes(venci30Dias);
        dashboard.setExpvencer(expvencer);
        // fin vencimientos a 7 30 y 90 dias.

    }


    public void descargaExcelX(List<Resumen> listResumen, Integer idFlujoPk, String dirTerrit, String fechaCorte) {

        List<Object[]> listActBogota;


        if (dirTerrit.equals("Otras DT")) {
            listActBogota = dr.descargaExcelOtraDt(idFlujoPk, fechaCorte);
        } else {
            listActBogota = dr.descargaExcelBogota( idFlujoPk, fechaCorte);
        }

        for (int a=0; a<listActBogota.size(); a++) {
            Resumen resumen= new Resumen();
            Object[] obj = listActBogota.get(a);
            BigDecimal PROCESO_PK = (BigDecimal)obj[0];
            resumen.setPROCESO_PK(PROCESO_PK.intValue());
            String TERRITORIAL_REPARTO= (String)obj[1];
            resumen.setTERRITORIAL_REPARTO(TERRITORIAL_REPARTO);
            String PROCESO_NAT_INVESTIGACION= (String)obj[2];
            resumen.setPROCESO_NAT_INVESTIGACION(PROCESO_NAT_INVESTIGACION);
            String QUERELLADOS= (String)obj[3];
            resumen.setQUERELLADOS(QUERELLADOS);
            String QUERELLANTES= (String)obj[4];
            resumen.setQUERELLANTES(QUERELLANTES);
            String ORGANIGRAMA_NOMBRE_REPARTO= (String)obj[5];
            resumen.setORGANIGRAMA_NOMBRE_REPARTO(ORGANIGRAMA_NOMBRE_REPARTO);
            listResumen.add(resumen);
        }

    }

    public void  consultaXEtapaProcesal(DashboardX dashboard, Integer idFlujoPk, String dirTerrit, String fechaCorte) {

        List<Object[]> listActBogota;
   //     dirTerrit = "'" + dirTerrit + "'";
     //   fechaCorte= "'" + fechaCorte + "'";



        if (dirTerrit.equals("Otras DT")) {
             listActBogota = dr.activosEstadoPrDTerrOtras( idFlujoPk, fechaCorte);
        } else {
             listActBogota = dr.activosEstadoPrDTerr(dirTerrit, idFlujoPk, fechaCorte);
        }
        Estado estadoAcFin = new Estado();
        int total = 0;
        for (int i=0; i<listActBogota.size(); i++) {
            Object[] objEstado = listActBogota.get(i);
            String estActFina = (String)objEstado[0];
            BigDecimal totEst = (BigDecimal)objEstado[1];
            if (estActFina.equals("ACTIVO")) {
                estadoAcFin.setActivos(totEst.intValue());
                total = total + totEst.intValue();
            }
            if (estActFina.equals("FINALIZADO")) {
                estadoAcFin.setFinalizados(totEst.intValue());
                total = total + totEst.intValue();
            }
        }
        estadoAcFin.setTotal(total);
        dashboard.setEstado(estadoAcFin);

        //------- inicia naturaleza
        List<Object[]> listNatuBogota ;
        if (dirTerrit.equals("Otras DT")) {
             listNatuBogota = dr.naturalezaOtrasDtGen( idFlujoPk, fechaCorte);
        } else {
            listNatuBogota = dr.naturalezaBogotaGen(dirTerrit, idFlujoPk, fechaCorte);
        }
        Naturaleza naturaleza = new Naturaleza();
        int totalNat = 0;
        for (int i=0; i<listNatuBogota.size(); i++) {
            Object[] objEstado = listNatuBogota.get(i);
            String natural = (String)objEstado[0];
            BigDecimal totNatu = (BigDecimal)objEstado[1];
            if (natural.equals("NORMAS LABORALES")) {
                naturaleza.setNormLabor(totNatu.intValue());
                totalNat = totalNat +totNatu.intValue();
            }
            if (natural.equals("RIESGOS LABORALES")) {
                naturaleza.setRiesLabor(totNatu.intValue());
                totalNat = totalNat + totNatu.intValue();
            }
        }
        dashboard.setNaturaleza(naturaleza);

        // ------ termina naturaleza

        // ------ INICIA GRUPO IVC
        int grupoIvc = dr.grupoIVCGen( idFlujoPk, fechaCorte);
        int grupoIvc_RCC = dr.grupoIVC_RCCGen( idFlujoPk, fechaCorte);
        Grupo grupo = new Grupo();
        grupo.setIvc(grupoIvc);
        grupo.setRcc(grupoIvc_RCC);
        grupo.setDespacho(0);
        dashboard.setGrupo(grupo);

        // ------ FIN GRUPO IVC

        // inicia vencimiento 7 30 y 90 dias.
        int venci7Dias = dr.porVencerNumDias(idFlujoPk,7);
        int venci30Dias = dr.porVencerNumDias(idFlujoPk,30);
        int venci90Dias = dr.porVencerNumDias(idFlujoPk,90);
        Expvencer expvencer = new Expvencer();

        expvencer.setUnasemana(venci7Dias);
        expvencer.setTresmeses(venci90Dias);
        expvencer.setUnmes(venci30Dias);
        dashboard.setExpvencer(expvencer);


        // fin vencimientos a 7 30 y 90 dias.


    }

    private void  consultaXEtapaProcesalX(DashboardX dashboard, EtapaProcesal etapaProcesal) {


        dashboard.setDirTerritorial("TERRITORIAL DE BOGOTA");



        dashboard.setEtapaProcesal(etapaProcesal.getNombreEtapa());  //  AP AVERIGUACIÓN PRELIMINAR 3218
        // 3218 : flujo_pk tabla : IVC_FLUJO  ::: 3218  AVERIGUACIÓN PRELIMINAR

        // 3218 : Averiguación Preliminar



        List<Object[]> listActBogota =  dr.activosFinalizadosBogota(etapaProcesal.getIdEtapaPro());
        Estado estadoAcFin = new Estado();
        int total = 0;
        for (int i=0; i<listActBogota.size(); i++) {
            Object[] objEstado = listActBogota.get(i);
            String estActFina = (String)objEstado[0];
            BigDecimal totEst = (BigDecimal)objEstado[1];
            if (estActFina.equals("ACTIVO")) {
                estadoAcFin.setActivos(totEst.intValue());
                total = total + totEst.intValue();
            }
            if (estActFina.equals("FINALIZADO")) {
                estadoAcFin.setFinalizados(totEst.intValue());
                total = total + totEst.intValue();
            }
        }
        estadoAcFin.setTotal(total);
        dashboard.setEstado(estadoAcFin);

        //------- inicia naturaleza
        List<Object[]> listNatuBogota =  dr.naturalezaBogota(etapaProcesal.getIdEtapaPro());
        Naturaleza naturaleza = new Naturaleza();
        int totalNat = 0;
        for (int i=0; i<listNatuBogota.size(); i++) {
            Object[] objEstado = listNatuBogota.get(i);
            String natural = (String)objEstado[0];
            BigDecimal totNatu = (BigDecimal)objEstado[1];
            if (natural.equals("NORMAS LABORALES")) {
                naturaleza.setNormLabor(totNatu.intValue());
                totalNat = totalNat +totNatu.intValue();
            }
            if (natural.equals("RIESGOS LABORALES")) {
                naturaleza.setRiesLabor(totNatu.intValue());
                totalNat = totalNat + totNatu.intValue();
            }
        }
        dashboard.setNaturaleza(naturaleza);

        // ------ termina naturaleza

        // ------ INICIA GRUPO IVC
        int grupoIvc = dr.grupoIVC(etapaProcesal.getIdEtapaPro());
        int grupoIvc_RCC = dr.grupoIVC_RCC(etapaProcesal.getIdEtapaPro());
        Grupo grupo = new Grupo();
        grupo.setIvc(grupoIvc);
        grupo.setRcc(grupoIvc_RCC);
        grupo.setDespacho(0);
        dashboard.setGrupo(grupo);

        // ------ FIN GRUPO IVC

        // inicia vencimiento 7 30 y 90 dias.
        int venci7Dias = dr.porVencerNumDias(etapaProcesal.getIdEtapaPro(),7);
        int venci30Dias = dr.porVencerNumDias(etapaProcesal.getIdEtapaPro(),30);
        int venci90Dias = dr.porVencerNumDias(etapaProcesal.getIdEtapaPro(),90);
        Expvencer expvencer = new Expvencer();

        expvencer.setUnasemana(venci7Dias);
        expvencer.setTresmeses(venci90Dias);
        expvencer.setUnmes(venci30Dias);
        dashboard.setExpvencer(expvencer);
        // fin vencimientos a 7 30 y 90 dias.

    }


    public List<Resumen> descargaExcel(Integer idFlujoPk, String dirTerrit, String fechaCorte  ){
       List<Resumen> listRes = new ArrayList<>();
        descargaExcelX(listRes, idFlujoPk,  dirTerrit,  fechaCorte);
        return listRes;
    }

    public DashboardX estProcesoGeneral(Integer idFlujoPk, String dirTerrit, String fechaCorte  ){
        DashboardX dashboard = new DashboardX();
        consultaXEtapaProcesal(dashboard, idFlujoPk, dirTerrit, fechaCorte);

        return dashboard;
    }

    public List<DashboardX> estProcesoGeneralX(Integer idFlujoPk, String dirTerrit, String fechaCorte  ){

        List<DashboardX> listEstProceso = new ArrayList();



        List<EtapaProcesal> ltEtaProc = new ArrayList();

        EtapaProcesal eAverPrel = new EtapaProcesal();
        eAverPrel.setIdEtapaPro(3218);
        eAverPrel.setNombreEtapa("AVERIGUACIÓN PRELIMINAR");
        ltEtaProc.add(eAverPrel);

        EtapaProcesal eAdmSanci = new EtapaProcesal();
        eAdmSanci.setIdEtapaPro(3245);
        eAdmSanci.setNombreEtapa("PROCEDIMIENTO ADMINISTRATIVO SANCIONATORIO");
        ltEtaProc.add(eAdmSanci);

        EtapaProcesal eRenuencia = new EtapaProcesal();
        eRenuencia.setIdEtapaPro(15691);
        eRenuencia.setNombreEtapa("RENUENCIA");
        ltEtaProc.add(eRenuencia);


//


        for (int i = 0; i < ltEtaProc.size(); i++) {
            EtapaProcesal etapaProcesal = ltEtaProc.get(i);

            DashboardX dashboard = new DashboardX();
          //  consultaXEtapaProcesal(dashboard, 1, "" , "");
            listEstProceso.add(dashboard);

            DashboardX dashboardx = new DashboardX();
            consultaXEtapaProcesalOtraDT(dashboardx, etapaProcesal);
            listEstProceso.add(dashboardx);
        }



        // List<Object[]> listEstProceso = pr.estProcesoDtGen(idFlujoPk, estado, "numMeses");
        return listEstProceso;
    }


}
