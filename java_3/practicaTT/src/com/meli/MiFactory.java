package java_3.practicaTT.src.com.meli;

import java.io.FileInputStream;
import java.util.Properties;

public class MiFactory {

    private static final Properties PROPERTIES = new Properties();
    private static final String PATH = "/Users/mvassallo/Documents/Workspaces/meli_bootcamp_w11/java_3/practicaTT/resources/MiFactory.properties";

    public static <T> Sorter<T> getInstance(String objName) {

        Object clazz = null;
        try (FileInputStream lectorArchivos = new FileInputStream(PATH)) {
            PROPERTIES.load(lectorArchivos);
            String className = PROPERTIES.getProperty(objName);
            clazz = Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Sorter<T>) clazz;
    }

}
