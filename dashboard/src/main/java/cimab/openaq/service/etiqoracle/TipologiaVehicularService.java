package cimab.openaq.service.etiqoracle;

import cimab.openaq.entity.etiqoracle.TipologiaVehicular;
import cimab.openaq.repository.etiqoracle.TipologiaVehicularRepository;
import cimab.openaq.service.etiquetado.generarPDF.PdfEtiquetadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipologiaVehicularService {
    private TipologiaVehicularRepository pes;
    @Autowired
    public void setPes(TipologiaVehicularRepository pes) {
        this.pes = pes;
    }


    public List<TipologiaVehicular> listTipologiaVehicular() {
        List<TipologiaVehicular> listTipoVehicular = pes.listTipologiaVehicular();
        return listTipoVehicular;
    }
}
