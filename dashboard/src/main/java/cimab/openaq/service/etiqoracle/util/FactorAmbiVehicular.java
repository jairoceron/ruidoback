package cimab.openaq.service.etiqoracle.util;

import cimab.openaq.entity.etiqoracle.EvaEtiquetado;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.repository.etiqoracle.EvaEtiquetadoRepository;
import cimab.openaq.repository.etiqoracle.InformacionvehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FactorAmbiVehicular {

    private InformacionvehiculoRepository vr ;
    private EvaEtiquetadoRepository eer;

    @Autowired
    public void setVr(InformacionvehiculoRepository vr) {
        this.vr = vr;
    }

    @Autowired
    public void setEer(EvaEtiquetadoRepository eer) {
        this.eer = eer;
    }

    public EvaEtiquetado calculoFactosAmbiVehicular(Informacionvehiculo infoVehiculo) {

        System.out.println("infoVehiculo.getClaseVehiculo()  " + infoVehiculo.getClaseVehiculo());
        System.out.println("infoVehiculo.getModelo()  " + infoVehiculo.getModelo()  );
        System.out.println("infoVehiculo.getCilindraje()  " + infoVehiculo.getCilindraje()  );


        String claseVehiculo = infoVehiculo.getClaseVehiculo().toUpperCase();
        String combustible = infoVehiculo.getTipoCombustible().toUpperCase();
        System.out.println("combustible  /" + combustible + "/"  );

        List<EvaEtiquetado> listEvaEtique =  eer.listInformacionvehiculoGrado6(combustible);

        if (listEvaEtique.size() > 0) {
            System.out.println("Entra a Grado6 " ) ;
            System.out.println("entra aqui :: " + listEvaEtique + " __> " + listEvaEtique.get(0) + " tamaño :: " + listEvaEtique.size()  );
            return listEvaEtique.get(0);
        }


        listEvaEtique =  eer.listInformacionvehiculoGrado5(claseVehiculo,
                combustible,
                infoVehiculo.getModelo(), infoVehiculo.getCilindraje());

        if (listEvaEtique.size() > 0) {
            System.out.println("Entra a Grado5 " ) ;
            return listEvaEtique.get(0);
        }



         listEvaEtique =  eer.listInformacionvehiculoGrado4(claseVehiculo,
                infoVehiculo.getModelo(), infoVehiculo.getCilindraje());

        if (listEvaEtique != null) {
            if (listEvaEtique.size() > 0) {
                System.out.println("Entra a Grado4 " ) ;
                return listEvaEtique.get(0);
            } else {
                 listEvaEtique =  eer.listInformacionvehiculoGrado3(claseVehiculo,
                        infoVehiculo.getModelo());
                if (listEvaEtique.size() > 0) {
                    System.out.println("Entra a Grado3 " ) ;
                    return listEvaEtique.get(0);
                } else {
                    listEvaEtique =  eer.listInformacionvehiculoGrado2(claseVehiculo);
                    if (listEvaEtique.size() > 0) {
                       // return listEvaEtique.get(0);
                    }

                }
            }
        }

        return null;

    }
}
