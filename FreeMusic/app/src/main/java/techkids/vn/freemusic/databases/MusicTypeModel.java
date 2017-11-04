package techkids.vn.freemusic.databases;

/**
 * Created by ctrls on 15/10/2017.
 */

public class MusicTypeModel {
    private String id;
    private String key;
    private int imageID;

    public void setId(String id) {
        this.id = id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getKey() {
        return key;
    }

    public String getId() {
        return this.id;
    }

    public int getImageID() {
        return imageID;
    }
}
