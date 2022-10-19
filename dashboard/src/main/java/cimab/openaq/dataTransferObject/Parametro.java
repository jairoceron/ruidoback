package cimab.openaq.dataTransferObject;

import lombok.Data;

@Data
public class Parametro {

    int clave;
    String valor;

    public Parametro (int clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }
}
