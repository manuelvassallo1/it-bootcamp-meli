package java_4.martegroup.src.main.java.com.meli.martegroup;

public class Guest implements Screamer {
    private boolean isMeliGuest;

    public Guest() {
    }

    public Guest(boolean isMeliGuest) {
        this.isMeliGuest = isMeliGuest;
    }

    private boolean getIsMeliGuest() {
        return isMeliGuest;
    }

    private void setMeliGuest(boolean meliGuest) {
        isMeliGuest = meliGuest;
    }

    @Override
    public void celebrate() {
        if (isMeliGuest) {
            System.out.println("Viva la Chiqui!!");
        }
    }
}
