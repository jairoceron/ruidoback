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
        // List<Propietariovehiculo> listPropVehiculo =  vr.listPropietariosVehiculos();

        //hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh

        EvaRecursos eRecursos = ers.recuperaClave("sda.etiquetado.xsl.file");
        File xsltFile = new File(eRecursos.getValor());

      //  666666666666666666666666666666666666
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
        System.out.println("Esta es la placa del propietario del vehiculo " + placa);
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
        System.out.println(listPropVehiculo);
        return listPropVehiculo;
    }

    public MetadataArchPDF generarEtiquetadPrinterHolograma (String placa) {



        EvaRecursos eResour = ers.recuperaClave("sda.etiquetado.xml.dirHolograma");


        // ---- paso 1 : generar el codigo qr
            System.out.println("generarEtiquetadPrinterHolograma :: paso 1a ");
            UtilFileXml utilFileXml = new UtilFileXml();
        System.out.println("generarEtiquetadPrinterHolograma :: paso 2a ");
            String fileXmlName = "" + placa + ".xml";
        System.out.println("generarEtiquetadPrinterHolograma :: paso 3a ");
            QRCodeService qrCodeService = new QRCodeService();  // genera la imagen QR code
        System.out.println("generarEtiquetadPrinterHolograma :: paso 4a ");



            qrCodeService.generateCode(eResour.getValor(), placa);  // genera la imagen wiht qr image
        System.out.println("generarEtiquetadPrinterHolograma :: paso 5a ");



        // ---- paso 2 : generar el archivo XML <holograma><placa>AAA000</placa><pathimageqr></pathimageqr></holograma>

        // evs.333333333333333333333333333333333


            utilFileXml.createNewFile(eResour.getValor(),fileXmlName,placa,eResour.getValor());
        System.out.println("generarEtiquetadPrinterHolograma :: paso 6a ");
        // ----- paso 3: generar el archifo PDF



        EvaRecursos eResource = ers.recuperaClave("sda.etiquetado.xslHolog.file");
        File xsltFile = new File(eResource.getValor());


        EvaRecursos pdfDir = ers.recuperaClave("sda.etiquetado.pdf.directory");
//-----------------
        // System.out.println("generarEtiquetadPrinterHolograma :: paso 7a ");
        pes.generarPDFbyte(placa, xsltFile,pdfDir.getValor(), eResour.getValor(), QRHOLOGRAMAETIQUETA, eResour.getValor()  );
        System.out.println("generarEtiquetadPrinterHolograma :: paso 8a ");

        MetadataArchPDF metadataArchPDF = new MetadataArchPDF();
        metadataArchPDF.setDescripcion("PDF etiqueta con Holograma");
        metadataArchPDF.setPath(pdfDir.getValor()+ "holograma"  + placa  + ".pdf");
        metadataArchPDF.setNameFile("holograma"  + placa  + ".pdf");
        metadataArchPDF.setPathAssets(pathAssets+ "holograma"  + placa  + ".pdf");

        return metadataArchPDF;
    }

}
