package cimab.openaq.service.rmcaboracle;

import org.hibernate.annotations.GenericGenerator;
import cimab.openaq.entity.rmcaboracle.S006T10;
import cimab.openaq.repository.rmcaboracle.S006T10Repository;
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
import cimab.openaq.repository.rmcaboracle.S006T10Repository;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

@Service
public class  S006T10Service {

    private S006T10Repository vr;
    @Autowired
    public void setVr(S006T10Repository vr) {
    this.vr = vr;
}
} 
