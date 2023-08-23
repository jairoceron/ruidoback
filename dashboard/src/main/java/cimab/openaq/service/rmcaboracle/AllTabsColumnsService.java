package cimab.openaq.service.rmcaboracle;
import cimab.openaq.entity.rmcaboracle.AllTabsColumns;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.rmcaboracle.AllTabsColumnsRepository;
import cimab.openaq.repository.ruido.EstadotramiteRepository;
import cimab.openaq.repository.ruido.PqrsRepository;
import cimab.openaq.service.oracle.entity.UtilEntity;
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

    public List<AllTabsColumns> listAllTabsColumns(String tableName) {
        List<AllTabsColumns> listAllTabsColumns = vr.listAllTabsColumnsByTable(tableName);

        System.out.println("tableName :::. " + tableName );
        System.out.println("listAllTabsColumns :::. " + listAllTabsColumns );

        UtilEntity utilEntity = new UtilEntity();
        utilEntity.createEntity(listAllTabsColumns, tableName);  // Crea la entidad
        utilEntity.createRepository(tableName);  // Crea el respository
        utilEntity.createService(tableName);  // Crea el service

        return listAllTabsColumns;
    }


}
