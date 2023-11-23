package cimab.openaq.service.etiqoracle;


import cimab.openaq.constantes.ConstantesEtiquetado;
import cimab.openaq.entity.etiqoracle.EvaRecursos;
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

import static cimab.openaq.constantes.ConstantesEtiquetado.QRHOLOGRAMAETIQUETA;
import static cimab.openaq.constantes.ConstantesEtiquetado.REPORTEGENETIQUETAD;

@Service
public class PropietariovehiculoService {

  //  @Value("${sda.etiquetado.xsl.file}")
 //   private String xslFile;

  //  @Value("${sda.etiquetado.xslHolog.file}")
  //  private String xslFileHologram;

  //  @Value("${sda.etiquetado.xml.dirHolograma}")
   // private String dirHologramaXml;

 //   @Value("${sda.etiquetado.chart.directory}")
 //   private String dirQrHolograma;


 //   @Value("${sda.etiquetado.xml.directory}")
 //   private String xmlDirectory;

 //   @Value("${sda.etiquetado.chart.directory}")
 //   private String charDirectory;


 //   @Value("${sda.etiquetado.pdf.directory}")
 //   private String pdfDirectory;

    @Value("${sda.etiquetado.pathAssets.directory}")
    private String pathAssets;

 //   @Value("${spring.datasource.driver-class-name}")
 //   private String leerAnotaciones;

    private PropietariovehiculoRepository vr;
    private InformacionvehiculoRepository ir;
    private InformacionvehiculoService is;

    private EvaRecursosService ers;

    @Autowired
    public void setErs(EvaRecursosService ers) {
        this.ers = ers;
    }

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


        EvaRecursos eRecursos = ers.recuperaClave("sda.etiquetado.xsl.file");
        File xsltFile = new File(eRecursos.getValor());


        EvaRecursos dirQHolog = ers.recuperaClave("sda.etiquetado.chart.directory");
        EvaRecursos xmlDirect = ers.recuperaClave("sda.etiquetado.xml.directory");

        EvaRecursos pdfDirector = ers.recuperaClave("sda.etiquetado.pdf.directory");



        pes.generarPDFbyte(placa, xsltFile, pdfDirector.getValor() ,xmlDirect.getValor(), REPORTEGENETIQUETAD, dirQHolog.getValor() );
        MetadataArchPDF metadataArchPDF = new MetadataArchPDF();
        metadataArchPDF.setDescripcion("");
        metadataArchPDF.setPath(pdfDirector.getValor() + "etiquetado"  + placa  + ".pdf");
        metadataArchPDF.setNameFile("etiquetado"  + placa  + ".pdf");
        metadataArchPDF.setPathAssets(pathAssets+ "etiquetado"  + placa  + ".pdf");
 // ************
        return metadataArchPDF;
    }

    public Propietariovehiculo PropietariovehiculoXplaca (String placa) {

        Propietariovehiculo propietaVehiculoX = vr.propietariosVehiculos(placa);
        return propietaVehiculoX;
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

            BigInteger idPropVehiculo = vr.valorSecuenciaPropVehiculo();
            propietarioVehiculo.setIdevapropvehi(idPropVehiculo);
        } else {

            BigInteger idProVehicu = propietaVehiculoX.getIdevapropvehi();
            propietarioVehiculo.setIdevapropvehi(idProVehicu);
        }


        vr.saveAndFlush(propietarioVehiculo);
        return propietarioVehiculo;
    }

    public List<Propietariovehiculo> listaaPropietarioVehiculooo(String placa) {
        List<Propietariovehiculo> listPropVehiculo =  vr.listPropietariosVehiculos();

        return listPropVehiculo;
    }

    public MetadataArchPDF generarEtiquetadPrinterHolograma (String placa) {



        EvaRecursos eResour = ers.recuperaClave("sda.etiquetado.xml.dirHolograma");


        // ---- paso 1 : generar el codigo qr

            UtilFileXml utilFileXml = new UtilFileXml();

            String fileXmlName = "" + placa + ".xml";

            QRCodeService qrCodeService = new QRCodeService();  // genera la imagen QR code




            qrCodeService.generateCode(eResour.getValor(), placa);  // genera la imagen wiht qr image


            utilFileXml.createNewFile(eResour.getValor(),fileXmlName,placa,eResour.getValor());



        EvaRecursos eResource = ers.recuperaClave("sda.etiquetado.xslHolog.file");
        File xsltFile = new File(eResource.getValor());


        EvaRecursos pdfDir = ers.recuperaClave("sda.etiquetado.pdf.directory");

        pes.generarPDFbyte(placa, xsltFile,pdfDir.getValor(), eResour.getValor(), QRHOLOGRAMAETIQUETA, eResour.getValor()  );


        MetadataArchPDF metadataArchPDF = new MetadataArchPDF();
        metadataArchPDF.setDescripcion("PDF etiqueta con Holograma");
        metadataArchPDF.setPath(pdfDir.getValor()+ "holograma"  + placa  + ".pdf");
        metadataArchPDF.setNameFile("holograma"  + placa  + ".pdf");
        metadataArchPDF.setPathAssets(pathAssets+ "holograma"  + placa  + ".pdf");

        return metadataArchPDF;
    }

}
