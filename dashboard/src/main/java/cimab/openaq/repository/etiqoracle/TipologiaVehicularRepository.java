package cimab.openaq.repository.etiqoracle;

import cimab.openaq.entity.etiqoracle.Propietariovehiculo;
import cimab.openaq.entity.etiqoracle.TipologiaVehicular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface  TipologiaVehicularRepository extends JpaRepository<TipologiaVehicular, Integer> {

    @Query(value = "SELECT * FROM TipologiaVehicular ORDER BY idTipologiaVehicular ",
            nativeQuery = true)
    List<TipologiaVehicular> listTipologiaVehicular();
}
