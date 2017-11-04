package techkids.vn.freemusic.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import techkids.vn.freemusic.network.json_model.TopSongResponseJSON;

/**
 * Created by ctrls on 24/10/2017.
 */

public interface GetTopSongService {
    @GET("https://itunes.apple.com/us/rss/topsongs/limit=100/genre={id}/explicit=true/json")
    Call<TopSongResponseJSON> getTopSongs(@Path("id") String id);

}
