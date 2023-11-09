package pl.ryfabartosz.drive;

import pl.ryfabartosz.files.File;

public interface Drive {
    void addFile(File file);
    void listFiles();
    File findFile(String fileName);
}
