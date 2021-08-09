package java_2.practicaTT.ejercicio2;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Utils {
    public static double areaPromedio(FiguraGeometrica[] arr) throws Exception {
        return Arrays.stream(arr)
                .map(FiguraGeometrica::area)
                .flatMapToDouble(DoubleStream::of)
                .average()
                .orElseThrow(Exception::new);
    }
}
