package cimab.openaq.controller.ruido;

import cimab.openaq.config.util.JwtUtil;
import cimab.openaq.dataTransferObject.SensorMedicion;
import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.model.AuthenticationRequest;
import cimab.openaq.model.AuthenticationResponse;
import cimab.openaq.service.Tablero.TableroService;
import cimab.openaq.service.ruido.RuidoService;
import cimab.openaq.service.sbc.SbcService;
import cimab.openaq.service.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RuidoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private RuidoService ts;

    @Autowired
    public void setTs(RuidoService ts) {
        this.ts = ts;
    }

    @GetMapping(path = "consultaVisitaooooRuido")
    public List<SensorMedicion> consultaVisitammmRuido(@RequestParam(name = "marcaSensor", defaultValue = "0") int marcaSensor,
                                                       @RequestParam(name = "codigoSensor", defaultValue = "0") String codigoSensor,
                                                       @RequestParam(name = "promedio", defaultValue = "0") int promedio,
                                                       @RequestParam(name = "variable", defaultValue = "0") int variable,
                                                       @RequestParam(name = "fechaInicial", defaultValue = "31/08/2018") String fechaInicial,
                                                       @RequestParam(name = "fechaFinal", defaultValue = "31/08/2018") String fechaFinal
    ) {

        System.out.println("Ingreso al controller ...... " + promedio);
        return null;
    }


    @GetMapping(path = "listFuncionariosRuido")
    public List<String> listFuncionariosRuido(@RequestParam(name = "marcaSensor", defaultValue = "0") int marcaSensor,
                                              @RequestParam(name = "codigoSensor", defaultValue = "0") String codigoSensor,
                                              @RequestParam(name = "promedio", defaultValue = "0") int promedio,
                                              @RequestParam(name = "variable", defaultValue = "0") int variable,
                                              @RequestParam(name = "fechaInicial", defaultValue = "31/08/2018") String fechaInicial,
                                              @RequestParam(name = "fechaFinal", defaultValue = "31/08/2018") String fechaFinal
    ) {

        System.out.println("Ingreso al controller ...... " + promedio);

        return ts.listFuncionariosRuido();
    }

    @RequestMapping({"/hello"})
    public String hello() {
        System.out.println("ESto es lo mas importante .... ");
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("Objeto JSON :: " + authenticationRequest);
        System.out.println(" :: " + authenticationRequest.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        AuthenticationResponse jwtX = new AuthenticationResponse(jwt);
        ResponseEntity xx = ResponseEntity.ok(jwtX);
        //      xx.ok().header("modulo","ruido");

        //     HttpHeaders headers = new HttpHeaders();
        //    headers.add("Custom-Header", "foo");


        // ResponseEntity<?> ff = new ResponseEntity("Hello World!", HttpStatus.OK,"ggg");
        return xx;
        // return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }


}
