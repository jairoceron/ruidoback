package cimab.openaq.repository.etiqoracle;

import org.hibernate.annotations.GenericGenerator;
import cimab.openaq.entity.etiqoracle.PqrsOracle;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
@Repository
public interface  PqrsOracleRepository  extends JpaRepository<PqrsOracle, Date> {

} 
