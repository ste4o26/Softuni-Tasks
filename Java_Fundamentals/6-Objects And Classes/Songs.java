import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Songs {

    static class Song {
        private String typeList;
        private String songName;
        private String time;

        public String getTypeList() {
            return this.typeList;
        }

        public String getSongName() {
            return this.songName;
        }

        public String getTime() {
            return this.time;
        }

        public Song(String typeOfList, String songName, String timeOfSong) {
            this.typeList = typeOfList;
            this.songName = songName;
            this.time = timeOfSong;
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(sc.nextLine());
        List<Song> songs = new ArrayList<Song>();
        fillList(songs, numberOfSongs, sc);
        String typeOfList = sc.nextLine();
        printSongsAsType(songs, typeOfList);
    }

    static void fillList(List<Song> songs, int numberOfSongs, Scanner sc) {
        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = sc.nextLine().split("_");
            String typeList = input[0];
            String songName = input[1];
            String songTime = input[2];
            Song song = new Song(typeList, songName, songTime);
            songs.add(song);
        }
    }

    static void printSongsAsType(List<Song> songs, String typeOfList) {
        for (Song currentSong : songs) {
            if (currentSong.getTypeList().equalsIgnoreCase(typeOfList)) {
                System.out.printf("%s%n", currentSong.getSongName());
            }
            if(typeOfList.equalsIgnoreCase("all")){
                System.out.printf("%s%n", currentSong.getSongName());
            }
        }
    }
}
