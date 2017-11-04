package techkids.vn.freemusic.network.json_model;

/**
 * Created by ctrls on 29/10/2017.
 */

public class SearchSongJSON {
    private DataJSON data;
    public DataJSON getData(){
        return data;
    }

    public class DataJSON {
        private String url;
        private String thumbnail;

        public String getUrl() {
            return url;
        }

        public String getThumbnail() {
            return thumbnail;
        }
    }
}
