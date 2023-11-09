package cimab.openaq.service.etiqoracle;

import org.hibernate.annotations.GenericGenerator;
import cimab.openaq.entity.etiqoracle.VisitasOracle;
import cimab.openaq.repository.etiqoracle.VisitasOracleRepository;
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
import cimab.openaq.repository.etiqoracle.VisitasOracleRepository;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

@Service
public class  VisitasOracleService {

    private VisitasOracleRepository vr;

    @Autowired
    public void setVr(VisitasOracleRepository vr) {
    this.vr = vr;
}
} 
