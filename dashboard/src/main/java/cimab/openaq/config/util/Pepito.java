package cimab.openaq.config.util;

public class Pepito {
    public Pepito setClaim(String ll) {
        return new Pepito();
    }
    public Pepito setNota(String ll) {
       return null;
    }
    public String setJwt(String ll) {
       return "hoy apredi una cosa nueva";
    }
    public void test() {
        String ll = new Pepito().setClaim("lola").setNota("sss").setJwt("fff");
    }
}
