package cimab.openaq.service.etiquetado.fileXML;

import java.io.FileOutputStream;

public class UtilFileXml {


    public void xmlGenCreate(String path, String nameFile, String placa, String dirQrHolograma) {
        String nameFL = path + nameFile;
        try {
            FileOutputStream fos = new FileOutputStream(nameFL, false);  // true for append mode
            System.out.print("Enter file content: ");
            String imageQr = dirQrHolograma + "qr_" + placa + ".png";

            String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
            str += "<etiquetado>" + "\n";      //str stores the string which we have entered
            str += "<portada><logo>logoScretaria.jpg</logo></portada>" + "\n";
            str += "<placa>" + placa +  "</placa>\n";
            str += "<imageQr> url(file:" + imageQr + ") </imageQr>" +  "\n";
            str += "</etiquetado>";

            byte[] b = str.getBytes();       //converts string into bytes
            fos.write(b);           //writes bytes into file
            fos.close();            //close the file
            System.out.println("file saved.");

        } catch(java.io.IOException ioe) {
            System.out.println(" createNewFile ........... ");
            ioe.printStackTrace();
        }

    }

    public void createNewFile(String path, String nameFile, String placa, String dirQrHolograma) {
        String nameFL = path + nameFile;
        try {
            FileOutputStream fos = new FileOutputStream(nameFL, false);  // true for append mode
            System.out.print("Enter file content: ");
            String imageQr = dirQrHolograma + "qr_" + placa + ".png";

            String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
            str += "<holograma>" + "\n";      //str stores the string which we have entered
            str += "<placa>" + placa +  "</placa>\n";
            str += "<imageQr> url(file:" + imageQr + ") </imageQr>" +  "\n";
            str += "</holograma>";

            byte[] b = str.getBytes();       //converts string into bytes
            fos.write(b);           //writes bytes into file
            fos.close();            //close the file
            System.out.println("file saved.");

        } catch(java.io.IOException ioe) {
            System.out.println(" createNewFile ........... ");
            ioe.printStackTrace();
        }

    }

}
