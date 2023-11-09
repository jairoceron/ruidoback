package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.SectorReportadoPqrs;
import cimab.openaq.repository.ruido.RdoTipopredioRepository;
import cimab.openaq.repository.ruido.SectorReportadoPqrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SectorReportadoPqrsService {

    private SectorReportadoPqrsRepository srr;

    @Autowired
    public void setSrr(SectorReportadoPqrsRepository srr) {
        this.srr = srr;
    }

    public List<SectorReportadoPqrs> listSectorReportado() {
        return srr.listSectorReportado();
       // 6666666666666666
    }
}
