package cimab.openaq.util;




import cimab.openaq.constantes.Constantes;
import cimab.openaq.entity.etiqoracle.AllTabsColumns;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static cimab.openaq.constantes.Constantes.*;


public class UtilEntity {

    public void createEntity(List<AllTabsColumns> listAllTabsColumns, String tableName,
                             String claseName, String paqueteG,
                             List<String> listLlavePrimaria) {

        String fileName = pathEntity + claseName + ".java";


        Path path = Paths.get(fileName);

        try {
            BufferedWriter writer =
                    Files.newBufferedWriter(path, StandardCharsets.UTF_8);

            String linea000 = "";
            linea000 = "package " + paqueteG + ";"  + "\n\n";
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
            String linea03 = "@NamedQuery(name=\"" + claseName + ".findAll\", query=\"SELECT c FROM " + claseName + " c\")"+ "\n";
            writer.write(linea03);
            String linea04 = "@Table(name = \"" + tableName  + "\")"+ "\n\n";
            writer.write(linea04);
            String linea05 = "public class " + claseName + "{" + "\n\n";
            writer.write(linea05);

            for (AllTabsColumns alltabColumns : listAllTabsColumns ) {
                String columnName = alltabColumns.getCOLUMN_NAME();
                String dataType = alltabColumns.getDATA_TYPE();

                // default, create, truncate and write to it.

                if (columnName.equals("DATE_TIME")) {
                    linea000 = "@Id\n";
                    writer.write(linea000);
                }
                Optional opLlavePrimaria = listLlavePrimaria.stream().filter(c -> c.equals(columnName)).findFirst();
                if (opLlavePrimaria.isPresent())  {
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


    public void createRepository(String tableName,
                                 String claseName,
                                 String paqueteRepositorio) {

        String fileName = pathRepository + claseName + "Repository.java";


        Path path = Paths.get(fileName);

        try {
            BufferedWriter writer =
                    Files.newBufferedWriter(path, StandardCharsets.UTF_8);

            String linea000 = "";

            linea000 = "package " + paqueteRepositorio +  ";"+ "\n\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import "+ PACKG_ENTITY_SARA + "." + claseName + ";" + "\n";
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
                    "public interface  " + claseName + "Repository  extends JpaRepository<" + claseName + ", Date> {\n\n";
            writer.write(linea05);



            String linea06 = "} "+ "\n";
            writer.write(linea06);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createService(String tableName,
                              String claseName,
                              String paqueteService,
                              String paqueteEntidad) {

        String fileName = pathService + claseName + "Service.java";

        Path path = Paths.get(fileName);

        try {
            BufferedWriter writer =
                    Files.newBufferedWriter(path, StandardCharsets.UTF_8);

            String linea000 = "";

            linea000 = "package " + PACKG_SERVICE_SARA + ";"+ "\n\n";
            writer.write(linea000);
            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import " + paqueteEntidad  + "." + claseName + ";" + "\n";
            writer.write(linea000);

            linea000 = "import "+ Constantes.PACKG_REPO_SARA + "." + claseName + "Repository;" + "\n";
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

            linea000 = "import " + Constantes.PACKG_REPO_SARA + "." + claseName + "Repository;\n";
            writer.write(linea000);

            linea000 = "import org.hibernate.annotations.GenericGenerator;"+ "\n";
            writer.write(linea000);

            linea000 = "import javax.persistence.*;"+ "\n";
            writer.write(linea000);
            linea000 = "import java.io.Serializable;"+ "\n\n";
            writer.write(linea000);





            String linea05 = "@Service\n" +
                    "public class  " + claseName + "Service {\n\n";
            writer.write(linea05);

            linea05 = "    private " + claseName + "Repository vr;\n\n";
            writer.write(linea05);
            linea05 = "    @Autowired\n";
            writer.write(linea05);
            linea05 = "    public void setVr(" +claseName+ "Repository vr) {\n";
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