package cimab.openaq.service.etiquetado.fileXML;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetadataArchPDF {
    String path;
    String nameFile;
    String descripcion;
    String pathAssets;
}
