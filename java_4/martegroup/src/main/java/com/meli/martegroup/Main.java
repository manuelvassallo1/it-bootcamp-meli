package java_4.martegroup.src.main.java.com.meli.martegroup;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Se apagan las velas! Feliz Cumpleaños!");
        explodeFireworks();
        System.out.println("\nCelebracion de los invitados de Meli:");
        celebrate();
    }

    private static void explodeFireworks() {
        System.out.println("Hora de los fuegos artificiales!\n");
        Fireworks fireworks = getFireworks();

        fireworks.getFwList().forEach(Firework::explode);

        fireworks.getPackList()
                .stream()
                .map(Pack::getFwList)
                .forEach(list -> list.forEach(Firework::explode));
    }

    private static void celebrate() {
        List<Guest> guests = getGuests();
        guests.forEach(Guest::celebrate);
    }

    private static Fireworks getFireworks() {
        Firework fw1 = new Firework("Boom");
        Firework fw2 = new Firework("BOOOM");
        Firework fw3 = new Firework("BO O O MM");

        Firework fw4 = new Firework("BOOOOOOOM");
        Firework fw5 = new Firework("BOO ooo OOM");
        Firework fw6 = new Firework("bom");

        List<Firework> list1 = new ArrayList<>();
        list1.add(fw1);
        list1.add(fw2);
        list1.add(fw3);

        List<Firework> list2 = new ArrayList<>();
        list2.add(fw4);
        list2.add(fw5);
        list2.add(fw6);

        Pack pack1 = new Pack(list2, null);

        List<Pack> packList = new ArrayList<>();
        packList.add(pack1);
        Pack pack2 = new Pack(list1, packList);

        List<Pack> packs = new ArrayList<>();
        packs.add(pack1);
        packs.add(pack2);

        return new Fireworks(list1, packs);
    }

    private static List<Guest> getGuests() {
        Guest guest1 = new Guest(false);
        Guest guest2 = new Guest(false);
        Guest guest3 = new Guest(false);

        Guest meliGuest1 = new Guest(true);
        Guest meliGuest2 = new Guest(true);
        Guest meliGuest3 = new Guest(true);

        List<Guest> guests = new ArrayList<>();
        guests.add(guest1);
        guests.add(guest2);
        guests.add(guest3);
        guests.add(meliGuest1);
        guests.add(meliGuest2);
        guests.add(meliGuest3);

        return guests;
    }
}
