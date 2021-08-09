package java_2.practicaTT.ejercicio1;

import java.util.regex.Pattern;

public class Password {
    private String pwd;
    private String regex;

    public Password(String regex, String pwd) {
        if (validarPwd(regex, pwd)) {
            this.pwd = pwd;
            this.regex = regex;
            System.out.println("Se creo correctamente la password.");
        } else {
            System.out.println("No se pudo, password no cumple requisitos.");
        }
    }

    private static boolean validarPwd(String regex, String pwd) {
        Pattern patron = Pattern.compile(regex);
        return patron.matcher(pwd).matches();
    }

    public void setValue(String pwd) {
        if (validarPwd(this.regex, pwd)) {
            this.pwd = pwd;
        } else {
            throw new IllegalArgumentException("La password '" + pwd + "' no cumple con los requisitos.");
        }
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
