package cimab.openaq.service.etiquetado;

import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import cimab.openaq.repository.etiquetado.ClasevehiculoRepository;
import cimab.openaq.repository.etiquetado.TipocombustibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipocombustibleService {

    private TipocombustibleRepository vr;

    @Autowired
    public void setVr(TipocombustibleRepository vr) {
        this.vr = vr;
    }

    public List<Tipocombustible> listTipoCombustible(int idclasevehiculo) {

        List<Tipocombustible> listTipoCombustible = new ArrayList<>();
        Tipocombustible tipoCombustible = new Tipocombustible();
        tipoCombustible.setNombre("Gasolina");
        listTipoCombustible.add(tipoCombustible);


        tipoCombustible = new Tipocombustible();
        tipoCombustible.setNombre("Gas");
        listTipoCombustible.add(tipoCombustible);


        tipoCombustible = new Tipocombustible();
        tipoCombustible.setNombre("Eléctrico");
        listTipoCombustible.add(tipoCombustible);

        tipoCombustible = new Tipocombustible();
        tipoCombustible.setNombre("Híbrido");
        listTipoCombustible.add(tipoCombustible);

        return listTipoCombustible;


        //return vr.listTipoCombustible(idclasevehiculo);
    }

}
