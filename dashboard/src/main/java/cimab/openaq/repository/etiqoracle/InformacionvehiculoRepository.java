package cimab.openaq.repository.etiqoracle;

import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiqoracle.Propietariovehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface  InformacionvehiculoRepository extends JpaRepository<Informacionvehiculo, BigInteger> {

    @Query(value = "select * from eva_infovehic e ORDER BY IDEVAINFOVEHIC DESC ",
            nativeQuery = true)
    List<Informacionvehiculo> listInformacionvehiculo();

    @Query(value = "SELECT eva_propvehi_seq.nextval FROM dual",
            nativeQuery = true)
    BigInteger valorSecuenciaPropVehiculo();

    @Query(value = "SELECT eva_infovehic_seq.nextval FROM dual",
            nativeQuery = true)
    BigInteger valorSecuenciaInfoVehiculo();

    @Query(value = "select * from eva_infovehic e where e.placa = :placa ",
            nativeQuery = true)
    Informacionvehiculo informacionvehiculo(String placa);

}