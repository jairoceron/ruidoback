package cimab.openaq.service.etiquetado;

import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.etiquetado.Estandaremision;
import cimab.openaq.repository.etiquetado.CilindradaRepository;
import cimab.openaq.repository.etiquetado.ClasevehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CilindradaService {
    private CilindradaRepository vr;

    @Autowired
    public void setVr(CilindradaRepository vr) {
        this.vr = vr;
    }

    public List<Cilindrada> listCilindrada(int idclasevehiculo) {

        List<Cilindrada> listCilind = new ArrayList<>();

        Cilindrada cil = new Cilindrada();
        cil.setNombre("900 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("1200 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("1300 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("1500 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("1600 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("1800 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("2000 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("2200 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("2600 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("2800 C.C.");
        listCilind.add(cil);

        cil = new Cilindrada();
        cil.setNombre("3000 C.C.");
        listCilind.add(cil);

        return listCilind;

        // 999999999999999999999999
        // return vr.listCilindrada(idclasevehiculo);
    }
}
