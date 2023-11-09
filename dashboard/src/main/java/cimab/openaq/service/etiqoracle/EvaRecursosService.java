package cimab.openaq.service.etiqoracle;

/* *
    autor: jairoceron@gmail.com   20231024

 */

import cimab.openaq.entity.etiqoracle.EvaRecursos;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiqoracle.Propietariovehiculo;
import cimab.openaq.entity.etiqoracle.dto.Placa;
import cimab.openaq.repository.etiqoracle.EvaRecursosRepository;
import cimab.openaq.repository.etiqoracle.InformacionvehiculoRepository;
import cimab.openaq.repository.etiqoracle.PropietariovehiculoRepository;
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
public class EvaRecursosService {
    private EvaRecursosRepository vr;

    @Autowired
    public void setVr(EvaRecursosRepository vr) {
        this.vr = vr;
    }


    public EvaRecursos recuperaClave(String clave) {
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        if (osName.startsWith("Windows")) {
            osName = "Windows";
        }
        if (osName.startsWith("Linux")) {
            osName = "Linux";
        }
        EvaRecursos eResources = vr.consultaClaveRecurso( clave, osName );
        return eResources;
    }


}
