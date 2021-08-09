package java_4.savetheropa.src.main.java.com.meli.savetheropa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();

        List<Clothing> clothingList1 = new ArrayList<>();
        clothingList1.add(new Clothing("Campera", "Nike"));
        clothingList1.add(new Clothing("Zapatillas", "Vans"));

        List<Clothing> clothingList2 = new ArrayList<>();
        clothingList2.add(new Clothing("Remera", "Casablanca"));
        clothingList2.add(new Clothing("Zapatillas", "Converse"));

        List<Clothing> clothingList3 = new ArrayList<>();
        clothingList3.add(new Clothing("Pantalon", "Levi's"));
        clothingList3.add(new Clothing("Gorra", "Tascani"));

        Integer id1 = wardrobe.saveClothing(clothingList1);
        System.out.println("\nSe guardaron tus prendas. Tu identificador es: " + id1);

        Integer id2 = wardrobe.saveClothing(clothingList2);
        System.out.println("\nSe guardaron tus prendas. Tu identificador es: " + id2);


        System.out.println("\nPrendas en el guardarropas:");
        wardrobe.showClothing();

        List<Clothing> clothingReturned1 = wardrobe.returnClothing(id1);
        System.out.println("\nPrendas devueltas: ");
        clothingReturned1.forEach(c -> System.out.println(c.getModel() + ", " + c.getBrand()));

        List<Clothing> clothingReturned2 = wardrobe.returnClothing(id2);
        System.out.println("\nPrendas devueltas: ");
        clothingReturned2.forEach(c -> System.out.println(c.getModel() + ", " + c.getBrand()));

        Integer id3 = wardrobe.saveClothing(clothingList3);
        System.out.println("\nSe guardaron tus prendas. Tu identificador es: " + id3);

        List<Clothing> clothingReturned3 = wardrobe.returnClothing(id3);
        System.out.println("\nPrendas devueltas: ");
        clothingReturned3.forEach(c -> System.out.println(c.getModel() + ", " + c.getBrand()));
    }
}
