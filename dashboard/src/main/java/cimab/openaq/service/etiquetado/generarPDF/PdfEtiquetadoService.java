package cimab.openaq.service.etiquetado.generarPDF;

import cimab.openaq.repository.etiquetado.CategoriaRepository;
import cimab.openaq.service.etiquetado.QR_code.QRCodeService;
import cimab.openaq.service.etiquetado.fileXML.UtilFileXml;
import lombok.Data;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


@Data
@Service
public class PdfEtiquetadoService {





   // private QRCodeService vr;

   // @Autowired
   // public void setVr(QRCodeService vr) {
   //     this.vr = vr;
   // }

    public byte[] generarPDFbyte(String placa,
                                 File xsltFile,
                                 String rutaPdfFile,
                                 String rutaXmlFile
                                 ) {




        String nombreArchivoPdf = rutaPdfFile + "etiquetado"  + placa  + ".pdf";
        String xmlFile = rutaXmlFile + placa + ".xml";

        System.out.println("Placa        : " + placa );
        System.out.println("rutaPdfFile  : " + rutaPdfFile );
        System.out.println("rutaXmlFile  : " + rutaXmlFile );


        UtilFileXml uFileXml = new UtilFileXml();
        String dirQrHolograma = "http://ambientebogota.gov.co/{" + placa + "}/inicio";
        uFileXml.xmlGenCreate(rutaXmlFile,placa + ".xml",placa,dirQrHolograma);

        byte[] flujoDatos = null;
        try {
            long inicio = System.currentTimeMillis();
            // File xsltFile = new File(xslFile);
            //Archivo XML que proveerá de datos
            StreamSource xmlSource = new StreamSource(new File(xmlFile));
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            OutputStream out;

            out = new FileOutputStream(nombreArchivoPdf);
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
            javax.xml.transform.Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(xmlSource, res);
            out.close();
            flujoDatos = flujoDatosPdfByte(nombreArchivoPdf);

            long fin = System.currentTimeMillis();
            //  long duracion = fin - inicio;

        } catch (Exception e) {
            System.out.println(".... generarPDFbyte  ");
            e.printStackTrace();
        }
        return flujoDatos;
    }

    public byte[] flujoDatosPdfByte(String archivoPDF) {

        byte[] encodedFile = null;
        try {
            encodedFile = Base64.encodeBase64(FileUtils.readFileToByteArray(new File(archivoPDF)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedFile;
    }
}
