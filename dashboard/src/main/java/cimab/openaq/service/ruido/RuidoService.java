package cimab.openaq.service.ruido;
import cimab.openaq.repository.rmcab.MenuRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RuidoService {

    private VisitaRepository vr;
    private MenuRepository mr;

    @Autowired
    public void setVr(VisitaRepository vr) {
        this.vr = vr;
    }

    @Autowired
    public void setVr(MenuRepository mr) {
        this.mr = mr;
    }


    public List<String> listFuncionariosRuido() {

        // System.out.println("SErvicio de ruido .... ");
        List<String> listFRuid = vr.listFuncionariosRuido();
        System.out.println("SErvicio de ruido .... " + listFRuid);
        return listFRuid;
    }

    public List<String> listGeneraMenu(String usuario) {

        // System.out.println("SErvicio de ruido .... ");

        List<String> listMenu = mr.listMenuModulo( usuario);
        System.out.println("SErvicio de ruido .... " + listMenu);
        return listMenu;
    }



}
