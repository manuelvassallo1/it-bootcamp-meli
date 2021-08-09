package java_4.savetheropa.src.main.java.com.meli.savetheropa;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Wardrobe {
    private Map<Integer, List<Clothing>> map;
    private int count;

    public Wardrobe() {
        map = new TreeMap<>();
        count = 0;
    }

    public Wardrobe(Map<Integer, List<Clothing>> map, int count) {
        this.map = map;
        this.count = count;
    }

    public Map<Integer, List<Clothing>> getMap() {
        return map;
    }

    public void setMap(Map<Integer, List<Clothing>> map) {
        this.map = map;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer saveClothing(List<Clothing> clothingList) {
        Integer identifier = count;
        map.put(identifier, clothingList);
        count++;

        return identifier;
    }

    public void showClothing() {
        map.forEach((key, value) -> {
            System.out.println("\nIdentificador nro: " + key);
            System.out.println("Prendas: ");
            value.forEach(c -> System.out.println(c.getModel() + ", " + c.getBrand()));
        });
    }

    public List<Clothing> returnClothing(Integer identifier) {
        return map.get(identifier);
    }
}
