package cimab.openaq.repository.rmcab;

import cimab.openaq.entity.rmcab.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.entity.rmcab.Variableambiental_rmcab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface   ModulousuarioRepository extends JpaRepository<Modulousuario, ModuloUsuarioPK> {

    @Query(value = "select * " +
            " from modulousuario", nativeQuery = true)
    List<Modulousuario> listModuloUsuario();

    @Query(value = "select m.* from usuario u, modulousuario m where u.usuario = m.usuario and u.usuario = :usuarioX", nativeQuery = true)
    List<Modulousuario> listModuloUsu(String usuarioX);
}


