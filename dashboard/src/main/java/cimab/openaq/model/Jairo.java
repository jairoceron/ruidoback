package cimab.openaq.model;

public class Jairo {

    public Integer ll(int a, int b) {
        try {
        return a / b;
    }finally  {
            System.out.println("finally");
        }

    }

    public static void main(String arg[]) {
        Jairo j = new Jairo ();
        try {
            j.ll(0, 0);
        } catch(Exception es)
        {
            System.out.println("Division por cero");
        }


    }
}
