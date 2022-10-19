package mintrabajo.dashboard.helper;

import java.util.ArrayList;
import java.util.List;

import mintrabajo.dashboard.model.dto.ListDTO;
import mintrabajo.dashboard.model.dto.ValoresDTO;

public class ListHelper {
	
	public static List<ListDTO> getUserStatusList() {
		List<ListDTO> ret = new ArrayList<>();
		ret.add(new ListDTO("A","Activo"));
		ret.add(new ListDTO("I","Inactivo"));
		return ret;
	}
	
	public static List<ListDTO> getFlowList(){
		List<ListDTO> ret = new ArrayList<>();
		ret.add(new ListDTO("0","Todas"));
		ret.add(new ListDTO("3218","Averiguación Prelimiar"));
		ret.add(new ListDTO("3245","Procedimiento Adminitrativo Sancionatorio"));
		ret.add(new ListDTO("15691","Renuencia"));
		ret.add(new ListDTO("15735","Función preventiva"));
		return ret;
	}
	public static List<ListDTO> getDtsFromObj(List<Object[]> obj){
		List<ListDTO> dt = new ArrayList<>();
		Object[] data;
		for(int i = 0; i < obj.size(); i++) {
			data = obj.get(i);
			dt.add(new ListDTO(data[0].toString(), data[1].toString(), data.length > 2 ? data[2].toString() : null));
		}
		return dt;
	}
	
	public static List<ValoresDTO> getValoresDTOFromObj(List<Object[]> obj){
		List<ValoresDTO> dt = new ArrayList<>();
		Object[] data;
		for(int i = 0; i < obj.size(); i++) {
			data = obj.get(i);
			dt.add(new ValoresDTO(Integer.parseInt(data[0].toString()), data[1].toString()));
		}
		return dt;
	}
	
	

}
