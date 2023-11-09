package pl.ryfabartosz;

public class Monitor {
    private final String name;
    private int width;
    private int height;

    public Monitor(String name) {
        this.name = name;

        setHightResolution();
    }

    public void setHightResolution() {
        width = 3840;
        height = 1920;
    }
    public void setLowResolution() {
        width = 640;
        height = 480;
    }

    public String printResolution() {
        return "resolution:" + width + "x" + height;
    }
}

