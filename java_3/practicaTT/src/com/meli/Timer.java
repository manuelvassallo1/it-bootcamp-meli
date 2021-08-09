package java_3.practicaTT.src.com.meli;

public class Timer {
    private long started;
    private long ended;

    public void start() {
        started = System.currentTimeMillis();
    }

    public void stop() {
        ended = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return ended - started;
    }

}
