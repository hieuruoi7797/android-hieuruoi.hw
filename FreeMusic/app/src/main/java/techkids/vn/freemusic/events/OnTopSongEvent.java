package techkids.vn.freemusic.events;

import techkids.vn.freemusic.databases.TopSongModel;

/**
 * Created by ctrls on 29/10/2017.
 */

public class OnTopSongEvent {
    private TopSongModel topSongModel;

    public OnTopSongEvent(TopSongModel topSongModel) {
        this.topSongModel = topSongModel;
    }

    public TopSongModel getTopSongModel() {
        return topSongModel;
    }

    public void setTopSongModel(TopSongModel topSongModel) {
        this.topSongModel = topSongModel;
    }
}
