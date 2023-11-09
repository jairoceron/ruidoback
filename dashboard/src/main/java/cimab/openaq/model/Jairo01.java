package cimab.openaq.model;

public class Jairo01 implements Runnable {

    int a=0, b=0;
    int incrementA() {
        return ++a;
    }
    int incrementB() {
        return ++b;
    }
    public void run() {
             for (int i=0; i<3; i++)
                 System.out.println(incrementA() + "" + incrementB());
    }

    public static void main(String arg[]) {
        System.out.println("Holla");
        Jairo01 test1 = new Jairo01();
        Jairo01 test2 = new Jairo01();
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);

    }
}
