package java_2.practicaTT.ejercicio1;

public class Main {
    public static void main(String[] args) {
        Password p = new Password("\\d+", "hola123");
        Password p2 = new Password("\\d+", "123");

        System.out.println(p.getPwd());
        System.out.println(p2.getPwd());

        try {
            p2.setValue("123a");
            System.out.println("Se ha seteado la pwd '" + p2.getPwd() + "' correctamente.");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            p2.setValue("123");
            System.out.println("Se ha seteado la pwd '" + p2.getPwd() + "' correctamente.");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        PasswordSimple ps = new PasswordSimple("ASD");
        PasswordIntermedia pi = new PasswordIntermedia("asd");
        PasswordFuerte pw = new PasswordFuerte("asd");

        PasswordSimple ps2 = new PasswordSimple("asd");
        PasswordIntermedia pi2 = new PasswordIntermedia("asd123");
        PasswordFuerte pw2 = new PasswordFuerte("Asd123");
    }
}
