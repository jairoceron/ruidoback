package cimab.openaq.controller.etiquetado;
import cimab.openaq.entity.etiquetado.Marca;
import cimab.openaq.entity.etiquetado.Tiposervicio;
import cimab.openaq.service.etiquetado.MarcaService;
import cimab.openaq.service.etiquetado.TiposervicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class MarcaController {
    private MarcaService ts;

    @Autowired
    public void setTs(MarcaService ts) {
        this.ts = ts;
    }

    @RequestMapping({"/listMarca"})
    public List<Marca> listMarca(@RequestBody Integer idclasevehiculo) {

        List<Marca> listMarca = ts.listMarca(idclasevehiculo);
        // 66666666666666666666666

        Marca marca = new Marca();


        marca.setNombre("CHEVROLET");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("BAJAJ");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("KIA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("RENAULT");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("MAZDA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("NISSAN");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("TOYOTA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("FORD");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("HYUNDAI");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("HONDA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("AKT");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("YAMAHA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("SIGMA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("SUZUKI");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("DODGE");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("CHERY");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("MERCEDES BENZ");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("TVS");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("VOLKSWAGEN");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("MITSUBISHI");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("KTM");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("JEEP - WILLYS");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("UM");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("AUDI");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("DFSK");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("CHANGAN");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("DAEWOO");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("FIAT");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("CHANGHE");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("FOTON");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("BYD");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("GREAT WALL");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("JMC");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("YAMAHA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("JIAN CHANGHE");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("SKODA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("SSANGYONG");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("CAN-AM");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("JINCHENG");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("SIMCA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("ZOTYE");
        listMarca.add(marca);


        marca = new Marca();
        marca.setNombre("MAHINDRA");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("APE");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("INTERNATIONAL");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("LINTEX");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("BAIC");
        listMarca.add(marca);

        marca = new Marca();
        marca.setNombre("DAIHATSU");
        listMarca.add(marca);


        return listMarca;

    }
}
