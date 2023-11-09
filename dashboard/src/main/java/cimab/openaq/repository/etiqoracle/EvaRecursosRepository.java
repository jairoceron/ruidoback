package cimab.openaq.repository.etiqoracle;

import cimab.openaq.entity.etiqoracle.EvaRecursos;
import cimab.openaq.entity.etiqoracle.EvaRecursosKey;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface EvaRecursosRepository extends JpaRepository<EvaRecursos, EvaRecursosKey> {

    @Query(value = "select * from eva_recursos e  ",
            nativeQuery = true)
    List<EvaRecursos> listInformacionvehiculo();


    @Query(value = "select * from EVA_RESOURCES e WHERE clave = :clave AND sistemaoperativo = :sistemaOperativo  ",
            nativeQuery = true)
    EvaRecursos consultaClaveRecurso(String clave, String sistemaOperativo);
}
