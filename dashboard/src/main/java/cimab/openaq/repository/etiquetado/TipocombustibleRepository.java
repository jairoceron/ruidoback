package cimab.openaq.repository.etiquetado;

import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.rmcab.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import cimab.openaq.entity.rmcab.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface TipocombustibleRepository  extends JpaRepository<Tipocombustible, Long> {

    @Query(value = "select * from sda_e_tipocombustib where idclasevehiculo = :idclasevehiculo ",
            nativeQuery = true)
    List<Tipocombustible> listTipoCombustible(int idclasevehiculo );

}
