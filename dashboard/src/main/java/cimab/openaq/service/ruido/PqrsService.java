package cimab.openaq.service.ruido;


import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.repository.ruido.PqrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PqrsService {

    private PqrsRepository pr;

    @Autowired
    public void setPr(PqrsRepository pr) {
        this.pr = pr;
    }

    public List<Pqrs> consultaPqrs() {
        return pr.listPqrs();
    }

}
