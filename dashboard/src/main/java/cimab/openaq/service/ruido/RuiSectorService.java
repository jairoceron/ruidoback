package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.entity.ruido.RuidoSector;
import cimab.openaq.repository.rmcab.MenuRepository;
import cimab.openaq.repository.ruido.RuiSectorRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuiSectorService {

    List<RuiSector> listSector = new ArrayList<>();
    List<RuidoSector> listRuidoSector = new ArrayList<>();
    private RuiSectorRepository rr;

    @Autowired
    public void setRr(RuiSectorRepository rr) {
        this.rr = rr;
    }

    public List<RuiSector> consultaSector() {

        return inicializarConsultaSector();


        // return rr.listSector();
    }

    public List<RuidoSector> consultaRuidoSector() {

        return inicializarConsultaRuidoSector();


        // return rr.listSector();
    }

    public List<RuiSector> inicializarConsultaSector() {

        RuiSector sector = new RuiSector();

        sector.setIdSector(1);
        sector.setNombre("COMERCIAL");
        listSector.add(sector);

        sector = new RuiSector();
        sector.setIdSector(2);
        sector.setNombre("NO REPORTA/NO APLICA");
        listSector.add(sector);

        sector = new RuiSector();
        sector.setIdSector(3);
        sector.setNombre("NO REPORTA / NO APLICA");
        listSector.add(sector);

        sector = new RuiSector();
        sector.setIdSector(4);
        sector.setNombre("SERVICIOS");
        listSector.add(sector);

        sector = new RuiSector();
        sector.setIdSector(5);
        sector.setNombre("EVENTOS");
        listSector.add(sector);

        sector = new RuiSector();
        sector.setIdSector(6);
        sector.setNombre("RESIDENCIAL");
        listSector.add(sector);

        sector = new RuiSector();
        sector.setIdSector(7);
        sector.setNombre("#N/D");
        listSector.add(sector);

        sector = new RuiSector();
        sector.setIdSector(8);
        sector.setNombre("INDUSTRIAL");
        listSector.add(sector);
        return listSector;
    }


    public List<RuidoSector> inicializarConsultaRuidoSector() {
        listRuidoSector = new ArrayList<>();
        RuidoSector sector = new RuidoSector();

        sector.setValue("COMERCIAL");
        sector.setViewValue("COMERCIAL");
        listRuidoSector.add(sector);

        sector = new RuidoSector();
        sector.setValue("NO REPORTA/NO APLICA");
        sector.setViewValue("NO REPORTA/NO APLICA");
        listRuidoSector.add(sector);

        sector = new RuidoSector();
        sector.setViewValue("NO REPORTA / NO APLICA");
        sector.setValue("NO REPORTA / NO APLICA");
        listRuidoSector.add(sector);

        sector = new RuidoSector();
        sector.setValue("SERVICIOS");
        sector.setViewValue("SERVICIOS");
        listRuidoSector.add(sector);

        sector = new RuidoSector();
        sector.setValue("EVENTOS");
        sector.setViewValue("EVENTOS");
        listRuidoSector.add(sector);

        sector = new RuidoSector();
        sector.setValue("RESIDENCIAL");
        sector.setViewValue("RESIDENCIAL");
        listRuidoSector.add(sector);

        sector = new RuidoSector();
        sector.setValue("#N/D");
        sector.setViewValue("#N/D");
        listRuidoSector.add(sector);

        sector = new RuidoSector();
        sector.setValue("INDUSTRIAL");
        sector.setViewValue("INDUSTRIAL");
        listRuidoSector.add(sector);
        return  listRuidoSector;
    }
}
