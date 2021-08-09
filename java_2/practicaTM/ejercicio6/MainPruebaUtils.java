package java_2.practicaTM.ejercicio6;

public class MainPruebaUtils {
    public static void main(String[] args) {
        System.out.println(StringUtil.rpad("hola", 'A', 5));
        System.out.println(StringUtil.rpad("hola", 'A', 3));

        System.out.println(StringUtil.ltrim("   aa bbaa"));
        System.out.println(StringUtil.rtrim("aa bbaa                "));
        System.out.println(StringUtil.trim("   aa bbaa       "));

        System.out.println(StringUtil.indexOfN("Hola soy una cadena", 'a', 2));
        System.out.println(StringUtil.indexOfN("Hola soy una cadena", 'a', 5));

    }
}
