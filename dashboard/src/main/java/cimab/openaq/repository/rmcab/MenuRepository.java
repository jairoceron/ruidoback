package cimab.openaq.repository.rmcab;

import cimab.openaq.entity.rmcab.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(value = "select * from menu ",
            nativeQuery = true)
    List<String> listFuncionariosRuido();


    @Query(value = "select menu from menu where modulo= :modulo and perfil = :perfil ",
            nativeQuery = true)
    List<String> listMenu(String modulo, String perfil);


    @Query(value = "select m.enlace from menu m, modulousuario mu " +
    " where m.modulo = mu.modulo " +
    " and mu.usuario = :usuario",
            nativeQuery = true)
    List<String> listMenuModulo(String usuario);
//************


}
