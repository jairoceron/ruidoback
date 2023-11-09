package cimab.openaq.service.etiqoracle;
import cimab.openaq.constantes.Constantes;


import cimab.openaq.entity.etiqoracle.AllTabsColumns;


import cimab.openaq.repository.etiqoracle.AllTabsColumnsRepository;

import cimab.openaq.util.UtilEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllTabsColumnsService {
    private AllTabsColumnsRepository vr;

    @Autowired
    public void setVr(AllTabsColumnsRepository vr) {
        this.vr = vr;
    }



    public List<AllTabsColumns> listAllTabsColumns(String tableName , String claseTable) {


        System.out.println("______________ " + tableName.toUpperCase());
        List<AllTabsColumns> listAllTabsColumns = vr.listAllTabsColumnsRuido(); // tableName.toUpperCase()
        List<String> listLlavePrimaria = vr.llavePrimaria(tableName);

        System.out.println("Si pasa por acá:  tableName :::. " + tableName );
        System.out.println("listAllTabsColumns :::. " + listAllTabsColumns );

        UtilEntity utilEntity = new UtilEntity();
        String paqueteEntity = Constantes.PACKG_ENTITY_SARA;
        String paqueteRepository = Constantes.PACKG_REPO_SARA;
        String paqueteService = "co.giunal.repository.sara";
        utilEntity.createEntity(listAllTabsColumns, tableName, claseTable, paqueteEntity,  listLlavePrimaria);  // Crea la entidad
        utilEntity.createRepository(tableName, claseTable, paqueteRepository );  // Crea el respository
        utilEntity.createService(tableName, claseTable, paqueteService, paqueteEntity);  // Crea el service

        return listAllTabsColumns;
    }

}
