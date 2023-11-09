package cimab.openaq.service.oracle.entity;

import cimab.openaq.entity.etiqoracle.AllTabsColumns;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UtilEntity {

    public void createEntity(List<AllTabsColumns> listAllTabsColumns, String tableName) {

        String fileName = "C:\\trabajo\\secretariaMedioAmbiente\\secretaria_medio_ambiente\\dashboard-back13\\dashboard\\src\\main\\java\\cimab\\openaq\\entity\\rmcaboracle\\" + tableName + ".java";

        Path path = Paths.get(fileName);

        try {
        BufferedWriter writer =
                Files.newBufferedWriter(path, StandardCharsets.UTF_8);

            String linea000 = "";
            linea000 = "package cimab.openaq.entity.rmcaboracle;"+ "\n\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import java.math.BigInteger;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.Column;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.GeneratedValue;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.GenerationType;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.Id;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import javax.persistence.Column;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.GeneratedValue;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.GenerationType;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.Id;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import javax.persistence.*;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n";
            writer.write(linea000);
            linea000 = "import lombok.Data;"+ "\n";
            writer.write(linea000);
            linea000 = "import lombok.NoArgsConstructor;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import javax.persistence.Column;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.Id;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n";
            writer.write(linea000);

        String linea00 = "@Data"+ "\n";
        writer.write(linea00);
        String linea01 = "@NoArgsConstructor"+ "\n";
        writer.write(linea01);
        String linea02 = "@Entity"+ "\n";
        writer.write(linea02);
        String linea03 = "@NamedQuery(name=\"" + tableName + ".findAll\", query=\"SELECT c FROM " + tableName + " c\")"+ "\n";
        writer.write(linea03);
        String linea04 = "@Table(name = \"eva_infovehic\")"+ "\n\n";
        writer.write(linea04);
            String linea05 = "public class " + tableName + "{" + "\n\n";
            writer.write(linea05);

        for (AllTabsColumns alltabColumns : listAllTabsColumns ) {
            String columnName = alltabColumns.getCOLUMN_NAME();
            String dataType = alltabColumns.getDATA_TYPE();

            // default, create, truncate and write to it.

            if (columnName.equals("DATE_TIME")) {
                linea000 = "@Id\n";
                writer.write(linea000);
            }

            String line = "    @Column(name = \"" + columnName + "\")"+ "\n";
            writer.write(line);
            String tipoDato = "String "+ "";
            if (dataType.equals("VARCHAR2")) {
                tipoDato = "String ";
            }
            if (dataType.equals("NUMBER")) {
                tipoDato = "BigInteger ";
            }



            String nombre2 = "    " + tipoDato + " " + columnName +  ";\n\n";
            writer.write(nombre2);

              //  wwwwwwwwwwwwwwwwwwwww




        }

            String linea06 = "} "+ "\n";
            writer.write(linea06);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createRepository(String tableName) {

        String fileName = "C:\\trabajo\\secretariaMedioAmbiente\\secretaria_medio_ambiente\\dashboard-back13\\dashboard\\src\\main\\java\\cimab\\openaq\\repository\\rmcaboracle\\" + tableName + "Repository.java";

        Path path = Paths.get(fileName);

        try {
            BufferedWriter writer =
                    Files.newBufferedWriter(path, StandardCharsets.UTF_8);

            String linea000 = "";

            linea000 = "package cimab.openaq.repository.rmcaboracle;"+ "\n\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import cimab.openaq.entity.rmcaboracle." + tableName + ";" + "\n";
            writer.write(linea000);

            linea000 = "import java.math.BigInteger;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.Column;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.GeneratedValue;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.GenerationType;"+ "\n";
            writer.write(linea000);
            linea000 = "import javax.persistence.Id;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import java.sql.Date;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.springframework.data.jpa.repository.JpaRepository;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.springframework.data.jpa.repository.Query;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.springframework.stereotype.Repository;"+ "\n";
            writer.write(linea000);


            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import javax.persistence.*;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n";
            writer.write(linea000);





            String linea05 = "@Repository\n" +
                    "public interface  " + tableName + "Repository  extends JpaRepository<" + tableName + ", Date> {\n\n";
            writer.write(linea05);



            String linea06 = "} "+ "\n";
            writer.write(linea06);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createService(String tableName) {

        String fileName = "C:\\trabajo\\secretariaMedioAmbiente\\secretaria_medio_ambiente\\dashboard-back13\\dashboard\\src\\main\\java\\cimab\\openaq\\service\\rmcaboracle\\" + tableName + "Service.java";

        Path path = Paths.get(fileName);

        try {
            BufferedWriter writer =
                    Files.newBufferedWriter(path, StandardCharsets.UTF_8);

            String linea000 = "";

            linea000 = "package cimab.openaq.service.rmcaboracle;"+ "\n\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import cimab.openaq.entity.rmcaboracle." + tableName + ";" + "\n";
            writer.write(linea000);

            linea000 = "import cimab.openaq.repository.rmcaboracle." + tableName + "Repository;" + "\n";
            writer.write(linea000);

            linea000 = "import java.math.BigInteger;"+ "\n";
            writer.write(linea000);

            linea000 = "import org.springframework.beans.factory.annotation.Autowired;"+ "\n";
            writer.write(linea000);

            linea000 = "import org.springframework.stereotype.Service;"+ "\n";
            writer.write(linea000);



            linea000 = "import javax.persistence.Id;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import java.sql.Date;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.springframework.data.jpa.repository.JpaRepository;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.springframework.data.jpa.repository.Query;"+ "\n";
            writer.write(linea000);
            linea000 = "import org.springframework.stereotype.Repository;"+ "\n";
            writer.write(linea000);

            linea000 = "import cimab.openaq.repository.rmcaboracle." + tableName + "Repository;\n";
            writer.write(linea000);

            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import javax.persistence.*;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n\n";
            writer.write(linea000);





            String linea05 = "@Service\n" +
                    "public class  " + tableName + "Service {\n\n";
            writer.write(linea05);

            linea05 = "    private " +tableName + "Repository vr;\n\n";
            writer.write(linea05);
            linea05 = "    @Autowired\n";
            writer.write(linea05);
            linea05 = "    public void setVr(" +tableName+ "Repository vr) {\n";
            writer.write(linea05);
            linea05 = "    this.vr = vr;\n";
            writer.write(linea05);
            linea05 = "}\n";
            writer.write(linea05);

            String linea06 = "} "+ "\n";
            writer.write(linea06);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
