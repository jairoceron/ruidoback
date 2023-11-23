package cimab.openaq.util;

import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.PqrsDTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static cimab.openaq.constantes.Constantes.*;

public class FechaVencimiento {

    public void addBanderaSegunFecha(PqrsDTO pqrs) {

        /*
        * Agrega el numero de días de vencimiento
        * */

        Timestamp fechaRadicado = pqrs.getFecha_radicado();
        // google java.sql.Timestamp "public static void main" number days between two dates
        // google java.sql.Date "public static void main" current day
        // google java.sql.Timestamp "public static void main" Timestamp to date
        long millis=System.currentTimeMillis();
        java.sql.Date currentDate=new java.sql.Date(millis);


        Date fechaRadicadoD=new Date(fechaRadicado.getTime());


        long diff = currentDate.getTime() - fechaRadicadoD.getTime()  ;


        long numDiasVencimiento       = (diff                / (1000 * 60 * 60 * 24))   ;

        pqrs.setDiasDeVencido(numDiasVencimiento);


        LocalDate dateAfter = LocalDate.of(2017, Month.JULY, 29);



        if (numDiasVencimiento > DIAS_VENCIMIENTO) {
            pqrs.setBanderaVencimiento(ROJO);
        }
        if (numDiasVencimiento > 5 && numDiasVencimiento <= DIAS_VENCIMIENTO) {
            pqrs.setBanderaVencimiento(AMARILLO);
        }
        if (numDiasVencimiento <= 5 ) {
            pqrs.setBanderaVencimiento("");
        }


       // 9999999999999999999999999999



    }


}
