package cimab.openaq.repository.rmcaboracle;

import cimab.openaq.entity.rmcaboracle.AllTabsColumns;
import cimab.openaq.entity.rmcaboracle.AllTabsColumnsPK;
import cimab.openaq.entity.ruido.Estadotramite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AllTabsColumnsRepository extends JpaRepository<AllTabsColumns, AllTabsColumnsPK> {

    @Query(value = "select * from ALL_TAB_COLS",
            nativeQuery = true)
    List<AllTabsColumns> listAllTabsColumns();

    @Query(value = " SELECT * FROM ALL_TAB_COLS WHERE table_name = :tableName AND owner = 'RMCAB'",
            nativeQuery = true)
    List<AllTabsColumns> listAllTabsColumnsByTable(String tableName);

}
