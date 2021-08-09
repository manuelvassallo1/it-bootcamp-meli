package java_2.practicaTT.ejercicio1;

public class PasswordIntermedia extends Password {
    public PasswordIntermedia(String pwd) {
        super("(?=.*[0-9])(?=.*[a-z]).*", pwd);
    }
}
