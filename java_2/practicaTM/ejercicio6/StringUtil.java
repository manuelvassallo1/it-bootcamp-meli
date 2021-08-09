package java_2.practicaTM.ejercicio6;

public class StringUtil {
    /*
        Ejercicio 6
        Partiendo de la clase StringUtil (que usamos para resolver Radix Sort), agregar los siguientes
        métodos estáticos:
        ● public static String rpad(String s,char c,int n); idem lpad, pero agregando caracteres a
        la derecha.
        ● public static String ltrim(String s); Retorna una cadena idéntica a s pero sin espacios a
        la izquierda.
        ● public static String rtrim(String s); idem ltrim, pero sin espacios a la derecha.
        ● public static String trim(String s); idem lpad, pero sin espacios a derecha ni izquierda.
        ● public static int indexOfN(String s,char c,int n); Retorna la posición de la n-ésima
        ocurrencia del carácter c dentro de s, o -1 si s no contiene a c. Por ejemplo, si s =
        “John|Paul|George|Ringo”, c = ‘|’ y n=2, la función debe retornar la posicióon de la
        segunda ocurrencia del carácter ‘|’ (pipe) dentro de la cadena s. Que, en este caso,
        es: 9.
     */

    public static String rpad(String s, char c, int n) {
        StringBuilder sb = new StringBuilder(s);
        String retorno;
        if (sb.length() >= n) {
            retorno = "No se puede realizar, el largo de la cadena es mayor al padding deseado";
        } else {
            while (n > 0) {
                sb.append(c);
                n--;
            }
            retorno = sb.toString();
        }
        return retorno;
    }

    public static String ltrim(String s) {
        return s.replaceAll("^\\s+", "");
    }

    public static String rtrim(String s) {
        return s.replaceAll("\\s+$", "");
    }

    public static String trim(String s) {
        return rtrim(ltrim(s));
    }

    public static int indexOfN(String s, char c, int n) {
        char[] arr = s.toCharArray();
        int cont = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                cont++;
            }
            if (n == cont) {
                return i;
            }
        }
        return -1;
    }
}
