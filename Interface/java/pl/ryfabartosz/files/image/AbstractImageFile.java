package pl.ryfabartosz.files.image;

import pl.ryfabartosz.files.AbstractFile;
import pl.ryfabartosz.files.FileType;

public class AbstractImageFile extends AbstractFile {
    public AbstractImageFile(String name, int size) {
        super(name, size);
    }

    @Override
    public FileType getType() {
        return FileType.IMAGE;
    }
}
