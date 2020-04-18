package p02_OpenClosedPrinciple.p01_FileStream;

public class Main {

    public static void main(String[] args) {
        StreamableResource file = new File("myFile", 10, 5);
        StreamableResource music = new Music(5, 10, "Martin Garix", "Insomnia");

        Progress progress = new Progress();
        progress.getCurrentPercent(file);
        progress.getCurrentPercent(music);
    }
}

