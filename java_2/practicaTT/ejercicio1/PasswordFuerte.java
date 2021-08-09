package java_2.practicaTT.ejercicio1;

public class PasswordFuerte extends Password {
    public PasswordFuerte(String pwd) {
        super("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).*", pwd);
    }
}
