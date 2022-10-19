package cimab.openaq.dataTransferObject;

import java.util.List;
import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class VariableSesionI {
    String username ;
    List<String > modulo;
    List<String > menu;
}
