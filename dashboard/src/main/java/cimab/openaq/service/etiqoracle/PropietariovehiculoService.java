package cimab.openaq.service.etiqoracle;


import cimab.openaq.constantes.ConstantesEtiquetado;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiqoracle.Propietariovehiculo;
import cimab.openaq.repository.etiqoracle.InformacionvehiculoRepository;
import cimab.openaq.repository.etiqoracle.PropietariovehiculoRepository;
import cimab.openaq.service.etiqoracle.util.UtilPropietarioVehiculo;
import cimab.openaq.service.etiquetado.QR_code.QRCodeService;
import cimab.openaq.service.etiquetado.fileXML.MetadataArchPDF;
import cimab.openaq.service.etiquetado.fileXML.UtilFileXml;
import cimab.openaq.service.etiquetado.generarPDF.PdfEtiquetadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
@Service
public class PropietariovehiculoService {

    @Value("${sda.etiquetado.xsl.file}")
    private String xslFile;

    @Value("${sda.etiquetado.xslHolog.file}")
    private String xslFileHologram;

    @Value("${sda.etiquetado.xml.dirHolograma}")
    private String dirHologramaXml;

    @Value("${sda.etiquetado.chart.directory}")
    private String dirQrHolograma;


    @Value("${sda.etiquetado.xml.directory}")
    private String xmlDirectory;

    @Value("${sda.etiquetado.chart.directory}")
    private String charDirectory;


    @Value("${sda.etiquetado.pdf.directory}")
    private String pdfDirectory;

    @Value("${sda.etiquetado.pathAssets.directory}")
    private String pathAssets;

    @Value("${spring.datasource.driver-class-name}")
    private String leerAnotaciones;

    private PropietariovehiculoRepository vr;
    private InformacionvehiculoRepository ir;
    private InformacionvehiculoService is;

    @Autowired
    public void setIs(InformacionvehiculoService is) {
        this.is = is;
    }

    @Autowired
    public void setVr(PropietariovehiculoRepository vr) {
        this.vr = vr;
    }

    @Autowired
    public void setIr(InformacionvehiculoRepository ir) {
        this.ir = ir;
    }

    private PdfEtiquetadoService pes;
    @Autowired
    public void setPes(PdfEtiquetadoService pes) {
        this.pes = pes;
    }

    public MetadataArchPDF listPropietarioVehiculo(String placa) {
        // List<Propietariovehiculo> listPropVehiculo =  vr.listPropietariosVehiculos();
        File xsltFile = new File(xslFile);

        pes.generarPDFbyte(placa, xsltFile, pdfDirectory ,xmlDirectory );
        MetadataArchPDF metadataArchPDF = new MetadataArchPDF();
        metadataArchPDF.setDescripcion("");
        metadataArchPDF.setPath(pdfDirectory+ "etiquetado"  + placa  + ".pdf");
        metadataArchPDF.setNameFile("etiquetado"  + placa  + ".pdf");
        metadataArchPDF.setPathAssets(pathAssets+ "etiquetado"  + placa  + ".pdf");
 // ************
        return metadataArchPDF;
    }

    public Propietariovehiculo guardaPropVehiculo(Propietariovehiculo propietarioVehiculo) {


        UtilPropietarioVehiculo upv = new UtilPropietarioVehiculo();
        upv.normalizarPropVehiculo(propietarioVehiculo);
        String placa = propietarioVehiculo.getPlaca();
        Propietariovehiculo propietaVehiculoX = vr.propietariosVehiculos(placa);

        Informacionvehiculo infVehiculo = ir.informacionvehiculo(placa);

        if (infVehiculo == null) {
            is.gInfoVeh(ConstantesEtiquetado.informacionvehiculoDefault(placa));
        }

        if (propietaVehiculoX == null) {
            System.out.println("NO .... Encontró el propietario del vehiculo ..... ");
            BigInteger idPropVehiculo = vr.valorSecuenciaPropVehiculo();
            propietarioVehiculo.setIdevapropvehi(idPropVehiculo);
        } else {
            System.out.println("Encontró el propietario del vehiculo ..... ");
            BigInteger idProVehicu = propietaVehiculoX.getIdevapropvehi();
            propietarioVehiculo.setIdevapropvehi(idProVehicu);
        }
        System.out.println(" Propietario Vehiculo " + propietarioVehiculo);
        System.out.println(" placa " + placa);

        vr.saveAndFlush(propietarioVehiculo);
        return propietarioVehiculo;
    }

    public List<Propietariovehiculo> listaaPropietarioVehiculooo(String placa) {
        List<Propietariovehiculo> listPropVehiculo =  vr.listPropietariosVehiculos();
        return listPropVehiculo;
    }

    public String generarEtiquetadPrinterHolograma (String placa) {

        // ---- paso 1 : generar el codigo qr

            UtilFileXml utilFileXml = new UtilFileXml();
            String fileXmlName = "" + placa + ".xml";
            QRCodeService qrCodeService = new QRCodeService();  // genera la imagen QR code
            qrCodeService.generateCode(dirQrHolograma, placa);  // genera la imagen wiht qr image

        // ---- paso 2 : generar el archivo XML <holograma><placa>AAA000</placa><pathimageqr></pathimageqr></holograma>

            utilFileXml.createNewFile(dirHologramaXml,fileXmlName,placa,dirQrHolograma);

        // ----- paso 3: generar el archifo PDF

        File xsltFile = new File(xslFileHologram);

        pes.generarPDFbyte(placa, xsltFile,pdfDirectory, dirHologramaXml  );


        return "archvio generado";
    }

}
