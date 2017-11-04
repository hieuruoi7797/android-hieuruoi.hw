package techkids.vn.freemusic.databases;

/**
 * Created by ctrls on 24/10/2017.
 */

public class TopSongModel {
    private String song;
    private String artist;
    private String smallImage;
    private String url;
    private String largeImange;

    public TopSongModel() {
        
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLargeImange(String largeImange) {
        this.largeImange = largeImange;
    }

    public String getUrl() {
        return url;
    }

    public String getLargeImage() {
        return largeImange;
    }

    public TopSongModel(String song, String artist, String smallImage) {
        this.song = song;
        this.artist = artist;
        this.smallImage = smallImage;
    }

    public String getSong() {
        return song;
    }

    public String getArtist() {
        return artist;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public void setDataFromFile(String songName, String artist, String path) {
    }
}
