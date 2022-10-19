package mintrabajo.dashboard.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import mintrabajo.dashboard.helper.DataHelper;
import mintrabajo.dashboard.model.ProcesosGrupo;
import mintrabajo.dashboard.repository.ProcesosGrupoRepository;

@Service
public class ProcesoGrupoService {
	private ProcesosGrupoRepository pr;

	@Autowired
	public void setPr(ProcesosGrupoRepository pr) {
		this.pr = pr;
	}
	
	
	@Cacheable(value = "procesosGrupDTO", key="#key")
	public List<ProcesosGrupo>  procesosGrupDTO(Long idDt,Date from, Date to, String key) {

		List<ProcesosGrupo> listaGrupos;
		//todos
		if(idDt == 0L ) {
			listaGrupos = DataHelper.getProcesoGrupoFromObj(pr.procesosgrupo(from, to));
		}else {
			listaGrupos = DataHelper.getProcesoGrupoFromObj(pr.procesosgrupo(from, to, idDt));
		}
		return listaGrupos;
	}

}
