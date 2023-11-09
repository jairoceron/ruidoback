package cimab.openaq.repository.etiqoracle;


import cimab.openaq.entity.etiqoracle.AllTabsColumns;
import cimab.openaq.entity.etiqoracle.AllTabsColumnsPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


import org.springframework.stereotype.Repository;
@Repository
public interface AllTabsColumnsRepository extends JpaRepository<AllTabsColumns, AllTabsColumnsPK> {

    @Query(value = "select * from ALL_TAB_COLS",
            nativeQuery = true)
    List<AllTabsColumns> listAllTabsColumns();

    @Query(value = "SELECT * FROM ALL_TAB_COLS WHERE table_name = :tableName AND owner = 'RMCAB'",
            nativeQuery = true)
    List<AllTabsColumns> listAllTabsColumnsByTable(String tableName);

    // WHERE table_name = :tableName AND INSTR(QUALIFIED_COL_NAME,'SHAPE', 1, 1) < 1
    @Query(value = "SELECT * FROM ALL_TAB_COLS WHERE table_name = 'PQRS' ",
            nativeQuery = true)
    List<AllTabsColumns> listAllTabsColumnsRuido();  // String tableName



    @Query(value = "SELECT column_name FROM all_cons_columns WHERE constraint_name in " +
            "( SELECT constraint_name FROM all_constraints WHERE" +
            " UPPER(table_name) = UPPER(:tableName) AND CONSTRAINT_TYPE = 'P' )" +
            " GROUP BY column_name",
            nativeQuery = true)
    List<String> llavePrimaria(String tableName);

}
