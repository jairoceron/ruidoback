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
        System.out.println(currentDate);

        Date fechaRadicadoD=new Date(fechaRadicado.getTime());
        System.out.println(fechaRadicadoD);

        long diff = currentDate.getTime() - fechaRadicadoD.getTime()  ;

        System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        long numDiasVencimiento       = (diff                / (1000 * 60 * 60 * 24))   ;

        System.out.println("Numero de dias de vencimiento  ------- " +numDiasVencimiento );

//        Vencido=ROJO (Fecha vencida)
  //      Próximo a vencer= AMARILLO (1 semana antes de vencer)

        pqrs.setDiasDeVencido(numDiasVencimiento);



      //  LocalDate dateBefore = LocalDate.of(fechaRadicado., Month.MAY, 24);
        //29-July-2017, change this to your desired End Date
        LocalDate dateAfter = LocalDate.of(2017, Month.JULY, 29);
    //    long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
    //    System.out.println(noOfDaysBetween);



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
