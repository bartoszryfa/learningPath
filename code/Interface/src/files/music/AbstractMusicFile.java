package pl.ryfabartosz.files.music;

import pl.ryfabartosz.files.AbstractFile;
import pl.ryfabartosz.files.FileType;

public abstract class AbstractMusicFile extends AbstractFile implements MusicFile {
    protected String bandName;
    protected String title;

    public AbstractMusicFile(String name, int size, String bandName, String title) {
        super(name, size);
        this.bandName = bandName;
        this.title = title;
    }

    @Override
    public FileType getType() {
        return FileType.MUSIK;
    }
}
