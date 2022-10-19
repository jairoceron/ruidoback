package cimab.openaq.repository.etiquetado;

import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface CilindradaRepository extends JpaRepository<Cilindrada, Long> {

    @Query(value = "select * from sda_e_cilindrada ",
            nativeQuery = true)
    List<Cilindrada> listCilindradaX();

    @Query(value = "select * from sda_e_cilindrada where idclasevehiculo = :idclasevehiculo ",
            nativeQuery = true)
    List<Cilindrada> listCilindrada(int idclasevehiculo );

}
