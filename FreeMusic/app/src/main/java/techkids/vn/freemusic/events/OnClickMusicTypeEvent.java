package techkids.vn.freemusic.events;

import techkids.vn.freemusic.databases.MusicTypeModel;

/**
 * Created by ctrls on 17/10/2017.
 */

public class OnClickMusicTypeEvent {
    private MusicTypeModel musicTypeModel;

    public OnClickMusicTypeEvent(MusicTypeModel musicTypeModel) {
        this.musicTypeModel = musicTypeModel;
    }

    public MusicTypeModel getMusicTypeModel() {
        return musicTypeModel;
    }

    public void setMusicTypeModel(MusicTypeModel musicTypeModel) {
        this.musicTypeModel = musicTypeModel;
    }
}
