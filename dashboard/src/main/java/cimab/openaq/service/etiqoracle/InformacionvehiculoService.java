package cimab.openaq.service.etiqoracle;

/* *
    autor: jairoceron@gmail.com   20230820

 */

import cimab.openaq.entity.etiqoracle.EvaEtiquetado;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiqoracle.Propietariovehiculo;
import cimab.openaq.entity.etiqoracle.dto.Placa;
import cimab.openaq.repository.etiqoracle.InformacionvehiculoRepository;
import cimab.openaq.repository.etiqoracle.PropietariovehiculoRepository;
import cimab.openaq.service.etiqoracle.util.FactorAmbiVehicular;
import cimab.openaq.service.etiqoracle.util.UtilInfoVehiculo;
import cimab.openaq.service.etiqoracle.util.UtilPropietarioVehiculo;
import cimab.openaq.service.etiquetado.generarPDF.PdfEtiquetadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
@Service
public class InformacionvehiculoService {

    private InformacionvehiculoRepository vr;
    private PropietariovehiculoRepository pr;

    private FactorAmbiVehicular fav;

    @Autowired
    public void setFav(FactorAmbiVehicular fav) {
        this.fav = fav;
    }

    @Autowired
    public void setVr(InformacionvehiculoRepository vr) {
        this.vr = vr;
    }

    @Autowired
    public void setPr(PropietariovehiculoRepository pr) {
        this.pr = pr;
    }


    /*
    * guardaInformacionVehiculo

    * */
    public Informacionvehiculo gInfoVeh(Informacionvehiculo informacionvehiculo) {

        UtilInfoVehiculo utilInfoVehiculo = new UtilInfoVehiculo();
        utilInfoVehiculo.normalizarInfoVehiculo(informacionvehiculo);

        String placa = informacionvehiculo.getPlaca();

       // System.out.println("InformacionVehiculo ::: " + informacionvehiculo);

        Informacionvehiculo informacionvehiculoX = vr.informacionvehiculo(placa);
        if (informacionvehiculoX == null) {
            BigInteger idevainfovehic =  vr.valorSecuenciaInfoVehiculo();
            informacionvehiculo.setIdevainfovehic(idevainfovehic);
        } else {
            BigInteger idInfoVe = informacionvehiculoX.getIdevainfovehic();
            informacionvehiculo.setIdevainfovehic(idInfoVe);
        }
//        System.out.println("HIzo el agua :: " + informacionvehiculo);


        EvaEtiquetado factorAmbiVehicular = fav.calculoFactosAmbiVehicular(informacionvehiculo);
        // Se actualiza el color de la etiqueta::: FactorVehicularAmbiental  " +  factorAmbiVehicular;
        if (factorAmbiVehicular != null) {
            informacionvehiculo.setColor_ETIQUETA(factorAmbiVehicular.getEtiquetado());
        }
        vr.saveAndFlush(informacionvehiculo);

        return informacionvehiculo;
    }

    public Placa consultaObjetoPlaca(String placaStr) {

        Placa placa = new Placa();
        Informacionvehiculo informacionvehiculo = vr.informacionvehiculo(placaStr);
        if (informacionvehiculo == null) {
            informacionvehiculo = new Informacionvehiculo();

        }
        Propietariovehiculo propietariovehiculo =  pr.propietariosVehiculos(placaStr);
        if (propietariovehiculo == null) {
            propietariovehiculo = new Propietariovehiculo();
        }

        placa.setPlaca(placaStr);
        placa.setInformacionvehiculo(informacionvehiculo);
        placa.setPropietariovehiculo(propietariovehiculo);
        return placa;
    }

    public List<Informacionvehiculo> listInformacionVehiculo(Informacionvehiculo informacionvehiculo) {
        return vr.listInformacionvehiculo();
    }
}
