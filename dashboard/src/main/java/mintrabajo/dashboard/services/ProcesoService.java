package mintrabajo.dashboard.services;

import mintrabajo.dashboard.model.Sancion;
import mintrabajo.dashboard.repository.ProcesoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@Service
public class ProcesoService {


     private ProcesoRepository pr;

     @Autowired
     public void setPr(ProcesoRepository pr) {
          this.pr = pr;
     }
     
     

     public void operacion(String date_from, String date_to) {
         List<Object[]> liObj = pr.calificacionGenSample(101022);

         for (int i=0; i<liObj.size(); i++) {
              Object[] obj = liObj.get(i);

         }
     }

    public void consSancion(String date_from, String date_to) {
        List<Object[]> liObj = pr.consSancion();

        for (int i=0; i<liObj.size(); i++) {
            Object[] obj = liObj.get(i);

        }
    }

    public void fechaReparto(String date_from, String date_to) {
        List<Object[]> liObj = pr.fechaReparto();

        for (int i=0; i<liObj.size(); i++) {
            Object[] obj = liObj.get(i);

        }
    }
    
   

    public List<Sancion>  totalSancionDt (Integer numMeses ) {
        List<Object[]> listSancion = pr.totalSancionDt(numMeses);
        return cargaMatriz(listSancion);
    }

    public List<Sancion>  estProcesoDt(Integer idFlujoPk, String estado, Integer numMeses  ){
        List<Object[]> listEstProceso = pr.estProcesoDt(idFlujoPk, estado, numMeses);
        return cargaMatrizEstProceso(listEstProceso);
    }

    private List<Sancion> cargaMatriz(List<Object[]> listObjSancion) {
        List<Sancion> listSancion = new ArrayList<>();
        for (int i=0; i<listObjSancion.size(); i++) {
            Object[] obj = listObjSancion.get(i);
            Sancion sancion = new Sancion();
            String nombreDirTerrit =  (String)obj[0];
            String estadoProceso =  (String)obj[1];
            BigDecimal totalSancion = (BigDecimal)obj[2];
            BigDecimal cantidad = (BigDecimal)obj[3];
            sancion.setCantidad(cantidad.intValue());
            sancion.setNombreDirTerritorial(nombreDirTerrit);
            sancion.setEstadoProceso(estadoProceso);
            if (totalSancion != null) {
                sancion.setValorSanciones(totalSancion.doubleValue());
            }
            listSancion.add(sancion);
        }
        return listSancion;
    }

    private List<Sancion> cargaMatrizEstProceso(List<Object[]> listObjSancion) {
        List<Sancion> listSancion = new ArrayList<>();
        for (int i=0; i<listObjSancion.size(); i++) {
            Object[] obj = listObjSancion.get(i);
            Sancion sancion = new Sancion();
            String nombreDirTerrit =  (String)obj[0];

            BigDecimal totalSancion = (BigDecimal)obj[1];
            BigDecimal cantidad = (BigDecimal)obj[2];
            sancion.setCantidad(cantidad.intValue());
            sancion.setNombreDirTerritorial(nombreDirTerrit);

            if (totalSancion != null) {
                sancion.setValorSanciones(totalSancion.doubleValue());
            }
            listSancion.add(sancion);
        }
        return listSancion;
    }
}
