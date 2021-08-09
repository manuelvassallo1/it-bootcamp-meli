package java_2.practicaTT.ejercicio1;

public class PasswordSimple extends Password {
    public PasswordSimple(String pwd) {
        super("(?=.*[a-z]).*", pwd);
    }
}
