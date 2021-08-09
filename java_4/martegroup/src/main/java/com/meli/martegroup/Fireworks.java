package java_4.martegroup.src.main.java.com.meli.martegroup;

import java.util.List;

public class Fireworks {
    private List<Firework> fwList;
    private List<Pack> packList;

    public Fireworks() {
    }

    public Fireworks(List<Firework> fwList, List<Pack> packList) {
        this.fwList = fwList;
        this.packList = packList;
    }

    public List<Firework> getFwList() {
        return fwList;
    }

    public void setFwList(List<Firework> fwList) {
        this.fwList = fwList;
    }

    public List<Pack> getPackList() {
        return packList;
    }

    public void setPackList(List<Pack> packList) {
        this.packList = packList;
    }
}
