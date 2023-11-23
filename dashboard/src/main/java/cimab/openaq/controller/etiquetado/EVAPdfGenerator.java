package cimab.openaq.controller.etiquetado;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@RestController
@RequestMapping(path = "eva/sda/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

// @GetMapping(path = "laboratory/{idLaboratory}")

public class EVAPdfGenerator {

    @GetMapping(
            value = "/get-file/{placa}",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public @ResponseBody byte[] getFile(@PathVariable(name = "placa") String placa) throws IOException {

        // https://www.alcaldiabogota.gov.co/sisjur/normas/Norma1.jsp?i=145758&dt=S#


         InputStream in = getClass().getResourceAsStream("/evaRepositorioPDF/LINUX_COMMAND_LINE.pdf");
        //InputStream in = null;
        if (placa.equals("KYR880")) {

            in = getClass().getResourceAsStream("/evaRepositorioPDF/KYR880.pdf");
        }

        if (placa.equals("LPY983")) {

            in = getClass().getResourceAsStream("/evaRepositorioPDF/LPY983.pdf");
        }

        if (placa.equals("LQU289")) {

            in = getClass().getResourceAsStream("/evaRepositorioPDF/LQU289.pdf");
        }

        if (placa.equals("OJX983")) {

            in = getClass().getResourceAsStream("/evaRepositorioPDF/OJX983.pdf");
        }



        return IOUtils.toByteArray(in);
    }

}
