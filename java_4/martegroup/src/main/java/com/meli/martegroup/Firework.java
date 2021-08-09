package java_4.martegroup.src.main.java.com.meli.martegroup;

public class Firework implements Explosive {

    private String msg;

    public Firework() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Firework(String msg) {
        this.msg = msg;
    }

    @Override
    public void explode() {
        System.out.println(msg);
    }
}
