package pl.ryfabartosz;

import pl.ryfabartosz.drive.Drive;
import pl.ryfabartosz.drive.SDDDrive;
import pl.ryfabartosz.files.File;
import pl.ryfabartosz.files.image.GIFImageFile;
import pl.ryfabartosz.files.image.JPGImageFile;
import pl.ryfabartosz.files.music.MP3File;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Apple");
        Drive sddDrive = new SDDDrive();

        Computer computer = new Computer(monitor, sddDrive);

        MP3File mp3File = new MP3File("audio.MP3", 200, "Janosiki", "Dzem", 100);

        GIFImageFile gifImageFile = new GIFImageFile("gigi.GIF", 20);
        JPGImageFile jpgImageFile = new JPGImageFile("janek.JPG", 10, 100);

        computer.addFile(mp3File);
        computer.addFile(jpgImageFile);
        computer.addFile(gifImageFile);

        File file = computer.findFile("gigi.GIF");
        System.out.println(file.getSize());
        System.out.println(file);
    }
}