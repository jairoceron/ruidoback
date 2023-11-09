package cimab.openaq.service.etiqoracle;

import org.hibernate.annotations.GenericGenerator;
import cimab.openaq.entity.etiqoracle.PqrsOracle;
import cimab.openaq.repository.etiqoracle.PqrsOracleRepository;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Id;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cimab.openaq.repository.etiqoracle.PqrsOracleRepository;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

@Service
public class  PqrsOracleService {

    private PqrsOracleRepository vr;

    @Autowired
    public void setVr(PqrsOracleRepository vr) {
    this.vr = vr;
}
} 
