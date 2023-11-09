package cimab.openaq.repository.etiqoracle;

import cimab.openaq.entity.etiqoracle.Propietariovehiculo;
import cimab.openaq.entity.etiquetado.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface PropietariovehiculoRepository extends JpaRepository<Propietariovehiculo, BigInteger> {

    @Query(value = "select * from eva_propvehi a ORDER BY placa ",
            nativeQuery = true)
    List<Propietariovehiculo> listPropietariosVehiculos();

    @Query(value = "SELECT eva_propvehi_seq.nextval FROM dual",
            nativeQuery = true)
    BigInteger valorSecuenciaPropVehiculo();

    @Query(value = "select * from eva_propvehi e where e.placa = :placa ",
    nativeQuery = true)
    Propietariovehiculo propietariosVehiculos(String placa);



}
