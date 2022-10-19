package mintrabajo.dashboard.model;


public class Resumen {

        Integer PROCESO_PK;
        String TERRITORIAL_REPARTO;
    String PROCESO_NAT_INVESTIGACION;
    String QUERELLADOS;
    String QUERELLANTES;
    String ORGANIGRAMA_NOMBRE_REPARTO ;
    
    public Resumen() {}

	public Integer getPROCESO_PK() {
		return PROCESO_PK;
	}

	public void setPROCESO_PK(Integer pROCESO_PK) {
		PROCESO_PK = pROCESO_PK;
	}

	public String getTERRITORIAL_REPARTO() {
		return TERRITORIAL_REPARTO;
	}

	public void setTERRITORIAL_REPARTO(String tERRITORIAL_REPARTO) {
		TERRITORIAL_REPARTO = tERRITORIAL_REPARTO;
	}

	public String getPROCESO_NAT_INVESTIGACION() {
		return PROCESO_NAT_INVESTIGACION;
	}

	public void setPROCESO_NAT_INVESTIGACION(String pROCESO_NAT_INVESTIGACION) {
		PROCESO_NAT_INVESTIGACION = pROCESO_NAT_INVESTIGACION;
	}

	public String getQUERELLADOS() {
		return QUERELLADOS;
	}

	public void setQUERELLADOS(String qUERELLADOS) {
		QUERELLADOS = qUERELLADOS;
	}

	public String getQUERELLANTES() {
		return QUERELLANTES;
	}

	public void setQUERELLANTES(String qUERELLANTES) {
		QUERELLANTES = qUERELLANTES;
	}

	public String getORGANIGRAMA_NOMBRE_REPARTO() {
		return ORGANIGRAMA_NOMBRE_REPARTO;
	}

	public void setORGANIGRAMA_NOMBRE_REPARTO(String oRGANIGRAMA_NOMBRE_REPARTO) {
		ORGANIGRAMA_NOMBRE_REPARTO = oRGANIGRAMA_NOMBRE_REPARTO;
	}
    
    
}
