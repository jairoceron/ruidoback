package cimab.openaq.model;
import lombok.Data;

@Data
public class JsonSDA {
    private String stanombre;
    private String stadireccion;
    private String stacode;
    private String stalongitud;
    private String stalatitud;
    private String variable;
    private String moncode;
    private String unidad;
    private String fechainicio;
    private String fechafin;
    private String fechamodificacion;
    private String concentracion;
    private String msflcode;
    private String monMonitorstate;
    private String staActive;
    private String tp;
    private String fn;
    private String h24;

}
