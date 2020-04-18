package p02_OpenClosedPrinciple.p01_FileStream;

public class Music extends StreamableResource{
    private int length;

    private int sent;

    private String artist;

    private String album;

    public Music(int length, int sent, String artist, String album) {
        super(length, sent);
        this.setArtist(artist);
        this.setAlbum(album);
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
