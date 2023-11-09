package pl.ryfabartosz.USBDevices;

public interface USBDevice {
    boolean connect();
    boolean disconnect();
    String getName();
}
